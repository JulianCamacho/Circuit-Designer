package Interface;

import DoublyLinkedList_Pack.DoublyLinkedList;
import Gates.AND;
import Gates.OR;
import Logic.*;
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

/**
 * Clase que contiene y controla la interfaz gráfica.
 */
public class GUI {

    protected static Pane wrapperPane;
    protected static Scene scene;
    public static DoublyLinkedList gateList;

    /**
     * Método para crear la pantalla principal.
     * @param primaryStage
     * @return Stage - retorna el Stage principal modificado de la aplicación.
     * @throws MalformedURLException
     */

    public static Stage createInterface(Stage primaryStage) throws MalformedURLException {
        primaryStage.setTitle("Circuit Designer");

        /**
         * Creación de stages, scenes, canvas, graphicsContext, bases de la aplicación
         **/
        BorderPane root = new BorderPane();
        scene = new Scene(root,900, 600, Color.LIGHTGRAY );
        wrapperPane = new Pane();
        wrapperPane.setPrefSize(1280, 720);
        root.setCenter(wrapperPane);

        //Implementación del ScrollPane
        ScrollPane scrollPane = new ScrollPane(wrapperPane);
        scrollPane.setPrefSize(700, 300);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        root.setMargin(scrollPane, new Insets(0, 0, 10, 10));
        root.setCenter(scrollPane);

        MyFlowPane myFlowPane = new MyFlowPane();
        root.setRight(myFlowPane.addFlowPane());

        HBox myHBox = addHBox();
        root.setTop(myHBox);

        primaryStage.setScene(scene);
        primaryStage.show();

        DragAndDropFeature dragdrop = new DragAndDropFeature();
        dragdrop.myDragAndDrop(wrapperPane, myFlowPane);

        gateList = new DoublyLinkedList();

        CanvasGrid.drawGrid(wrapperPane);

        return primaryStage;
    }

    /**
     * Método para obtener un HBox personalizado.
     * @return HBox - Panel horizontal donde se almacenan los botones
     */

    private static HBox addHBox() {
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(15, 12, 15, 12));
        hbox.setSpacing(10);
        hbox.setStyle("-fx-background-color: #336699;");

        Button buttonRun = new Button("Run");
        buttonRun.setPrefSize(100, 20);
        buttonRun.setOnMouseClicked(event -> gateList.printList());

        Button buttonSave = new Button("Save");
        buttonSave.setPrefSize(100, 20);
        buttonSave.setOnMouseClicked(event -> {
            AlertBox.displayResultAlertBox("Demasiado flow", "Stop");
        });

        Button buttonClear = new Button("Clear");
        buttonClear.setPrefSize(100, 20);
        buttonClear.setOnMouseClicked(event -> {
            wrapperPane.getChildren().clear();
            gateList.clearList();
            CanvasGrid.drawGrid(wrapperPane);
        });

        Button buttonTable = new Button("Generate Truth Table");
        buttonTable.setPrefSize(100, 20);
        buttonTable.setOnMouseClicked(event -> {
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
