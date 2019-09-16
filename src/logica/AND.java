package logica;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.MalformedURLException;

public class AND extends Gate {
    private boolean input1;
    private boolean input2;
    private Gate prev1;
    private Gate prev2;


    public AND() throws MalformedURLException {
        super();
        this.path = ("./src/GateImages/AND.png");
        this.image = loadGateImage();
        this.imageView = super.setImageView();
        this.input1 = false;
        this.input2 = false;
        this.prev1 = null;
        this.prev2 = null;
        canvasDragAndDrop(GUI.canvas, GUI.gc);
    }


    @Override
    public boolean logic() {
        boolean ANDresult = false;
        if (this.prev1 == null | this.prev2 == null) {
            System.out.println("Exception");
        } else {
            ANDresult = this.input1 & this.input2;
            this.setOutput(ANDresult);
        }
        return ANDresult;
    }


}
