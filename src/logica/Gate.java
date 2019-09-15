package logica;

import javafx.scene.image.Image;

import java.io.File;
import java.net.MalformedURLException;

/**
 * Clase Gate: clase abstracta, súper clase o Padre de todas las compuertas lógicas
 * */

public abstract class Gate {
    protected Image image;
    protected String path;
    protected boolean output;

    public Gate (){
        //this.image = null;
        //this.path = null;
        //this.output = false;
    }

    /**
     * Método logic, contiene la lógica de cada compuerta
     *
     * @return*/
    public boolean logic(){
         return false;
    }

    public Image loadGateImage() throws MalformedURLException {
        File file1 = new File(path);
        Image loadedImage = new Image(file1.toURI().toURL().toString());
        return loadedImage;
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
