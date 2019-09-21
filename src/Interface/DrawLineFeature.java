package Interface;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;

public class DrawLineFeature {

    protected static Object source;
    protected static double posXi;
    protected static double posYi;
    protected static Object target;
    protected static double posXf;
    protected static double posYf;

    public static void myLineDrawer(Pane wrapperPane, Shape on) {
        on.setOnMouseClicked(event -> {
            System.out.println(event.getSource());
            if (source == null){
                source = event.getSource();
                System.out.println(source);
                posXi = event.getSceneX();
                posYi = event.getSceneY();
            }
            else if (target == null){
                target = event.getSource();
                System.out.println(target);
                posXf = event.getSceneX();
                posYf = event.getSceneY();
                Line newLine = new Line(posXi, posYi, posXf, posYf);
                newLine.setStroke(randomColor());
                wrapperPane.getChildren().add(newLine);
            }
            else{
                source = null;
                target = null;
            }
        });
    }

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

