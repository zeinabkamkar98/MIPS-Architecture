package simulator.wrapper.wrappers;

import simulator.control.Simulator;
import simulator.gates.combinational.And;
import simulator.network.Link;
import simulator.wrapper.Wrapper;

import java.util.ArrayList;
import java.util.List;

public class PC extends Wrapper {
    public PC(String label, String stream, Link... links) {
        super(label, stream, links);
    }

    @Override
    public void initialize() {

        Register[] pcarr = new Register[32];
        List<Mux2to1> muxs = new ArrayList<>();

        for (int i = 0 ; i < 32; i++){
            pcarr[i] = new Register("myReg","2X1", Simulator.trueLogic, getInput(i));
        }

        And and=new And("and");
        and.addInput(
                getOutput(0),getOutput(1),getOutput(2),getOutput(3),getOutput(4),getOutput(5),getOutput(6),getOutput(7),
                getOutput(8),getOutput(9),getOutput(10),getOutput(11),getOutput(12),getOutput(13),getOutput(14),getOutput(15),
                getOutput(16),getOutput(17),getOutput(18),getOutput(19),getOutput(20),getOutput(21),getOutput(22),getOutput(23),
                getOutput(24),getOutput(25),getOutput(26),getOutput(27),getOutput(28),getOutput(29),getOutput(30),getOutput(31)
        );

        for(int i=0;i<32;i++){
            muxs.add(new Mux2to1("mux" + i, "3x1",
                    and.getOutput(0),
                    pcarr[i].getOutput(0),Simulator.falseLogic
                    )
            );
        }
        for(int i=0;i<32;i++) {
            addOutput(muxs.get(i).getOutput(0));
        }


    }
}
