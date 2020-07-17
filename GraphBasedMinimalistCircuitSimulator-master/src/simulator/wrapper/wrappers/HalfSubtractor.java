package simulator.wrapper.wrappers;

import simulator.control.Simulator;
import simulator.gates.combinational.And;
import simulator.gates.combinational.Not;
import simulator.gates.combinational.Xor;
import simulator.network.Link;
import simulator.wrapper.Wrapper;

public class HalfSubtractor extends Wrapper {
    public HalfSubtractor(String label, String stream, Link... links) {
        super(label, stream, links);
    }

    @Override
    public void initialize() {
        And and1 = new And("AND1");
        Xor xor1 = new Xor("XOR1");
        Not not1=new Not("NOT1");

        not1.addInput(getInput(0));
        and1.addInput(not1.getOutput(0), getInput(1));
        xor1.addInput(getInput(0), getInput(1));

        //output(0)=>carry,output(1)=>diffrence
        addOutput(and1.getOutput(0), xor1.getOutput(0));
    }
}
