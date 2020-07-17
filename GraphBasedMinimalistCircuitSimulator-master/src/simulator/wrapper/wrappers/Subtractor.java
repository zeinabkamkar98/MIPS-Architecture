package simulator.wrapper.wrappers;

import simulator.control.Simulator;
import simulator.network.Link;
import simulator.wrapper.Wrapper;

import java.util.ArrayList;
import java.util.List;


public class Subtractor extends Wrapper {
    public Subtractor(String label, String stream, Link... links) {
        super(label, stream, links);
    }

    @Override
    public void initialize() {
        List<FullSubtractor> fullSubtractors = new ArrayList<>();
        /* you can also use getInputs().size() instead of getInputSize()
         * but to prevent several potential problems, always try not to use
         * collections explicitly.*/

        int firstLowerBitIndex = (getInputSize() - 1) / 2;
        int secondLowerBitIndex = getInputSize() - 1;
        int fullSubtractorSize = getInputSize() / 2;

        for (int i = 0; i < fullSubtractorSize; ++i)
            fullSubtractors.add(new FullSubtractor("FA" + i, "3X2",
                    getInput(firstLowerBitIndex - i),
                    getInput(secondLowerBitIndex - i)));

        fullSubtractors.get(0).addInput(Simulator.falseLogic);

        for (int i = 1; i < fullSubtractorSize; ++i)
            fullSubtractors.get(i).addInput(fullSubtractors.get(i - 1).getOutput(0));

        addOutput(fullSubtractors.get(fullSubtractorSize - 1).getOutput(0));

        for (int i = fullSubtractorSize - 1; i >= 0; --i)
            addOutput(fullSubtractors.get(i).getOutput(1));

    }
}