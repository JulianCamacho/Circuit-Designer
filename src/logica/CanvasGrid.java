package logica;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Clase para dibujar una cuadrícula en el canvas
 */
public class CanvasGrid {

    public static void drawGrid(GraphicsContext gc){
        for(int i = 0, j = 0; i < 1300; i += 35, j += 42.5) {
           gc.setLineWidth(0.3);
           gc.setStroke(Color.GRAY);
           gc.strokeLine(j, 0, j, 800);
           gc.strokeLine(0, i, 1280, i);
        }
    }
}
