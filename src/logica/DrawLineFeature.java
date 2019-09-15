package logica;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.*;
import javafx.scene.paint.Color;

import java.util.Random;

public class DrawLineFeature {

    public void myLineDrawer(Canvas canvas, GraphicsContext gc) {
        canvas.addEventHandler(MouseEvent.MOUSE_PRESSED, event -> {
            gc.beginPath();
            gc.moveTo(event.getX(), event.getY());
            gc.stroke();
        });

        canvas.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            gc.lineTo(event.getX(), event.getY());
            gc.setStroke(randomColor());
            gc.stroke();
        });

        canvas.addEventHandler(MouseEvent.MOUSE_RELEASED, event -> {
        });
    }

    // generate the random integers for r, g and b value
    public Color randomColor() {
        int r = (int) (0xff * Math.random());
        int g = (int) (0xff * Math.random());
        int b = (int) (0xff * Math.random());
        return Color.rgb(r, g, b);
    }
}