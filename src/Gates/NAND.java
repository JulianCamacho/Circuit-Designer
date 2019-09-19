package Gates;

import Logic.Gate;

import java.net.MalformedURLException;

/**
 * CLase base para compuertas tipo NAND.
 */
public class NAND extends Gate {
    private boolean input1;
    private boolean input2;
    private Gate prev2;

    public NAND(double posX, double posY) throws MalformedURLException {
        super();
        this.path = ("./src/GateImages/NAND.png");
        this.image = loadGateImage();
        this.imageView = setImageView();
        this.input1 = false;
        this.input2 = false;
        this.prev2 = null;
        this.posX = posX;
        this.posY = posY;
    }

    public NAND() throws MalformedURLException {
        super();
        this.path = ("./src/GateImages/NAND.png");
        this.image = loadGateImage();
        this.imageView = setImageView();
        this.input1 = false;
        this.input2 = false;
        this.prev2 = null;
    }

    @Override
    public boolean logic() {
        boolean NANDresult = false;
        if (this.prev == null | this.prev2 == null) {
            System.out.println("Exception");
        } else {
            NANDresult = !(this.input1 & this.input2);
            this.setOutput(NANDresult);
        }
        return NANDresult;
    }

}
