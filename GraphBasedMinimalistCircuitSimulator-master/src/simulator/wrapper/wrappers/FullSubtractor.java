package simulator.wrapper.wrappers;

import simulator.gates.combinational.Or;
import simulator.network.Link;
import simulator.wrapper.Wrapper;

public class FullSubtractor extends Wrapper {
    public FullSubtractor(String label, String stream, Link... links) {
        super(label, stream, links);
    }

    @Override
    public void initialize() {
        HalfSubtractor hs1 = new HalfSubtractor("HalfSubtractor1", "2X2", getInput(0), getInput(1));
        HalfSubtractor hs2 = new HalfSubtractor("HalfSubtractor2", "2X2", hs1.getOutput(1), getInput(2));
        Or or1 = new Or("OR1", hs2.getOutput(0), hs1.getOutput(0));

        addOutput(or1.getOutput(0), hs2.getOutput(1));
    }
}
