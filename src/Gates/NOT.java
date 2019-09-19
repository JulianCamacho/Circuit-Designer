package Gates;

import Logic.Gate;

import java.net.MalformedURLException;

/**
 * CLase base para compuertas tipo NOT.
 */
public class NOT extends Gate {
    private boolean input;
    private Gate prev;

    public NOT(double posX, double posY) throws MalformedURLException {
        super();
        this.path = ("./src/GateImages/NOT.png");
        this.image = loadGateImage();
        this.imageView = super.setImageView();
        this.input = false;
        this.posX = posX;
        this.posY = posY;
    }

    public NOT() throws MalformedURLException {
        super();
        this.path = "./src/GateImages/NOT.png";
        this.image = loadGateImage();
        this.imageView = setImageView();
        this.input = false;
        this.prev = null;
    }

    @Override
    public boolean logic(){
        boolean NOTresult = false;
        if (this.prev == null) {
            System.out.println("Exception");
        } else {
            NOTresult = !this.input;
            this.setOutput(NOTresult);
        }
        return NOTresult;
    }
}
