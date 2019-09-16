package logica;

import javafx.scene.control.Alert;

public class AlertBox {

    public static void displayAlertBox(String title, String message){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
