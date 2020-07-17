package simulator.wrapper.wrappers;

import simulator.control.Simulator;
import simulator.network.Link;
import simulator.wrapper.Wrapper;

import java.util.ArrayList;
import java.util.List;

//a generic adder
public class ALU extends Wrapper {
    public ALU(String label, String stream, Link... links) {
        super(label, stream, links);
    }

    @Override
    public void initialize() {



    }
}