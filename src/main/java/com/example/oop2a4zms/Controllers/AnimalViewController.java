package com.example.oop2a4zms.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import com.example.oop2a4zms.Helpers.AlertHelper;
import com.example.oop2a4zms.Model.Animal;
import javafx.stage.Stage;

public class AnimalViewController {

    private Animal aCurrentAnimal;

    @FXML
    private TextField aNameTextField;
    @FXML
    private ComboBox<String> aSexComboBox;
    @FXML
    private TextField aAgeTextField;
    @FXML
    private TextField aWeightTextField;
    @FXML
    private Button aSaveButton;

    @FXML
    public void initialize() {
        if (aSexComboBox.getItems().isEmpty()) {
            aSexComboBox.getItems().addAll("Male", "Female");
        }
    }

    public void setAnimal(Animal pAnimal) {
        this.aCurrentAnimal = pAnimal;

        if (pAnimal != null) {
            aNameTextField.setText(pAnimal.getName());
            aSexComboBox.setValue(pAnimal.getSex());
            aAgeTextField.setText(String.valueOf(pAnimal.getAge()));
            aWeightTextField.setText(String.valueOf(pAnimal.getWeight()));

        } else {

            aNameTextField.clear();
            aSexComboBox.setValue(null);
            aAgeTextField.clear();
            aWeightTextField.clear();
        }
    }

    @FXML
    private void handleSaveButton() {

        if (aCurrentAnimal != null) {
            String name = aNameTextField.getText().trim();
            String sex = aSexComboBox.getValue();
            String ageText = aAgeTextField.getText().trim();
            String weightText = aWeightTextField.getText().trim();


            if (name.isEmpty() || sex == null || ageText.isEmpty() || weightText.isEmpty()) {
                AlertHelper.showWarning("Missing Information: Please fill in all fields!");
                return;
            }
            aCurrentAnimal.setName(name);
            aCurrentAnimal.setSex(sex);


            try {

                int age = Integer.parseInt(ageText);
                double weight = Double.parseDouble(weightText);

                if (age < 0 || weight < 0) {
                    AlertHelper.showWarning("Invalid Input: Age and weight must be positive numbers!");
                    return;
                }

                aCurrentAnimal.setAge(age);
                aCurrentAnimal.setWeight(weight);
            } catch (NumberFormatException e) {
                AlertHelper.showWarning("Invalid Input: Enter valid numbers for age and weight!");
                return;
            }


            closeWindow();
        } else {
            AlertHelper.showWarning("No Animal Selected: Please select an animal to edit!");
        }
    }

    @FXML
    private void handleCloseButton() {
        boolean confirmClose = AlertHelper.showConfirmation("Are you sure you want to close without saving?");
        if (confirmClose) {
            closeWindow();
        }
    }


    private void closeWindow() {
        Stage stage = (Stage) aSaveButton.getScene().getWindow();
        stage.close();
    }
}
