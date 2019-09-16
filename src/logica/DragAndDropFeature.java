package logica;

import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;

import java.awt.*;

public class DragAndDropFeature {

    private GateType gateType;
    /**
     * Event Handlers para el Drag & Drop
     * */
    public void myDragAndDrop(MyFlowPane myFlowPane, Canvas canvas, GraphicsContext gc) {
        myFlowPane.getiV1().setOnDragDetected(event -> {
            Dragboard db = myFlowPane.getiV1().startDragAndDrop(TransferMode.ANY);
            ClipboardContent content = new ClipboardContent(); content.putImage(myFlowPane.getANDimage());
            db.setContent(content);
            gateType = GateType.AND;
            event.consume();
        });

        myFlowPane.getiV2().setOnDragDetected(event -> {
            Dragboard db = myFlowPane.getiV2().startDragAndDrop(TransferMode.ANY);
            ClipboardContent content = new ClipboardContent(); content.putImage(myFlowPane.getNANDimage());
            db.setContent(content);
            gateType = GateType.NAND;
            event.consume();
        });

        myFlowPane.getiV3().setOnDragDetected(event -> {
            Dragboard db = myFlowPane.getiV3().startDragAndDrop(TransferMode.ANY);
            ClipboardContent content = new ClipboardContent(); content.putImage(myFlowPane.getORimage());
            db.setContent(content);
            gateType = GateType.OR;
            event.consume();
        });

        myFlowPane.getiV4().setOnDragDetected(event -> {
            Dragboard db = myFlowPane.getiV4().startDragAndDrop(TransferMode.ANY);
            ClipboardContent content = new ClipboardContent(); content.putImage(myFlowPane.getNORimage());
            db.setContent(content);
            gateType = GateType.NOR;
            event.consume();
        });

        myFlowPane.getiV5().setOnDragDetected(event -> {
            Dragboard db = myFlowPane.getiV5().startDragAndDrop(TransferMode.ANY);
            ClipboardContent content = new ClipboardContent(); content.putImage(myFlowPane.getXORimage());
            db.setContent(content);
            gateType = GateType.XOR;
            event.consume();
        });

        myFlowPane.getiV6().setOnDragDetected(event -> {
            Dragboard db = myFlowPane.getiV6().startDragAndDrop(TransferMode.ANY);
            ClipboardContent content = new ClipboardContent(); content.putImage(myFlowPane.getXNORimage());
            db.setContent(content);
            gateType = GateType.XNOR;
            event.consume();
        });

        myFlowPane.getiV7().setOnDragDetected(event -> {
            Dragboard db = myFlowPane.getiV7().startDragAndDrop(TransferMode.ANY);
            ClipboardContent content = new ClipboardContent(); content.putImage(myFlowPane.getNOTimage());
            db.setContent(content);
            gateType = GateType.NOT;
            event.consume();
        });

        canvas.setOnDragOver(new EventHandler <DragEvent>() {
            public void handle(DragEvent event) {
                /* accept it only if it is  not dragged from the same node
                 * and if it has a string data */
                if (event.getGestureSource() != canvas && event.getDragboard().hasImage()) {
                    /* allow for both copying and moving, whatever user chooses */
                    event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
                }

                event.consume();
            }
        });

        canvas.setOnDragDropped(new EventHandler<DragEvent>() {
            public void handle(DragEvent event) {
                int xMouse = (MouseInfo.getPointerInfo().getLocation().x - 320);
                int yMouse = (MouseInfo.getPointerInfo().getLocation().y - 150);
                System.out.println(xMouse);
                System.out.println(yMouse);
                System.out.println("onDragDropped");
                Dragboard db = event.getDragboard();
                boolean success;
                if (db.hasImage()) {
                    switch (gateType) {
                        case AND: {
                            //GateFactory.getGate(GateType.AND);
                            gc.drawImage(myFlowPane.getANDimage(), event.getX()-32, event.getY()-15);
                            success = true; event.setDropCompleted(success);
                            event.consume();
                            break;
                        }
                        case NAND: {
                            gc.drawImage(myFlowPane.getNANDimage(), event.getX()-32, event.getY()-15);
                            success = true; event.setDropCompleted(success);
                            event.consume();
                            break;
                        }
                        case OR: {
                            gc.drawImage(myFlowPane.getORimage(), event.getX()-32, event.getY()-15);
                            success = true; event.setDropCompleted(success);
                            event.consume(); break;
                        }
                        case NOR: {
                            gc.drawImage(myFlowPane.getNORimage(), event.getX()-32, event.getY()-15);
                            success = true; event.setDropCompleted(success);
                            event.consume(); break;
                        }
                        case XOR: {
                            gc.drawImage(myFlowPane.getXORimage(), event.getX()-32, event.getY()-15);
                            success = true; event.setDropCompleted(success);
                            event.consume(); break;
                        }
                        case XNOR: {
                            gc.drawImage(myFlowPane.getXNORimage(), event.getX()-32, event.getY()-15);
                            success = true; event.setDropCompleted(success);
                            event.consume(); break;
                        }
                        case NOT: {
                            gc.drawImage(myFlowPane.getNOTimage(), event.getX()-32, event.getY()-15);
                            success = true; event.setDropCompleted(success);
                            event.consume(); break;
                        }
                    }
                }
            }
        });
    }
}
