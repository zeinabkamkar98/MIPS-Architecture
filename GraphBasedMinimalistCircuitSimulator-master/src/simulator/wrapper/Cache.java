package simulator.wrapper;

import simulator.Sample;
import simulator.control.Simulator;
import simulator.gates.combinational.*;
import simulator.gates.sequential.Clock;
import simulator.network.Link;
import simulator.wrapper.wrappers.*;
import simulator.wrapper.wrappers.LOD;

import java.util.ArrayList;

public class Cache extends Wrapper {
    simulator.wrapper.wrappers.LOD[] data;
    SubCache[][] tags;
    SubCache[] valid;
    Memory memory;
//    Clock clk;

    public Cache(String label, String stream, Link... links) {
        super(label, stream, links);
//        this.memory = mem;
//        this.clk = clk;


    }

    @Override
    public void initialize() {
        this.memory = Sample.memory;
//        addOutput(Simulator.trueLogic, Simulator.falseLogic, Simulator.falseLogic, Simulator.falseLogic,
//                Simulator.falseLogic, Simulator.falseLogic, Simulator.falseLogic, Simulator.falseLogic,
//                Simulator.falseLogic, Simulator.falseLogic, Simulator.falseLogic, Simulator.falseLogic,
//                Simulator.falseLogic, Simulator.falseLogic, Simulator.falseLogic, Simulator.falseLogic,
//                Simulator.falseLogic, Simulator.falseLogic, Simulator.falseLogic, Simulator.falseLogic,
//                Simulator.falseLogic, Simulator.falseLogic, Simulator.falseLogic, Simulator.falseLogic,
//                Simulator.falseLogic, Simulator.falseLogic, Simulator.falseLogic, Simulator.falseLogic,
//                Simulator.falseLogic, Simulator.falseLogic, Simulator.falseLogic, Simulator.falseLogic);



        tags = new SubCache[16][26];
        data = new simulator.wrapper.wrappers.LOD[16];
        valid = new SubCache[16];


        for (int i = 0; i <16 ; i++) {
            for (int j = 0; j <26 ; j++) {
                tags[i][j]=new SubCache("t"+i+""+j,"3x1",Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic);

            }

        }
        for (int i = 0; i < 16; i++) {
            valid[i] = new SubCache("v" + i, "3x1", new Clock("clk", 100).getOutput(0), Simulator.trueLogic, Simulator.falseLogic);

        }
////
        Dec16 setDec = new Dec16("desoder", "4x16",getInput(26), getInput(27),getInput(28), getInput(29));
//        Decoder offsetDec = new Decoder("desoder", "2x4", getInput(30), getInput(31));


//        Mux16to4[] checkSet = new Mux16to4[128];
        Mux4to2[] checkOffset = new Mux4to2[32];
        Mux2to1[] checkHit = new Mux2to1[32];
//

//
        for (int i = 0; i < 16; i++) {
            data[i] = new LOD("a", "130x128", Simulator.falseLogic, Simulator.falseLogic,
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
                    Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,
                    Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic
            );


        }

        for (int i = 0; i < 128; i++) {
//            checkSet[i] = new Mux16to4("CS" + i, "20x1",getInput(26), getInput(27),getInput(28), getInput(29), data[0].getLOD()[i].getOutput(0), data[1].getLOD()[i].getOutput(0), data[2].getLOD()[i].getOutput(0), data[3].getLOD()[i].getOutput(0), data[4].getLOD()[i].getOutput(0), data[5].getLOD()[i].getOutput(0), data[6].getLOD()[i].getOutput(0), data[7].getLOD()[i].getOutput(0), data[8].getLOD()[i].getOutput(0), data[9].getLOD()[i].getOutput(0), data[10].getLOD()[i].getOutput(0), data[11].getLOD()[i].getOutput(0), data[12].getLOD()[i].getOutput(0), data[13].getLOD()[i].getOutput(0), data[14].getLOD()[i].getOutput(0), data[15].getLOD()[i].getOutput(0));
//
        }
        for (int i = 0; i < 32; i++) {
//            checkOffset[i] = new Mux4to2("CO" + i, "6x1", getInput(30), getInput(31), checkSet[0 + i].getOutput(0), checkSet[32 + i].getOutput(0), checkSet[64 + i].getOutput(0), checkSet[96 + i].getOutput(0));
        }
        for (int i = 0; i < 16; i++) {
//            addOutput(setDec.getOutput(i));
//            addOutput(setDec.getOutput(i));
//
        }
////
////
//
        Mux16to4[] tagComparator=new Mux16to4[26];

        for (int i = 0; i <26 ; i++) {
            tagComparator[i]=new Mux16to4("tag Comparetor"+i,"20x1",getInput(26),getInput(27),getInput(28),getInput(29),
//                    Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,
//                    Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,
//                    Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,
//                    Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic);
                    tags[0][i].getOutput(0),tags[1][i].getOutput(0),tags[2][i].getOutput(0),tags[3][i].getOutput(0),
                    tags[4][i].getOutput(0),tags[5][i].getOutput(0),tags[6][i].getOutput(0),tags[7][i].getOutput(0),
                    tags[8][i].getOutput(0),tags[9][i].getOutput(0),tags[10][i].getOutput(0),tags[11][i].getOutput(0),
                    tags[12][i].getOutput(0),tags[13][i].getOutput(0),tags[14][i].getOutput(0),tags[15][i].getOutput(0));

        }
        Comparetor tagCompare=new Comparetor("tag comparator","52x1");
//
        for (int i = 0; i <26 ; i++) {


            tagCompare.addInput(tagComparator[i].getOutput(0));
        }
        for (int i = 0; i < 26; i++) {
            tagCompare.addInput(getInput(i));

        }
        Mux16to4 val=new Mux16to4("valid","20x1",getInput(26),getInput(27),getInput(28),getInput(29));
        for (int i = 0; i < 16; i++) {
            val.addInput(valid[i].getOutput(0));

        }
//        tagCompare==1:Data with given set has given tag
        tagCompare.setOutput(0,new And("A",tagCompare.getOutput(0),val.getOutput(0)).getOutput(0));

        for (int i = 0; i <32 ; i++) {
//            addOutput(tagCompare.getOutput(0));

        }
        Or[] resultOfLODs=new Or[128];
        for (int i = 0; i <128 ; i++) {
            resultOfLODs[i]=new Or("result Of LODs"+i);

        }
        for (int i = 0; i <16 ; i++) {
            data[i].setInput(0,setDec.getOutput(0));
            data[i].setInput(1,Simulator.falseLogic);
            for (int j = 0; j <128 ; j++) {
                resultOfLODs[j].addInput(data[i].getOutput(j));
            }
        }
        And[] ands=new And[128];
        for (int i = 0; i <128 ; i++) {
            ands[i]=new And("a"+i);

        }
        for (int i = 0; i < 4; i++) {
            NumToSignal numToSignal=new NumToSignal(i);
            Comparetor comparetor=new Comparetor("Comp","4x1",numToSignal.getOut().get(30),numToSignal.getOut().get(31),getInput(30),getInput(31));

            for (int j = 0; j < 32; j++) {
                ands[i*32+j].addInput(comparetor.getOutput(0),resultOfLODs[i*32+j].getOutput(0));
            }

        }
        Or[] finalRes=new Or[32];
        for (int i = 0; i <32 ; i++) {
            finalRes[i]=new Or("Final Result"+i);
            finalRes[i].addInput(resultOfLODs[0+i].getOutput(0),resultOfLODs[32+i].getOutput(0),resultOfLODs[64+i].getOutput(0),resultOfLODs[96+i].getOutput(0));

        }
        memory.setInput(0,new Not("NOT",tagCompare.getOutput(0)).getOutput(0));
        memory.setInput(1, Simulator.falseLogic);
//
        for (int i = 0; i <32 ; i++) {
            memory.setInput(
                    i + 2, new And("ss",getInput(i),Simulator.trueLogic).getOutput(0));
        }
        for (int i = 0; i <32 ; i++) {

            checkHit[i]=new Mux2to1("CH"+i,"3x1",tagCompare.getOutput(0),memory.getOutput(i),finalRes[i].getOutput(0));
//            addOutput(checkHit[i].getOutput(0));
        }
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//        data[0/4].setInput(0,Simulator.falseLogic);

        System.out.println(valid[0].getOutput(0).getSignal());
        Adder[] adders = new Adder[16*4];
        for (int i = 0; i < 16*4; i++) {
            memory.setInput(0,new Not("NOT",tagCompare.getOutput(0)).getOutput(0));
            memory.setInput(1,Simulator.falseLogic);
            NumToSignal numToSignal = new NumToSignal(i * 32);
            ArrayList<Link> res = numToSignal.getOut();
            adders[i] = new Adder("ADDER" + i, "64x32", getInput(0), getInput(1), getInput(2), getInput(3), getInput(4), getInput(5), getInput(6), getInput(7), getInput(8), getInput(9), getInput(10), getInput(11), getInput(12), getInput(13), getInput(14), getInput(15), getInput(16), getInput(17), getInput(18), getInput(19), getInput(20), getInput(21), getInput(22), getInput(23), getInput(24), getInput(25), getInput(26), getInput(27), getInput(28), getInput(29), getInput(30), getInput(31), res.get(0), res.get(1), res.get(2), res.get(3), res.get(4), res.get(5), res.get(6), res.get(7), res.get(8), res.get(9), res.get(10), res.get(11), res.get(12), res.get(13), res.get(14), res.get(15), res.get(16), res.get(17), res.get(18), res.get(19), res.get(20), res.get(21), res.get(22), res.get(23), res.get(24), res.get(25), res.get(26), res.get(27), res.get(28), res.get(29), res.get(30), res.get(31));

            for (int j = 0; j < 32; j++) {
                memory.setInput(
                        j + 2, new And("ss",getInput(j),Simulator.trueLogic).getOutput(0));
            }
//            memory.setInput(0, FinalVal.getOutput(0));

//            Not n = new Not("n", Simulator.falseLogic);
//            And and = new And("a", setDec.getOutput(i/4), n.getOutput(0));
//            Or or1 = new Or("o", and.getOutput(0), getInput(32), and.getOutput(0));
//            for (int j = 0; j < 32; j++) {
//
//                data[i/4].setInput((i%4)*32+j+2,memory.getOutput(j));
////                        Mux2to1 choose = new Mux2to1("mux" + i + j, "3x1", getInput(32), getInput(33), memory.getOutput(j));
////                        Link link = memory.getOutput(k);
////                        data[j].getLOD()[l * 32 + k].setInput(2, new And("a", choose.getOutput(0), Simulator.trueLogic).getOutput(0));
////
//            }
        }
//




//            memory.setInput(0, FinalVal.getOutput(0));


        for (int i = 0; i <16 ; i++) {
            valid[i].setInput(1,setDec.getOutput(i));
            valid[i].setInput(2,Simulator.trueLogic);

        }
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 26; j++) {
                tags[i][j].setInput(2,getInput(j));
                tags[i][j].setInput(1,new And("a",setDec.getOutput(i),new Not("n",tagCompare.getOutput(0)).getOutput(0)).getOutput(0));

            }
        }


//
//
//
//

//
        for (int i = 0; i < 16; i++) {
            addOutput(valid[0].getOutput(0));
            addOutput(valid[1].getOutput(0));
//
        }
    }
}

//
