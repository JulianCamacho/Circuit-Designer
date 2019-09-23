package Interface;

import Logic.Gate;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

import static Interface.GUI.*;

public class DrawLineFeature {

    protected static Object source;
    protected static double posXi;
    protected static double posYi;
    protected static Object target;
    protected static double posXf;
    protected static double posYf;

    public static void myLineDrawer(Shape on) {
        on.setOnMouseClicked(eventEventHandler);
    }

    public static EventHandler<MouseEvent> eventEventHandler = new EventHandler<MouseEvent>(){
        @Override
        public void handle(MouseEvent event) {
            if (source == null){
                source = event.getSource();
                if (getType(source) == "output" || getType(source) == "pred"){
                    AlertBox.displayResultAlertBox("Selected", "Selected: " +  getGateName(source));
                    posXi = event.getX();
                    posYi = event.getY();
                }
            }
            else if (target == null) {
                target = event.getSource();
                if ((target != source) && (gateIdentity(source) != gateIdentity(target)) && (getType(source) != getType(target))) {
                    if (getType(source) == "output"){
                        realConnection(source, target);
                        AlertBox.displayResultAlertBox("Connected", "Connected to: " + shapeIdentity(target));
                        posXf = event.getX();
                        posYf = event.getY();
                        Line newLine = new Line(posXi, posYi, posXf, posYf);
                        newLine.setStroke(randomColor());
                        wrapperPane.getChildren().add(newLine);
                    }
                    else if (getType(source) == "pred"){
                        inputConnection(source, target);
                        AlertBox.displayResultAlertBox("Connected", "Connected to: " + shapeIdentity(target));
                        posXf = event.getX();
                        posYf = event.getY();
                        Line newLine = new Line(posXi, posYi, posXf, posYf);
                        newLine.setStroke(randomColor());
                        wrapperPane.getChildren().add(newLine);
                    }
                }
            }
            else if (target != null){
                source = null;
                target = null;
            }
        }
    };

    public static void inputConnection(Object source, Object target){
        if (getType(source) == "pred"){
            int i = 0;
            while (i < generalList.getLength()) {
                if (source.equals(generalList.getGate(i).getGateInterface())){
                    Gate sourceGate = generalList.getGate(i);
                    int j = 0;
                    while (j < gateList.getLength()){
                        if (target.equals(gateList.getGate(j).getGateIn1())){
                            Gate targetGate = gateIdentity(target);
                            sourceGate.realNext = targetGate;
                            targetGate.realPrev1 = sourceGate;
                            joinSource_Input1(sourceGate, targetGate);
                            sourceGate.setOutputState("input1");
                            System.out.println(sourceGate + sourceGate.getOutputState());
                            sourceGate.setOutConnected(true);
                            targetGate.setIn1Connected(true);
                            targetGate.setInput1State("true");
                            System.out.println("Conectados: " + sourceGate.getName() + "y" + targetGate.getName());
                            break;
                        }
                        if (target.equals(gateList.getGate(j).getGateIn2())){
                            Gate targetGate = gateIdentity(target);
                            sourceGate.realNext = targetGate;
                            targetGate.realPrev1 = sourceGate;
                            joinSource_Input2(sourceGate, targetGate);
                            sourceGate.setOutputState("input2");
                            System.out.println(sourceGate + sourceGate.getOutputState());
                            sourceGate.setOutConnected(true);
                            targetGate.setIn2Connected(true);
                            targetGate.setInput2State("true");
                            System.out.println("Conectados: " + sourceGate.getName() + "y" + targetGate.getName());
                            break;
                        }
                        j++;
                    }
                }
                i++;
            }
        }
    }

