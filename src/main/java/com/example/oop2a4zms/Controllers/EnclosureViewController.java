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
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class  EnclosureViewController {
    @FXML private ListView<Animal> aEnclosureListView;

    private Enclosure aEnclosure;

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

    }


    public void displayModifyAnimal() {
        Animal selectedAnimal = aEnclosureListView.getSelectionModel().getSelectedItem();
        if (selectedAnimal != null) {

        }
    }

    @FXML
    public void deleteAnimalFromEnclosure() {
        Animal selectedAnimal = aEnclosureListView.getSelectionModel().getSelectedItem();
        if (selectedAnimal != null) {
            aEnclosure.removeAnimal(selectedAnimal);
            refreshAnimalList();
        }
    }

    @FXML
    public void goBack() {
        // Code to go back to the previous view or main menu

    }



    private void refreshAnimalList() {
        // TODO: Work with Itertator instead.
        if (aEnclosure != null) {
            List<Animal> animalList = new ArrayList<>();

            for (Animal animal : aEnclosure) {
                animalList.add(animal);
            }

            ObservableList<Animal> observableAnimalList = FXCollections.observableArrayList(animalList);
            aEnclosureListView.setItems(observableAnimalList);
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