package simulator.wrapper.wrappers;

import simulator.control.Simulator;
import simulator.network.Link;
import simulator.wrapper.Wrapper;

public class ShiftLeft32to32b extends Wrapper {
    public ShiftLeft32to32b(String label, String stream, Link... links) {
        super(label, stream, links);
    }
    //input=>0=in(h),...,31=in(l)
    //output=>0=in(2),1=in(3),...,29=in(31),30=false,31=false
    @Override
    public void initialize() {

        for(int i=5;i<=31;i++){
            addOutput(getInput(i));
        }

        addOutput(Simulator.falseLogic);
        addOutput(Simulator.falseLogic);
        addOutput(Simulator.falseLogic);
        addOutput(Simulator.falseLogic);
        addOutput(Simulator.falseLogic);

    }
}
