package logica;

import javafx.scene.canvas.GraphicsContext;

public class CanvasGrid {

    public void drawGrid(GraphicsContext gc){
        for(int i = 0; i < 1200; i += 35) {
           gc.setLineWidth(0.3);
           gc.strokeLine(i, 0, i, 720);
           gc.strokeLine(0, i, 1280, i);
        }
    }
}
