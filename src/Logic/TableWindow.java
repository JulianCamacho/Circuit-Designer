package Logic;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.net.MalformedURLException;

public class TableWindow {

    public static Stage createTableWindow() throws MalformedURLException {
        Stage tableStage = new Stage();
        tableStage.setTitle("Truth Table");
        /**
         * Creación de stages, scenes, canvas, graphicsContext, bases de la aplicación
         **/
        GridPane root2 = new GridPane();
        root2.setPadding(new Insets(10, 10, 10, 10));
        root2.setVgap(8);
        root2.setHgap(10);
        root2.setGridLinesVisible(true);

        Scene scene = new Scene(root2,300, 200, Color.LIGHTGRAY );

        Label result = new Label("Result");
        result.setPadding(new Insets(5, 5, 5, 5));
        GridPane.setConstraints(result, 0, 0);

        Label firstVar = new Label("firstVar");
        firstVar.setPadding(new Insets(5, 5, 5, 5));
        GridPane.setConstraints(firstVar, 1, 0);

        Label secondVar = new Label("secondVar");
        secondVar.setPadding(new Insets(5, 5, 5, 5));
        GridPane.setConstraints(secondVar, 2, 0);

        root2.getChildren().addAll(result, firstVar, secondVar);

        tableStage.setScene(scene);
        tableStage.show();

        return tableStage;
    }
}
