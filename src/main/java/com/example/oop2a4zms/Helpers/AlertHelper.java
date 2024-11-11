package com.example.oop2a4zms.Helpers;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import java.util.Optional;

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
     * Returns true if the user confirms, false otherwise.
     *
     * @param pMessage The message to be displayed in the confirmation alert dialog.
     * @return boolean indicating user's confirmation choice
     */
    public static boolean showConfirmation(String pMessage) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, pMessage, ButtonType.YES, ButtonType.NO);
        Optional<ButtonType> result = alert.showAndWait();
        return result.isPresent() && result.get() == ButtonType.YES;
    }
}
