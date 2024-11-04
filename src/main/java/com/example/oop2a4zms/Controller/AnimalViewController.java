package com.example.oop2a4zms.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import com.example.oop2a4zms.Model.Animal; // Verify that this matches the actual location of the Animal class

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
        sexComboBox.getItems().addAll("Male", "Female");
    }

    @FXML
    private void handleSaveButton() {
        String name = nameTextField.getText();
        String sex = sexComboBox.getValue();
        int age;
        double weight;

        try {
            age = Integer.parseInt(ageTextField.getText());
            weight = Double.parseDouble(weightTextField.getText());
        } catch (NumberFormatException e) {
            showAlert("Invalid Input", "Please enter valid numbers for age and weight.");
            return;
        }

        if (name.isEmpty() || sex == null) {
            showAlert("Missing Information", "Please fill in all fields.");
            return;
        }

        Animal animal = new Animal(name, age, sex, weight);
        System.out.println("Animal saved: " + animal.getName());
    }

    @FXML
    private void handleCloseButton() {
        nameTextField.clear();
        sexComboBox.setValue(null);
        ageTextField.clear();
        weightTextField.clear();
        System.out.println("Animal view closed.");
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
