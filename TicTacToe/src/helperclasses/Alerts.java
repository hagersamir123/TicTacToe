/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helperclasses;

import java.util.List;
import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextInputDialog;

/**
 *
 * @author Mohamed Elsayed
 */
public class Alerts {

    private static TextInputDialog dialog;
    private static Alert alert;

    public static String getInput(String title, String header, String prompet) {
        dialog = new TextInputDialog();
        dialog.setTitle(title);
        dialog.setHeaderText(header);
        dialog.setContentText(prompet);
        Optional<String> result = dialog.showAndWait();

        if (!result.isPresent()) {
            return null;
        }
        return result.get();
    }

    public static void showAlert(Alert.AlertType type, String title, String header, String content) {
        alert = new Alert(type);
        alert.getButtonTypes().clear();
        alert.getButtonTypes().add(ButtonType.OK);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }

    public static Optional<ButtonType> showYesNoAlert(Alert.AlertType type, String title, String header, String content) {
        alert = new Alert(type);
        alert.getButtonTypes().clear();
        alert.getButtonTypes().add(ButtonType.YES);
        alert.getButtonTypes().add(ButtonType.NO);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        Optional<ButtonType> result = alert.showAndWait();
        if (!result.isPresent()) {
            return null;
        }
        return result;
    }

    public static Optional<ButtonType> showMultiOpsAlert(List<ButtonType> buttons, String title, String header, String content) {
        alert = new Alert(Alert.AlertType.NONE);
        for(ButtonType button: buttons){
            alert.getButtonTypes().add(button);
        }
        
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        Optional<ButtonType> result = alert.showAndWait();
        if (!result.isPresent()) {
            return null;
        }
        return result;
    }
}
