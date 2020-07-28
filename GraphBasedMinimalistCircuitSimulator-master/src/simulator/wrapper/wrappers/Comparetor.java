package simulator.wrapper.wrappers;

import simulator.gates.combinational.Not;
import simulator.gates.combinational.Or;
import simulator.gates.combinational.Xor;
import simulator.network.Link;
import simulator.wrapper.Wrapper;

public class Comparetor extends Wrapper {
    public Comparetor(String label, String stream, Link... links) {
        super(label, stream, links);
    }

    @Override
    public void initialize() {
        int input=getInputSize();
        Or o1=new Or("ComparatorResult");
        for (int i = 0; i <input/2 ; i++) {

            Xor xor=new Xor("XOR0"+i,getInput(i),getInput(i+input/2));
            o1.addInput(xor.getOutput(0));

        }
        addOutput(new Not("n",o1.getOutput(0)).getOutput(0));

    }
}
