//Dedicated to Goli

package simulator;
import simulator.control.Simulator;
import simulator.gates.combinational.And;
import simulator.gates.combinational.Memory;
import simulator.gates.sequential.BigClock;
import simulator.gates.sequential.Clock;
import simulator.network.Link;
import simulator.wrapper.ALUControlUnit;
import simulator.wrapper.Cache;
import simulator.wrapper.wrappers.*;
import java.util.ArrayList;
import java.util.List;


public class Sample {

    public static Clock clock = new Clock("clock",1000);

    public static Memory memory=new Memory("Memory",Simulator.falseLogic,
            Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,
            Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,
            Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,
            Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,

            Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,
            Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,
            Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,
            Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,
            Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,
            Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,
            Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,
            Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic);

    public static void main(String[] args) {
//
//        PC pc=new PC("pc","32x32");
//
//        NextPcValueBit nextPcValue=new NextPcValueBit("newPc","61x32");
//
//        Memory I_memory= new Memory("I_MEMORY");
//        Memory D_memory= new Memory("D_MEMORY");
//
//        ControlUnit controlunit = new ControlUnit("controlunit","6X10");
//
//        ALUControlUnit alucontrolunit = new ALUControlUnit("alucontrolunit", "8X4");
//
//        ALU alu=new ALU("alu","68x33");
//
//        RegisterFile registerfile = new RegisterFile("registerfile","48X64");
//
//        SignExtend signExtend=new SignExtend("signExtend","16x32");
//
//        List<Mux2to1> muxsbeforereg = new ArrayList<>();
//        List<Mux2to1> muxsbeforealu = new ArrayList<>();
//        List<Mux2to1> muxsbeforewrite = new ArrayList<>();
//
//
//
//        pc.addInput(
//                nextPcValue.getOutput(0),nextPcValue.getOutput(1),nextPcValue.getOutput(2),nextPcValue.getOutput(3),
//                nextPcValue.getOutput(4),nextPcValue.getOutput(5),nextPcValue.getOutput(6),nextPcValue.getOutput(7),
//                nextPcValue.getOutput(8),nextPcValue.getOutput(9),nextPcValue.getOutput(10),nextPcValue.getOutput(11),
//                nextPcValue.getOutput(12),nextPcValue.getOutput(13),nextPcValue.getOutput(14),nextPcValue.getOutput(15),
//
//                nextPcValue.getOutput(16),nextPcValue.getOutput(17),nextPcValue.getOutput(18),nextPcValue.getOutput(19),
//                nextPcValue.getOutput(20),nextPcValue.getOutput(21),nextPcValue.getOutput(22),nextPcValue.getOutput(23),
//                nextPcValue.getOutput(24),nextPcValue.getOutput(25),nextPcValue.getOutput(26),nextPcValue.getOutput(27),
//                nextPcValue.getOutput(28),nextPcValue.getOutput(29),nextPcValue.getOutput(30),nextPcValue.getOutput(31)
//        );
//
//        nextPcValue.addInput(
//                pc.getOutput(0),pc.getOutput(1),pc.getOutput(2),pc.getOutput(3),
//                pc.getOutput(4),pc.getOutput(5),pc.getOutput(6),pc.getOutput(7),
//                pc.getOutput(8),pc.getOutput(9),pc.getOutput(10),pc.getOutput(11),
//                pc.getOutput(12),pc.getOutput(13),pc.getOutput(14),pc.getOutput(15),
//                pc.getOutput(16),pc.getOutput(17),pc.getOutput(18),pc.getOutput(19),
//                pc.getOutput(20),pc.getOutput(21),pc.getOutput(22),pc.getOutput(23),
//                pc.getOutput(24),pc.getOutput(25),pc.getOutput(26),pc.getOutput(27),
//                pc.getOutput(28),pc.getOutput(29),pc.getOutput(30),pc.getOutput(31),
//
////                Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,
////                Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,
////                Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,
////                Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,
////                Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,
////                Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,
////                Simulator.falseLogic,Simulator.falseLogic,
////
//                I_memory.getOutput(6),I_memory.getOutput(7),I_memory.getOutput(8),I_memory.getOutput(9),
//                I_memory.getOutput(10),I_memory.getOutput(11),I_memory.getOutput(12),I_memory.getOutput(13),
//                I_memory.getOutput(14),I_memory.getOutput(15),I_memory.getOutput(16),I_memory.getOutput(17),
//                I_memory.getOutput(18),I_memory.getOutput(19),I_memory.getOutput(20),I_memory.getOutput(21),
//
//                I_memory.getOutput(22),I_memory.getOutput(23),I_memory.getOutput(24),I_memory.getOutput(25),
//                I_memory.getOutput(26),I_memory.getOutput(27),I_memory.getOutput(28),I_memory.getOutput(29),
//                I_memory.getOutput(30),I_memory.getOutput(31),
//
//
//                 alu.getOutput(32),controlunit.getOutput(6),controlunit.getOutput(9)
////                Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic
//        );
//
//        I_memory.addInput(
//                Simulator.falseLogic,
//
//                pc.getOutput(16),pc.getOutput(17),pc.getOutput(18),pc.getOutput(19),
//                pc.getOutput(20),pc.getOutput(21),pc.getOutput(22),pc.getOutput(23),
//                pc.getOutput(24),pc.getOutput(25),pc.getOutput(26),pc.getOutput(27),
//                pc.getOutput(28),pc.getOutput(29),pc.getOutput(30),pc.getOutput(31),
//
//                Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,
//                Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,
//                Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,
//                Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,
//
//                Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,
//                Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,
//                Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,
//                Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic
//
//        );
//
//
//        controlunit.addInput(I_memory.getOutput(5),I_memory.getOutput(4),I_memory.getOutput(3)
//                            ,I_memory.getOutput(2),I_memory.getOutput(1),I_memory.getOutput(0));
//
//
//        alucontrolunit.addInput(controlunit.getOutput(7),controlunit.getOutput(8),
//                I_memory.getOutput(26),I_memory.getOutput(27),I_memory.getOutput(28)
//                ,I_memory.getOutput(29),I_memory.getOutput(30),I_memory.getOutput(31));
//
//        signExtend.addInput(
//                I_memory.getOutput(16),I_memory.getOutput(17),I_memory.getOutput(18),I_memory.getOutput(19),
//                I_memory.getOutput(20),I_memory.getOutput(21), I_memory.getOutput(22),I_memory.getOutput(23),
//                I_memory.getOutput(24),I_memory.getOutput(25),I_memory.getOutput(26),I_memory.getOutput(27),
//                I_memory.getOutput(28),I_memory.getOutput(29), I_memory.getOutput(30),I_memory.getOutput(31)
//        );
//
//        for(int i=0;i<5;i++){
//            muxsbeforereg.add(new Mux2to1("mux" + i, "3x1",
//                            controlunit.getOutput(0),
//                            I_memory.getOutput(11+i),I_memory.getOutput(16+i)
//                    )
//            );
//        }
//
//        registerfile.addInput(
//                I_memory.getOutput(6),I_memory.getOutput(7),I_memory.getOutput(8),I_memory.getOutput(9),
//                I_memory.getOutput(10),I_memory.getOutput(11),I_memory.getOutput(12),I_memory.getOutput(13),
//                I_memory.getOutput(14),I_memory.getOutput(15),
//                muxsbeforereg.get(0).getOutput(0),muxsbeforereg.get(1).getOutput(0),muxsbeforereg.get(2).getOutput(0),
//                muxsbeforereg.get(3).getOutput(0),muxsbeforereg.get(4).getOutput(0),
//                controlunit.getOutput(3)
//        );
//
//        //register write 32bit
//        for(int i=0;i<32;i++){
//            muxsbeforewrite.add(new Mux2to1("mux" + i, "3x1",
//                            controlunit.getOutput(2),
//                            alu.getOutput(i),D_memory.getOutput(i)
//                    )
//            );
//        }
//
//        for (int i=0;i<32;i++){
//            registerfile.addInput(muxsbeforewrite.get(i).getOutput(0));
//        }
//
//
//        //alu input 1
//        alu.addInput(
//                registerfile.getOutput(0),registerfile.getOutput(1),registerfile.getOutput(2),registerfile.getOutput(3),
//                registerfile.getOutput(4),registerfile.getOutput(5),registerfile.getOutput(6),registerfile.getOutput(7),
//                registerfile.getOutput(8),registerfile.getOutput(9),registerfile.getOutput(10),registerfile.getOutput(11),
//                registerfile.getOutput(12),registerfile.getOutput(13),registerfile.getOutput(14),registerfile.getOutput(15),
//                registerfile.getOutput(16),registerfile.getOutput(17),registerfile.getOutput(18),registerfile.getOutput(19),
//                registerfile.getOutput(20),registerfile.getOutput(21),registerfile.getOutput(22),registerfile.getOutput(23),
//                registerfile.getOutput(24),registerfile.getOutput(25),registerfile.getOutput(26),registerfile.getOutput(27),
//                registerfile.getOutput(28),registerfile.getOutput(29),registerfile.getOutput(30),registerfile.getOutput(31)
//        );
//
//        //alu input2
//        for(int i=0;i<32;i++){
//            muxsbeforealu.add(new Mux2to1("mux" + i, "3x1",
//                            controlunit.getOutput(1),
//                            registerfile.getOutput(i+32),signExtend.getOutput(i)
//                    )
//            );
//        }
//
//        for (int i=0;i<32;i++){
//            alu.addInput(muxsbeforealu.get(i).getOutput(0));
//        }
//
//        //alu control unit
//        alu.addInput(alucontrolunit.getOutput(3),alucontrolunit.getOutput(2),alucontrolunit.getOutput(1),alucontrolunit.getOutput(0));
//
//
//
//        D_memory.addInput(
//                controlunit.getOutput(5),
//
//                alu.getOutput(16),alu.getOutput(17),alu.getOutput(18),alu.getOutput(19),
//                alu.getOutput(20),alu.getOutput(21),alu.getOutput(22),alu.getOutput(23),
//                alu.getOutput(24),alu.getOutput(25),alu.getOutput(26),alu.getOutput(27),
//                alu.getOutput(28),alu.getOutput(29),alu.getOutput(30),alu.getOutput(31),
//
//                registerfile.getOutput(32),registerfile.getOutput(33),registerfile.getOutput(34),registerfile.getOutput(35),
//                registerfile.getOutput(36),registerfile.getOutput(37),registerfile.getOutput(38),registerfile.getOutput(39),
//                registerfile.getOutput(40),registerfile.getOutput(41),registerfile.getOutput(42),registerfile.getOutput(43),
//                registerfile.getOutput(44),registerfile.getOutput(45),registerfile.getOutput(46),registerfile.getOutput(47),
//                registerfile.getOutput(48),registerfile.getOutput(49),registerfile.getOutput(50),registerfile.getOutput(51),
//                registerfile.getOutput(52),registerfile.getOutput(53),registerfile.getOutput(54),registerfile.getOutput(55),
//                registerfile.getOutput(56),registerfile.getOutput(57),registerfile.getOutput(58),registerfile.getOutput(59),
//                registerfile.getOutput(60),registerfile.getOutput(61),registerfile.getOutput(62),registerfile.getOutput(63)
//
//        );
//

        //





//        PC pc=new PC("pc","32x32");
//
//        NextPcValueBit nextPcValue=new NextPcValueBit("newPc","61x32");
//
////        Memory I_memory= new Memory("I_MEMORY");
////        Memory D_memory= new Memory("D_MEMORY");
//
//        ControlUnit controlunit = new ControlUnit("controlunit","6X10");
//
//        ALUControlUnit alucontrolunit = new ALUControlUnit("alucontrolunit", "8X4");
//
//        ALU alu=new ALU("alu","68x33");
//
//        RegisterFile registerfile = new RegisterFile("registerfile","48X64");
//
//        SignExtend signExtend=new SignExtend("signExtend","16x32");
//
//        Cache I_cache=new Cache("Cache","66x32",
//                Simulator.trueLogic,Simulator.falseLogic
////                Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic//                Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,
//        );
//        Cache D_cache=new Cache("Cache","66x32",
//                controlunit.getOutput(4),controlunit.getOutput(5)
////                Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic//                Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,
//        );
//        List<Mux2to1> muxsbeforereg = new ArrayList<>();
//        List<Mux2to1> muxsbeforealu = new ArrayList<>();
//        List<Mux2to1> muxsbeforewrite = new ArrayList<>();
//
//
//
//        pc.addInput(
//                nextPcValue.getOutput(0),nextPcValue.getOutput(1),nextPcValue.getOutput(2),nextPcValue.getOutput(3),
//                nextPcValue.getOutput(4),nextPcValue.getOutput(5),nextPcValue.getOutput(6),nextPcValue.getOutput(7),
//                nextPcValue.getOutput(8),nextPcValue.getOutput(9),nextPcValue.getOutput(10),nextPcValue.getOutput(11),
//                nextPcValue.getOutput(12),nextPcValue.getOutput(13),nextPcValue.getOutput(14),nextPcValue.getOutput(15),
//
//                nextPcValue.getOutput(16),nextPcValue.getOutput(17),nextPcValue.getOutput(18),nextPcValue.getOutput(19),
//                nextPcValue.getOutput(20),nextPcValue.getOutput(21),nextPcValue.getOutput(22),nextPcValue.getOutput(23),
//                nextPcValue.getOutput(24),nextPcValue.getOutput(25),nextPcValue.getOutput(26),nextPcValue.getOutput(27),
//                nextPcValue.getOutput(28),nextPcValue.getOutput(29),nextPcValue.getOutput(30),nextPcValue.getOutput(31)
//        );
//
//        nextPcValue.addInput(
//                pc.getOutput(0),pc.getOutput(1),pc.getOutput(2),pc.getOutput(3),
//                pc.getOutput(4),pc.getOutput(5),pc.getOutput(6),pc.getOutput(7),
//                pc.getOutput(8),pc.getOutput(9),pc.getOutput(10),pc.getOutput(11),
//                pc.getOutput(12),pc.getOutput(13),pc.getOutput(14),pc.getOutput(15),
//                pc.getOutput(16),pc.getOutput(17),pc.getOutput(18),pc.getOutput(19),
//                pc.getOutput(20),pc.getOutput(21),pc.getOutput(22),pc.getOutput(23),
//                pc.getOutput(24),pc.getOutput(25),pc.getOutput(26),pc.getOutput(27),
//                pc.getOutput(28),pc.getOutput(29),pc.getOutput(30),pc.getOutput(31),
//
////                Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,
////                Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,
////                Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,
////                Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,
////                Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,
////                Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,
////                Simulator.falseLogic,Simulator.falseLogic,
////
//                I_cache.getOutput(6),I_cache.getOutput(7),I_cache.getOutput(8),I_cache.getOutput(9),
//                I_cache.getOutput(10),I_cache.getOutput(11),I_cache.getOutput(12),I_cache.getOutput(13),
//                I_cache.getOutput(14),I_cache.getOutput(15),I_cache.getOutput(16),I_cache.getOutput(17),
//                I_cache.getOutput(18),I_cache.getOutput(19),I_cache.getOutput(20),I_cache.getOutput(21),
//
//                I_cache.getOutput(22),I_cache.getOutput(23),I_cache.getOutput(24),I_cache.getOutput(25),
//                I_cache.getOutput(26),I_cache.getOutput(27),I_cache.getOutput(28),I_cache.getOutput(29),
//                I_cache.getOutput(30),I_cache.getOutput(31),
//
//
//                 alu.getOutput(32),controlunit.getOutput(6),controlunit.getOutput(9)
////                Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic
//        );
//
//        I_cache.addInput(
//                Simulator.trueLogic,Simulator.falseLogic,
//
//                pc.getOutput(0),pc.getOutput(1),pc.getOutput(2),pc.getOutput(3),
//                pc.getOutput(4),pc.getOutput(5),pc.getOutput(6),pc.getOutput(7),
//                pc.getOutput(8),pc.getOutput(9),pc.getOutput(10),pc.getOutput(11),
//                pc.getOutput(12),pc.getOutput(13),pc.getOutput(14),pc.getOutput(15),
//                pc.getOutput(16),pc.getOutput(17),pc.getOutput(18),pc.getOutput(19),
//                pc.getOutput(20),pc.getOutput(21),pc.getOutput(22),pc.getOutput(23),
//                pc.getOutput(24),pc.getOutput(25),pc.getOutput(26),pc.getOutput(27),
//                pc.getOutput(28),pc.getOutput(29),pc.getOutput(30),pc.getOutput(31),
//
//                Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,
//                Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,
//                Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,
//                Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,
//
//                Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,
//                Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,
//                Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,
//                Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic
//
//        );
//
//
//        controlunit.addInput(I_cache.getOutput(5),I_cache.getOutput(4),I_cache.getOutput(3)
//                            ,I_cache.getOutput(2),I_cache.getOutput(1),I_cache.getOutput(0));
//
//
//        alucontrolunit.addInput(controlunit.getOutput(7),controlunit.getOutput(8),
//                I_cache.getOutput(26),I_cache.getOutput(27),I_cache.getOutput(28)
//                ,I_cache.getOutput(29),I_cache.getOutput(30),I_cache.getOutput(31));
//
//        signExtend.addInput(
//                I_cache.getOutput(16),I_cache.getOutput(17),I_cache.getOutput(18),I_cache.getOutput(19),
//                I_cache.getOutput(20),I_cache.getOutput(21), I_cache.getOutput(22),I_cache.getOutput(23),
//                I_cache.getOutput(24),I_cache.getOutput(25),I_cache.getOutput(26),I_cache.getOutput(27),
//                I_cache.getOutput(28),I_cache.getOutput(29), I_cache.getOutput(30),I_cache.getOutput(31)
//        );
//
//        for(int i=0;i<5;i++){
//            muxsbeforereg.add(new Mux2to1("mux" + i, "3x1",
//                            controlunit.getOutput(0),
//                            I_cache.getOutput(11+i),I_cache.getOutput(16+i)
//                    )
//            );
//        }
//
//        registerfile.addInput(
//                I_cache.getOutput(6),I_cache.getOutput(7),I_cache.getOutput(8),I_cache.getOutput(9),
//                I_cache.getOutput(10),I_cache.getOutput(11),I_cache.getOutput(12),I_cache.getOutput(13),
//                I_cache.getOutput(14),I_cache.getOutput(15),
//                muxsbeforereg.get(0).getOutput(0),muxsbeforereg.get(1).getOutput(0),muxsbeforereg.get(2).getOutput(0),
//                muxsbeforereg.get(3).getOutput(0),muxsbeforereg.get(4).getOutput(0),
//                controlunit.getOutput(3)
//        );
//
//        //register write 32bit
//        for(int i=0;i<32;i++){
//            muxsbeforewrite.add(new Mux2to1("mux" + i, "3x1",
//                            controlunit.getOutput(2),
//                            alu.getOutput(i),D_cache.getOutput(i)
//                    )
//            );
//        }
//
//        for (int i=0;i<32;i++){
//            registerfile.addInput(muxsbeforewrite.get(i).getOutput(0));
//        }
//
//
//        //alu input 1
//        alu.addInput(
//                registerfile.getOutput(0),registerfile.getOutput(1),registerfile.getOutput(2),registerfile.getOutput(3),
//                registerfile.getOutput(4),registerfile.getOutput(5),registerfile.getOutput(6),registerfile.getOutput(7),
//                registerfile.getOutput(8),registerfile.getOutput(9),registerfile.getOutput(10),registerfile.getOutput(11),
//                registerfile.getOutput(12),registerfile.getOutput(13),registerfile.getOutput(14),registerfile.getOutput(15),
//                registerfile.getOutput(16),registerfile.getOutput(17),registerfile.getOutput(18),registerfile.getOutput(19),
//                registerfile.getOutput(20),registerfile.getOutput(21),registerfile.getOutput(22),registerfile.getOutput(23),
//                registerfile.getOutput(24),registerfile.getOutput(25),registerfile.getOutput(26),registerfile.getOutput(27),
//                registerfile.getOutput(28),registerfile.getOutput(29),registerfile.getOutput(30),registerfile.getOutput(31)
//        );
//
//        //alu input2
//        for(int i=0;i<32;i++){
//            muxsbeforealu.add(new Mux2to1("mux" + i, "3x1",
//                            controlunit.getOutput(1),
//                            registerfile.getOutput(i+32),signExtend.getOutput(i)
//                    )
//            );
//        }
//
//        for (int i=0;i<32;i++){
//            alu.addInput(muxsbeforealu.get(i).getOutput(0));
//        }
//
//        //alu control unit
//        alu.addInput(alucontrolunit.getOutput(3),alucontrolunit.getOutput(2),alucontrolunit.getOutput(1),alucontrolunit.getOutput(0));
//
//
//
//        D_cache.addInput(
//                controlunit.getOutput(4),
//                controlunit.getOutput(5),
//
//                alu.getOutput(0),alu.getOutput(1),alu.getOutput(2),alu.getOutput(3),
////                alu.getOutput(4),alu.getOutput(5),alu.getOutput(6),alu.getOutput(7),
////                alu.getOutput(8),alu.getOutput(9),alu.getOutput(10),alu.getOutput(11),
////                alu.getOutput(12),alu.getOutput(13),alu.getOutput(14),alu.getOutput(15),
//                  alu.getOutput(16),alu.getOutput(17),alu.getOutput(18),alu.getOutput(19),
////                alu.getOutput(20),alu.getOutput(21),alu.getOutput(22),alu.getOutput(23),
////                alu.getOutput(24),alu.getOutput(25),alu.getOutput(26),alu.getOutput(27),
////                alu.getOutput(28),alu.getOutput(29),alu.getOutput(30),alu.getOutput(31),
//
//                registerfile.getOutput(32),registerfile.getOutput(33),registerfile.getOutput(34),registerfile.getOutput(35),
//                registerfile.getOutput(36),registerfile.getOutput(37),registerfile.getOutput(38),registerfile.getOutput(39),
//                registerfile.getOutput(40),registerfile.getOutput(41),registerfile.getOutput(42),registerfile.getOutput(43),
//                registerfile.getOutput(44),registerfile.getOutput(45),registerfile.getOutput(46),registerfile.getOutput(47),
//                registerfile.getOutput(48),registerfile.getOutput(49),registerfile.getOutput(50),registerfile.getOutput(51),
//                registerfile.getOutput(52),registerfile.getOutput(53),registerfile.getOutput(54),registerfile.getOutput(55),
//                registerfile.getOutput(56),registerfile.getOutput(57),registerfile.getOutput(58),registerfile.getOutput(59),
//                registerfile.getOutput(60),registerfile.getOutput(61),registerfile.getOutput(62),registerfile.getOutput(63)
//
//        );
//


//
        Cache cache=new Cache("Cache","66x32",
                Simulator.trueLogic,Simulator.falseLogic,
                Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,
                Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,
                Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,
                Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,
                Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,
                Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,
                Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,
                Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,

                Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,
                Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,
                Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,
                Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,
                Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,
                Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,
                Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,
                Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic
                );
//        DFlipFlop2 dFlipFlop2=new DFlipFlop2("d","2x2",Simulator.falseLogic,Simulator.trueLogic);

        Simulator.debugger.addTrackItem(cache);

        Simulator.debugger.setDelay(500);
        Simulator.circuit.startCircuit();
    }


}
