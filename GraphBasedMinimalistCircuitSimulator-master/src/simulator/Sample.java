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

    public static Clock clock = new Clock("clock",1000);

    public static void main(String[] args) {

        PC pc=new PC("pc","32x32");

        NextPcValueBit nextPcValue=new NextPcValueBit("newPc","61x32");

        Memory I_memory= new Memory("I_MEMORY");

        pc.addInput(
                nextPcValue.getOutput(0),nextPcValue.getOutput(1),nextPcValue.getOutput(2),nextPcValue.getOutput(3),
                nextPcValue.getOutput(4),nextPcValue.getOutput(5),nextPcValue.getOutput(6),nextPcValue.getOutput(7),
                nextPcValue.getOutput(8),nextPcValue.getOutput(9),nextPcValue.getOutput(10),nextPcValue.getOutput(11),
                nextPcValue.getOutput(12),nextPcValue.getOutput(13),nextPcValue.getOutput(14),nextPcValue.getOutput(15),

                nextPcValue.getOutput(16),nextPcValue.getOutput(17),nextPcValue.getOutput(18),nextPcValue.getOutput(19),
                nextPcValue.getOutput(20),nextPcValue.getOutput(21),nextPcValue.getOutput(22),nextPcValue.getOutput(23),
                nextPcValue.getOutput(24),nextPcValue.getOutput(25),nextPcValue.getOutput(26),nextPcValue.getOutput(27),
                nextPcValue.getOutput(28),nextPcValue.getOutput(29),nextPcValue.getOutput(30),nextPcValue.getOutput(31)
        );

        nextPcValue.addInput(
                pc.getOutput(0),pc.getOutput(1),pc.getOutput(2),pc.getOutput(3),
                pc.getOutput(4),pc.getOutput(5),pc.getOutput(6),pc.getOutput(7),
                pc.getOutput(8),pc.getOutput(9),pc.getOutput(10),pc.getOutput(11),
                pc.getOutput(12),pc.getOutput(13),pc.getOutput(14),pc.getOutput(15),
                pc.getOutput(16),pc.getOutput(17),pc.getOutput(18),pc.getOutput(19),
                pc.getOutput(20),pc.getOutput(21),pc.getOutput(22),pc.getOutput(23),
                pc.getOutput(24),pc.getOutput(25),pc.getOutput(26),pc.getOutput(27),
                pc.getOutput(28),pc.getOutput(29),pc.getOutput(30),pc.getOutput(31),

                Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,
                Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,
                Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,
                Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,
                Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,
                Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,
                Simulator.falseLogic,Simulator.falseLogic,

                //alu.getOutput(32),controlUnit.getOutput(6),controlUnit.getOutput(9)//zero,branch,jump####################################################################
                Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic
        );

        I_memory.addInput(Simulator.falseLogic,

                pc.getOutput(16),pc.getOutput(17),pc.getOutput(18),pc.getOutput(19),
                pc.getOutput(20),pc.getOutput(21),pc.getOutput(22),pc.getOutput(23),
                pc.getOutput(24),pc.getOutput(25),pc.getOutput(26),pc.getOutput(27),
                pc.getOutput(28),pc.getOutput(29),pc.getOutput(30),pc.getOutput(31),

                Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,
                Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,
                Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,
                Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,

                Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,
                Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,
                Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,
                Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic

        );

        Simulator.debugger.addTrackItem(pc,nextPcValue,I_memory);

        Simulator.debugger.setDelay(500);
        Simulator.circuit.startCircuit();
    }


}
