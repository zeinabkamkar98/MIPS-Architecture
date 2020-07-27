package simulator.wrapper.wrappers;

import simulator.control.Simulator;
import simulator.gates.combinational.Not;
import simulator.gates.combinational.Or;
import simulator.network.Link;
import simulator.wrapper.Wrapper;

import java.util.ArrayList;
import java.util.List;

//a generic adder
public class ALU extends Wrapper {
    //input=>0=in1(h),...,31=in1(l),32=in2(h),...63=in(l)
    //64=control0,65=control1,66=control2,67=control3
    //output=>0=out(h),...,31=out(l),32=zero

    public ALU(String label, String stream, Link... links) {
        super(label, stream, links);
    }

    @Override
    public void initialize() {
        Adder adder=new Adder("aluAdder","64x32");
        Subtractor subtractor=new Subtractor("aluSubtractor","64x32");
        BIGAND and=new BIGAND("aluAnd","64x32");
        BIGOR or=new BIGOR("aluOr","64x32");
        List<Mux16to4> muxs = new ArrayList<>();
        Or notZero=new Or("notZero");
        Not zero=new Not("aluZero");

        adder.addInput(
                getInput(0),getInput(1),getInput(2),getInput(3),getInput(4),getInput(5),getInput(6),getInput(7),
                getInput(8),getInput(9),getInput(10),getInput(11),getInput(12),getInput(13),getInput(14),getInput(15),
                getInput(16),getInput(17),getInput(18),getInput(19),getInput(20),getInput(21),getInput(22),getInput(23),
                getInput(24),getInput(25),getInput(26),getInput(27),getInput(28),getInput(29),getInput(30),getInput(31),

                getInput(32),getInput(33),getInput(34),getInput(35),getInput(36),getInput(37),getInput(38),getInput(39),
                getInput(40),getInput(41),getInput(42),getInput(43),getInput(44),getInput(45),getInput(46),getInput(47),
                getInput(48),getInput(49),getInput(50),getInput(51),getInput(52),getInput(53),getInput(54),getInput(55),
                getInput(56),getInput(57),getInput(58),getInput(59),getInput(60),getInput(61),getInput(62),getInput(63)
        );
        subtractor.addInput(
                getInput(0),getInput(1),getInput(2),getInput(3),getInput(4),getInput(5),getInput(6),getInput(7),
                getInput(8),getInput(9),getInput(10),getInput(11),getInput(12),getInput(13),getInput(14),getInput(15),
                getInput(16),getInput(17),getInput(18),getInput(19),getInput(20),getInput(21),getInput(22),getInput(23),
                getInput(24),getInput(25),getInput(26),getInput(27),getInput(28),getInput(29),getInput(30),getInput(31),

                getInput(32),getInput(33),getInput(34),getInput(35),getInput(36),getInput(37),getInput(38),getInput(39),
                getInput(40),getInput(41),getInput(42),getInput(43),getInput(44),getInput(45),getInput(46),getInput(47),
                getInput(48),getInput(49),getInput(50),getInput(51),getInput(52),getInput(53),getInput(54),getInput(55),
                getInput(56),getInput(57),getInput(58),getInput(59),getInput(60),getInput(61),getInput(62),getInput(63)
        );
        and.addInput(
                getInput(0),getInput(1),getInput(2),getInput(3),getInput(4),getInput(5),getInput(6),getInput(7),
                getInput(8),getInput(9),getInput(10),getInput(11),getInput(12),getInput(13),getInput(14),getInput(15),
                getInput(16),getInput(17),getInput(18),getInput(19),getInput(20),getInput(21),getInput(22),getInput(23),
                getInput(24),getInput(25),getInput(26),getInput(27),getInput(28),getInput(29),getInput(30),getInput(31),

                getInput(32),getInput(33),getInput(34),getInput(35),getInput(36),getInput(37),getInput(38),getInput(39),
                getInput(40),getInput(41),getInput(42),getInput(43),getInput(44),getInput(45),getInput(46),getInput(47),
                getInput(48),getInput(49),getInput(50),getInput(51),getInput(52),getInput(53),getInput(54),getInput(55),
                getInput(56),getInput(57),getInput(58),getInput(59),getInput(60),getInput(61),getInput(62),getInput(63)
        );
        or.addInput(
                getInput(0),getInput(1),getInput(2),getInput(3),getInput(4),getInput(5),getInput(6),getInput(7),
                getInput(8),getInput(9),getInput(10),getInput(11),getInput(12),getInput(13),getInput(14),getInput(15),
                getInput(16),getInput(17),getInput(18),getInput(19),getInput(20),getInput(21),getInput(22),getInput(23),
                getInput(24),getInput(25),getInput(26),getInput(27),getInput(28),getInput(29),getInput(30),getInput(31),

                getInput(32),getInput(33),getInput(34),getInput(35),getInput(36),getInput(37),getInput(38),getInput(39),
                getInput(40),getInput(41),getInput(42),getInput(43),getInput(44),getInput(45),getInput(46),getInput(47),
                getInput(48),getInput(49),getInput(50),getInput(51),getInput(52),getInput(53),getInput(54),getInput(55),
                getInput(56),getInput(57),getInput(58),getInput(59),getInput(60),getInput(61),getInput(62),getInput(63)
        );

        for(int i=0;i<31;i++){
            muxs.add(new Mux16to4("mux" + i, "20x1",
                    getInput(64), getInput(65), getInput(66), getInput(67),
                    and.getOutput(i), or.getOutput(i), adder.getOutput(i), Simulator.falseLogic, Simulator.falseLogic,
                    Simulator.falseLogic, subtractor.getOutput(i), Simulator.falseLogic, Simulator.falseLogic,
                    Simulator.falseLogic, Simulator.falseLogic, Simulator.falseLogic, Simulator.falseLogic,
                    Simulator.falseLogic, Simulator.falseLogic, Simulator.falseLogic, Simulator.falseLogic
                    )
            );
        }

        muxs.add(new Mux16to4("mux" + 31, "20x1",
                        getInput(64), getInput(65), getInput(66), getInput(67),
                        and.getOutput(31), or.getOutput(31), adder.getOutput(31), Simulator.falseLogic, Simulator.falseLogic,
                        Simulator.falseLogic, subtractor.getOutput(31), subtractor.getOutput(0), Simulator.falseLogic,
                        Simulator.falseLogic, Simulator.falseLogic, Simulator.falseLogic, Simulator.falseLogic,
                        Simulator.falseLogic, Simulator.falseLogic, Simulator.falseLogic, Simulator.falseLogic
                )
        );

        for(int i=0;i<32;i++) {
            addOutput(muxs.get(i).getOutput(0));
            notZero.addInput(getOutput(i));
        }
        zero.addInput(notZero.getOutput(0));
        addOutput(zero.getOutput(0));

    }
}