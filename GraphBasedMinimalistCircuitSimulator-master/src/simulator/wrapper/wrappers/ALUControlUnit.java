package simulator.wrapper.wrappers;

import simulator.control.Simulator;
import simulator.gates.combinational.And;
import simulator.gates.combinational.Not;
import simulator.gates.combinational.Or;
import simulator.network.Link;
import simulator.wrapper.Wrapper;

/**
 * Input[0]:Aluop1
 * Input[1]:Aluop2
 * Input[2]:F5
 * Input[3]:F4
 * Input[4]:F3
 * Input[5]:F2
 * Input[6:F1
 * Input[7]:F0
 */
public class ALUControlUnit extends Wrapper {
    public ALUControlUnit(String label, String stream, Link... links) {
        super(label, stream, links);
    }

    @Override
    public void initialize() {
        Not not_a=new Not("NOTA",getInput(0));
        Not not_b=new Not("NOTA",getInput(1));
        Not not_e=new Not("NOTA",getInput(4));
        Not not_f=new Not("NOTA",getInput(5));
        Not not_g=new Not("NOTA",getInput(6));
        Not not_h=new Not("NOTA",getInput(7));
        not_a.evaluate();
        not_b.evaluate();
        not_e.evaluate();
        not_f.evaluate();
        not_g.evaluate();
        not_h.evaluate();

        And a1=new And("a1",getInput(0),not_e.getOutput(0),getInput(5),not_g.getOutput(0),getInput(7));
        And a2=new And("a2",getInput(0),getInput(4),not_f.getOutput(0),getInput(6),not_h.getOutput(0));
        Or o1=new Or("O1",a1.getOutput(0),a2.getOutput(0));

        a1.evaluate();
        a2.evaluate();
        o1.evaluate();

        And a3=new And("a3",not_e.getOutput(0),not_f.getOutput(0),not_h.getOutput(0));
        And a4=new And("a4",not_f.getOutput(0),getInput(6),not_h.getOutput(0));
        Or or2=new Or("O2",a3.getOutput(0),a4.getOutput(0),not_a.getOutput(0),getInput(1));

        a3.evaluate();
        a4.evaluate();
        or2.evaluate();
        And a5=new And("a5",getInput(0),a4.getOutput(0));
        Or or3=new Or("O3",getInput(1),a5.getOutput(0));
        a5.evaluate();
        or3.evaluate();
        addOutput(Simulator.falseLogic,or3.getOutput(0),or2.getOutput(0),o1.getOutput(0));

    }


}
