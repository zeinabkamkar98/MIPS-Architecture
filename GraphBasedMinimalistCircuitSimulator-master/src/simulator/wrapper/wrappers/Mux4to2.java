package simulator.wrapper.wrappers;


import simulator.control.Simulator;
import simulator.gates.combinational.And;
import simulator.gates.combinational.Not;
import simulator.gates.combinational.Or;
import simulator.network.Link;
import simulator.wrapper.Wrapper;

public class Mux4to2 extends Wrapper {
    //input=>0=select0(l),1=select1(h),2=in0,3=in1,4=in2,5=in3
    //ouput=>0=output

    public Mux4to2(String label, String stream, Link... links) {
        super(label, stream, links);
    }

    @Override
    public void initialize() {

        Mux2to1 mux1=new Mux2to1("mux1","3x1");
        Mux2to1 mux2=new Mux2to1("mux2","3x1");
        Mux2to1 mux3=new Mux2to1("mux3","3x1");
        mux1.addInput(getInput(0),getInput(2),getInput(3));
        mux2.addInput(getInput(0),getInput(4),getInput(5));
        mux3.addInput(getInput(1),mux1.getOutput(0),mux2.getOutput(0));
        addOutput(mux3.getOutput(0));
    }
}