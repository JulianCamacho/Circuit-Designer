package logica;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class GUI {

    public static Stage createInterface(Stage primaryStage) {
        primaryStage.setTitle("Circuit Designer");

        /**
         * Creación de stages, scenes, canvas, graphicsContext, bases de la aplicación
         **/
        Group root = new Group();
        BorderPane bp = new BorderPane();
        Scene scene = new Scene(root, 800, 600, Color.LIGHTGRAY );
        Canvas canvas = new Canvas();
        bp.setRight(addFlowPane());
        bp.setTop(addHBox());
        bp.setCenter(canvas);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        root.getChildren().addAll(canvas, bp);

        primaryStage.setScene(scene);
        primaryStage.show();


    bp.setOnDragDetected(event -> {
        /* drag was detected, start drag-and-drop gesture*/
        System.out.println("onDragDetected");
        /* allow any transfer mode */
        Dragboard db = bp.startDragAndDrop(TransferMode.ANY);

        ClipboardContent content = new ClipboardContent();
        content.getImage();
        });

        return primaryStage;

    }
    private static FlowPane addFlowPane() {
        FlowPane flow = new FlowPane();
        flow.setPadding(new Insets(5, 0, 5, 0));
        flow.setVgap(4);
        flow.setHgap(4);
        flow.setPrefWrapLength(170); // preferred width allows for two columns
        flow.setStyle("-fx-background-color: DAE6F3;");

        //Image image1 = new Image("./bmwi_.png");
        //ImageView iV1 = new ImageView();
        //iV1.setImage(image1);

        //flow.getChildren().add(iV1);

        return flow;
    }

    private static HBox addHBox() {
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(15, 12, 15, 12));
        hbox.setSpacing(10);
        hbox.setStyle("-fx-background-color: #336699;");

        Button buttonCurrent = new Button("Current");
        buttonCurrent.setPrefSize(100, 20);

        Button buttonProjected = new Button("Projected");
        buttonProjected.setPrefSize(100, 20);
        hbox.getChildren().addAll(buttonCurrent, buttonProjected);

        return hbox;
    }

    private static VBox addVBox() {
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10));
        vbox.setSpacing(8);
        return vbox;
    }

}
