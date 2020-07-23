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

        PC pc = new PC("PC", "32X32");
        NextPcValue nextPcValue=new NextPcValue("updatePC","61x32");
        ControlUnit controlUnit = new ControlUnit("CONTROLUNIT", "6X10");

        pc.addInput(
                nextPcValue.getOutput(0),nextPcValue.getOutput(1),nextPcValue.getOutput(2),nextPcValue.getOutput(3),nextPcValue.getOutput(4),nextPcValue.getOutput(5),nextPcValue.getOutput(6),nextPcValue.getOutput(7),
                nextPcValue.getOutput(8),nextPcValue.getOutput(9),nextPcValue.getOutput(10),nextPcValue.getOutput(11),nextPcValue.getOutput(12),nextPcValue.getOutput(13),nextPcValue.getOutput(14),nextPcValue.getOutput(15),
                nextPcValue.getOutput(16),nextPcValue.getOutput(17),nextPcValue.getOutput(18),nextPcValue.getOutput(19),nextPcValue.getOutput(20),nextPcValue.getOutput(21),nextPcValue.getOutput(22),nextPcValue.getOutput(23),
                nextPcValue.getOutput(24),nextPcValue.getOutput(25),nextPcValue.getOutput(26),nextPcValue.getOutput(27),nextPcValue.getOutput(28),nextPcValue.getOutput(29),nextPcValue.getOutput(30),nextPcValue.getOutput(31)
        );

        nextPcValue.addInput(
                pc.getOutput(0),pc.getOutput(1),pc.getOutput(2),pc.getOutput(3),pc.getOutput(4),pc.getOutput(5),pc.getOutput(6),pc.getOutput(7),
                pc.getOutput(8),pc.getOutput(9),pc.getOutput(10),pc.getOutput(11),pc.getOutput(12),pc.getOutput(13),pc.getOutput(14),pc.getOutput(15),
                pc.getOutput(16),pc.getOutput(17),pc.getOutput(18),pc.getOutput(19),pc.getOutput(20),pc.getOutput(21),pc.getOutput(22),pc.getOutput(23),
                pc.getOutput(24),pc.getOutput(25),pc.getOutput(26),pc.getOutput(27),pc.getOutput(28),pc.getOutput(29),pc.getOutput(30),pc.getOutput(31),
//                memory.getOutput(6),memory.getOutput(7),memory.getOutput(8),memory.getOutput(9),memory.getOutput(10),memory.getOutput(11),memory.getOutput(12),memory.getOutput(13),
//                memory.getOutput(14),memory.getOutput(15),memory.getOutput(16),memory.getOutput(17),memory.getOutput(18),memory.getOutput(19),memory.getOutput(20),memory.getOutput(21),
//                memory.getOutput(22),memory.getOutput(23),memory.getOutput(24),memory.getOutput(25),memory.getOutput(26),memory.getOutput(27),memory.getOutput(28),memory.getOutput(29),
//                memory.getOutput(30),memory.getOutput(31),
                Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,
                Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,
                Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,
                Simulator.falseLogic,Simulator.trueLogic,
                Simulator.falseLogic,controlUnit.getOutput(6),controlUnit.getOutput(9)
        );

        controlUnit.addInput(Simulator.falseLogic, Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.trueLogic,Simulator.falseLogic);

        Simulator.debugger.addTrackItem(pc,nextPcValue,memory,controlUnit);
        Simulator.debugger.setDelay(500);
        Simulator.circuit.startCircuit();
    }


}