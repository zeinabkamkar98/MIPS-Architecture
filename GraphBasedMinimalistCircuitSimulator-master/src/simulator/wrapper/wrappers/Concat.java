package simulator.wrapper.wrappers;

import simulator.control.Simulator;
import simulator.network.Link;
import simulator.wrapper.Wrapper;

public class Concat extends Wrapper {
    public Concat(String label, String stream, Link... links) {
        super(label, stream, links);
    }

    @Override
    public void initialize() {

        for(int i=0;i<=31;i++){
            addOutput(getInput(i));
        }

    }
}
