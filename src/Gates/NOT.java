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

/**
 * Clase base para compuertas tipo NOT.
 */
public class NOT extends Gate {

    public NOT() throws MalformedURLException {
        super();
        this.path = "./src/GateImages/NOT.png";
        this.image = loadGateImage();
        this.imageView = setImageView();
        this.name = "NOT";
    }

    @Override
    public boolean logic(){
        boolean NOTresult = !this.input1;
        this.setOutput(NOTresult);
        return NOTresult;
    }

    @Override
    public boolean logic(boolean in1, boolean in2) {
        return !(in1);
    }

    @Override
    public void createGateInterface(Pane wrapperPane, double posX, double posY) {
        gateInterface = new Rectangle( posX, posY, 80, 30);
        gateInterface.setFill(new ImagePattern(this.getImage()));

        Label outL = new Label("o<" + outNumber + ">");
        outL.setLayoutX(posX + 85);
        outL.setLayoutY(posY + 8);
        this.myID = this.name + ": Gate number " + outNumber;
        gateOut = new Circle(posX + 70, posY + 15 , 7);
        gateOut.setFill(Color.TRANSPARENT);
        gateOut.setCursor(Cursor.CROSSHAIR);
        gateOut.setOnMouseClicked(event -> DrawLineFeature.myLineDrawer(gateOut));
        gateOut.setId("o<" + outNumber + ">");
        outNumber ++;

        Label in1L = new Label("i<" + inNumber + ">");
        in1L.setLayoutX(posX);
        in1L.setLayoutY(posY - 15);
        inNumber ++;
        gateIn1 = new Circle(posX + 5, posY + 15, 7);
        gateIn1.setFill(Color.TRANSPARENT);
        gateIn1.setCursor(Cursor.CROSSHAIR);
        gateIn1.setOnMouseClicked(event -> DrawLineFeature.myLineDrawer(gateIn1));
        gateIn1.setId("i<" + inNumber + ">");

        wrapperPane.getChildren().addAll(gateInterface, gateIn1, gateOut, in1L, outL);
    }
}
