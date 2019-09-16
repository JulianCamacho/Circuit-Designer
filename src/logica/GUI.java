package logica;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.net.MalformedURLException;

public class GUI {

    public static Stage createInterface(Stage primaryStage) throws MalformedURLException {
        primaryStage.setTitle("Circuit Designer");

        /**
         * Creación de stages, scenes, canvas, graphicsContext, bases de la aplicación
         **/
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root,800, 600, Color.LIGHTGRAY );
        // Create a wrapper Pane first
        Pane wrapperPane = new Pane();
        root.setCenter(wrapperPane);
        // Put canvas in the center of the window
        Canvas canvas = new Canvas(1280, 720);

        canvas.setOnMouseEntered(event -> {
            System.out.println("Aquí hay canvas");
        });


        wrapperPane.getChildren().add(canvas);

        MyFlowPane myFlowPane = new MyFlowPane();
        root.setRight(myFlowPane.addFlowPane());

        HBox myHBox = addHBox();
        root.setTop(myHBox);

        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.BLUE);

        primaryStage.setScene(scene);
        primaryStage.show();

        DragAndDropFeature dragdrop = new DragAndDropFeature();
        dragdrop.myDragAndDrop(myFlowPane, canvas, gc);

        DrawLineFeature drawLine = new DrawLineFeature();
        drawLine.myLineDrawer(canvas, gc);

        CanvasGrid canvasGrid = new CanvasGrid();
        canvasGrid.drawGrid(gc);

        return primaryStage;
    }

    /**
     * Método para obtener un HBox personalizado
     * */
    private static HBox addHBox() {
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(15, 12, 15, 12));
        hbox.setSpacing(10);
        hbox.setStyle("-fx-background-color: #336699;");

        Button buttonRun = new Button("Run");
        buttonRun.setPrefSize(100, 20);

        Button buttonSave = new Button("Save");
        buttonSave.setPrefSize(100, 20);
        buttonSave.setOnMouseClicked(event -> {
            System.out.println("skere");
        });

        Button buttonClear = new Button("Clear");
        buttonClear.setPrefSize(100, 20);

        Button buttonTable = new Button("Generate Truth Table");
        buttonTable.setPrefSize(100, 20);
        buttonTable.setOnMouseClicked(event -> {
            System.out.println("skuuu");
            TableWindow tableWindow = new TableWindow();
            try {
                tableWindow.createTableWindow();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

        });

        hbox.getChildren().addAll(buttonRun, buttonSave, buttonClear, buttonTable);

        return hbox;
    }

}
