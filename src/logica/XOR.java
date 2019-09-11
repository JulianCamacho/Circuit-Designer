package logica;

public class XOR extends Gate {
    private boolean input1;
    private boolean input2;
    private Gate prev1;
    private Gate prev2;

    public XOR() {
        super();
        this.input1 = false;
        this.input2 = false;
        this.prev1 = null;
        this.prev2 = null;
    }

    @Override
    public boolean logic() {
        boolean XORresult = false;
        if (this.prev1 == null | this.prev2 == null) {
            System.out.println("Exception");
        } else {
            XORresult = (!(this.input1 & this.input2) & (this.input1 | this.input2));
            this.setOutput(XORresult);
        }
        return XORresult;
    }
}
