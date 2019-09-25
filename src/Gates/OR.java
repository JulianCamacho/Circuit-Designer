package Gates;

import Logic.Gate;

import java.net.MalformedURLException;

/**
 * Clase base para compuertas tipo OR.
 */
public class OR extends Gate {

    public OR() throws MalformedURLException {
        super();
        this.path = "./src/GateImages/OR.png";
        this.image = loadGateImage();
        this.imageView = setImageView();
        this.name = "OR";
    }

    @Override
    public boolean logic() {
        boolean ORresult = this.input1 | this.input2;
        this.setOutput(ORresult);
        return ORresult;
    }

    @Override
    public boolean logic(boolean in1, boolean in2) {
        return in1 | in2;
    }
}
