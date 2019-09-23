package Gates;

import Logic.Gate;

import java.net.MalformedURLException;

/**
 * Clase base para compuertas tipo XOR.
 */
public class XOR extends Gate {

    public XOR() throws MalformedURLException {
        super();
        this.path = "./src/GateImages/XOR.png";
        this.image = loadGateImage();
        this.imageView = setImageView();
        this.name = "XOR";
    }

    @Override
    public boolean logic() {
        boolean XORresult = (!(this.input1 & this.input2) & (this.input1 | this.input2));
        this.setOutput(XORresult);
        return XORresult;
    }


}
