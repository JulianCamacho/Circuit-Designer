package Gates;

import Logic.Gate;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.MalformedURLException;

public class TrueGate extends Gate {

    public TrueGate() throws MalformedURLException {
        this.output = true;
        this.path = ("./src/GateImages/TRUE.png");
        this.image = loadGateImage();
        this.imageView = setImageView();
    }
}
