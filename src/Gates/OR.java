package Gates;

import Logic.Gate;

import java.net.MalformedURLException;

/**
 * Clase base para compuertas tipo OR.
 */
public class OR extends Gate {
    private boolean input1;
    private boolean input2;
    private Gate prev2;

    public OR(double posX, double posY) throws MalformedURLException {
        super();
        this.path = ("./src/GateImages/OR.png");
        this.image = loadGateImage();
        this.imageView = setImageView();
        this.input1 = false;
        this.input2 = false;
        this.prev2 = null;
        this.posX = posX;
        this.posY = posY;
    }

    public OR() throws MalformedURLException {
        super();
        this.path = "./src/GateImages/OR.png";
        this.image = loadGateImage();
        this.imageView = setImageView();
        this.input1 = false;
        this.input2 = false;
        this.prev2 = null;
    }

    @Override
    public boolean logic() {
        boolean ORresult = false;
        if (this.prev == null | this.prev2 == null) {
            System.out.println("Exception");
        } else {
            ORresult = this.input1 | this.input2;
            this.setOutput(ORresult);
        }
        return ORresult;
    }


}
