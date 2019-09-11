package logica;

import javafx.application.Application;
import javafx.stage.Stage;
/**
 * Mátodo principal de la aplicación
 * @author José Julián Camacho
 * @date 4.9.19
 * */
public class Main extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        GUI.createInterface(primaryStage);
    }
}