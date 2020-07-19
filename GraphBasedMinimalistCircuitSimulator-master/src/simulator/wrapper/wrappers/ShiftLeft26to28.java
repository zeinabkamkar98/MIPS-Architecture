package simulator.wrapper.wrappers;

import simulator.control.Simulator;
import simulator.network.Link;
import simulator.wrapper.Wrapper;

public class ShiftLeft26to28 extends Wrapper {

    public ShiftLeft26to28(String label, String stream, Link... links) {
        super(label, stream, links);
    }
    //input=>0=in(h),...,25=in(l)
    //output=>0=in(0),1=in(1),...,25=in(31),26=false,27=false

    @Override
    public void initialize() {

        for(int i=0;i<26;i++){
            addOutput(getInput(i));
        }
        addOutput(Simulator.falseLogic);
        addOutput(Simulator.falseLogic);
    }
}
