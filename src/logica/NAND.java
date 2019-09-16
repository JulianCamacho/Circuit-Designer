package logica;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.MalformedURLException;

public class NAND extends Gate {
    private boolean input1;
    private boolean input2;
    private Gate prev1;
    private Gate prev2;

    public NAND() throws MalformedURLException {
        super();
        this.path = ("./src/GateImages/NAND.png");
        this.imageView = setImageView();
        this.input1 = false;
        this.input2 = false;
        this.prev1 = null;
        this.prev2 = null;
    }

    @Override
    public Image loadGateImage() throws MalformedURLException {
        return super.loadGateImage();
    }

    @Override
    public ImageView setImageView() throws MalformedURLException {
        return super.setImageView();
    }

    @Override
    public boolean logic() {
        boolean NANDresult = false;
        if (this.prev1 == null | this.prev2 == null) {
            System.out.println("Exception");
        } else {
            NANDresult = !(this.input1 & this.input2);
            this.setOutput(NANDresult);
        }
        return NANDresult;
    }
}
