package simulator.wrapper.wrappers;

import simulator.Sample;
import simulator.control.Simulator;
import simulator.gates.sequential.Clock;
import simulator.network.Link;
import simulator.wrapper.Wrapper;



public class Register extends Wrapper {//SELECT,NEWDATA
    public Register(String label, String stream, Link... links) {
        super(label, stream, links);
    }
    //REGWRITE //NEWDATA

    @Override
    public void initialize() {


        simulator.wrapper.wrappers.DFlipFlop DFLIPFLOP1 = new simulator.wrapper.wrappers.DFlipFlop("DFLIPFLOP","2x2");
        Mux2to1 MUX2TO1 = new Mux2to1("MUX2TO1","3X1");


        MUX2TO1.addInput(getInput(0), DFLIPFLOP1.getOutput(0), getInput(1) );
        DFLIPFLOP1.addInput(Sample.clock.getOutput(0), MUX2TO1.getOutput(0));
        addOutput(DFLIPFLOP1.getOutput(0));
    }
}
