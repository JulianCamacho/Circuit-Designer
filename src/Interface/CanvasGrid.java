package Interface;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

/**
 * Clase para dibujar una cuadrícula en el canvas
 */
public class CanvasGrid {
    public static Line VLine;
    public static Line HLine;


    public static void drawGrid(Pane wrapperPane){
        for(int i = 0, j = 0; i < 1300; i += 35, j += 42.5) {
            VLine = new Line(j, 0, j, 1280);
            VLine.setStroke(Color.LIGHTGRAY);
            HLine = new Line(0, i, 720, i);
            HLine.setStroke(Color.LIGHTGRAY);
            wrapperPane.getChildren().addAll(VLine, HLine);
        }
    }
}
