package com.example.oop2a4zms.Controllers;

import com.example.oop2a4zms.Model.Animal;
import com.example.oop2a4zms.Model.Enclosure;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;


public class  EnclosureViewController {
    @FXML private ListView<Animal> aEnclosureListView;

    private Enclosure aEnclosure;

    public EnclosureViewController(Enclosure enclosure) {
        this.aEnclosure = enclosure;
        refreshAnimalList();
    }

    @FXML
    public void initialize() {
        aEnclosureListView.setItems(FXCollections.observableArrayList(aEnclosure.getAnimals()));
    }

    @FXML
    public void addAnimalToEnclosure() {

    }

    @FXML
    public void displayModifyAnimal() {
        Animal selectedAnimal = aEnclosureListView.getSelectionModel().getSelectedItem();
        if (selectedAnimal != null) {
            // Display/modify the selected animal's details
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

    private void refreshAnimalList() {
        aEnclosureListView.setItems(FXCollections.observableArrayList(aEnclosure.getAnimals()));
    }
}

