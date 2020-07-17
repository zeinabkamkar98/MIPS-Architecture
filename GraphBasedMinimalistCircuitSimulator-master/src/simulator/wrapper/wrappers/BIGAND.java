package simulator.wrapper.wrappers;

import simulator.control.Simulator;
import simulator.gates.combinational.And;
import simulator.network.Link;
import simulator.wrapper.Wrapper;

import java.util.ArrayList;
import java.util.List;

//a generic adder
public class BIGAND extends Wrapper {
    public BIGAND(String label, String stream, Link... links) {
        super(label, stream, links);
    }

    @Override
    public void initialize() {
        List<And> Ands = new ArrayList<>();

        int firstLowerBitIndex = (getInputSize() - 1) / 2;
        int secondLowerBitIndex = getInputSize() - 1;
        int AndSize = getInputSize() / 2;

        for (int i = 0; i < AndSize; ++i)
            Ands.add(new And("and" + i,
                    getInput(firstLowerBitIndex - i),
                    getInput(secondLowerBitIndex - i)));

        for (int i = AndSize - 1; i >= 0; --i)
            addOutput(Ands.get(i).getOutput(0));

    }
}