    public static void realConnection(Object source, Object target){
        if (gateList.isEmpty() == false){
            int i = 0;
            while (i < gateList.getLength()) {
                if (source.equals(gateList.getGate(i).getGateOut())){
                    Gate sourceGate = gateIdentity(source);
                    int j = 0;
                    while (j < gateList.getLength()){
                        if (target.equals(gateList.getGate(j).getGateIn1())){
                            Gate targetGate = gateIdentity(target);
                            sourceGate.realNext = targetGate;
                            targetGate.realPrev1 = sourceGate;
                            joinSource_Input1(sourceGate, targetGate);
                            sourceGate.setOutputState("input1");
                            sourceGate.setOutConnected(true);
                            targetGate.setIn1Connected(true);
                            //targetGate.setInput1State("true");
                            System.out.println("Conectados: " + sourceGate.getName() + "y" + targetGate.getName());
                            break;
                        }
                        if (target.equals(gateList.getGate(j).getGateIn2())){
                            Gate targetGate = gateIdentity(target);
                            sourceGate.realNext = targetGate;
                            targetGate.realPrev2 = sourceGate;
                            joinSource_Input2(sourceGate, targetGate);
                            sourceGate.setOutputState("input2");
                            sourceGate.setOutConnected(true);
                            targetGate.setIn2Connected(true);
                            //targetGate.setInput2State("true");
                            System.out.println("Conectados: " + sourceGate.getName() + "y" + targetGate.getName());
                        }
                        j++;
                    }
                }
                i++;
            }
        }
    }

    public static void joinSource_Input1(Gate source, Gate target){
        target.input1 = source.output;
    }

    public static void joinSource_Input2(Gate source, Gate target){
        target.input2 = source.output;
    }


    public static String getType(Object source){
        if (generalList.isEmpty() == false){
            int i = 0;
            while (i < generalList.getLength()) {
                if (source.equals(generalList.getGate(i).getGateIn1()) || source.equals(generalList.getGate(i).getGateIn2())){
                    return "input";
                }
                else if (source.equals(generalList.getGate(i).getGateOut())){
                    return "output";
                }
                else if (source.equals(generalList.getGate(i).getGateInterface())){
                    return "pred";
                }
                i++;
            }
        }
        return "";
    }

    public static String getGateName(Object source){
        if (generalList.isEmpty() == false){
            int i = 0;
            while (i < generalList.getLength()) {
                if (source.equals(generalList.getGate(i).getGateIn1()) ||
                        source.equals(generalList.getGate(i).getGateIn2()) ||
                        source.equals(generalList.getGate(i).getGateOut()) ||
                        source.equals(generalList.getGate(i).getGateInterface())) {
                    return generalList.getGate(i).getName();
                }
                i++;
            }
        }
        return null;
    }

    public static Gate gateIdentity(Object source){
        if (generalList.isEmpty() == false){
            int i = 0;
            while (i < generalList.getLength()) {
                if (source.equals(generalList.getGate(i).getGateIn1()) ||
                        source.equals(generalList.getGate(i).getGateIn2()) ||
                        source.equals(generalList.getGate(i).getGateOut()) ||
                        source.equals(generalList.getGate(i).getGateInterface())) {
                    return generalList.getGate(i);
                }
                i++;
            }
        }
        return null;
    }

    public static String shapeIdentity(Object source){
        if (gateList.isEmpty() == false){
            String result = null;
            int i = 0;
            while (i < gateList.getLength()) {
                if (source.equals(gateList.getGate(i).getGateIn1())){
                    result = gateList.getGate(i).getGateIn1().getId();
                    break;
                }
                else if( source.equals(gateList.getGate(i).getGateIn2())){
                    result = gateList.getGate(i).getGateIn2().getId();
                    break;
                }
                else if (source.equals(gateList.getGate(i).getGateOut())){
                    result = gateList.getGate(i).getGateOut().getId();
                    break;
                }
                i++;
            }
            return result;
        }
        return "";
    }

    public static Circle finaleShape(Object source){
        if (gateList.isEmpty() == false){
            int i = 0;
            while (i < gateList.getLength()) {
                if (source.equals(gateList.getGate(i).getGateIn1())){
                    return gateList.getGate(i).getGateIn1();
                }
                else if( source.equals(gateList.getGate(i).getGateIn2())){
                    return gateList.getGate(i).getGateIn2();
                }
                else if (source.equals(gateList.getGate(i).getGateOut())){
                    return gateList.getGate(i).getGateOut();
                }
                i++;
            }
            return null;
        }
        return null;
    }

    /**
     * Método randomColor: genera un color aleatorio a partir de valores rgb.
     */
    public static Color randomColor() {
        int r = (int) (0xff * Math.random());
        int g = (int) (0xff * Math.random());
        int b = (int) (0xff * Math.random());
        return Color.rgb(r, g, b);
    }
}

