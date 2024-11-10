package com.example.oop2a4zms.Controllers;

import com.example.oop2a4zms.Model.Animal;
import com.example.oop2a4zms.Model.CompositeAnimalCollection;
import com.example.oop2a4zms.Model.Enclosure;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class  EnclosureViewController {
    @FXML private ListView<Animal> aEnclosureListView;

    private CompositeAnimalCollection bigCatsCollection;

    private Enclosure aEnclosure;

    public EnclosureViewController(Enclosure enclosure) {
        this.aEnclosure = enclosure;
        refreshAnimalList();
    }

    @FXML
    public void initialize() {
        List<Animal> animalList = new ArrayList<>();
        Iterator<Animal> iterator = aEnclosure.iterator();

        while (iterator.hasNext()) {
            animalList.add(iterator.next());
        }

        aEnclosureListView.setItems(FXCollections.observableArrayList(animalList));
    }

    public void setEnclosure(Enclosure enclosure) {
        this.aEnclosure = enclosure;
        refreshAnimalList();
    }

    @FXML
    public void addAnimalToEnclosure() {

    }

    @FXML
    public void displayModifyAnimal() {
        Animal selectedAnimal = aEnclosureListView.getSelectionModel().getSelectedItem();
        if (selectedAnimal != null) {

        }
    }

    @FXML
    public void deleteAnimalFromEnclosure() {
        // Code to delete the selected animal
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

    private void launchAnimalViewController(Animal selectedAnimal) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("animal-view.fxml"));
            Parent animalView = fxmlLoader.load();

            AnimalViewController animalController = fxmlLoader.getController();
            animalController.setAnimal(selectedAnimal); // Pass the selected Animal to AnimalViewController

            Stage stage = new Stage();
            stage.setScene(new Scene(animalView));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void refreshAnimalList() {
        // TODO: Work with Itertator instead.
        if (aEnclosure != null) {
            List<Animal> animalList = new ArrayList<>();
            Iterator<Animal> iterator = aEnclosure.iterator();

            while (iterator.hasNext()) {
                animalList.add(iterator.next());
            }

            ObservableList<Animal> observableAnimalList = FXCollections.observableArrayList(animalList);
            aEnclosureListView.setItems(observableAnimalList);
        }
    }
}