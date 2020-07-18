package simulator.wrapper.wrappers;

import simulator.control.Simulator;
import simulator.gates.combinational.Or;
import simulator.network.Link;
import simulator.wrapper.Wrapper;

import java.util.ArrayList;
import java.util.List;

//a generic adder
public class ALU extends Wrapper {
    //input=>0=in1(h),...,31=in1(l),32=in2(h),...63=in(l),64=control0,65=control1,66=control2,67=control3
    //output=>0=out(l),...,31=out(h),32=zero

    public ALU(String label, String stream, Link... links) {
        super(label, stream, links);
    }

    @Override
    public void initialize() {
        Adder adder=new Adder("aluAdder","64x32");
        Subtractor subtractor=new Subtractor("aluSubtractor","64x32");
        BIGAND and=new BIGAND("aluAnd","64x32");
        BIGOR or=new BIGOR("aluOr","64x32");
        Mux16to4 mux=new Mux16to4("aluMux16x4","20x1");
        Or zero=new Or("AluZero");

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


    }
}