package logica;

public class GateFactory {

    public static Gate getGate(GateType gt){
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
            System.out.println("Unknown logic gate");
        }
        return null;
    }
}
