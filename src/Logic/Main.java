package Logic;
import Interface.MenuWindow;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Clase principal para iniciar la aplicación.
 *  * @author José Julián Camacho
 *  * @date 4.9.19
 */
public class Main extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    /**
     * Método principal para inicializar la aplicación.
     * @param primaryStage - Stage de la pantalla principal.
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        MenuWindow.createMenu(primaryStage);
    }
}