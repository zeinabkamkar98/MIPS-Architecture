package simulator.wrapper.wrappers;

import simulator.control.Simulator;
import simulator.gates.combinational.And;
import simulator.network.Link;
import simulator.wrapper.Wrapper;

import java.util.ArrayList;
import java.util.List;

//a generic adder
public class NextPcValue extends Wrapper {
    public NextPcValue(String label, String stream, Link... links) {
        super(label, stream, links);
    }
    //input=>0=pc(h),...,31=pc(l)
    //32=instruction(h),...,57=instruction(l)
    //58=zero
    //59=branch
    //60=jump
    //output=>0=pc(l),1=pc(h)

    @Override
    public void initialize() {


        //cal pc+4
        Adder pc4= new Adder("pc+4","64x32");
        pc4.addInput(
                getInput(0),getInput(1),getInput(2),getInput(3),getInput(4),getInput(5),getInput(6),getInput(7),
                getInput(8),getInput(9),getInput(10),getInput(11),getInput(12),getInput(13),getInput(14),getInput(15),
                getInput(16),getInput(17),getInput(18),getInput(19),getInput(20),getInput(21),getInput(22),getInput(23),
                getInput(24),getInput(25),getInput(26),getInput(27),getInput(28),getInput(29),getInput(30),getInput(31),

                Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,
                Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,
                Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,
                Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.trueLogic,Simulator.falseLogic,Simulator.falseLogic

        );


        //cal branch address
        SignExtend conAdderss=new SignExtend("signExtend","16x32");
        conAdderss.addInput(
                getInput(42),getInput(43),getInput(44),getInput(45),getInput(46),getInput(47),getInput(48),getInput(49),
                getInput(50),getInput(51),getInput(52),getInput(53),getInput(54),getInput(55),getInput(56),getInput(57)
                );

        ShiftLeft32to32 shift32=new ShiftLeft32to32("shift32","32x32");
        shift32.addInput(
                conAdderss.getOutput(0),conAdderss.getOutput(1),conAdderss.getOutput(2),conAdderss.getOutput(3),conAdderss.getOutput(4),conAdderss.getOutput(5),conAdderss.getOutput(6),conAdderss.getOutput(7),
                conAdderss.getOutput(8),conAdderss.getOutput(9),conAdderss.getOutput(10),conAdderss.getOutput(11),conAdderss.getOutput(12),conAdderss.getOutput(13),conAdderss.getOutput(14),conAdderss.getOutput(15),
                conAdderss.getOutput(16),conAdderss.getOutput(17),conAdderss.getOutput(18),conAdderss.getOutput(19),conAdderss.getOutput(20),conAdderss.getOutput(21),conAdderss.getOutput(22),conAdderss.getOutput(23),
                conAdderss.getOutput(24),conAdderss.getOutput(25),conAdderss.getOutput(26),conAdderss.getOutput(27),conAdderss.getOutput(28),conAdderss.getOutput(29),conAdderss.getOutput(30),conAdderss.getOutput(31)
        );

        Adder branchAdd=new Adder("branchAdd","64x32");
        branchAdd.addInput(
                shift32.getOutput(0),shift32.getOutput(1),shift32.getOutput(2),shift32.getOutput(3),shift32.getOutput(4),shift32.getOutput(5),shift32.getOutput(6),shift32.getOutput(7),
                shift32.getOutput(8),shift32.getOutput(9),shift32.getOutput(10),shift32.getOutput(11),shift32.getOutput(12),shift32.getOutput(13),shift32.getOutput(14),shift32.getOutput(15),
                shift32.getOutput(16),shift32.getOutput(17),shift32.getOutput(18),shift32.getOutput(19),shift32.getOutput(20),shift32.getOutput(21),shift32.getOutput(22),shift32.getOutput(23),
                shift32.getOutput(24),shift32.getOutput(25),shift32.getOutput(26),shift32.getOutput(27),shift32.getOutput(28),shift32.getOutput(29),shift32.getOutput(30),shift32.getOutput(31),

                pc4.getOutput(0),pc4.getOutput(1),pc4.getOutput(2),pc4.getOutput(3),pc4.getOutput(4),pc4.getOutput(5),pc4.getOutput(6),pc4.getOutput(7),
                pc4.getOutput(8),pc4.getOutput(9),pc4.getOutput(10),pc4.getOutput(11),pc4.getOutput(12),pc4.getOutput(13),pc4.getOutput(14),pc4.getOutput(15),
                pc4.getOutput(16),pc4.getOutput(17),pc4.getOutput(18),pc4.getOutput(19),pc4.getOutput(20),pc4.getOutput(21),pc4.getOutput(22),pc4.getOutput(23),
                pc4.getOutput(24),pc4.getOutput(25),pc4.getOutput(26),pc4.getOutput(27),pc4.getOutput(28),pc4.getOutput(29),pc4.getOutput(30),pc4.getOutput(31)
        );

        //cal jumpAddress
        ShiftLeft26to28 shift28=new ShiftLeft26to28("shift28","26x28");
        shift28.addInput(
                getInput(32),getInput(33),getInput(34),getInput(35),getInput(36),getInput(37),getInput(38),getInput(39),
                getInput(40),getInput(41),getInput(42),getInput(43),getInput(44),getInput(45),getInput(46),getInput(47),
                getInput(48),getInput(49),getInput(50),getInput(51),getInput(52),getInput(53),getInput(54),getInput(55),
                getInput(56),getInput(57)
        );

        Concat jumpAdd=new Concat("jumpAdd","32x32");
        jumpAdd.addInput(
                pc4.getInput(0),pc4.getInput(1),pc4.getInput(2),pc4.getInput(3),
                shift28.getOutput(0),shift28.getOutput(1),shift28.getOutput(2),shift28.getOutput(3),shift28.getOutput(4),shift28.getOutput(5),shift28.getOutput(6),shift28.getOutput(7),
                shift28.getOutput(8),shift28.getOutput(9),shift28.getOutput(10),shift28.getOutput(11),shift28.getOutput(12),shift28.getOutput(13),shift28.getOutput(14),shift28.getOutput(15),
                shift28.getOutput(16),shift28.getOutput(17),shift28.getOutput(18),shift28.getOutput(19),shift28.getOutput(20),shift28.getOutput(21),shift28.getOutput(22),shift28.getOutput(23),
                shift28.getOutput(24),shift28.getOutput(25),shift28.getOutput(26),shift28.getOutput(27)
        );

        //cal branch control signal
        And BranchCon= new And("branchCon",getInput(58),getInput(59));

        List<Mux4to2> muxs = new ArrayList<>();

        for(int i=0;i<32;i++){
            muxs.add(new Mux4to2("mux" + i, "6x1",
                    BranchCon.getOutput(0),getInput(60),
                    pc4.getOutput(i),branchAdd.getOutput(i),jumpAdd.getOutput(i),Simulator.falseLogic)
            );
        }
        for(int i=0;i<32;i++) {
            addOutput(muxs.get(i).getOutput(0));
        }

    }
}