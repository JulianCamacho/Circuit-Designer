package logica;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.MalformedURLException;

public class NOT extends Gate{
    private boolean input;
    private Gate prev;

    public NOT() throws MalformedURLException {
        super();
        this.path = "./src/GateImages/NOT.png";
        this.imageView = super.setImageView();
        this.input = false;
        this.prev = null;
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
