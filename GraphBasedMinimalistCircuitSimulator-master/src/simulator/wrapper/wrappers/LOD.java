package simulator.wrapper.wrappers;

import simulator.control.Simulator;
import simulator.gates.sequential.Clock;
import simulator.network.Link;
import simulator.wrapper.Wrapper;

/**
 * input0,1:Signal
 * input2,514:write data
 * */
public class LOD extends Wrapper {
    private SubCache[] LOD;
    public LOD(String label, String stream, Link... links) {
        super(label, stream, links);
    }

    @Override
    public void initialize() {
        LOD=new SubCache[512];
        for (int i = 0; i < 512; i++) {
            LOD[i]=new SubCache("element"+i,"3x1", new Clock("S",100).getOutput(0), Simulator.falseLogic, Simulator.falseLogic);

        }
        addOutput(Simulator.falseLogic, Simulator.falseLogic, Simulator.falseLogic, Simulator.falseLogic, Simulator.falseLogic, Simulator.falseLogic, Simulator.falseLogic, Simulator.falseLogic, Simulator.falseLogic, Simulator.falseLogic, Simulator.falseLogic, Simulator.falseLogic, Simulator.falseLogic, Simulator.falseLogic, Simulator.falseLogic, Simulator.falseLogic, Simulator.falseLogic, Simulator.falseLogic, Simulator.falseLogic, Simulator.falseLogic, Simulator.falseLogic, Simulator.falseLogic, Simulator.falseLogic, Simulator.falseLogic, Simulator.falseLogic, Simulator.falseLogic, Simulator.falseLogic, Simulator.falseLogic, Simulator.falseLogic, Simulator.falseLogic, Simulator.falseLogic, Simulator.falseLogic);

    }
    public void read(){
        for (int i = 0; i < 512; i++) {
            this.addOutput(LOD[i].getOutput(0));

        }
    }  public void write(){
        for (int i = 0; i < 512; i++) {
            LOD[i].setInput(1,getInput(1));
            LOD[i].setInput(2,getInput(i+2));


        }
    }

    public SubCache[] getLOD() {
        return LOD;
    }

    public void setLOD(SubCache[] LOD) {
        this.LOD = LOD;
    }
}
