package Gates;

import Logic.Gate;
import java.net.MalformedURLException;

/**
 * Clase base para compuertas tipo AND.
 */
public class AND extends Gate {

    public AND() throws MalformedURLException {
        super();
        this.path = ("./src/GateImages/AND.png");
        this.image = loadGateImage();
        this.imageView = setImageView();
        this.name = "AND";
    }

    @Override
    public boolean logic() {
        boolean ANDresult = this.input1 & this.input2;
        this.setOutput(ANDresult);
        return ANDresult;
    }


}
