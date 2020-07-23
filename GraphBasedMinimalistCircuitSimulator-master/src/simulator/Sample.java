//Dedicated to Goli

package simulator;

import simulator.control.Simulator;
import simulator.gates.combinational.And;
import simulator.gates.combinational.Memory;
import simulator.gates.sequential.Clock;
import simulator.network.Link;
import simulator.wrapper.wrappers.*;

import java.util.ArrayList;
import java.util.List;

public class Sample {
    public static   Memory memory=new Memory("M!",Simulator.falseLogic,Simulator.trueLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.trueLogic);

    public static Memory getMemory() {
        return memory;
    }

    public static void setMemory(Memory memory) {
        Sample.memory = memory;
    }

    public static Clock clock = new Clock("clock",1000);

    public static void main(String[] args) {
//        ALU alu=new ALU("alu","68x33");
//        alu.addInput(
//
//                Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,
//                Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,
//                Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,
//                Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.trueLogic,Simulator.trueLogic,
//
//                Simulator.falseLogic,Simulator.trueLogic,Simulator.trueLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,
//                Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,
//                Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,
//                Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.trueLogic,Simulator.falseLogic,Simulator.trueLogic,
//x
//                Simulator.trueLogic,Simulator.trueLogic,Simulator.trueLogic,Simulator.falseLogic);
//
//        Simulator.debugger.addTrackItem(alu);


        PC myPC = new PC("myPC", "32X32");
        NextPcValue pc=new NextPcValue("updatePC","61x32");

        myPC.addInput(

                pc.getOutput(0),pc.getOutput(1),pc.getOutput(2),pc.getOutput(3),pc.getOutput(4),pc.getOutput(5),pc.getOutput(6),pc.getOutput(7),
                pc.getOutput(8),pc.getOutput(9),pc.getOutput(10),pc.getOutput(11),pc.getOutput(12),pc.getOutput(13),pc.getOutput(14),pc.getOutput(15),
                pc.getOutput(16),pc.getOutput(17),pc.getOutput(18),pc.getOutput(19),pc.getOutput(20),pc.getOutput(21),pc.getOutput(22),pc.getOutput(23),
                pc.getOutput(24),pc.getOutput(25),pc.getOutput(26),pc.getOutput(27),pc.getOutput(28),pc.getOutput(29),pc.getOutput(30),pc.getOutput(31)

                );
//        myPC.addInput(Simulator.falseLogic, Simulator.falseLogic, Simulator.falseLogic, Simulator.falseLogic,
//                Simulator.falseLogic, Simulator.falseLogic, Simulator.falseLogic, Simulator.falseLogic,
//                Simulator.falseLogic, Simulator.falseLogic, Simulator.falseLogic, Simulator.falseLogic,
//                Simulator.falseLogic, Simulator.falseLogic, Simulator.falseLogic, Simulator.falseLogic,
//                Simulator.falseLogic, Simulator.falseLogic, Simulator.falseLogic, Simulator.falseLogic,
//                Simulator.falseLogic, Simulator.falseLogic, Simulator.falseLogic, Simulator.falseLogic,
//                Simulator.falseLogic, Simulator.falseLogic, Simulator.falseLogic, Simulator.falseLogic,
//                Simulator.falseLogic, Simulator.falseLogic, Simulator.falseLogic, Simulator.falseLogic
//        );

        Simulator.debugger.addTrackItem(myPC);
        pc.addInput(
                myPC.getOutput(0),myPC.getOutput(1),myPC.getOutput(2),myPC.getOutput(3),myPC.getOutput(4),myPC.getOutput(5),myPC.getOutput(6),myPC.getOutput(7),
                myPC.getOutput(8),myPC.getOutput(9),myPC.getOutput(10),myPC.getOutput(11),myPC.getOutput(12),myPC.getOutput(13),myPC.getOutput(14),myPC.getOutput(15),
                myPC.getOutput(16),myPC.getOutput(17),myPC.getOutput(18),myPC.getOutput(19),myPC.getOutput(20),myPC.getOutput(21),myPC.getOutput(22),myPC.getOutput(23),
                myPC.getOutput(24),myPC.getOutput(25),myPC.getOutput(26),myPC.getOutput(27),myPC.getOutput(28),myPC.getOutput(29),myPC.getOutput(30),myPC.getOutput(31),


                Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,
                Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,
                Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,
                Simulator.falseLogic,Simulator.trueLogic,

                Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic

        );

        Simulator.debugger.addTrackItem(myPC,pc);
        Simulator.debugger.setDelay(500);
        Simulator.circuit.startCircuit();
        System.out.println("hello");
    }


}