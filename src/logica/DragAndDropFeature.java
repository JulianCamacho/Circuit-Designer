package logica;

import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.Pane;

import java.awt.*;
import java.net.MalformedURLException;

public class DragAndDropFeature {

    private GateType gateType;
    private AND and = new AND();
    private NAND nand = new NAND();
    private OR or = new OR();
    private NOR nor = new NOR();
    private XOR xor = new XOR();
    private XNOR xnor = new XNOR();
    private NOT not = new NOT();

    public DragAndDropFeature() throws MalformedURLException {
    }

    /**
     * Event Handlers para el Drag & Drop
     */
    public void myDragAndDrop(MyFlowPane myFlowPane, Canvas canvas, GraphicsContext gc) {
        myFlowPane.getiV1().setOnDragDetected(event -> {
            Dragboard db = myFlowPane.getiV1().startDragAndDrop(TransferMode.ANY);
            ClipboardContent content = new ClipboardContent();
            content.putImage(and.getImage());
            db.setContent(content);
            gateType = GateType.AND;
            event.consume();
        });

        myFlowPane.getiV2().setOnDragDetected(event -> {
            Dragboard db = myFlowPane.getiV2().startDragAndDrop(TransferMode.ANY);
            ClipboardContent content = new ClipboardContent();
            content.putImage(nand.getImage());
            db.setContent(content);
            gateType = GateType.NAND;
            event.consume();
        });

        myFlowPane.getiV3().setOnDragDetected(event -> {
            Dragboard db = myFlowPane.getiV3().startDragAndDrop(TransferMode.ANY);
            ClipboardContent content = new ClipboardContent();
            content.putImage(or.getImage());
            db.setContent(content);
            gateType = GateType.OR;
            event.consume();
        });

        myFlowPane.getiV4().setOnDragDetected(event -> {
            Dragboard db = myFlowPane.getiV4().startDragAndDrop(TransferMode.ANY);
            ClipboardContent content = new ClipboardContent();
            content.putImage(nor.getImage());
            db.setContent(content);
            gateType = GateType.NOR;
            event.consume();
        });

        myFlowPane.getiV5().setOnDragDetected(event -> {
            Dragboard db = myFlowPane.getiV5().startDragAndDrop(TransferMode.ANY);
            ClipboardContent content = new ClipboardContent();
            content.putImage(xor.getImage());
            db.setContent(content);
            gateType = GateType.XOR;
            event.consume();
        });

        myFlowPane.getiV6().setOnDragDetected(event -> {
            Dragboard db = myFlowPane.getiV6().startDragAndDrop(TransferMode.ANY);
            ClipboardContent content = new ClipboardContent();
            content.putImage(xnor.getImage());
            db.setContent(content);
            gateType = GateType.XNOR;
            event.consume();
        });

        myFlowPane.getiV7().setOnDragDetected(event -> {
            Dragboard db = myFlowPane.getiV7().startDragAndDrop(TransferMode.ANY);
            ClipboardContent content = new ClipboardContent();
            content.putImage(not.getImage());
            db.setContent(content);
            gateType = GateType.NOT;
            event.consume();
        });

        canvas.setOnDragOver(new EventHandler<DragEvent>() {
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
                System.out.println("onDragDropped");
                Dragboard db = event.getDragboard();
                boolean success;
                if (db.hasImage()) {
                    switch (gateType) {
                        case AND: {
                            gc.drawImage(and.getImage(), event.getX() - 35, event.getY() - 15);
                            break;
                        }
                        case NAND: {
                            gc.drawImage(nand.getImage(), event.getX() - 35, event.getY() - 15);

                            break;
                        }
                        case OR: {
                            gc.drawImage(or.getImage(), event.getX() - 35, event.getY() - 15);
                            success = true;
                            event.setDropCompleted(success);
                            event.consume();
                            break;
                        }
                        case NOR: {
                            gc.drawImage(nor.getImage(), event.getX() - 35, event.getY() - 15);

                            break;
                        }
                        case XOR: {
                            gc.drawImage(xor.getImage(), event.getX() - 35, event.getY() - 15);

                            break;
                        }
                        case XNOR: {
                            gc.drawImage(xnor.getImage(), event.getX() - 35, event.getY() - 15);

                            break;
                        }
                        case NOT: {
                            gc.drawImage(not.getImage(), event.getX() - 35, event.getY() - 15);

                            break;
                        }
                    }
                    success = true;
                    event.setDropCompleted(success);
                    event.consume();
                }
            }
        });
    }

        public static boolean avoidOverlap (Canvas canvas, GraphicsContext gc){
            return false;
        }
}