package Interface;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.File;
import java.net.MalformedURLException;

public class MenuWindow {

    public static Stage createMenu(Stage primaryStage) throws MalformedURLException {
        primaryStage.setTitle("Menu");
        StackPane bp = new StackPane();
        Scene scene = new Scene(bp, 400, 300);

        File newFile = new File("./src/GateImages/BGMenu.png");
        Image background = new Image(newFile.toURI().toURL().toString());
        ImageView imageV1 = new ImageView(background);

        Button buttonStart = new Button("Start");
        buttonStart.setPrefSize(100, 20);
        buttonStart.setAlignment(Pos.BASELINE_CENTER);
        buttonStart.setOnMouseClicked(event -> {
            try {
                GUI.createInterface();
                primaryStage.close();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        });
        bp.getChildren().addAll(imageV1, buttonStart);

        primaryStage.setScene(scene);
        primaryStage.show();

        return primaryStage;
    }
}
