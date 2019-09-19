package Gates;

import Logic.Gate;

import java.net.MalformedURLException;

/**
 * CLase base para compuertas tipo XOR.
 */
public class XOR extends Gate {
    private boolean input1;
    private boolean input2;
    private Gate prev2;

    public XOR(double posX, double posY) throws MalformedURLException {
        super();
        this.path = ("./src/GateImages/XOR.png");
        this.image = loadGateImage();
        this.imageView = setImageView();
        this.input1 = false;
        this.input2 = false;
        this.prev2 = null;
        this.posX = posX;
        this.posY = posY;
    }

    public XOR() throws MalformedURLException {
        super();
        this.path = "./src/GateImages/XOR.png";
        this.image = loadGateImage();
        this.imageView = setImageView();
        this.input1 = false;
        this.input2 = false;
        this.prev2 = null;
    }

    @Override
    public boolean logic() {
        boolean XORresult = false;
        if (this.prev == null | this.prev2 == null) {
            System.out.println("Exception");
        } else {
            XORresult = (!(this.input1 & this.input2) & (this.input1 | this.input2));
            this.setOutput(XORresult);
        }
        return XORresult;
    }


}
