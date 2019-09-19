package Logic;

import Interface.MyFlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

public class MoveAndDropFeature {


    public static void myMoveDrop(Rectangle currentRect, Pane wrapperPane, MyFlowPane myFlowPane) {
        currentRect.setOnMouseDragged(event -> {
            if (event.isPrimaryButtonDown())
                System.out.println("moviendo"+event.getSource());
        });
        currentRect.setOnMouseDragReleased(event -> {
            if (event.isPrimaryButtonDown()){
            currentRect.setTranslateX(currentRect.getTranslateX() + event.getX());
            currentRect.setTranslateY(currentRect.getTranslateY() + event.getY());}
        });
    }
}
