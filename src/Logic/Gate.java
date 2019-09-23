package Logic;

import Interface.DrawLineFeature;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import java.io.File;
import java.net.MalformedURLException;

/**
 * Clase Gate: clase abstracta, súper clase o Padre de todas las compuertas lógicas.
 */
public abstract class Gate{
    protected File file;
    protected Image image;
    protected ImageView imageView;
    protected static String path;

    public boolean input1;
    public boolean input2;
    public boolean output;

    protected String input1State = null;
    protected String input2State = null;
    protected String outputState = null;

    protected boolean isIn1Connected;
    protected boolean isIn2Connected;
    protected boolean isOutConnected;

    protected boolean isCalculated;

    public Gate next;
    public Gate prev;

    public Gate realNext;
    public Gate realPrev1;
    public Gate realPrev2;

    protected String myID = null;
    protected String name = null;

    protected Rectangle gateInterface;
    protected Circle gateIn1;
    protected Circle gateIn2;
    protected Circle gateOut;

    protected static int inNumber = 0;
    protected static int outNumber = 0;

    public Gate(){
        this.next = null;
        this.prev = null;
    }

    /**
     * Método logic, contiene la lógica de cada compuerta.
     * @return Valor de la compuerta.
     */
    public boolean logic() {
        return false;
    }

    /**
     * Método para cargar las imágenes: crea un archivo con la ruta de la imagen, a partir de este carga la imagen.
     * @return Image - Imagen cargada.
     * @throws MalformedURLException
     */
    public Image loadGateImage() throws MalformedURLException {
        file = new File(path);
        Image loadedImage = new Image(file.toURI().toURL().toString());
        image = loadedImage;
        return loadedImage;
    }

    /**
     * Método para mostrar la imagen de la compuerta como un ImageView nuevo.
     * @return ImageView - ImageView de cada compuerta.
     * @throws MalformedURLException
     */
    public ImageView setImageView() throws MalformedURLException {
        ImageView imageV1 = new ImageView();
        imageV1.setImage(loadGateImage());
        imageV1.setFitWidth(75);
        imageV1.setFitHeight(30);
        imageView = imageV1;
        return imageV1;
    }

    /**
     * Método que crea todas las imágenes, figuras y labels de las compuertas.
     * @param wrapperPane - Pane en el que se van a dibujar los diferentes componentes de las compuertas.
     * @param posX - Posición en X en la que se van a ubicar los componentes.
     * @param posY - Posición en Y en la que se van a ubicar los componentes.
     */

    public void createGateInterface(Pane wrapperPane, double posX, double posY){
        gateInterface = new Rectangle( posX, posY, 80, 30);
        gateInterface.setFill(new ImagePattern(this.getImage()));

        Label outL = new Label("o<" + outNumber + ">");
        outL.setLayoutX(posX + 85);
        outL.setLayoutY(posY + 8);
        this.myID = this.name + ": Gate number " + outNumber;
        outNumber ++;
        gateOut = new Circle(posX + 70, posY + 15 , 7);
        gateOut.setFill(Color.TRANSPARENT);
        gateOut.setCursor(Cursor.CROSSHAIR);
        gateOut.setOnMouseClicked(event -> DrawLineFeature.myLineDrawer(gateOut));
        gateOut.setId(this.myID + ": output");

        Label in1L = new Label("i<" + inNumber + ">");
        in1L.setLayoutX(posX);
        in1L.setLayoutY(posY - 15);
        inNumber ++;
        gateIn1 = new Circle(posX + 5, posY + 8, 7);
        gateIn1.setFill(Color.TRANSPARENT);
        gateIn1.setCursor(Cursor.CROSSHAIR);
        gateIn1.setOnMouseClicked(event -> DrawLineFeature.myLineDrawer(gateIn1));
        gateIn1.setId(this.myID + ": input 1");

        Label in2L = new Label("i<" + inNumber + ">");
        in2L.setLayoutX(posX);
        in2L.setLayoutY(posY + 28);
        inNumber ++;
        gateIn2 = new Circle(posX + 5, posY + 23, 7);
        gateIn2.setFill(Color.TRANSPARENT);
        gateIn2.setCursor(Cursor.CROSSHAIR);
        gateIn2.setOnMouseClicked(event -> DrawLineFeature.myLineDrawer(gateIn2));
        gateIn2.setId(this.myID + ": input 2");

        wrapperPane.getChildren().addAll(gateInterface, gateIn1, gateIn2, gateOut, in1L, in2L, outL);
    }

    public Image getImage() { return image; }

    public void setImage(Image image) { this.image = image; }

    public ImageView getImageView() { return imageView; }

    public String getPath() { return path; }

    public boolean getOutput() { return output; }

    public void setOutput(boolean output) { this.output = output; }

    public boolean getInput1() { return input1; }

    public void setInput1(boolean input1) { this.input1 = input1; }

    public boolean getInput2() { return input2; }

    public void setInput2(boolean input2) { this.input2 = input2; }

    public Gate getNext() { return next; }

    public Gate getPrev() { return prev; }

    public String getInput1State() { return input1State; }

    public void setInput1State(String input1State) { this.input1State = input1State; }

    public String getInput2State() { return input2State; }

    public void setInput2State(String input2State) { this.input2State = input2State; }

    public String getOutputState() { return outputState; }

    public void setOutputState(String outputState) { this.outputState = outputState; }

    public String getMyID() { return myID; }

    public void setMyID(String myID) { this.myID = myID; }

    public String getName() { return name; }

    public boolean isIn1Connected() { return isIn1Connected; }

    public void setIn1Connected(boolean in1Connected) { isIn1Connected = in1Connected; }

    public boolean isIn2Connected() { return isIn2Connected; }

    public void setIn2Connected(boolean in2Connected) { isIn2Connected = in2Connected; }

    public boolean isOutConnected() { return isOutConnected; }

    public void setOutConnected(boolean outConnected) { isOutConnected = outConnected; }

    public boolean isCalculated() { return isCalculated; }

    public void setCalculated(boolean calculated) { isCalculated = calculated; }

    public Circle getGateIn1() { return gateIn1; }

    public Circle getGateIn2() { return gateIn2; }

    public Circle getGateOut() { return gateOut; }

    public Rectangle getGateInterface() { return gateInterface; }

    public static void setInNumber(int inNumber) { Gate.inNumber = inNumber; }

    public static void setOutNumber(int outNumber) { Gate.outNumber = outNumber; }
}
