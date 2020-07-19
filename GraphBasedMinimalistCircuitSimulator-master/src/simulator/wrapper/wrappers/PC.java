package simulator.wrapper.wrappers;

import simulator.control.Simulator;
import simulator.network.Link;
import simulator.wrapper.Wrapper;

public class PC extends Wrapper {
    public PC(String label, String stream, Link... links) {
        super(label, stream, links);
    }

    @Override
    public void initialize() {

        Register[] pcarr = new Register[32];

        for (int i = 0 ; i < 32; i++){
            pcarr[i] = new Register("myReg","2X1", Simulator.trueLogic, getInput(i));
        }

        for (int i = 0 ; i < 32; i++){
            addOutput(pcarr[i].getOutput(0));
        }


    }
}
