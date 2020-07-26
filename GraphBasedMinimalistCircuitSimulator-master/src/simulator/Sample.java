//Dedicated to Goli

package simulator;
import simulator.control.Simulator;
import simulator.gates.combinational.And;
import simulator.gates.combinational.Memory;
import simulator.gates.sequential.BigClock;
import simulator.gates.sequential.Clock;
import simulator.network.Link;
import simulator.wrapper.wrappers.*;
import java.util.ArrayList;
import java.util.List;


public class Sample {

//    public static   Memory D_memory=new Memory("MD_MEMORY");

//    public static Memory getMemory() {
//        return I_memory;
//    }
//
//    public static Memory getI_Memory() {
//        return I_memory;
//    }
//
//    public static void setI_Memory(Memory memory) {
//        Sample.I_memory = memory;
//    }

//    public static Memory getD_memory() {
//        return D_memory;
//    }
//
//    public static void setD_memory(Memory d_memory) {
//        D_memory = d_memory;
//    }

    public static BigClock clock = new BigClock("clock");


    public static void main(String[] args) {
         Memory I_memory= new Memory("I_MEMORY");

//        memory.evaluate();
//        Cache cache=new Cache("C!",
//                "65x32",
//                memory,new Clock("CLK",100),
//                Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.trueLogic);
        PC pc = new PC("PC", "32X32");
        NextPcValue nextPcValue=new NextPcValue("updatePC","61x32");
        ControlUnit controlUnit = new ControlUnit("CONTROLUNIT", "6X10");
        ALUControlUnit alucontrolunit = new ALUControlUnit("alucontrolunit", "8X4");
        RegisterFile registerfile = new RegisterFile("registerfile","48X64");
        ALU alu=new ALU("alu","68x33");//output alu mishe address baray data memory
//        Cache DCache=new Cache("DATACACHE","65x32",memory,clock);
//        Cache ICache=new Cache("IATACACHE","65x32",memory,clock);

        SignExtend signExtend=new SignExtend("signExtend","16x32");
        List<Mux2to1> muxsbeforealu = new ArrayList<>();
        List<Mux2to1> muxsafterdatamem = new ArrayList<>();
        List<Mux2to1> muxBeforeMem1 = new ArrayList<>();
        List<Mux2to1> muxBeforeMem2 = new ArrayList<>();
        List<Mux2to1> multiplexers=new ArrayList<>();

        SignExtend conAdderss=new SignExtend("signExtend","16x32");
        conAdderss.addInput(
                I_memory.getOutput(10),
                I_memory.getOutput(11),
                I_memory.getOutput(12),
                I_memory.getOutput(13),
                I_memory.getOutput(14),
                I_memory.getOutput(15),
                I_memory.getOutput(16),
                I_memory.getOutput(17),
                I_memory.getOutput(18),
                I_memory.getOutput(19),
                I_memory.getOutput(20),
                I_memory.getOutput(21),
                I_memory.getOutput(22),
                I_memory.getOutput(23),
                I_memory.getOutput(24),
                I_memory.getOutput(26)
        );

        ShiftLeft32to32b shift32=new ShiftLeft32to32b("shift32","32x32");
        shift32.addInput(
                conAdderss.getOutput(0),conAdderss.getOutput(1),conAdderss.getOutput(2),conAdderss.getOutput(3),conAdderss.getOutput(4),conAdderss.getOutput(5),conAdderss.getOutput(6),conAdderss.getOutput(7),
                conAdderss.getOutput(8),conAdderss.getOutput(9),conAdderss.getOutput(10),conAdderss.getOutput(11),conAdderss.getOutput(12),conAdderss.getOutput(13),conAdderss.getOutput(14),conAdderss.getOutput(15),
                conAdderss.getOutput(16),conAdderss.getOutput(17),conAdderss.getOutput(18),conAdderss.getOutput(19),conAdderss.getOutput(20),conAdderss.getOutput(21),conAdderss.getOutput(22),conAdderss.getOutput(23),
                conAdderss.getOutput(24),conAdderss.getOutput(25),conAdderss.getOutput(26),conAdderss.getOutput(27),conAdderss.getOutput(28),conAdderss.getOutput(29),conAdderss.getOutput(30),conAdderss.getOutput(31)
        );
        Link[] links=new Link[32];
        for (int i = 0; i <32 ; i++) {
            links[i]=new And("and",controlUnit.getOutput(6),shift32.getOutput(i)).getOutput(0);
        }

        Adder branchAdd=new Adder("branchAdd","64x32");
        branchAdd.addInput(
                shift32.getOutput(0),shift32.getOutput(1),shift32.getOutput(2),shift32.getOutput(3),shift32.getOutput(4),shift32.getOutput(5),shift32.getOutput(6),shift32.getOutput(7),
                shift32.getOutput(8),shift32.getOutput(9),shift32.getOutput(10),shift32.getOutput(11),shift32.getOutput(12),shift32.getOutput(13),shift32.getOutput(14),shift32.getOutput(15),
                shift32.getOutput(16),shift32.getOutput(17),shift32.getOutput(18),shift32.getOutput(19),shift32.getOutput(20),shift32.getOutput(21),shift32.getOutput(22),shift32.getOutput(23),
                shift32.getOutput(24),shift32.getOutput(25),shift32.getOutput(26),shift32.getOutput(27),shift32.getOutput(28),shift32.getOutput(29),shift32.getOutput(30),shift32.getOutput(31),

                Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,
                Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,
                Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,
                Simulator.falseLogic,Simulator.falseLogic,Simulator.trueLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic

        );
        for (int i = 0; i < 26; i++) {
            multiplexers.add(new Mux2to1("m","3x1",controlUnit.getOutput(6),Simulator.falseLogic,Simulator.falseLogic));

        }
        multiplexers.add(new Mux2to1("m","3x1",controlUnit.getOutput(6),Simulator.trueLogic,Simulator.trueLogic));

        for (int i = 27; i < 32; i++) {
            multiplexers.add(new Mux2to1("m","3x1",controlUnit.getOutput(6),Simulator.falseLogic,Simulator.falseLogic));

        }

        Adder adder=new Adder("1","64x32", pc.getOutput(0),pc.getOutput(1),pc.getOutput(2),pc.getOutput(3),pc.getOutput(4),pc.getOutput(5),pc.getOutput(6),pc.getOutput(7),
                pc.getOutput(8),pc.getOutput(9),pc.getOutput(10),pc.getOutput(11),pc.getOutput(12),pc.getOutput(13),pc.getOutput(14),pc.getOutput(15),
                pc.getOutput(16),pc.getOutput(17),pc.getOutput(18),pc.getOutput(19),pc.getOutput(20),pc.getOutput(21),pc.getOutput(22),pc.getOutput(23),
                pc.getOutput(24),pc.getOutput(25),pc.getOutput(26),pc.getOutput(27),pc.getOutput(28),pc.getOutput(29),pc.getOutput(30),pc.getOutput(31),
//                multiplexers.get(0).getOutput(0),multiplexers.get(1).getOutput(0),multiplexers.get(2).getOutput(0),multiplexers.get(3).getOutput(0),
//                multiplexers.get(4).getOutput(0),multiplexers.get(5).getOutput(0),multiplexers.get(6).getOutput(0),multiplexers.get(7).getOutput(0),
//                multiplexers.get(8).getOutput(0),multiplexers.get(9).getOutput(0),multiplexers.get(10).getOutput(0),multiplexers.get(11).getOutput(0),
//                multiplexers.get(12).getOutput(0),multiplexers.get(13).getOutput(0),multiplexers.get(14).getOutput(0),multiplexers.get(15).getOutput(0),
//                multiplexers.get(16).getOutput(0),multiplexers.get(17).getOutput(0),multiplexers.get(18).getOutput(0),multiplexers.get(19).getOutput(0),
//                multiplexers.get(20).getOutput(0),multiplexers.get(21).getOutput(0),multiplexers.get(22).getOutput(0),multiplexers.get(23).getOutput(0),
//                multiplexers.get(24).getOutput(0),multiplexers.get(25).getOutput(0),multiplexers.get(26).getOutput(0),multiplexers.get(27).getOutput(0),
//                multiplexers.get(28).getOutput(0),multiplexers.get(29).getOutput(0),multiplexers.get(30).getOutput(0),multiplexers.get(31).getOutput(0)
                Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,
                Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,
                Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,
                Simulator.falseLogic,Simulator.falseLogic,Simulator.trueLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic
        );
        pc.addInput(
                adder.getOutput(0),adder.getOutput(1),adder.getOutput(2),adder.getOutput(3),adder.getOutput(4),adder.getOutput(5),adder.getOutput(6),adder.getOutput(7),
                adder.getOutput(8),adder.getOutput(9),adder.getOutput(10),adder.getOutput(11),adder.getOutput(12),adder.getOutput(13),adder.getOutput(14),adder.getOutput(15),
                adder.getOutput(16),adder.getOutput(17),adder.getOutput(18),adder.getOutput(19),adder.getOutput(20),adder.getOutput(21),adder.getOutput(22),adder.getOutput(23),
                adder.getOutput(24),adder.getOutput(25),adder.getOutput(26),adder.getOutput(27),adder.getOutput(28),adder.getOutput(29),adder.getOutput(30),adder.getOutput(31)
        );
//
//        D_memory.addInput(controlUnit.getOutput(4));
//        D_memory.addInput(controlUnit.getOutput(5));


//        for (int i = 0; i <32 ; i++) {
//
//            D_memory.addInput(alu.getOutput(i));
//        }
//        for (int i = 0; i <32 ; i++) {
//
//            D_memory.addInput(registerfile.getOutput(32+i));
//
//        }
        // I_memory.addInput(Simulator.trueLogic);
        I_memory.addInput(Simulator.falseLogic);
        I_memory.addInput(
            pc.getOutput(16),pc.getOutput(17),pc.getOutput(18),pc.getOutput(19),pc.getOutput(20),pc.getOutput(21),pc.getOutput(22),pc.getOutput(23),
            pc.getOutput(24),pc.getOutput(25),pc.getOutput(26),pc.getOutput(27),pc.getOutput(28),pc.getOutput(29),pc.getOutput(30),pc.getOutput(31));
        for (int i = 0; i <32 ; i++) {
            I_memory.addInput(Simulator.falseLogic);

        }
        nextPcValue.addInput(
                pc.getOutput(0),pc.getOutput(1),pc.getOutput(2),pc.getOutput(3),pc.getOutput(4),pc.getOutput(5),pc.getOutput(6),pc.getOutput(7),
                pc.getOutput(8),pc.getOutput(9),pc.getOutput(10),pc.getOutput(11),pc.getOutput(12),pc.getOutput(13),pc.getOutput(14),pc.getOutput(15),
                pc.getOutput(16),pc.getOutput(17),pc.getOutput(18),pc.getOutput(19),pc.getOutput(20),pc.getOutput(21),pc.getOutput(22),pc.getOutput(23),
                pc.getOutput(24),pc.getOutput(25),pc.getOutput(26),pc.getOutput(27),pc.getOutput(28),pc.getOutput(29),pc.getOutput(30),pc.getOutput(31),

                //instruction[26-0]
                I_memory.getOutput(6), I_memory.getOutput(7), I_memory.getOutput(8), I_memory.getOutput(9), I_memory.getOutput(10),I_memory.getOutput(11),I_memory.getOutput(12),I_memory.getOutput(13),
                I_memory.getOutput(14), I_memory.getOutput(15), I_memory.getOutput(16), I_memory.getOutput(17), I_memory.getOutput(18),I_memory.getOutput(19),I_memory.getOutput(20),I_memory.getOutput(21),
                I_memory.getOutput(22), I_memory.getOutput(23), I_memory.getOutput(24), I_memory.getOutput(25), I_memory.getOutput(26),I_memory.getOutput(27),I_memory.getOutput(28),I_memory.getOutput(29),
                I_memory.getOutput(30), I_memory.getOutput(31),

                alu.getOutput(32),controlUnit.getOutput(6),controlUnit.getOutput(9)//zero,branch,jump
        );

        //input : instruction[31-26]   //output :  output[4] MemRead &&& output[5]MemWrite(data memory)  ///baghie signala controli ro vasel kardim
        controlUnit.addInput(I_memory.getOutput(5), I_memory.getOutput(4),I_memory.getOutput(3),I_memory.getOutput(2),I_memory.getOutput(1),I_memory.getOutput(0));

        alucontrolunit.addInput(
                controlUnit.getOutput(7),controlUnit.getOutput(8),
                I_memory.getOutput(26),I_memory.getOutput(27),I_memory.getOutput(28),I_memory.getOutput(29),I_memory.getOutput(30),I_memory.getOutput(31)
        );

        //5 mux ghabl az register //select az regDST
        //input[0] instruction[20] //input[1] instruction[15]
        Mux2to1 muxbeforeregMSB4 = new Mux2to1("muxbeforeregMSB4","3X1",controlUnit.getOutput(0),I_memory.getOutput(11),I_memory.getOutput(16));
        //input[0] instruction[19] //input[1] instruction[14]
        Mux2to1 muxbeforeregMSB3 = new Mux2to1("muxbeforeregMSB3","3X1",controlUnit.getOutput(0),I_memory.getOutput(12),I_memory.getOutput(17));
        //input[0] instruction[18] //input[1] instruction[13]
        Mux2to1 muxbeforeregMSB2 = new Mux2to1("muxbeforeregMSB2","3X1",controlUnit.getOutput(0),I_memory.getOutput(13),I_memory.getOutput(18));
        //input[0] instruction[17] //input[1] instruction[12]
        Mux2to1 muxbeforeregMSB1 = new Mux2to1("muxbeforeregMSB1","3X1",controlUnit.getOutput(0),I_memory.getOutput(14),I_memory.getOutput(19));
        //input[0] instruction[16] //input[1] instruction[11]
        Mux2to1 muxbeforeregMSB0 = new Mux2to1("muxbeforeregMSB0","3X1",controlUnit.getOutput(0),I_memory.getOutput(25),I_memory.getOutput(20));

        //////Register file
        //input[0-5] ==== instruction[25-21]
        //input[6-10] ==== instruction[20-16]
        //input[11-15] ==== mux haie bala az MSB4 ta MSB0
        //input[16] === regWrite
        registerfile.addInput(
                I_memory.getOutput(6), I_memory.getOutput(7), I_memory.getOutput(8), I_memory.getOutput(9), I_memory.getOutput(10),
                I_memory.getOutput(11), I_memory.getOutput(12), I_memory.getOutput(13), I_memory.getOutput(14), I_memory.getOutput(15),
                muxbeforeregMSB4.getOutput(0),muxbeforeregMSB3.getOutput(0),muxbeforeregMSB2.getOutput(0),muxbeforeregMSB1.getOutput(0),muxbeforeregMSB0.getOutput(0),
                controlUnit.getOutput(3)
        );

        //input[17-31] === dataii k gharare dar reg neveshte beshe k az data mem miad ya az alu
        //0=>alu
        //1=data memory
        for(int i=0;i<32;i++){
            muxsafterdatamem.add(new Mux2to1("mux" + i, "3x1",
                            controlUnit.getOutput(2),//memtoreg signal(control signal)
                            alu.getOutput(i),Simulator.falseLogic//D_memory.getOutput(i) //az data mem baiad biad
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
        //second alu input(select beewen imediat and register)
        signExtend.addInput(
                I_memory.getOutput(16),I_memory.getOutput(17),I_memory.getOutput(18),I_memory.getOutput(19),I_memory.getOutput(20),I_memory.getOutput(21), I_memory.getOutput(22),I_memory.getOutput(23),
                I_memory.getOutput(24),I_memory.getOutput(25),I_memory.getOutput(26),I_memory.getOutput(27),I_memory.getOutput(28),I_memory.getOutput(29), I_memory.getOutput(30),I_memory.getOutput(31)
        );

        for(int i=0;i<32;i++){
            muxsbeforealu.add(new Mux2to1("mux" + i, "3x1",
                            controlUnit.getOutput(1),//RegDestination(control signal)
                            registerfile.getOutput(i+32),signExtend.getOutput(i)
                    )
            );
        }
        for(int i=0;i<32;i++) {
            alu.addInput(muxsbeforealu.get(i).getOutput(0));
        }

        //alu control signal
        alu.addInput(alucontrolunit.getOutput(3),alucontrolunit.getOutput(2),alucontrolunit.getOutput(1),alucontrolunit.getOutput(0));


        //add alu output to data memory address

        //data memory ro bezar inja vali khodesh ro bala tarif kon pish baghishon
        //
        //
        //
        //

        Simulator.debugger.addTrackItem(I_memory);
        Simulator.debugger.setDelay(1);
        Simulator.circuit.startCircuit();
    }


}
