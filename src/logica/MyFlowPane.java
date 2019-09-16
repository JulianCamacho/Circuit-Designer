package logica;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;

import java.net.MalformedURLException;

public class MyFlowPane {
    private Image ANDimage, NANDimage, ORimage, NORimage, XORimage, XNORimage, NOTimage;
    private ImageView iV1, iV2, iV3, iV4, iV5, iV6, iV7;
    private FlowPane flow = new FlowPane();

    private void loadImages() throws MalformedURLException {
        //AND Image
        Gate ImageAND = new AND();
        this.ANDimage = ImageAND.loadGateImage();

        //NAND Image
        Gate ImageNAND = new NAND();
        this.NANDimage = ImageNAND.loadGateImage();

        //OR Image
        Gate ImageOR = new OR();
        this.ORimage = ImageOR.loadGateImage();

        //NOR Image
        Gate ImageNOR = new NOR();
        this.NORimage = ImageNOR.loadGateImage();

        //XOR Image
        Gate ImageXOR = new XOR();
        this.XORimage = ImageXOR.loadGateImage();

        //XNOR Image
        Gate ImageXNOR = new XNOR();
        this.XNORimage = ImageXNOR.loadGateImage();

        //NOT Image
        Gate ImageNOT = new NOT();
        this.NOTimage = ImageNOT.loadGateImage();
    }

    /**
     * Método para obtener un FlowPane personalizado
     * */
    public FlowPane addFlowPane() throws MalformedURLException {
        loadImages();
        this.flow.setPadding(new Insets(5, 0, 5, 0));
        this.flow.setVgap(10);
        this.flow.setHgap(4);
        this.flow.setAlignment(Pos.CENTER);
        this.flow.setPrefWrapLength(170); // preferred width allows for two columns
        this.flow.setStyle("-fx-background-color: DAE6F3;");

        /**
         * Método para dibujar las imágenes de las compuertas como ImageView en el FlowPane
         * */

        this.iV1 = new ImageView(); iV1.setImage(this.ANDimage); iV1.setFitWidth(100); iV1.setFitHeight(50);
        this.iV2 = new ImageView(); iV2.setImage(this.NANDimage); iV2.setFitWidth(100); iV2.setFitHeight(50);
        this.iV3 = new ImageView(); iV3.setImage(this.ORimage); iV3.setFitWidth(100); iV3.setFitHeight(50);
        this.iV4 = new ImageView(); iV4.setImage(this.NORimage); iV4.setFitWidth(100); iV4.setFitHeight(50);
        this.iV5 = new ImageView(); iV5.setImage(this.XORimage); iV5.setFitWidth(100); iV5.setFitHeight(50);
        this.iV6 = new ImageView(); iV6.setImage(this.XNORimage); iV6.setFitWidth(100); iV6.setFitHeight(50);
        this.iV7 = new ImageView(); iV7.setImage(this.NOTimage); iV7.setFitWidth(100); iV7.setFitHeight(50);

        this.flow.getChildren().addAll(iV1, iV2, iV3, iV4, iV5, iV6, iV7);

        return flow;
    }

    public Image getANDimage() { return ANDimage; }

    public Image getNANDimage() { return NANDimage; }

    public Image getORimage() { return ORimage; }

    public Image getNORimage() { return NORimage; }

    public Image getXORimage() { return XORimage; }

    public Image getXNORimage() { return XNORimage; }

    public Image getNOTimage() { return NOTimage; }

    public ImageView getiV1() { return iV1; }

    public ImageView getiV2() { return iV2; }

    public ImageView getiV3() { return iV3; }

    public ImageView getiV4() { return iV4; }

    public ImageView getiV5() { return iV5; }

    public ImageView getiV6() { return iV6; }

    public ImageView getiV7() { return iV7; }

    public FlowPane getFlow() { return flow; }
}
