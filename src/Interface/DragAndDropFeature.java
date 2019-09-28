package Interface;

import Gates.*;
import Logic.Gate;
import Logic.GateFactory;
import Logic.GateType;
import javafx.scene.Cursor;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.Pane;

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
    private TrueGate trueGate = new TrueGate();
    private FalseGate falseGate = new FalseGate();

    public DragAndDropFeature() throws MalformedURLException {
    }

    public void myDragAndDrop(Pane wrapperPane, MyFlowPane myFlowPane) {
        myFlowPane.getiV1().setOnDragDetected(event -> {
            Dragboard db = myFlowPane.getiV1().startDragAndDrop(TransferMode.ANY);
            ClipboardContent content = new ClipboardContent();
            content.putImage(and.getImage());
            db.setContent(content);
            myFlowPane.getiV1().setCursor(Cursor.CLOSED_HAND);
            gateType = GateType.AND;
            event.consume();
        });

        myFlowPane.getiV2().setOnDragDetected(event -> {
            Dragboard db = myFlowPane.getiV2().startDragAndDrop(TransferMode.ANY);
            ClipboardContent content = new ClipboardContent();
            content.putImage(nand.getImage());
            db.setContent(content);
            myFlowPane.getiV2().setCursor(Cursor.CLOSED_HAND);
            gateType = GateType.NAND;
            event.consume();
        });

        myFlowPane.getiV3().setOnDragDetected(event -> {
            Dragboard db = myFlowPane.getiV3().startDragAndDrop(TransferMode.ANY);
            ClipboardContent content = new ClipboardContent();
            content.putImage(or.getImage());
            db.setContent(content);
            myFlowPane.getiV3().setCursor(Cursor.CLOSED_HAND);
            gateType = GateType.OR;
            event.consume();
        });

        myFlowPane.getiV4().setOnDragDetected(event -> {
            Dragboard db = myFlowPane.getiV4().startDragAndDrop(TransferMode.ANY);
            ClipboardContent content = new ClipboardContent();
            content.putImage(nor.getImage());
            db.setContent(content);
            myFlowPane.getiV4().setCursor(Cursor.CLOSED_HAND);
            gateType = GateType.NOR;
            event.consume();
        });

        myFlowPane.getiV5().setOnDragDetected(event -> {
            Dragboard db = myFlowPane.getiV5().startDragAndDrop(TransferMode.ANY);
            ClipboardContent content = new ClipboardContent();
            content.putImage(xor.getImage());
            db.setContent(content);
            myFlowPane.getiV5().setCursor(Cursor.CLOSED_HAND);
            gateType = GateType.XOR;
            event.consume();
        });

        myFlowPane.getiV6().setOnDragDetected(event -> {
            Dragboard db = myFlowPane.getiV6().startDragAndDrop(TransferMode.ANY);
            ClipboardContent content = new ClipboardContent();
            content.putImage(xnor.getImage());
            db.setContent(content);
            myFlowPane.getiV6().setCursor(Cursor.CLOSED_HAND);
            gateType = GateType.XNOR;
            event.consume();
        });

        myFlowPane.getiV7().setOnDragDetected(event -> {
            Dragboard db = myFlowPane.getiV7().startDragAndDrop(TransferMode.ANY);
            ClipboardContent content = new ClipboardContent();
            content.putImage(not.getImage());
            db.setContent(content);
            myFlowPane.getiV7().setCursor(Cursor.CLOSED_HAND);
            gateType = GateType.NOT;
            event.consume();
        });

        myFlowPane.getiV8().setOnDragDetected(event -> {
            Dragboard db = myFlowPane.getiV8().startDragAndDrop(TransferMode.ANY);
            ClipboardContent content = new ClipboardContent();
            content.putImage(trueGate.getImage());
            db.setContent(content);
            myFlowPane.getiV8().setCursor(Cursor.CLOSED_HAND);
            gateType = GateType.TRUE;
            event.consume();
        });

        myFlowPane.getiV9().setOnDragDetected(event -> {
            Dragboard db = myFlowPane.getiV9().startDragAndDrop(TransferMode.ANY);
            ClipboardContent content = new ClipboardContent();
            content.putImage(falseGate.getImage());
            db.setContent(content);
            myFlowPane.getiV9().setCursor(Cursor.CLOSED_HAND);
            gateType = GateType.FALSE;
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
                        try {
                            Gate newGateAND = GateFactory.getGate(GateType.AND);
                            newGateAND.createGateInterface(wrapperPane, event.getX()-30, event.getY()-10);
                            GUI.gateList.addLast(newGateAND);
                            GUI.generalList.addLast(newGateAND);
                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        }
                        break;
                        }
                    case NAND: {
                        try {
                            Gate newGateNAND = GateFactory.getGate(GateType.NAND);
                            newGateNAND.createGateInterface(wrapperPane, event.getX()-30, event.getY()-10);
                            GUI.gateList.addLast(newGateNAND);
                            GUI.generalList.addLast(newGateNAND);
                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        }
                        break;
                    }
                    case OR: {
                        try {
                            Gate newGateOR = GateFactory.getGate(GateType.OR);
                            newGateOR.createGateInterface(wrapperPane, event.getX()-30, event.getY()-10);
                            GUI.gateList.addLast(newGateOR);
                            GUI.generalList.addLast(newGateOR);
                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        }
                        break;
                    }
                    case NOR: {
                        try {
                            Gate newGateNOR = GateFactory.getGate(GateType.NOR);
                            newGateNOR.createGateInterface(wrapperPane, event.getX()-30, event.getY()-10);
                            GUI.gateList.addLast(newGateNOR);
                            GUI.generalList.addLast(newGateNOR);
                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        }
                        break;
                    }
                    case XOR: {
                        try {
                            Gate newGateXOR = GateFactory.getGate(GateType.XOR);
                            newGateXOR.createGateInterface(wrapperPane, event.getX()-30, event.getY()-10);
                            GUI.gateList.addLast(newGateXOR);
                            GUI.generalList.addLast(newGateXOR);
                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        }
                        break;
                    }
                    case XNOR: {
                        try {
                            Gate newGateXNOR = GateFactory.getGate(GateType.XNOR);
                            newGateXNOR.createGateInterface(wrapperPane, event.getX()-30, event.getY()-10);
                            GUI.gateList.addLast(newGateXNOR);
                            GUI.generalList.addLast(newGateXNOR);
                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        }
                        break;
                    }
                    case NOT: {
                        try {
                            Gate newGateNOT = GateFactory.getGate(GateType.NOT);
                            newGateNOT.createGateInterface(wrapperPane, event.getX()-30, event.getY()-10);
                            GUI.gateList.addLast(newGateNOT);
                            GUI.generalList.addLast(newGateNOT);
                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        }
                        break;
                    }
                    case TRUE: {
                        try {
                            Gate newGateTrue = GateFactory.getGate(GateType.TRUE);
                            newGateTrue.createGateInterface(wrapperPane, event.getX()-13, event.getY()-13);
                            GUI.generalList.addLast(newGateTrue);
                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        }
                        break;
                    }
                    case FALSE: {
                        try {
                            Gate newGateFalse = GateFactory.getGate(GateType.FALSE);
                            newGateFalse.createGateInterface(wrapperPane, event.getX()-13, event.getY()-13);
                            GUI.generalList.addLast(newGateFalse);
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