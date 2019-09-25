package Gates;

import Logic.Gate;

import java.net.MalformedURLException;

/**
 * CLase base para compuertas tipo NAND.
 */
public class NAND extends Gate {

    public NAND() throws MalformedURLException {
        super();
        this.path = ("./src/GateImages/NAND.png");
        this.image = loadGateImage();
        this.imageView = setImageView();
        this.name = "NAND";
    }

    @Override
    public boolean logic() {
        boolean NANDresult = !(this.input1 & this.input2);
        this.setOutput(NANDresult);
        return NANDresult;
    }

    @Override
    public boolean logic(boolean in1, boolean in2) {
        return !(in1 & in2);
    }
}
