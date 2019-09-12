package logica;

import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;

public class DragFeature {
    /**
     * Event Handlers para el Drag & Drop
     * */
    public void myDrag(MyFlowPane myFlowPane, Canvas canvas, GraphicsContext gc) {
        myFlowPane.getiV1().setOnDragDetected(event -> {
            Dragboard db = myFlowPane.getiV1().startDragAndDrop(TransferMode.ANY);
            ClipboardContent content = new ClipboardContent(); content.putImage(myFlowPane.getANDimage());
            db.setContent(content); event.consume();
        });

        myFlowPane.getiV2().setOnDragDetected(event -> {
            Dragboard db = myFlowPane.getiV2().startDragAndDrop(TransferMode.ANY);
            ClipboardContent content = new ClipboardContent(); content.putImage(myFlowPane.getNANDimage());
            db.setContent(content); event.consume();
        });

        myFlowPane.getiV3().setOnDragDetected(event -> {
            Dragboard db = myFlowPane.getiV3().startDragAndDrop(TransferMode.ANY);
            ClipboardContent content = new ClipboardContent(); content.putImage(myFlowPane.getORimage());
            db.setContent(content); event.consume();
        });

        myFlowPane.getiV4().setOnDragDetected(event -> {
            Dragboard db = myFlowPane.getiV4().startDragAndDrop(TransferMode.ANY);
            ClipboardContent content = new ClipboardContent(); content.putImage(myFlowPane.getNORimage());
            db.setContent(content); event.consume();
        });

        myFlowPane.getiV5().setOnDragDetected(event -> {
            Dragboard db = myFlowPane.getiV5().startDragAndDrop(TransferMode.ANY);
            ClipboardContent content = new ClipboardContent(); content.putImage(myFlowPane.getXORimage());
            db.setContent(content); event.consume();
        });

        myFlowPane.getiV6().setOnDragDetected(event -> {
            Dragboard db = myFlowPane.getiV6().startDragAndDrop(TransferMode.ANY);
            ClipboardContent content = new ClipboardContent(); content.putImage(myFlowPane.getXNORimage());
            db.setContent(content); event.consume();
        });

        myFlowPane.getiV7().setOnDragDetected(event -> {
            Dragboard db = myFlowPane.getiV7().startDragAndDrop(TransferMode.ANY);
            ClipboardContent content = new ClipboardContent(); content.putImage(myFlowPane.getNOTimage());
            db.setContent(content); event.consume();
        });

        canvas.setOnDragOver(new EventHandler <DragEvent>() {
            public void handle(DragEvent event) {
                /* data is dragged over the target */
                System.out.println("onDragOver");

                /* accept it only if it is  not dragged from the same node
                 * and if it has a string data */
                if (event.getGestureSource() != canvas &&
                        event.getDragboard().hasImage()) {
                    /* allow for both copying and moving, whatever user chooses */
                    event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
                }

                event.consume();
            }
        });

        canvas.setOnDragDropped(new EventHandler<DragEvent>() {
            public void handle(DragEvent event) {
                /* data dropped */
                System.out.println("onDragDropped");
                Dragboard db = event.getDragboard();
                boolean success;
                if (db.hasImage()) {
                    gc.drawImage(myFlowPane.getANDimage(), 50, 30);
                    success = true;
                    event.setDropCompleted(success);
                }
                event.consume();
            }
        });

    }
}
