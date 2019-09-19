package Interface;

import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

public class DrawLineFeature {

    //private static int i = 0;
    private static Node on;
    private static Line currentLine;

    public static void myLineDrawer(Rectangle rect, Pane wrapperPane) {
        //for (int i = 0; i < wrapperPane.getChildren().size(); i++) {
            rect.setOnMousePressed(e -> {
                if (e.isSecondaryButtonDown()){
                    System.out.println("lineando"+e.getSource());
                    currentLine = new Line(e.getX(), e.getY(), e.getX(), e.getY());
                    currentLine.setStroke(randomColor());
                    wrapperPane.getChildren().add(currentLine);
                }
            });
            wrapperPane.setOnMouseDragged(ev -> {
                if(ev.isSecondaryButtonDown()){
                    currentLine.setEndX(ev.getX());
                    currentLine.setEndY(ev.getY());
                    ev.consume();
                }
            });
             //   }
        }
    //}

    /**
     * Método randomColor: genera un color aleatorio a partir de valores rgb.
     */
    public static Color randomColor() {
        int r = (int) (0xff * Math.random());
        int g = (int) (0xff * Math.random());
        int b = (int) (0xff * Math.random());
        return Color.rgb(r, g, b);
    }
}