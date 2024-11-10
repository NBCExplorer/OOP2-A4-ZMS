package com.example.oop2a4zms.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import com.example.oop2a4zms.Model.Animal;
import javafx.stage.Stage;

public class AnimalViewController {

    private Animal currentAnimal;

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
    public void initialize() {
        if (sexComboBox.getItems().isEmpty()) {
            sexComboBox.getItems().addAll("Male", "Female");
        }
    }

    public void setAnimal(Animal animal) {
        this.currentAnimal = animal;
        if (animal != null) {
            nameTextField.setText(animal.getName());
            sexComboBox.setValue(animal.getSex());
            ageTextField.setText(String.valueOf(animal.getAge()));
            weightTextField.setText(String.valueOf(animal.getWeight()));
        }
    }

    @FXML
    private void handleSaveButton() {
        if (currentAnimal != null) {
            currentAnimal.setName(nameTextField.getText());
            currentAnimal.setSex(sexComboBox.getValue());
            try {
                currentAnimal.setAge(Integer.parseInt(ageTextField.getText()));
                currentAnimal.setWeight(Double.parseDouble(weightTextField.getText()));
            } catch (NumberFormatException e) {
                showAlert("Invalid Input", "Enter valid numbers for age and weight!");
                return;
            }
            System.out.println("Animal updated successfully: " + currentAnimal);

            // Close the stage after saving
            closeWindow();
        } else {
            showAlert("No Animal Selected", "Please select an animal to edit.");
        }
    }

    @FXML
    private void handleCloseButton() {
        System.out.println("Close button clicked");
        nameTextField.clear();
        sexComboBox.setValue(null);
        ageTextField.clear();
        weightTextField.clear();


        closeWindow();
    }
    private void closeWindow() {
        Stage stage = (Stage) saveButton.getScene().getWindow();
        stage.close();
    }



    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
