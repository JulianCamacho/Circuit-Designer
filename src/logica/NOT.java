package logica;

public class NOT extends Gate{
    private boolean input;
    private Gate prev;

    public NOT() {
        super();
        this.path = "./src/GateImages/NOT.png";
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
