package Logic;

import Interface.DrawLineFeature;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

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

    protected boolean input1;
    protected boolean input2;
    protected boolean output;

    protected String input1State = null;
    protected String input2State = null;
    protected String outputState = null;

    public Gate next;
    public Gate prev;

    public double posX;
    public double posY;

    protected String myID = null;
    protected String name = null;

    protected Rectangle gateInterface;
    protected Circle gateIn1;
    protected Circle gateIn2;
    protected Circle gateOut;

    static int inNumber = 0;
    static int outNumber = 0;

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

        Label in1L = new Label("i<" + inNumber + ">");
        in1L.setLayoutX(posX);
        in1L.setLayoutY(posY - 15);
        inNumber ++;
        gateIn1 = new Circle(posX + 5, posY + 9, 7);
        gateIn1.setFill(Color.TRANSPARENT);
        gateIn1.setCursor(Cursor.CROSSHAIR);
        gateIn1.setOnDragDetected(event -> DrawLineFeature.myLineDrawer(wrapperPane, gateIn1));

        Label in2L = new Label("i<" + inNumber + ">");
        in2L.setLayoutX(posX);
        in2L.setLayoutY(posY + 28);
        inNumber ++;
        gateIn2 = new Circle(posX + 5, posY + 22, 7);
        gateIn2.setFill(Color.BLACK);
        gateIn2.setCursor(Cursor.CROSSHAIR);

        Label outL = new Label("o<" + outNumber + ">");
        outL.setLayoutX(posX + 85);
        outL.setLayoutY(posY + 8);
        this.myID = "Gate number" + outNumber;
        outNumber ++;
        gateOut = new Circle(posX + 70, posY + 15 , 7);
        gateOut.setFill(Color.BLACK);
        gateOut.setCursor(Cursor.CROSSHAIR);

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

    public void setNext(Gate next) { this.next = next; }

    public Gate getPrev() { return prev; }

    public void setPrev(Gate prev) { this.prev = prev; }

    public double getPosX() { return posX; }

    public double getPosY() { return posY; }

    public String getInput1State() { return input1State; }

    public void setInput1State(String input1State) { this.input1State = input1State; }

    public String getInput2State() { return input2State; }

    public void setInput2State(String input2State) { this.input2State = input2State; }

    public String getOutputState() { return outputState; }

    public void setOutputState(String outputState) { this.outputState = outputState; }

    public String getMyID() { return myID; }

    public void setMyID(String myID) { this.myID = myID; }

    public String getName() { return name; }
}
