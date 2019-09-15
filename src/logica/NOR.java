package logica;

import javafx.scene.image.Image;

import java.net.MalformedURLException;

public class NOR extends Gate {
    private boolean input1;
    private boolean input2;
    private Gate prev1;
    private Gate prev2;

    public NOR() {
        super();
        this.path = "./src/GateImages/NOR.png";
        this.input1 = false;
        this.input2 = false;
        this.prev1 = null;
        this.prev2 = null;
    }

    @Override
    public boolean logic() {
        boolean NORresult = false;
        if (this.prev1 == null | this.prev2 == null) {
            System.out.println("Exception");
        } else {
            NORresult = !(this.input1 | this.input2);
            this.setOutput(NORresult);
        }
        return NORresult;
    }

}
