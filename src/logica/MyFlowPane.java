package logica;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;

import java.net.MalformedURLException;

public class MyFlowPane {
    private ImageView iV1, iV2, iV3, iV4, iV5, iV6, iV7;
    private FlowPane flow = new FlowPane();

    /**
     * Método para cargar las imágenes desde donde de hace el Drag & Drop, en el FLowPane
     */
    private void loadImages() throws MalformedURLException {
        AND ImageAND = new AND();
        this.iV1 = ImageAND.getImageView(); iV1.setFitWidth(80); iV1.setFitHeight(40);

        NAND ImageNAND = new NAND();
        this.iV2 = ImageNAND.getImageView(); iV2.setFitWidth(80); iV2.setFitHeight(40);

        OR ImageOR = new OR();
        this.iV3 = ImageOR.getImageView(); iV3.setFitWidth(80); iV3.setFitHeight(40);

        NOR ImageNOR = new NOR();
        this.iV4 = ImageNOR.getImageView(); iV4.setFitWidth(80); iV4.setFitHeight(40);

        XOR ImageXOR = new XOR();
        this.iV5 = ImageXOR.getImageView(); iV5.setFitWidth(80); iV5.setFitHeight(40);

        XNOR ImageXNOR = new XNOR();
        this.iV6 = ImageXNOR.getImageView(); iV6.setFitWidth(80); iV6.setFitHeight(40);

        NOT ImageNOT = new NOT();
        this.iV7 = ImageNOT.getImageView(); iV7.setFitWidth(80); iV7.setFitHeight(40);/*
        //AND Image
        AND.getImage();

        //NAND Image
        Gate ImageNAND = new NAND();
        this.NANDimage = ImageNAND.getImage();

        //OR Image
        Gate ImageOR = new OR();
        this.ORimage = ImageOR.getImage();

        //NOR Image
        Gate ImageNOR = new NOR();
        this.NORimage = ImageNOR.getImage();

        //XOR Image
        Gate ImageXOR = new XOR();
        this.XORimage = ImageXOR.getImage();

        //XNOR Image
        Gate ImageXNOR = new XNOR();
        this.XNORimage = ImageXNOR.getImage();

        //NOT Image
        Gate ImageNOT = new NOT();
        this.NOTimage = ImageNOT.getImage();
    }*/
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
        this.flow.setPrefWrapLength(150); // preferred width allows for two columns
        this.flow.setStyle("-fx-background-color: DAE6F3;");

        /**
         * Método para dibujar las imágenes de las compuertas como ImageView en el FlowPane
         * */

        this.flow.getChildren().addAll(iV1, iV2, iV3, iV4, iV5, iV6, iV7);

        return flow;
    }

    //Getters and setters

    public ImageView getiV1() { return iV1; }

    public ImageView getiV2() { return iV2; }

    public ImageView getiV3() { return iV3; }

    public ImageView getiV4() { return iV4; }

    public ImageView getiV5() { return iV5; }

    public ImageView getiV6() { return iV6; }

    public ImageView getiV7() { return iV7; }

    public FlowPane getFlow() { return flow; }
}
