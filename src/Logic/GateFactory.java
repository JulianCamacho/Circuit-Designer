package Logic;

import Gates.*;
import Interface.AlertBox;

import java.net.MalformedURLException;

/**
 * Clase generadora de compuertas.
 */
public class GateFactory {

    /**
     * Método para solicitar una compuerta específica.
     * @param gt - Tipo do de compuerta que se solicita crear.
     * @return Gate - Compuerta solicitada.
     * @throws MalformedURLException
     */
    public static Gate getGate(GateType gt) throws MalformedURLException {
        if (gt == GateType.AND){
            return new AND();
        }
        if (gt == GateType.NAND){
            return new NAND();
        }
        if (gt == GateType.OR){
            return new OR();
        }
        if (gt == GateType.NOR){
            return new NOR();
        }
        if (gt == GateType.XOR){
            return new XOR();
        }
        if (gt == GateType.XNOR){
            return new XNOR();
        }
        if (gt == GateType.NOT){
            return new NOT();
        }
        else{
            AlertBox.displayAlertBox("Unknown gate", "Couldn´t create the specified Gate");
        }
        return null;
    }
}
