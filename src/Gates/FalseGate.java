package Gates;

import Logic.Gate;
import javafx.scene.Cursor;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

import java.net.MalformedURLException;

public class FalseGate extends Gate {

    public FalseGate() throws MalformedURLException {
        this.output = false;
        this.path = ("./src/GateImages/FALSE.png");
        this.image = loadGateImage();
        this.imageView = setImageView();
    }

    @Override
    public void createGateInterface(Pane wrapperPane, double posX, double posY) {
        gateInterface = new Rectangle( posX, posY, 30, 30);
        gateInterface.setFill(new ImagePattern(this.getImage()));
        gateInterface.setCursor(Cursor.CROSSHAIR);
        wrapperPane.getChildren().addAll(gateInterface);
    }
}

