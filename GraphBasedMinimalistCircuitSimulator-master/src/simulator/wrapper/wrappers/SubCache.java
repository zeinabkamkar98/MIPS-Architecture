package simulator.wrapper.wrappers;

import simulator.control.Simulator;
import simulator.gates.sequential.Clock;
import simulator.gates.sequential.flipflops.DFlipFlop;
import simulator.network.Link;
import simulator.wrapper.Wrapper;
import simulator.wrapper.wrappers.Mux2to1;
import simulator.wrapper.wrappers.RealDFlipFlop;


public class SubCache extends Wrapper {
/*
This class receives 3 inputs and has 1 output.
input0:clock signal
input1:Control signal for refresh or write data on flip flop
input2:data we (maybe) want to write on flip flop

output:data which is in flip flop
*/

    public SubCache(String label, String stream, Link... links) {
        super(label, stream, links);

    }


    @Override
    public void initialize() {

        DFlipFlop flipFlop=new DFlipFlop("DFF","2x2",getInput(0),Simulator.trueLogic);
        Mux2to1 mux1 =new Mux2to1("mux","3x1", getInput(1)
                , flipFlop.getOutput(0),
                getInput(2));
        flipFlop.setInput(1,mux1.getOutput(0));
        addOutput(flipFlop.getOutput(0));
    }

    @Override
    public void addInput(Link... links) {

    }

    @Override
    public void setInput(int index, Link link) {

    }

    @Override
    public void addOutput(Link... links) {

    }

    @Override
    public void setOutput(int index, Link link) {

    }
}
