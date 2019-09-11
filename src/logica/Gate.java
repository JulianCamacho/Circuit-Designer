package logica;

import javafx.scene.image.Image;
/**
 * Clase Gate: clase abstracta, súper clase o Padre de todas las compuertas lógicas
 * */

public abstract class Gate {
    private Image image;
    private String path;
    private boolean output;

    public Gate (){
        this.image = null;
        this.path = null;
        this.output = false;
    }

    /**
     * Método logic, contiene la lógica de cada compuerta
     *
     * @return*/
    public boolean logic(){
         return false;
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
