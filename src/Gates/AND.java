package Gates;

import Logic.Gate;
import javafx.scene.shape.Rectangle;

import java.net.MalformedURLException;

/**
 * Clase base para compuertas tipo AND.
 */
public class AND extends Gate {
    private boolean input1;
    private boolean input2;
    private Gate prev2;
    protected Rectangle rectInput2;

    public AND() throws MalformedURLException {
        super();
        this.path = ("./src/GateImages/AND.png");
        this.image = loadGateImage();
        this.imageView = setImageView();
        this.name = "AND";
        this.input1 = false;
        this.input2 = false;
        this.prev2 = null;
    }

    @Override
    public boolean logic() {
        boolean ANDresult = false;
        if (this.prev == null | this.prev2 == null) {
            System.out.println("Exception");
        } else {
            ANDresult = this.input1 & this.input2;
            this.setOutput(ANDresult);
        }
        return ANDresult;
    }


}
