package logica;

public class XNOR extends Gate {
    private boolean input1;
    private boolean input2;
    private Gate prev1;
    private Gate prev2;

    public XNOR() {
        super();
        this.input1 = false;
        this.input2 = false;
        this.prev1 = null;
        this.prev2 = null;
    }

    @Override
    public boolean logic() {
        boolean XNORresult = false;
        if (this.prev1 == null | this.prev2 == null) {
            System.out.println("Exception");
        } else {
            XNORresult = !(!(this.input1 & this.input2) & (this.input1 | this.input2));
            this.setOutput(XNORresult);
        }
        return XNORresult;
    }
}
