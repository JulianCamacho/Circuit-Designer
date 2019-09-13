package logica;

import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.*;

public class DrawLineFeature {

    public void myLineDrawer(Canvas canvas, GraphicsContext gc) {
        canvas.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                gc.beginPath();
                gc.moveTo(event.getX(), event.getY());
                gc.stroke();
            }
        });

        canvas.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                gc.lineTo(event.getX(), event.getY());
                gc.stroke();
            }
        });

        canvas.addEventHandler(MouseEvent.MOUSE_RELEASED, new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
            }
        });
    }
}