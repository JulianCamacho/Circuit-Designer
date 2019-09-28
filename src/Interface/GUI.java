package Interface;

import DoublyLinkedList_Pack.DoublyLinkedList;
import Logic.CircuitSolver;
import Logic.Gate;
import Logic.TableWindow;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
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
    public static DoublyLinkedList generalList = new DoublyLinkedList();

    public static void createInterface() throws MalformedURLException {
        Stage secondaryStage = new Stage();
        secondaryStage.setTitle("Circuit Designer");

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

        secondaryStage.setScene(scene);
        secondaryStage.show();

        DragAndDropFeature dragdrop = new DragAndDropFeature();
        dragdrop.myDragAndDrop(wrapperPane, myFlowPane);

        gateList = new DoublyLinkedList();

        CanvasGrid.drawGrid(wrapperPane);
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
        buttonRun.setOnMouseClicked(event -> {
            try {
                CircuitSolver.evaluateFinalList(gateList);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        });

        Button buttonSave = new Button("Save");
        buttonSave.setPrefSize(100, 20);
        buttonSave.setOnMouseClicked(event -> gateList.printList());


        Button buttonClear = new Button("Clear");
        buttonClear.setPrefSize(100, 20);
        buttonClear.setOnMouseClicked(event -> {
            wrapperPane.getChildren().clear();
            gateList.clearList();
            gateList.setLength(0);
            generalList.clearList();
            generalList.setLength(0);
            Gate.setInNumber(0);
            Gate.setOutNumber(0);
            CanvasGrid.drawGrid(wrapperPane);
        });

        Button buttonTable = new Button("Generate Truth Table");
        buttonTable.setPrefSize(150, 20);
        buttonTable.setOnMouseClicked(event -> {
            try {
                TableWindow.createTableWindow();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        });

        hbox.getChildren().addAll(buttonRun, buttonClear, buttonTable, buttonSave);
        return hbox;
    }
}
