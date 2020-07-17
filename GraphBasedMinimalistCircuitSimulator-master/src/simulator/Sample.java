//Dedicated to Goli

package simulator;

import simulator.control.Simulator;
import simulator.wrapper.wrappers.*;

public class Sample {
    public static void main(String[] args) {
        //sample circuit
       /* Adder adder = new Adder("ADDER", "10X6",
                Simulator.trueLogic, Simulator.falseLogic, Simulator.falseLogic, Simulator.falseLogic, Simulator.falseLogic,
                Simulator.falseLogic, Simulator.falseLogic, Simulator.falseLogic, Simulator.falseLogic, Simulator.trueLogic);

        Simulator.debugger.addTrackItem(adder);*/

/*        HalfSubtractor sub=new HalfSubtractor("sub1","2X2");
        sub.addInput(Simulator.falseLogic,Simulator.trueLogic);*/

/*
        Subtractor sub = new Subtractor("ADDER", "12X7",
                Simulator.falseLogic, Simulator.falseLogic, Simulator.falseLogic, Simulator.trueLogic, Simulator.trueLogic,Simulator.trueLogic,
                Simulator.falseLogic, Simulator.trueLogic, Simulator.falseLogic, Simulator.trueLogic, Simulator.falseLogic,Simulator.trueLogic);

        Simulator.debugger.addTrackItem(sub);
*/
/*
        BIGAND and=new BIGAND("BIGAND","6X3",
                Simulator.trueLogic,Simulator.trueLogic,Simulator.falseLogic,
                Simulator.falseLogic,Simulator.trueLogic,Simulator.falseLogic);
        BIGOR or=new BIGOR("BIGOR","6X3",
                Simulator.trueLogic,Simulator.trueLogic,Simulator.falseLogic,
                Simulator.falseLogic,Simulator.trueLogic,Simulator.falseLogic);
        Simulator.debugger.addTrackItem(or,and);
*/

        Simulator.debugger.setDelay(500);
        Simulator.circuit.startCircuit();
    }
}