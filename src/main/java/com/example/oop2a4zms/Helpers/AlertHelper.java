package com.example.oop2a4zms.Helpers;

import javafx.scene.control.Alert;

/**
 * A helper class for displaying alert messages in a JavaFX application.
 * This class provides methods to show warning and confirmation dialogs with customizable messages.
 */
public class AlertHelper {

    /**
     * Displays a warning alert dialog with the specified message.
     *
     * @param pMessage The message to be displayed in the warning alert dialog.
     */
    public static void showWarning(String pMessage) {
        Alert alert = new Alert(Alert.AlertType.WARNING, pMessage);
        alert.showAndWait();
    }

    /**
     * Displays a confirmation alert dialog with the specified message.
     *
     * @param pMessage The message to be displayed in the confirmation alert dialog.
     */
    public static void showConfirmation(String pMessage) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, pMessage);
        alert.showAndWait();
    }
}
