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
        ALUControlUnit alucontrolunit = new ALUControlUnit("alucontrolunit", "8X4");
        ALU alu=new ALU("alu","68x33");

        SignExtend signExtend=new SignExtend("signExtend","16x32");
        List<Mux2to1> muxsbeforealu = new ArrayList<>();
        List<Mux2to1> muxsafterdatamem = new ArrayList<>();
        RegisterFile registerfile = new RegisterFile("registerfile","48X64");

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

                memory.getOutput(6),memory.getOutput(7),memory.getOutput(8),memory.getOutput(9),memory.getOutput(10),memory.getOutput(11),memory.getOutput(12),memory.getOutput(13),
                memory.getOutput(14),memory.getOutput(15),memory.getOutput(16),memory.getOutput(17),memory.getOutput(18),memory.getOutput(19),memory.getOutput(20),memory.getOutput(21),
                memory.getOutput(22),memory.getOutput(23),memory.getOutput(24),memory.getOutput(25),memory.getOutput(26),memory.getOutput(27),memory.getOutput(28),memory.getOutput(29),
                memory.getOutput(30),memory.getOutput(31),

                alu.getOutput(32),controlUnit.getOutput(6),controlUnit.getOutput(9)
        );

        //input : instruction[31-26]   //output :  //output[4] MemRead &&& output[5]  MemWrite
        controlUnit.addInput(memory.getOutput(5), memory.getOutput(4),memory.getOutput(3),memory.getOutput(2),memory.getOutput(1),memory.getOutput(0));

        alucontrolunit.addInput(
                controlUnit.getOutput(7),controlUnit.getOutput(8),
                memory.getOutput(26),memory.getOutput(27),memory.getOutput(28),memory.getOutput(29),memory.getOutput(30),memory.getOutput(31)
        );

        //5 mux ghabl az register //select az regDST
        //input[0] instruction[20] //input[1] instruction[15]
        Mux2to1 muxbeforeregMSB4 = new Mux2to1("muxbeforeregMSB4","3X1",controlUnit.getOutput(0),memory.getOutput(11),memory.getOutput(16));
        //input[0] instruction[19] //input[1] instruction[14]
        Mux2to1 muxbeforeregMSB3 = new Mux2to1("muxbeforeregMSB3","3X1",controlUnit.getOutput(0),memory.getOutput(12),memory.getOutput(17));
        //input[0] instruction[18] //input[1] instruction[13]
        Mux2to1 muxbeforeregMSB2 = new Mux2to1("muxbeforeregMSB2","3X1",controlUnit.getOutput(0),memory.getOutput(13),memory.getOutput(18));
        //input[0] instruction[17] //input[1] instruction[12]
        Mux2to1 muxbeforeregMSB1 = new Mux2to1("muxbeforeregMSB1","3X1",controlUnit.getOutput(0),memory.getOutput(14),memory.getOutput(19));
        //input[0] instruction[16] //input[1] instruction[11]
        Mux2to1 muxbeforeregMSB0 = new Mux2to1("muxbeforeregMSB0","3X1",controlUnit.getOutput(0),memory.getOutput(25),memory.getOutput(20));

        //////Register file
        //input[0-5] ==== instruction[25-21]
        //input[6-10] ==== instruction[20-16]
        //input[11-15] ==== mux haie bala az MSB4 ta MSB0
        //input[16] === regWrite
        registerfile.addInput(
                memory.getOutput(6), memory.getOutput(7), memory.getOutput(8), memory.getOutput(9), memory.getOutput(10),
                memory.getOutput(11), memory.getOutput(12), memory.getOutput(13), memory.getOutput(14), memory.getOutput(15),
                muxbeforeregMSB4.getOutput(0),muxbeforeregMSB3.getOutput(0),muxbeforeregMSB2.getOutput(0),muxbeforeregMSB1.getOutput(0),muxbeforeregMSB0.getOutput(0),
                controlUnit.getOutput(3)
        );

        //input[17-31] === dataii k gharare dar reg neveshte beshe k az data mem miad ya az alu
        for(int i=0;i<32;i++){
            muxsafterdatamem.add(new Mux2to1("mux" + i, "3x1",
                            //controlUnit.getOutput(2),
                            Simulator.falseLogic,
                            alu.getOutput(i),Simulator.falseLogic //az data mem baiad biad
                    )
            );
        }
        //b input haie reg ezafashoon mikone
        for(int i=0;i<32;i++) {
            registerfile.addInput(muxsafterdatamem.get(i).getOutput(0));
        }


        //first alu input
        alu.addInput(
                registerfile.getOutput(0),registerfile.getOutput(1),registerfile.getOutput(2),registerfile.getOutput(3),registerfile.getOutput(4),registerfile.getOutput(5),registerfile.getOutput(6),registerfile.getOutput(7),
                registerfile.getOutput(8),registerfile.getOutput(9),registerfile.getOutput(10),registerfile.getOutput(11),registerfile.getOutput(12),registerfile.getOutput(13),registerfile.getOutput(14),registerfile.getOutput(15),
                registerfile.getOutput(16),registerfile.getOutput(17),registerfile.getOutput(18),registerfile.getOutput(19),registerfile.getOutput(20),registerfile.getOutput(21),registerfile.getOutput(22),registerfile.getOutput(23),
                registerfile.getOutput(24),registerfile.getOutput(25),registerfile.getOutput(26),registerfile.getOutput(27),registerfile.getOutput(28),registerfile.getOutput(29),registerfile.getOutput(30),registerfile.getOutput(31)
                );
        //second alu input
        signExtend.addInput(
                memory.getOutput(16),memory.getOutput(17),memory.getOutput(18),memory.getOutput(19),memory.getOutput(20),memory.getOutput(21), memory.getOutput(22),memory.getOutput(23),
                memory.getOutput(24),memory.getOutput(25),memory.getOutput(26),memory.getOutput(27),memory.getOutput(28),memory.getOutput(29), memory.getOutput(30),memory.getOutput(31)
        );

        for(int i=0;i<32;i++){
            muxsbeforealu.add(new Mux2to1("mux" + i, "3x1",
                            controlUnit.getOutput(1),
                            registerfile.getOutput(i+32),signExtend.getOutput(i)
                    )
            );
        }
        for(int i=0;i<32;i++) {
            alu.addInput(muxsbeforealu.get(i).getOutput(0));
        }


        //alu control signal
        alu.addInput(alucontrolunit.getOutput(3),alucontrolunit.getOutput(2),alucontrolunit.getOutput(1),alucontrolunit.getOutput(0));

        Simulator.debugger.addTrackItem(controlUnit,alucontrolunit,alu,registerfile);
        Simulator.debugger.setDelay(500);
        Simulator.circuit.startCircuit();
    }


}