package simulator.wrapper.wrappers;


import simulator.control.Simulator;
import simulator.gates.combinational.And;
import simulator.gates.combinational.Not;
import simulator.gates.combinational.Or;
import simulator.network.Link;
import simulator.wrapper.Wrapper;

public class Mux16to4 extends Wrapper {
    //input=>0=select0(l),1=select1,2=select3,3=select4(h),4=in0,5=in1,6=in2,7=in3,7=in4,8=in5,...19=in15
    //ouput=>0=output

    public Mux16to4(String label, String stream, Link... links) {
        super(label, stream, links);
    }

    @Override
    public void initialize() {

        Mux4to2 mux1=new Mux4to2("mux1","6x1");
        Mux4to2 mux2=new Mux4to2("mux2","6x1");
        Mux4to2 mux3=new Mux4to2("mux3","6x1");
        Mux4to2 mux4=new Mux4to2("mux4","6x1");
        Mux4to2 mux5=new Mux4to2("mux4","6x1");

        mux1.addInput(getInput(0),getInput(1),getInput(4),getInput(5),getInput(6),getInput(7));
        mux2.addInput(getInput(0),getInput(1),getInput(8),getInput(9),getInput(10),getInput(11));
        mux3.addInput(getInput(0),getInput(1),getInput(12),getInput(13),getInput(14),getInput(15));
        mux4.addInput(getInput(0),getInput(1),getInput(16),getInput(17),getInput(18),getInput(19));

        mux5.addInput(getInput(2),getInput(3),mux1.getOutput(0),mux2.getOutput(0),mux3.getOutput(0),mux4.getOutput(0));
        addOutput(mux5.getOutput(0));
    }
}