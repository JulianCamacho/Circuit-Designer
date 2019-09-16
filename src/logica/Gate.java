package logica;

import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.Pane;

import java.io.File;
import java.net.MalformedURLException;

/**
 * Clase Gate: clase abstracta, súper clase o Padre de todas las compuertas lógicas
 * */

public abstract class Gate {
    protected Image image;
    protected ImageView imageView;
    protected static String path;
    protected boolean output;

    public Gate() {
        //this.image = null;
        //this.path = null;
        //this.output = false;
    }

    /**
     * Método logic, contiene la lógica de cada compuerta
     *
     * @return
     */
    public boolean logic() {
        return false;
    }

    public Image loadGateImage() throws MalformedURLException {
        File file1 = new File(path);
        Image loadedImage = new Image(file1.toURI().toURL().toString());
        image = loadedImage;
        return loadedImage;
    }

    public ImageView setImageView() throws MalformedURLException {
        ImageView imageV1 = new ImageView();
        imageV1.setImage(loadGateImage());
        imageV1.setFitWidth(80);
        imageV1.setFitHeight(40);
        imageView = imageV1;
        return imageV1;
    }

    public void canvasDragAndDrop(Canvas canvas, GraphicsContext gc) {
        this.imageView.setOnDragDetected(event -> {
            Dragboard db = this.imageView.startDragAndDrop(TransferMode.ANY);
            ClipboardContent content = new ClipboardContent();
            content.putImage(this.getImage());
            db.setContent(content);
            event.consume();
        });
        canvas.setOnDragDropped(event -> {
            System.out.println("onDragDropped");
            Dragboard db = event.getDragboard();
            boolean success;
            if (db.hasImage()) {
                gc.drawImage(this.getImage(), event.getX() - 35, event.getY() - 15);
            }
            success = true;
            event.setDropCompleted(success);
            event.consume();
        });
    }


    /**
     * Getters and Setters
     * */
    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }


    public ImageView getImageView() {
        return imageView;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public boolean isOutput() {
        return output;
    }

    public void setOutput(boolean output) {
        this.output = output;
    }

}
