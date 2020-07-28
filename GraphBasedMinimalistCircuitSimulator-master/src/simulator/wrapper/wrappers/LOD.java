package simulator.wrapper.wrappers;

import simulator.Sample;
import simulator.control.Simulator;
import simulator.gates.combinational.And;
import simulator.gates.sequential.Clock;
import simulator.network.Link;
import simulator.wrapper.Wrapper;

/**
 * input0,1:Signal
 * input2,514:write data
 * */
public class LOD extends Wrapper {
    public SubCache[] LOD;
    public LOD(String label, String stream, Link... links) {
        super(label, stream, links);
    }

    @Override
    public void initialize() {
        LOD=new SubCache[128];
        for (int i = 0; i < 128; i++) {
            LOD[i]=new SubCache("element"+i,"3x1", Sample.clock.getOutput(0), Simulator.falseLogic, Simulator.falseLogic);

        }



        for (int i = 0; i < 128; i++) {
            LOD[i].setInput(1,getInput(1));
            LOD[i].setInput(2,getInput(i+2));


        }
        Mux2to1[] mux2to1=new Mux2to1[128];
        for (int i = 0; i <128 ; i++) {
            mux2to1[i]=new Mux2to1("Mux"+i,"3x1",getInput(0),Simulator.falseLogic,LOD[i].getOutput(0));
            addOutput(mux2to1[i].getOutput(0));
        }



    }
    public void read(){
        for (int i = 0; i < 512; i++) {
//            addOutput(LOD[i].getOutput(0));

        }
    }  public void write(){
        for (int i = 0; i < 512; i++) {
            LOD[i].setInput(1,getInput(1));
            LOD[i].setInput(2,getInput(i+2));
            System.out.println(getInput(i+2).getSignal());


        }

    }

    public SubCache[] getLOD() {
        return LOD;
    }

    public void setLOD(SubCache[] LOD) {
        this.LOD = LOD;
    }
}
