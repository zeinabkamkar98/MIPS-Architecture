package simulator.wrapper;

import simulator.SubCache;
import simulator.control.Simulator;
import simulator.gates.combinational.Memory;
import simulator.gates.combinational.Not;
import simulator.network.Link;
import simulator.wrapper.Wrapper;
import simulator.wrapper.wrappers.Mux2to1;

public class Cache extends Wrapper {
    SubCache[] way1;
    SubCache[] tags1;
    SubCache[] valid;
    Memory memory;

    public Cache(String label, String stream, Memory mem, Link... links) {
        super(label, stream, links);
        way1 = new SubCache[1024 * 16 * 32];
        tags1 = new SubCache[18 * 1024];
        valid = new SubCache[1024];
        this.memory = mem;
        addOutput(Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic);

    }

    private int getTag() {

        int tag = 0;
        for (int i = 0; i < 18; i++) {
            tag += Math.pow(2, 17 - i);
        }
        return tag;
    }

    private int getSet() {

        int set = 0;
        for (int i = 18; i < 28; i++) {
            set += Math.pow(2, 27 - i);
        }

        return set;
    }

    private int getOffset() {

        int offset = 0;
        for (int i = 28; i < 32; i++) {
            offset += Math.pow(2, 31 - i);
        }

        return offset;
    }


    @Override
    public void initialize() {
        Mux2to1[] mux2x1s = new Mux2to1[32];
        memory.addInput((new Not("Not1",valid[getSet()].getOutput(0))).getOutput(0),Simulator.falseLogic,getInput(0),getInput(1),getInput(2),getInput(3),getInput(4),getInput(5),getInput(6),getInput(7),getInput(8),getInput(9),getInput(10),getInput(11),getInput(12),getInput(13),getInput(14),getInput(15),getInput(16),getInput(17),getInput(18),getInput(19),getInput(20),getInput(21),getInput(22),getInput(23),getInput(24),getInput(25),getInput(26),getInput(27),getInput(28),getInput(29),getInput(30),getInput(31));
        for (int i = 0; i < 32; i++) {
            mux2x1s[i]=new Mux2to1("MUX"+i,"3X1",valid[getSet()].getOutput(0),memory.getOutput(i),way1[getSet()*32*16+32*getOffset()+i].getOutput(0));
        }
        addOutput(mux2x1s[0].getOutput(0),mux2x1s[1].getOutput(0),mux2x1s[2].getOutput(0),mux2x1s[3].getOutput(0),mux2x1s[4].getOutput(0),mux2x1s[5].getOutput(0),mux2x1s[6].getOutput(0),mux2x1s[7].getOutput(0),mux2x1s[8].getOutput(0),mux2x1s[9].getOutput(0),mux2x1s[10].getOutput(0),mux2x1s[11].getOutput(0),mux2x1s[12].getOutput(0),mux2x1s[13].getOutput(0),mux2x1s[14].getOutput(0),mux2x1s[15].getOutput(0),mux2x1s[16].getOutput(0),mux2x1s[17].getOutput(0),mux2x1s[18].getOutput(0),mux2x1s[19].getOutput(0),mux2x1s[20].getOutput(0),mux2x1s[21].getOutput(0),mux2x1s[22].getOutput(0),mux2x1s[23].getOutput(0),mux2x1s[24].getOutput(0),mux2x1s[25].getOutput(0),mux2x1s[26].getOutput(0),mux2x1s[27].getOutput(0),mux2x1s[28].getOutput(0),mux2x1s[29].getOutput(0),mux2x1s[30].getOutput(0),mux2x1s[31].getOutput(0));
        valid[getSet()].setInput(1,Simulator.trueLogic);
        valid[getSet()].setInput(2,Simulator.trueLogic);
        for (int i = 0; i <16 ; i++) {

//            moving Data from mem to lod
//            needs 32bit adder for address calculation
        }



    }

}
