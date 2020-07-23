package simulator.wrapper;

import simulator.Sample;
import simulator.SubCache;
import simulator.control.Simulator;
import simulator.gates.combinational.*;
import simulator.gates.sequential.Clock;
import simulator.network.Link;
import simulator.wrapper.wrappers.*;

import java.util.ArrayList;

public class Cache2 extends Wrapper {
    LOD[] data;
    SubCache[][] tags;
    SubCache[] valid;
    Memory memory;
    Clock clk;

    public Cache2(String label, String stream, Memory mem, Clock clk, Link... links) {
        super(label, stream, links);
        this.memory = mem;
        this.clk = clk;


    }

    @Override
    public void initialize() {
//        this.memory=mem;
        this.memory =Sample.getMemory();
        memory.evaluate();
//        addOutput(Simulator.trueLogic, Simulator.falseLogic, Simulator.falseLogic, Simulator.falseLogic, Simulator.falseLogic, Simulator.falseLogic, Simulator.falseLogic, Simulator.falseLogic, Simulator.falseLogic, Simulator.falseLogic, Simulator.falseLogic, Simulator.falseLogic, Simulator.falseLogic, Simulator.falseLogic, Simulator.falseLogic, Simulator.falseLogic, Simulator.falseLogic, Simulator.falseLogic, Simulator.falseLogic, Simulator.falseLogic, Simulator.falseLogic, Simulator.falseLogic, Simulator.falseLogic, Simulator.falseLogic, Simulator.falseLogic, Simulator.falseLogic, Simulator.falseLogic, Simulator.falseLogic, Simulator.falseLogic, Simulator.falseLogic, Simulator.falseLogic, Simulator.falseLogic);
        memory.setInput(0,Simulator.trueLogic);
        memory.setInput(1,Simulator.falseLogic);

        for (int i = 0; i <32 ; i++) {
            memory.setInput(
                    i + 2, new And("ss",getInput(i),Simulator.trueLogic).getOutput(0));
        }


        tags = new SubCache[16][24];
        data = new LOD[16];
        valid = new SubCache[16];


        for (int i = 0; i <16 ; i++) {
            for (int j = 0; j <24 ; j++) {
                tags[i][j]=new SubCache("t"+i+""+j,"3x1",Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic);

            }

        }
        for (int i = 0; i < 16; i++) {
            valid[i] = new SubCache("v" + i, "3x1", new Clock("clk", 100).getOutput(0), Simulator.trueLogic, Simulator.falseLogic);

        }

        Dec16 setDec = new Dec16("desoder", "4x16", getInput(24), getInput(25), getInput(26), getInput(27));
        Dec16 offsetDec = new Dec16("desoder", "4x16", getInput(28), getInput(29), getInput(30), getInput(31));


        Mux16to4[] checkSet = new Mux16to4[512];
        Mux16to4[] checkOffset = new Mux16to4[32];
        Mux16to4[] checkOffset2 = new Mux16to4[32];
        Mux2to1[] checkHit = new Mux2to1[32];
//
        for (int i = 0; i < 32; i++) {

        }
//
        for (int i = 0; i < 16; i++) {
            data[i] = new LOD("a", "2x32", Simulator.falseLogic, Simulator.falseLogic);

        }
//
        for (int i = 0; i < 512; i++) {
            checkSet[i] = new Mux16to4("CS" + i, "20x1", getInput(24), getInput(25), getInput(26), getInput(27), data[0].getLOD()[i].getOutput(0), data[1].getLOD()[i].getOutput(0), data[2].getLOD()[i].getOutput(0), data[3].getLOD()[i].getOutput(0), data[4].getLOD()[i].getOutput(0), data[5].getLOD()[i].getOutput(0), data[6].getLOD()[i].getOutput(0), data[7].getLOD()[i].getOutput(0), data[8].getLOD()[i].getOutput(0), data[9].getLOD()[i].getOutput(0), data[10].getLOD()[i].getOutput(0), data[11].getLOD()[i].getOutput(0), data[12].getLOD()[i].getOutput(0), data[13].getLOD()[i].getOutput(0), data[14].getLOD()[i].getOutput(0), data[15].getLOD()[i].getOutput(0));

        }
        for (int i = 0; i < 32; i++) {
            checkOffset[i] = new Mux16to4("CO" + i, "20x1", getInput(28), getInput(29), getInput(30), getInput(31), checkSet[0 + i].getOutput(0), checkSet[32 + i].getOutput(0), checkSet[64 + i].getOutput(0), checkSet[96 + i].getOutput(0), checkSet[128 + i].getOutput(0), checkSet[160 + i].getOutput(0), checkSet[192 + i].getOutput(0), checkSet[224 + i].getOutput(0), checkSet[256 + i].getOutput(0), checkSet[228 + i].getOutput(0), checkSet[320 + i].getOutput(0), checkSet[352 + i].getOutput(0), checkSet[384 + i].getOutput(0), checkSet[416 + i].getOutput(0), checkSet[448 + i].getOutput(0), checkSet[480 + i].getOutput(0));

        }
//        for (int i = 0; i < 16; i++) {
//            addOutput(setDec.getOutput(i));
//            addOutput(setDec.getOutput(i));
//
//        }
//
//
        Not[] nots = new Not[16];
        And[] ands = new And[16];
        And[] ands2 = new And[16];
        Or[] ors = new Or[16];
        Or o1 = new Or("o1", Simulator.falseLogic);
        for (int i = 0; i < 16; i++) {
            ands[i] = new And("a" + i,valid[i].getOutput(0),setDec.getOutput(i));
            o1.addInput(ands[i].getOutput(0));
        }
//        o1 output:data in set is valid,but tag should be checked.
//        ands[i]:shows that data of a set is accepted or no.(1:Accepted)



        Or[] ands1= new Or[16];
        Or[] oos=new Or[16];
        Or o2=new Or("o",Simulator.falseLogic);
        for (int i = 0; i <16 ; i++) {
            Xor[] Xors = new Xor[24];
            ands1[i] = new Or("a", Simulator.falseLogic);

            for (int j = 0; j < 24; j++) {
                Xors[j] = new Xor("aa1", getInput(j), tags[i][j].getOutput(0));
                ands1[i].addInput(Xors[j].getOutput(0));
            }
//            if ands1[i]==1:tag is not acepted.(ands1[i]==0:is accepted)
            //Check tags
//            NumToSignal numToSignal = new NumToSignal(i);
//            ArrayList<Link> res = numToSignal.getOut();
//            Xor xor1 = new Xor("xor1", getInput(24), res.get(28));
//            Xor xor2 = new Xor("xor1", getInput(25), res.get(29));
//            Xor xor3 = new Xor("xor1", getInput(26), res.get(30));
//            Xor xor4 = new Xor("xor1", getInput(27), res.get(31));
//
//             oos[i]=new Or("OO",xor1.getOutput(0),xor2.getOutput(0),xor3.getOutput(0),xor4.getOutput(0));
//
//             o2.addInput(oos[i].getOutput(0));
//            each oos[i] shows data offset match ?
//            Check Offset

        }
        for (int j = 0; j <16 ; j++) {
            ands2[j]=new And("a"+j,new Not("n",ands1[j].getOutput(0)).getOutput(0),ands[j].getOutput(0));

        }
        Not validity = new Not("v1", o2.getOutput(0));
        Or validity2=new Or("validity2",Simulator.falseLogic);
        for (int i = 0; i < 16; i++) {
            validity2.addInput(ands2[i].getOutput(0));
        }
        for (int i = 0; i <32 ; i++) {
//            addOutput(validity2.getOutput(0));

        }

        for (int j = 0; j < 32 ; j++) {
            checkHit[j] = new Mux2to1("ch" + j, "3x1", validity2.getOutput(0),checkOffset[j].getOutput(0), memory.getOutput(j));

            addOutput(checkHit[j].getOutput(0));
        }

        Adder[] adders = new Adder[16];
        for (int i = 0; i < 16; i++) {
            memory.setInput(0,new And("a",setDec.getOutput(i),new Not("n",ands2[i].getOutput(0)).getOutput(0)).getOutput(0));
            memory.setInput(1,Simulator.falseLogic);
            NumToSignal numToSignal = new NumToSignal(i * 32);
            ArrayList<Link> res = numToSignal.getOut();
            adders[i] = new Adder("ADDER" + i, "64x32", getInput(0), getInput(1), getInput(2), getInput(3), getInput(4), getInput(5), getInput(6), getInput(7), getInput(8), getInput(9), getInput(10), getInput(11), getInput(12), getInput(13), getInput(14), getInput(15), getInput(16), getInput(17), getInput(18), getInput(19), getInput(20), getInput(21), getInput(22), getInput(23), getInput(24), getInput(25), getInput(26), getInput(27), getInput(28), getInput(29), getInput(30), getInput(31), res.get(0), res.get(1), res.get(2), res.get(3), res.get(4), res.get(5), res.get(6), res.get(7), res.get(8), res.get(9), res.get(10), res.get(11), res.get(12), res.get(13), res.get(14), res.get(15), res.get(16), res.get(17), res.get(18), res.get(19), res.get(20), res.get(21), res.get(22), res.get(23), res.get(24), res.get(25), res.get(26), res.get(27), res.get(28), res.get(29), res.get(30), res.get(31));

            for (int j = 0; j < 32; j++) {
                memory.setInput(
                        j + 2, new And("ss",getInput(j),Simulator.trueLogic).getOutput(0));
            }
//            memory.setInput(0, FinalVal.getOutput(0));
            memory.evaluate();

            for (int j = 0; j < 16; j++) {
                for (int k = 0; k < 32; k++) {
                    data[j].getLOD()[i * 32 + k].setInput(1, new And("a",setDec.getOutput(j),new Not("n",ands2[j].getOutput(0)).getOutput(0)).getOutput(0));
                    data[j].getLOD()[i * 32 + k].setInput(2, memory.getOutput(k));

                }

            }



//            memory.setInput(0, FinalVal.getOutput(0));
        }

        for (int i = 0; i <16 ; i++) {
            valid[i].setInput(1,setDec.getOutput(i));
            valid[i].setInput(2,Simulator.trueLogic);

        }
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 24; j++) {
                tags[i][j].setInput(2,getInput(j));
                tags[i][j].setInput(1,new And("a",setDec.getOutput(i),new Not("n",ands2[i].getOutput(0)).getOutput(0)).getOutput(0));

            }
        }





    }
}

