package Gates;

import Logic.Gate;

import java.net.MalformedURLException;

/**
 * Clase base para compuertas tipo XNOR.
 */
public class XNOR extends Gate {

    public XNOR() throws MalformedURLException {
        super();
        this.path = "./src/GateImages/XNOR.png";
        this.image = loadGateImage();
        this.imageView = setImageView();
        this.name = "XNOR";
    }

    @Override
    public boolean logic() {
        boolean XNORresult = !(!(this.input1 & this.input2) & (this.input1 | this.input2));
        this.setOutput(XNORresult);
        return XNORresult;
    }

}
