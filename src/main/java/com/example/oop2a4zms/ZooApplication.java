package com.example.oop2a4zms;

import com.example.oop2a4zms.Controllers.CompositeAnimalCollectionViewController;
import com.example.oop2a4zms.Helpers.ImportHelper;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ZooApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ZooApplication.class.getResource("composite-animal-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        CompositeAnimalCollectionViewController newCompositeAnimalCollectionViewController = fxmlLoader.getController();
        newCompositeAnimalCollectionViewController.setCompositeAnimalCollection(ImportHelper.createAnimals());
        stage.setTitle("Zoo Management Application");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}