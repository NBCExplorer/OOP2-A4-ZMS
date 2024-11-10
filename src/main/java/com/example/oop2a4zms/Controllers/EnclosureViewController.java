package com.example.oop2a4zms.Controllers;

import com.example.oop2a4zms.Model.Animal;
import com.example.oop2a4zms.Model.CompositeAnimalCollection;
import com.example.oop2a4zms.Model.Enclosure;
import com.example.oop2a4zms.ZooApplication;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class  EnclosureViewController {
    @FXML private ListView<String> aEnclosureListView;

    private Enclosure aEnclosure;
    @FXML private TextField nameTextField;
    @FXML private TextField ageTextField;
    @FXML private TextField weightTextField;
    @FXML private ComboBox<String> sexComboBox;

    public EnclosureViewController() {

    }

    @FXML
    public void initialize() {
        if (aEnclosure != null) {
            refreshAnimalList();
        }
    }

    public void setEnclosure(Enclosure enclosure) {
        this.aEnclosure = enclosure;
        refreshAnimalList();
    }

    @FXML
    public void addAnimalToEnclosure() {
        try {
            String name = nameTextField.getText();
            int age = Integer.parseInt(ageTextField.getText());
            String sex = sexComboBox.getValue();
            double weight = Double.parseDouble(weightTextField.getText());

            Animal newAnimal = new Animal(name, age, sex, weight);
            aEnclosure.addAnimal(newAnimal);
            refreshAnimalList();
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Invalid input");
            alert.setContentText("Please enter valid values for age and weight.");
            alert.showAndWait();
        }
    }


    public void displayModifyAnimal() {
        String selectedAnimalName = aEnclosureListView.getSelectionModel().getSelectedItem();
        if (selectedAnimalName != null) {
            Animal selectedAnimal = findAnimalByName(selectedAnimalName);
            if (selectedAnimal != null) {
                launchAnimalViewController(selectedAnimal);
            }
        }
    }

    @FXML
    public void deleteAnimalFromEnclosure() {
        String selectedAnimalName = aEnclosureListView.getSelectionModel().getSelectedItem();
        if (selectedAnimalName != null) {
            Animal selectedAnimal = findAnimalByName(selectedAnimalName);
            if (selectedAnimal != null) {
                aEnclosure.removeAnimal(selectedAnimal);
                refreshAnimalList();
            }
        }
    }

    @FXML
    public void goBack() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(ZooApplication.class.getResource("/com/example/oop2a4zms/composite-animal-view.fxml"));
            Parent parent = fxmlLoader.load();

            CompositeAnimalCollectionViewController controller = fxmlLoader.getController();
            controller.initializeView(); // Call the initialize method to set up the view

            Stage stage = (Stage) aEnclosureListView.getScene().getWindow();
            stage.setScene(new Scene(parent));
            stage.setTitle("Composite Animal Collection");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            System.err.println("Error: Unable to load the FXML file or set the scene.");
            e.printStackTrace();
        }
    }

private Animal findAnimalByName(String name) {
    for (Animal animal : aEnclosure) {
        if (animal.getName().equals(name)) {
            return animal;
        }
    }
    return null;
}



    private void refreshAnimalList() {
        // TODO: Work with Itertator instead.
        if (aEnclosure != null) {
            List<String> animalNames = new ArrayList<>();
            for (Animal animal : aEnclosure) {
                animalNames.add(animal.getName());
            }
            ObservableList<String> observableAnimalNames = FXCollections.observableArrayList(animalNames);
            aEnclosureListView.setItems(observableAnimalNames);
        }
    }

    private void launchAnimalViewController(Animal animal) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(ZooApplication.class.getResource("/com/example/oop2a4zms/animal-view.fxml"));
            Parent parent = fxmlLoader.load();

            AnimalViewController controller = fxmlLoader.getController();
            controller.setAnimal(animal);

            Stage stage = new Stage();
            stage.setScene(new Scene(parent));
            stage.setTitle("Modify Animal");
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(aEnclosureListView.getScene().getWindow());
            stage.showAndWait();

            refreshAnimalList();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}