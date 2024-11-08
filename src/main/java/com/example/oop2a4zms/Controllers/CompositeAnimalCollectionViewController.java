package com.example.oop2a4zms.Controllers;

import com.example.oop2a4zms.Model.AnimalCollection;
import com.example.oop2a4zms.Model.CompositeAnimalCollection;
import com.example.oop2a4zms.Model.Enclosure;
import com.example.oop2a4zms.ZooApplication;
import com.example.oop2a4zms.Helpers.AlertHelper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class CompositeAnimalCollectionViewController {
    @FXML
    private ListView<AnimalCollection> aAnimalCollectionListView;

    private CompositeAnimalCollection aCompositeAnimalCollection = new CompositeAnimalCollection();

    @FXML
    protected void onBackButtonClick() {
        Stage stage = (Stage) aAnimalCollectionListView.getScene().getWindow();
        stage.close();
    }

    @FXML
    protected void onViewButtonClick(ActionEvent pEvent) {
        try {
            int selectedIndex = this.aAnimalCollectionListView.getSelectionModel().getSelectedIndex();
            if (selectedIndex == -1) {
                AlertHelper.showWarning("Please select a zoo area!");
            } else {
                AnimalCollection selectedCollection = this.aCompositeAnimalCollection.getSelectedIndex(selectedIndex);
                if (selectedCollection instanceof Enclosure) {
                    this.launchEnclosureViewController(pEvent, (Enclosure) selectedCollection);
                } else if (selectedCollection instanceof CompositeAnimalCollection) {
                    this.launchNextCompositeAnimalController(pEvent, (CompositeAnimalCollection) selectedCollection);
                } else {
                    throw new RuntimeException("This should not happen!");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void launchEnclosureViewController(ActionEvent pEvent, Enclosure pEnclosure) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ZooApplication.class.getResource("enclosure-view.fxml"));
        Parent view = fxmlLoader.load();
        EnclosureViewController newEnclosureViewController = fxmlLoader.getController();
        // TODO: Fix
        //newEnclosureViewController.setEnclosure(pEnclosure);
        buildSceneAndStage(pEvent, view, pEnclosure.getName());
    }

    // TODO: Uncomment once CompositeAnimalCollection is built
    private void launchNextCompositeAnimalController(ActionEvent pEvent, CompositeAnimalCollection pComposite) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ZooApplication.class.getResource("composite-animal-view.fxml"));
        Parent parent = fxmlLoader.load();
        CompositeAnimalCollectionViewController newCompositeAnimalCollectionViewController = fxmlLoader.getController();
        // TODO: Fix
        newCompositeAnimalCollectionViewController.setCompositeAnimalCollection(pComposite);
        buildSceneAndStage(pEvent, parent, pComposite.getName());
    }

    private void buildSceneAndStage(ActionEvent pEvent, Parent view, String name) {
        Scene nextScene = new Scene(view, 500, 500);
        Stage nextStage = new Stage();
        nextStage.setScene(nextScene);
        nextStage.setTitle(name);
        nextStage.initModality(Modality.WINDOW_MODAL);
        nextStage.initOwner(((Node) pEvent.getSource()).getScene().getWindow());
        nextStage.showAndWait();
    }

    // TODO: Uncomment once CompositeAnimalCollection is built
    public void setCompositeAnimalCollection(CompositeAnimalCollection pCompositeAnimalCollection) {
        this.aCompositeAnimalCollection = pCompositeAnimalCollection;
        for(AnimalCollection collection : pCompositeAnimalCollection) {
            this.aAnimalCollectionListView.getItems().add(collection);
        }
    }
}
