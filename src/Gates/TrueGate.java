package Gates;

import Interface.DrawLineFeature;
import Logic.Gate;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import java.net.MalformedURLException;

public class TrueGate extends Gate {

    public TrueGate() throws MalformedURLException {
        this.output = true;
        this.path = ("./src/GateImages/TRUE.png");
        this.image = loadGateImage();
        this.imageView = setImageView();
        this.isOutConnected =true;
        this.name = "TRUE";
    }

    @Override
    public void createGateInterface(Pane wrapperPane, double posX, double posY) {
        gateInterface = new Rectangle( posX, posY, 30, 30);
        gateInterface.setFill(new ImagePattern(this.getImage()));
        gateInterface.setCursor(Cursor.CROSSHAIR);
        gateInterface.setOnMouseClicked(event -> DrawLineFeature.myLineDrawer(gateInterface));
        this.myID = this.name;

        wrapperPane.getChildren().addAll(gateInterface);
    }
}
