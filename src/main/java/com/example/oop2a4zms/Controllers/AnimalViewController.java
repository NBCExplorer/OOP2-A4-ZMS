package com.example.oop2a4zms.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import com.example.oop2a4zms.Model.Animal;

public class AnimalViewController {

    @FXML
    private TextField nameTextField;
    @FXML
    private ComboBox<String> sexComboBox;
    @FXML
    private TextField ageTextField;
    @FXML
    private TextField weightTextField;
    @FXML
    private Button saveButton;

    @FXML
    private Button closeButton;

    @FXML
    public void initialize() {
        if (sexComboBox.getItems().isEmpty()) {
            sexComboBox.getItems().addAll("Male", "Female");
        }
    }


    @FXML
    private void handleSaveButton() {

        System.out.println("Save button clicked");
        //handle field interactions, validation, and saving animal information
        String name = nameTextField.getText();
        String sex = sexComboBox.getValue();
        int age;

        double weight;

        try {

            age = Integer.parseInt(ageTextField.getText());
            weight = Double.parseDouble(weightTextField.getText());
        } catch (NumberFormatException e) {

            showAlert("Invalid Input", "Enter valid numbers for age and weight!");
            return;

        }

        if (name.isEmpty() || sex == null) {
            showAlert("Missing Information", "You need to fill in all fields");
            return;
        }

        Animal animal = new Animal(name, age, sex, weight);
        System.out.println("Saving animal details");
        System.out.println("Animal saved: " + animal);


        System.out.println("Name: " + animal.getName());
        System.out.println("Sex: " + animal.getSex());
        System.out.println("Age: " + animal.getAge());
        System.out.println("Weight: " + animal.getWeight() + "kg");
        System.out.println("Animal saved successfully!");
    }

    @FXML
    private void handleCloseButton() {
        System.out.println("Close button clicked");
        nameTextField.clear();
        sexComboBox.setValue(null);
        ageTextField.clear();
        weightTextField.clear();
        System.out.println("Animal view closed");
    }

    private void showAlert(String title, String message) {

        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public Button getSaveButton() {
        return saveButton;
    }

    public Button getCloseButton() {
        return closeButton;
    }

}
