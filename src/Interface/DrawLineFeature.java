package Interface;

import Logic.Gate;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;

import static Interface.GUI.*;

/**
 * Clase que controla el dibujo de líneas gráficamente y realiza las conexiones lógicas
 */
public class DrawLineFeature {

    protected static Object source;
    protected static double posXi;
    protected static double posYi;
    protected static Object target;
    protected static double posXf;
    protected static double posYf;

    /**
     * Método que se le aplica a una figura para que restringir y realizar sus conexiones
     * @param on - Figura sobre la que se encuentra
     */

    public static void myLineDrawer(Shape on) {
        on.setOnMouseClicked(eventEventHandler);
    }

    /**
     * EventHandler: se encarga de los eventos de mouse, clicks en este caso.
     */

    public static EventHandler<MouseEvent> eventEventHandler = new EventHandler<MouseEvent>(){
        @Override
        public void handle(MouseEvent event) {

            // El primer elemento sobre el que se hace click será el source
            if (source == null){
                source = event.getSource();
                //Verifica que solo se pueda tener como source una salida de una compuerta o las predeterminadas (TRUE y FALSE)
                if (getType(source) == "output" || getType(source) == "pred"){
                    AlertBox.displayResultAlertBox("Selected", "Selected: " +  getGateName(source));
                    posXi = event.getX();
                    posYi = event.getY();
                }
            }

            // El segundo elemento sobre el que se hace click será el target
            else if (target == null) {
                target = event.getSource();

                //Verifica que no sean el mismo círculo de salida, que las conexiones no se realicen entre la misma compuerta,
                // y que se realicen entre un input y un output, para evitar conexiones out-out, in-in.
                if ((target != source) && (gateIdentity(source) != gateIdentity(target)) && (getType(source) != getType(target))) {

                    //Si el source es un output
                    if (getType(source) == "output"){

                        //Se realiza una realConnection (conexión compuerta a compuerta)
                        realConnection(source, target);
                        AlertBox.displayResultAlertBox("Connected", "Connected to: " + shapeIdentity(target));
                        posXf = event.getX();
                        posYf = event.getY();

                        // Se dibuja la línea
                        Line newLine = new Line(posXi, posYi, posXf, posYf);
                        newLine.setStroke(randomColor());
                        wrapperPane.getChildren().add(newLine);
                    }

                    //Si el source es un predeterminado(T, F)
                    else if (getType(source) == "pred"){

                        //Se realiza un inputConnection (conexión predeterminado - compuerta)
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
                // Se reinicia la determinación de source y targets
                source = null;
                target = null;
            }
        }
    };

    /**
     * Método para las conexiones predeterminado(T, F) - compuerta
     * @param source
     * @param target
     */

    public static void inputConnection(Object source, Object target){

        //Si se trata efectivamente de un predeterminado
        if (getType(source) == "pred"){
            int i = 0;

            //Revisa la lista con todas las compuertas hasta las predeterminadas
            while (i < generalList.getLength()) {

                //Si el source es el mismo objeto que un rectángulo de las predeterminadas
                if (source.equals(generalList.getGate(i).getGateInterface())){
                    Gate sourceGate = generalList.getGate(i);
                    int j = 0;

                    //Revisa la lista de solo las compuertas
                    while (j < gateList.getLength()){

                        // Si el target es el mismo objeto que algún input 1 de las compuertas de la lista
                        if (target.equals(gateList.getGate(j).getGateIn1())){

                            //Se identifica quién es la compuerta
                            Gate targetGate = gateIdentity(target);

                            //Se realizan las conexiones reales de las compuertas de acuerdo con el circuito
                            sourceGate.realNext = targetGate;
                            targetGate.realPrev1 = sourceGate;

                            //Se realiza la conexión efectiva
                            joinSource_Input1(sourceGate, targetGate);

                            //Se cambia el estado del output indicando que va hacia un input 1
                            sourceGate.setOutputState("input1");

                            //Las pone como conectadas
                            sourceGate.setOutConnected(true);
                            targetGate.setIn1Connected(true);

                            //Se cambia el estado del input 1 para que al resolver el circuito se vea como que ya tiene un valor
                            targetGate.setInput1State("true");
                            break;
                        }

                        // Si el target es el mismo objeto que algún input 2 de las compuertas de la lista
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

    /**
     * Método para las conexiones compuerta - compuerta
     * @param source
     * @param target
     */

    public static void realConnection(Object source, Object target){
        if (gateList.isEmpty() == false){
            int i = 0;

            //Se revisa toda la lista hasta que el objeto sea igual al del source
            while (i < gateList.getLength()) {
                if (source.equals(gateList.getGate(i).getGateOut())){
                    Gate sourceGate = gateIdentity(source);
                    int j = 0;

                    //Se revisa toda la lista hasta que el objeto sea igual al del target
                    while (j < gateList.getLength()){

                        //Si el objeto es el mismo que un input 1
                        if (target.equals(gateList.getGate(j).getGateIn1())){

                            //El target es ese input 1
                            Gate targetGate = gateIdentity(target);

                            //Se realizan las conexiones del circuito
                            sourceGate.realNext = targetGate;
                            targetGate.realPrev1 = sourceGate;

                            //Se realiza la igualación efectiva
                            joinSource_Input1(sourceGate, targetGate);

                            //Se especifica que el output va hacia un input1
                            sourceGate.setOutputState("input1");
                            //Se especifica que están conectados
                            sourceGate.setOutConnected(true);
                            targetGate.setIn1Connected(true);
                            break;
                        }

                        //Si el objeto de target es el mismo que un input 2
                        if (target.equals(gateList.getGate(j).getGateIn2())){
                            Gate targetGate = gateIdentity(target);
                            sourceGate.realNext = targetGate;
                            targetGate.realPrev2 = sourceGate;
                            joinSource_Input2(sourceGate, targetGate);
                            sourceGate.setOutputState("input2");
                            sourceGate.setOutConnected(true);
                            targetGate.setIn2Connected(true);
                        }
                        j++;
                    }
                }
                i++;
            }
        }
    }

    /**
     * Método para igualar los valores de las compuertas desde una predeterminada hasta una entrada
     * @param source
     * @param target
     */

    public static void joinSource_Input1(Gate source, Gate target){
        target.input1 = source.output;
    }

    /**
     * Método para igualar los valores de las compuertas desde la salida de una compuerta normal, hasta una entrada de otra
     * @param source
     * @param target
     */

    public static void joinSource_Input2(Gate source, Gate target){
        target.input2 = source.output;
    }

    /**
     * Método que verifica el tipo de figura de la que se trata, si es un input, un output o una predeterminada
     * @param source
     * @return el tipo de figura
     */

    public static String getType(Object source){
        if (generalList.isEmpty() == false){
            int i = 0;

            //Ciclo para ir revisando la lista general con las compuertas normales y predeterminadas
            while (i < generalList.getLength()) {

                //Si el obkjeto es el mismo que alguna entrada
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

    /**
     * Método que identifica el nombre de la compuerta del source o target
     * @param source
     * @return El nombre la compuerta de la que se trata
     */

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

    /**
     * Método que identifica de qué compuerta se trata
     * @param source
     * @return el objeto de la compuerta que es igual al source o target
     */

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

    /**
     * Método que revisa la lista de compuertas e identifica de qué figura (input1, input2, output) se trata
     * @param source
     * @return El ID de la figura, en este caso la etiqueta
     */

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

