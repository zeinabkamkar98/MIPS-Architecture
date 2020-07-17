package simulator.wrapper.wrappers;


import simulator.control.Simulator;
import simulator.gates.combinational.And;
import simulator.gates.combinational.Not;
import simulator.gates.combinational.Or;
import simulator.network.Link;
import simulator.wrapper.Wrapper;

public class Mux2to1 extends Wrapper {
    //SELECT,INPUT0,INPUT1

    public Mux2to1(String label, String stream, Link... links) {
        super(label, stream, links);
    }

    @Override
    public void initialize() {

        Not NOT1 = new Not("NOT1");
        And AND1 = new And("AND1"); //(S,A)
        And AND2 = new And("AND2");//(S,B)

        NOT1.addInput(getInput(0));
        AND1.addInput(NOT1.getOutput(0), getInput(1));
        AND2.addInput(getInput(0), getInput(2));

        Or Or1 = new Or("Or1", AND1.getOutput(0), AND2.getOutput(0));

        addOutput(Or1.getOutput(0));
    }
}