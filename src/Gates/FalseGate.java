package Gates;

import Logic.Gate;

import java.net.MalformedURLException;

public class FalseGate extends Gate {

    public FalseGate() throws MalformedURLException {
        this.output = false;
        this.path = ("./src/GateImages/FALSE.png");
        this.image = loadGateImage();
        this.imageView = setImageView();
    }
}

