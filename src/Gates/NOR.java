package Gates;

import Logic.Gate;

import java.net.MalformedURLException;

/**
 * Clase base para compuertas tipo NOR.
 */
public class NOR extends Gate {

    public NOR() throws MalformedURLException {
        super();
        this.path = "./src/GateImages/NOR.png";
        this.image = loadGateImage();
        this.imageView = setImageView();
        this.name = "NOR";
    }

    @Override
    public boolean logic() {
        boolean NORresult = !(this.input1 | this.input2);
        this.setOutput(NORresult);
        return NORresult;
    }



}
