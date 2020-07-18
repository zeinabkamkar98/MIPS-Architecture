
import simulator.gates.combinational.And;
import simulator.gates.combinational.Not;
import simulator.gates.combinational.Or;
import simulator.network.Link;
import simulator.wrapper.Wrapper;

public class Mux2x1 extends Wrapper {
    public Mux2x1(String label, String stream, Link... links) {
        super(label, stream, links);
    }

    @Override
    public void initialize() {
        Not not0 = new Not("N0", getInput(0));

        And[] ands = new And[2];
        for (int i = 0; i < 2; ++i)
            ands[i] = new And("A" + i, getInput(i + 1));

        ands[0].addInput(not0.getOutput(0), getInput(1));
        ands[1].addInput(getInput(0), getInput(2));

        Or or = new Or("Or");
        or.addInput(ands[0].getOutput(0),ands[1].getOutput(0));

        addOutput(or.getOutput(0));
    }
}
