package Interface;

import Gates.*;
import Interface.DrawLineFeature;
import Interface.GUI;
import Interface.MyFlowPane;
import Logic.Gate;
import Logic.GateFactory;
import Logic.GateType;
import Logic.MoveAndDropFeature;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

import java.net.MalformedURLException;

/**
 * Clase controladora del Drag & Drop principal.
 */
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
     * Event Handlers para el Drag & Drop.
     * @param wrapperPane - Panel donde se dibujan las compuertas.
     * @param myFlowPane - Panel desde donde se arrastran las compuertas.
     */
    public void myDragAndDrop(Pane wrapperPane, MyFlowPane myFlowPane) {
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

        wrapperPane.setOnDragOver(event -> {
            if (event.getGestureSource() != wrapperPane && event.getDragboard().hasImage()) {
                event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
            }
            event.consume();
        });

        wrapperPane.setOnDragDropped(event -> {
            Dragboard db = event.getDragboard();
            boolean success;
            if (db.hasImage()) {
                switch (gateType) {
                    case AND: {
                        Gate newGate = null;
                        Rectangle newRect = new Rectangle(event.getX() - 35, event.getY() - 15, 75, 30);
                        try {
                            newGate = GateFactory.getGate(GateType.AND);
                            newRect.setFill(new ImagePattern(newGate.getImage()));
                            wrapperPane.getChildren().add(newRect);
                            newGate.canvasDragAndDrop(wrapperPane);

                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        } finally {
                            System.out.println(1);
                            //GUI.labelList.add(newLabel);
                            System.out.println(2);
                            GUI.gateList.add(newGate);
                            System.out.println(3);
                            System.out.println(GUI.gateList.size());
                        }
                        break; }
                    case NAND: {
                        Gate newGate = null;
                        Rectangle newRect = new Rectangle(event.getX() - 35, event.getY() - 15, 75, 30);
                        try {
                            newGate = GateFactory.getGate(GateType.NAND);
                            newRect.setFill(new ImagePattern(newGate.getImage()));
                            wrapperPane.getChildren().add(newRect);
                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        }
                        break;
                    }
                    case OR: {
                        try {
                            Gate newGate = GateFactory.getGate(GateType.OR);
                            Label newLabel = new Label();
                            newLabel.setLayoutX(event.getX() - 35);
                            newLabel.setLayoutY(event.getY() - 15);
                            wrapperPane.getChildren().add(newLabel);

                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        }
                        break;
                    }
                    case NOR: {
                        try {
                            Gate newGate = GateFactory.getGate(GateType.NOR);
                            Label newLabel = new Label();
                            newLabel.setLayoutX(event.getX() - 35);
                            newLabel.setLayoutY(event.getY() - 15);
                            wrapperPane.getChildren().add(newLabel);

                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        }
                        break;
                    }
                    case XOR: {
                        try {
                            Gate newGate = GateFactory.getGate(GateType.XOR);
                            Label newLabel = new Label();
                            newLabel.setLayoutX(event.getX() - 35);
                            newLabel.setLayoutY(event.getY() - 15);
                            wrapperPane.getChildren().add(newLabel);

                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        }
                        break;
                    }
                    case XNOR: {
                        try {
                            Gate newGate = GateFactory.getGate(GateType.XNOR);
                            Label newLabel = new Label();
                            newLabel.setLayoutX(event.getX() - 35);
                            newLabel.setLayoutY(event.getY() - 15);
                            wrapperPane.getChildren().add(newLabel);

                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        }
                        break;
                    }
                    case NOT: {
                        try {
                            Gate newGate = GateFactory.getGate(GateType.NOT);
                            Label newLabel = new Label();
                            newLabel.setLayoutX(event.getX() - 35);
                            newLabel.setLayoutY(event.getY() - 15);
                            wrapperPane.getChildren().add(newLabel);

                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        }
                        break;
                    }
                }
                success = true;
                event.setDropCompleted(success);
                event.consume();
            }
        });
    }
}