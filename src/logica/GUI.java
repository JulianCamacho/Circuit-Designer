package logica;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.net.MalformedURLException;

public class GUI {

    protected static Canvas canvas;
    protected static GraphicsContext gc;

    public static Stage createInterface(Stage primaryStage) throws MalformedURLException {
        primaryStage.setTitle("Circuit Designer");

        /**
         * Creación de stages, scenes, canvas, graphicsContext, bases de la aplicación
         **/
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root,900, 600, Color.LIGHTGRAY );
        // Create a wrapper Pane first
        Pane wrapperPane = new Pane();
        root.setCenter(wrapperPane);
        // Put canvas in the center of the window
        canvas = new Canvas(1280, 720);

        /**
         * Implementación de un scrollPane para el canvas
         */
        ScrollPane scrollPane = new ScrollPane(wrapperPane);
        scrollPane.setPrefSize(700, 300);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        root.setMargin(scrollPane, new Insets(0, 0, 10, 10));
        root.setCenter(scrollPane);

        canvas.setOnMouseEntered(event -> {
            System.out.println("Aquí hay canvas");
        });


        wrapperPane.getChildren().add(canvas);

        MyFlowPane myFlowPane = new MyFlowPane();
        root.setRight(myFlowPane.addFlowPane());

        gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.BLUE);

        HBox myHBox = addHBox(gc);
        root.setTop(myHBox);

        primaryStage.setScene(scene);
        primaryStage.show();

        DragAndDropFeature dragdrop = new DragAndDropFeature();
        dragdrop.myDragAndDrop(myFlowPane, canvas, gc);

        DrawLineFeature.myLineDrawer(canvas, gc);

        CanvasGrid.drawGrid(gc);

        return primaryStage;
    }

    /**
     * Método para obtener un HBox personalizado
     * */
    private static HBox addHBox(GraphicsContext gc) {
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
            AlertBox.displayAlertBox("Demasiado flow", "Stop");
        });

        /**
         * Botón para reiniciar el canvas
         */

        Button buttonClear = new Button("Clear");
        buttonClear.setPrefSize(100, 20);
        buttonClear.setOnMouseClicked(event -> {
            gc.restore();
            gc.clearRect(0, 0, 1300, 800);
            CanvasGrid.drawGrid(gc);
        });

        Button buttonTable = new Button("Generate Truth Table");
        buttonTable.setPrefSize(100, 20);
        buttonTable.setOnMouseClicked(event -> {
            System.out.println("skuuu");
            try {
                TableWindow.createTableWindow();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

        });

        hbox.getChildren().addAll(buttonRun, buttonSave, buttonClear, buttonTable);

        return hbox;
    }

}
