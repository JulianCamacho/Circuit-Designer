package Logic;

import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
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
    protected boolean output;
    public Gate next;
    public Gate prev;
    public double posX;
    public double posY;
    protected String name;
    protected Rectangle rectInput1;

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
        File file1 = new File(path);
        Image loadedImage = new Image(file1.toURI().toURL().toString());
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

    public void createGateInterface(Pane wrapperPane, double posX, double posY){
        Rectangle gateInterface = new Rectangle( posX, posY, 80, 30);
        gateInterface.setFill(new ImagePattern(this.getImage()));
        Circle gateIn1 = new Circle(posX + 5, posY + 9, 7);
        gateIn1.setFill(Color.TRANSPARENT);
        gateIn1.setCursor(Cursor.CROSSHAIR);
        Circle gateIn2 = new Circle(posX + 5, posY + 22, 7);
        gateIn2.setFill(Color.BLACK);
        gateIn2.setCursor(Cursor.CROSSHAIR);
        Circle gateOut = new Circle(posX + 70, posY + 15 , 7);
        gateOut.setFill(Color.BLACK);
        gateOut.setCursor(Cursor.CROSSHAIR);
        wrapperPane.getChildren().addAll(gateInterface, gateIn1, gateIn2, gateOut);
    }

    public void canvasDragAndDrop(Pane wrapperPane) {
        this.imageView.setOnDragDetected(event -> {
            System.out.println(event.getSource());
            Dragboard db = this.imageView.startDragAndDrop(TransferMode.ANY);
            ClipboardContent content = new ClipboardContent();
            content.putImage(this.getImage());
            db.setContent(content);
            event.consume();
        });
        wrapperPane.setOnDragOver(event -> {
            if (event.getDragboard().hasImage()) {
                event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
            }
            event.consume();
        });
        wrapperPane.setOnDragDropped(event -> {
            Dragboard db = event.getDragboard();
            boolean success;
            if (db.hasImage()) {
                this.imageView.setTranslateX(event.getX());
                this.imageView.setTranslateY(event.getY());
                success = true;
                event.setDropCompleted(success);
                event.consume();
            }
        });
    }

    public Image getImage() { return image; }

    public void setImage(Image image) { this.image = image; }

    public ImageView getImageView() { return imageView; }

    public String getPath() { return path; }

    public void setPath(String path) { this.path = path; }

    public boolean isOutput() { return output; }

    public void setOutput(boolean output) { this.output = output; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }
}
