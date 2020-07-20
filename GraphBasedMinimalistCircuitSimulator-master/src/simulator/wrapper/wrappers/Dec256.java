package simulator.wrapper.wrappers;

import simulator.gates.combinational.And;
import simulator.network.Link;
import simulator.wrapper.Wrapper;

public class Dec256 extends Wrapper {
    public Dec256(String label, String stream, Link... links) {
        super(label, stream, links);
    }

    @Override
    public void initialize() {
        Decoder5to32 d1=new Decoder5to32("D1","5x32",getInput(0),getInput(1),getInput(2),getInput(3),getInput(4));
        Dec16 d2=new Dec16("D2","4x16",getInput(5),getInput(6),getInput(7),getInput(8));
        Dec16 d3=new Dec16("D3","4x16",getInput(5),getInput(6),getInput(7),getInput(8));
        Dec16 d4=new Dec16("D4","4x16",getInput(5),getInput(6),getInput(7),getInput(8));
        Dec16 d5=new Dec16("D5","4x16",getInput(5),getInput(6),getInput(7),getInput(8));
        Dec16 d6=new Dec16("D6","4x16",getInput(5),getInput(6),getInput(7),getInput(8));
        Dec16 d7=new Dec16("D7","4x16",getInput(5),getInput(6),getInput(7),getInput(8));
        Dec16 d8=new Dec16("D8","4x16",getInput(5),getInput(6),getInput(7),getInput(8));
        Dec16 d9=new Dec16("D9","4x16",getInput(5),getInput(6),getInput(7),getInput(8));
        Dec16 d10=new Dec16("D10","4x16",getInput(5),getInput(6),getInput(7),getInput(8));
        Dec16 d11=new Dec16("D11","4x16",getInput(5),getInput(6),getInput(7),getInput(8));
        Dec16 d12=new Dec16("D12","4x16",getInput(5),getInput(6),getInput(7),getInput(8));
        Dec16 d13=new Dec16("D13","4x16",getInput(5),getInput(6),getInput(7),getInput(8));
        Dec16 d14=new Dec16("D14","4x16",getInput(5),getInput(6),getInput(7),getInput(8));
        Dec16 d15=new Dec16("D15","4x16",getInput(5),getInput(6),getInput(7),getInput(8));
        Dec16 d16=new Dec16("D16","4x16",getInput(5),getInput(6),getInput(7),getInput(8));
        Dec16 d17=new Dec16("D17","4x16",getInput(5),getInput(6),getInput(7),getInput(8));
        Dec16 d18=new Dec16("D18","4x16",getInput(5),getInput(6),getInput(7),getInput(8));
        Dec16 d19=new Dec16("D19","4x16",getInput(5),getInput(6),getInput(7),getInput(8));
        Dec16 d20=new Dec16("D20","4x16",getInput(5),getInput(6),getInput(7),getInput(8));
        Dec16 d21=new Dec16("D21","4x16",getInput(5),getInput(6),getInput(7),getInput(8));
        Dec16 d22=new Dec16("D22","4x16",getInput(5),getInput(6),getInput(7),getInput(8));
        Dec16 d23=new Dec16("D23","4x16",getInput(5),getInput(6),getInput(7),getInput(8));
        Dec16 d24=new Dec16("D24","4x16",getInput(5),getInput(6),getInput(7),getInput(8));
        Dec16 d25=new Dec16("D25","4x16",getInput(5),getInput(6),getInput(7),getInput(8));
        Dec16 d26=new Dec16("D26","4x16",getInput(5),getInput(6),getInput(7),getInput(8));
        Dec16 d27=new Dec16("D27","4x16",getInput(5),getInput(6),getInput(7),getInput(8));
        Dec16 d28=new Dec16("D28","4x16",getInput(5),getInput(6),getInput(7),getInput(8));
        Dec16 d29=new Dec16("D29","4x16",getInput(5),getInput(6),getInput(7),getInput(8));
        Dec16 d30=new Dec16("D30","4x16",getInput(5),getInput(6),getInput(7),getInput(8));
        Dec16 d31=new Dec16("D31","4x16",getInput(5),getInput(6),getInput(7),getInput(8));
        Dec16 d32=new Dec16("D32","4x16",getInput(5),getInput(6),getInput(7),getInput(8));
        Dec16 d33=new Dec16("D33","4x16",getInput(5),getInput(6),getInput(7),getInput(8));


        for (int j = 0; j < 16; j++) {
            And and=new And("And",d1.getOutput(0),d2.getOutput(j));
            d2.setOutput(j,and.getOutput(0));

        }
        for (int j = 0; j < 16; j++) {
            And and=new And("And",d1.getOutput(1),d3.getOutput(j));
            d3.setOutput(j,and.getOutput(0));
        }

        for (int j = 0; j < 16; j++) {
            And and=new And("And",d1.getOutput(2),d4.getOutput(j));
            d4.setOutput(j,and.getOutput(0));}
        for (int j = 0; j < 16; j++) {
            And and=new And("And",d1.getOutput(3),d5.getOutput(j));
            d5.setOutput(j,and.getOutput(0));}
        for (int j = 0; j < 16; j++) {
            And and=new And("And",d1.getOutput(4),d6.getOutput(j));
            d6.setOutput(j,and.getOutput(0));}
        for (int j = 0; j < 16; j++) {
            And and=new And("And",d1.getOutput(5),d7.getOutput(j));
            d7.setOutput(j,and.getOutput(0));}
        for (int j = 0; j < 16; j++) {
            And and=new And("And",d1.getOutput(6),d8.getOutput(j));
            d8.setOutput(j,and.getOutput(0));}
        for (int j = 0; j < 16; j++) {
            And and=new And("And",d1.getOutput(7),d9.getOutput(j));
            d9.setOutput(j,and.getOutput(0));}
        for (int j = 0; j < 16; j++) {
            And and=new And("And",d1.getOutput(8),d10.getOutput(j));
            d10.setOutput(j,and.getOutput(0));}
        for (int j = 0; j < 16; j++) {
            And and=new And("And",d1.getOutput(9),d11.getOutput(j));
            d11.setOutput(j,and.getOutput(0));}
        for (int j = 0; j < 16; j++) {
            And and=new And("And",d1.getOutput(10),d12.getOutput(j));
            d12.setOutput(j,and.getOutput(0));}
        for (int j = 0; j < 16; j++) {
            And and=new And("And",d1.getOutput(11),d13.getOutput(j));
            d13.setOutput(j,and.getOutput(0));}
        for (int j = 0; j < 16; j++) {
            And and=new And("And",d1.getOutput(12),d14.getOutput(j));
            d14.setOutput(j,and.getOutput(0));}
        for (int j = 0; j < 16; j++) {
            And and=new And("And",d1.getOutput(13),d15.getOutput(j));
            d15.setOutput(j,and.getOutput(0));}
        for (int j = 0; j < 16; j++) {
            And and=new And("And",d1.getOutput(14),d16.getOutput(j));
            d16.setOutput(j,and.getOutput(0));}
        for (int j = 0; j < 16; j++) {
            And and=new And("And",d1.getOutput(15),d17.getOutput(j));
            d17.setOutput(j,and.getOutput(0));}
        for (int j = 0; j < 16; j++) {
            And and=new And("And",d1.getOutput(16),d18.getOutput(j));
            d18.setOutput(j,and.getOutput(0));}
        for (int j = 0; j < 16; j++) {
            And and=new And("And",d1.getOutput(17),d19.getOutput(j));
            d19.setOutput(j,and.getOutput(0));}
        for (int j = 0; j < 16; j++) {
            And and=new And("And",d1.getOutput(18),d20.getOutput(j));
            d20.setOutput(j,and.getOutput(0));}
        for (int j = 0; j < 16; j++) {
            And and=new And("And",d1.getOutput(19),d21.getOutput(j));
            d21.setOutput(j,and.getOutput(0));}
        for (int j = 0; j < 16; j++) {
            And and=new And("And",d1.getOutput(20),d22.getOutput(j));
            d22.setOutput(j,and.getOutput(0));}
        for (int j = 0; j < 16; j++) {
            And and=new And("And",d1.getOutput(21),d23.getOutput(j));
            d23.setOutput(j,and.getOutput(0));}
        for (int j = 0; j < 16; j++) {
            And and=new And("And",d1.getOutput(22),d24.getOutput(j));
            d24.setOutput(j,and.getOutput(0));}
        for (int j = 0; j < 16; j++) {
            And and=new And("And",d1.getOutput(23),d25.getOutput(j));
            d25.setOutput(j,and.getOutput(0));}
        for (int j = 0; j < 16; j++) {
            And and=new And("And",d1.getOutput(24),d26.getOutput(j));
            d26.setOutput(j,and.getOutput(0));}
        for (int j = 0; j < 16; j++) {
            And and=new And("And",d1.getOutput(25),d27.getOutput(j));
            d27.setOutput(j,and.getOutput(0));}
        for (int j = 0; j < 16; j++) {
            And and=new And("And",d1.getOutput(26),d28.getOutput(j));
            d28.setOutput(j,and.getOutput(0));}
        for (int j = 0; j < 16; j++) {
            And and=new And("And",d1.getOutput(27),d29.getOutput(j));
            d29.setOutput(j,and.getOutput(0));}
        for (int j = 0; j < 16; j++) {
            And and=new And("And",d1.getOutput(28),d30.getOutput(j));
            d30.setOutput(j,and.getOutput(0));}
        for (int j = 0; j < 16; j++) {
            And and=new And("And",d1.getOutput(29),d31.getOutput(j));
            d31.setOutput(j,and.getOutput(0));}
        for (int j = 0; j < 16; j++) {
            And and=new And("And",d1.getOutput(30),d32.getOutput(j));
            d32.setOutput(j,and.getOutput(0));}
        for (int j = 0; j < 16; j++) {
            And and=new And("And",d1.getOutput(31),d33.getOutput(j));
            d33.setOutput(j,and.getOutput(0));}
        addOutput(d2.getOutput(0),d2.getOutput(1),d2.getOutput(2),d2.getOutput(3),d2.getOutput(4),d2.getOutput(5),d2.getOutput(6),d2.getOutput(7),d2.getOutput(8),d2.getOutput(9),d2.getOutput(10),d2.getOutput(11),d2.getOutput(12),d2.getOutput(13),d2.getOutput(14),d2.getOutput(15),d3.getOutput(0),d3.getOutput(1),d3.getOutput(2),d3.getOutput(3),d3.getOutput(4),d3.getOutput(5),d3.getOutput(6),d3.getOutput(7),d3.getOutput(8),d3.getOutput(9),d3.getOutput(10),d3.getOutput(11),d3.getOutput(12),d3.getOutput(13),d3.getOutput(14),d3.getOutput(15),d4.getOutput(0),d4.getOutput(1),d4.getOutput(2),d4.getOutput(3),d4.getOutput(4),d4.getOutput(5),d4.getOutput(6),d4.getOutput(7),d4.getOutput(8),d4.getOutput(9),d4.getOutput(10),d4.getOutput(11),d4.getOutput(12),d4.getOutput(13),d4.getOutput(14),d4.getOutput(15),d5.getOutput(0),d5.getOutput(1),d5.getOutput(2),d5.getOutput(3),d5.getOutput(4),d5.getOutput(5),d5.getOutput(6),d5.getOutput(7),d5.getOutput(8),d5.getOutput(9),d5.getOutput(10),d5.getOutput(11),d5.getOutput(12),d5.getOutput(13),d5.getOutput(14),d5.getOutput(15),d6.getOutput(0),d6.getOutput(1),d6.getOutput(2),d6.getOutput(3),d6.getOutput(4),d6.getOutput(5),d6.getOutput(6),d6.getOutput(7),d6.getOutput(8),d6.getOutput(9),d6.getOutput(10),d6.getOutput(11),d6.getOutput(12),d6.getOutput(13),d6.getOutput(14),d6.getOutput(15),d7.getOutput(0),d7.getOutput(1),d7.getOutput(2),d7.getOutput(3),d7.getOutput(4),d7.getOutput(5),d7.getOutput(6),d7.getOutput(7),d7.getOutput(8),d7.getOutput(9),d7.getOutput(10),d7.getOutput(11),d7.getOutput(12),d7.getOutput(13),d7.getOutput(14),d7.getOutput(15),d8.getOutput(0),d8.getOutput(1),d8.getOutput(2),d8.getOutput(3),d8.getOutput(4),d8.getOutput(5),d8.getOutput(6),d8.getOutput(7),d8.getOutput(8),d8.getOutput(9),d8.getOutput(10),d8.getOutput(11),d8.getOutput(12),d8.getOutput(13),d8.getOutput(14),d8.getOutput(15),d9.getOutput(0),d9.getOutput(1),d9.getOutput(2),d9.getOutput(3),d9.getOutput(4),d9.getOutput(5),d9.getOutput(6),d9.getOutput(7),d9.getOutput(8),d9.getOutput(9),d9.getOutput(10),d9.getOutput(11),d9.getOutput(12),d9.getOutput(13),d9.getOutput(14),d9.getOutput(15),d10.getOutput(0),d10.getOutput(1),d10.getOutput(2),d10.getOutput(3),d10.getOutput(4),d10.getOutput(5),d10.getOutput(6),d10.getOutput(7),d10.getOutput(8),d10.getOutput(9),d10.getOutput(10),d10.getOutput(11),d10.getOutput(12),d10.getOutput(13),d10.getOutput(14),d10.getOutput(15),d11.getOutput(0),d11.getOutput(1),d11.getOutput(2),d11.getOutput(3),d11.getOutput(4),d11.getOutput(5),d11.getOutput(6),d11.getOutput(7),d11.getOutput(8),d11.getOutput(9),d11.getOutput(10),d11.getOutput(11),d11.getOutput(12),d11.getOutput(13),d11.getOutput(14),d11.getOutput(15),d12.getOutput(0),d12.getOutput(1),d12.getOutput(2),d12.getOutput(3),d12.getOutput(4),d12.getOutput(5),d12.getOutput(6),d12.getOutput(7),d12.getOutput(8),d12.getOutput(9),d12.getOutput(10),d12.getOutput(11),d12.getOutput(12),d12.getOutput(13),d12.getOutput(14),d12.getOutput(15),d13.getOutput(0),d13.getOutput(1),d13.getOutput(2),d13.getOutput(3),d13.getOutput(4),d13.getOutput(5),d13.getOutput(6),d13.getOutput(7),d13.getOutput(8),d13.getOutput(9),d13.getOutput(10),d13.getOutput(11),d13.getOutput(12),d13.getOutput(13),d13.getOutput(14),d13.getOutput(15),d14.getOutput(0),d14.getOutput(1),d14.getOutput(2),d14.getOutput(3),d14.getOutput(4),d14.getOutput(5),d14.getOutput(6),d14.getOutput(7),d14.getOutput(8),d14.getOutput(9),d14.getOutput(10),d14.getOutput(11),d14.getOutput(12),d14.getOutput(13),d14.getOutput(14),d14.getOutput(15),d15.getOutput(0),d15.getOutput(1),d15.getOutput(2),d15.getOutput(3),d15.getOutput(4),d15.getOutput(5),d15.getOutput(6),d15.getOutput(7),d15.getOutput(8),d15.getOutput(9),d15.getOutput(10),d15.getOutput(11),d15.getOutput(12),d15.getOutput(13),d15.getOutput(14),d15.getOutput(15),d16.getOutput(0),d16.getOutput(1),d16.getOutput(2),d16.getOutput(3),d16.getOutput(4),d16.getOutput(5),d16.getOutput(6),d16.getOutput(7),d16.getOutput(8),d16.getOutput(9),d16.getOutput(10),d16.getOutput(11),d16.getOutput(12),d16.getOutput(13),d16.getOutput(14),d16.getOutput(15),d17.getOutput(0),d17.getOutput(1),d17.getOutput(2),d17.getOutput(3),d17.getOutput(4),d17.getOutput(5),d17.getOutput(6),d17.getOutput(7),d17.getOutput(8),d17.getOutput(9),d17.getOutput(10),d17.getOutput(11),d17.getOutput(12),d17.getOutput(13),d17.getOutput(14),d17.getOutput(15),d18.getOutput(0),d18.getOutput(1),d18.getOutput(2),d18.getOutput(3),d18.getOutput(4),d18.getOutput(5),d18.getOutput(6),d18.getOutput(7),d18.getOutput(8),d18.getOutput(9),d18.getOutput(10),d18.getOutput(11),d18.getOutput(12),d18.getOutput(13),d18.getOutput(14),d18.getOutput(15),d19.getOutput(0),d19.getOutput(1),d19.getOutput(2),d19.getOutput(3),d19.getOutput(4),d19.getOutput(5),d19.getOutput(6),d19.getOutput(7),d19.getOutput(8),d19.getOutput(9),d19.getOutput(10),d19.getOutput(11),d19.getOutput(12),d19.getOutput(13),d19.getOutput(14),d19.getOutput(15),d20.getOutput(0),d20.getOutput(1),d20.getOutput(2),d20.getOutput(3),d20.getOutput(4),d20.getOutput(5),d20.getOutput(6),d20.getOutput(7),d20.getOutput(8),d20.getOutput(9),d20.getOutput(10),d20.getOutput(11),d20.getOutput(12),d20.getOutput(13),d20.getOutput(14),d20.getOutput(15),d21.getOutput(0),d21.getOutput(1),d21.getOutput(2),d21.getOutput(3),d21.getOutput(4),d21.getOutput(5),d21.getOutput(6),d21.getOutput(7),d21.getOutput(8),d21.getOutput(9),d21.getOutput(10),d21.getOutput(11),d21.getOutput(12),d21.getOutput(13),d21.getOutput(14),d21.getOutput(15),d22.getOutput(0),d22.getOutput(1),d22.getOutput(2),d22.getOutput(3),d22.getOutput(4),d22.getOutput(5),d22.getOutput(6),d22.getOutput(7),d22.getOutput(8),d22.getOutput(9),d22.getOutput(10),d22.getOutput(11),d22.getOutput(12),d22.getOutput(13),d22.getOutput(14),d22.getOutput(15),d23.getOutput(0),d23.getOutput(1),d23.getOutput(2),d23.getOutput(3),d23.getOutput(4),d23.getOutput(5),d23.getOutput(6),d23.getOutput(7),d23.getOutput(8),d23.getOutput(9),d23.getOutput(10),d23.getOutput(11),d23.getOutput(12),d23.getOutput(13),d23.getOutput(14),d23.getOutput(15),d24.getOutput(0),d24.getOutput(1),d24.getOutput(2),d24.getOutput(3),d24.getOutput(4),d24.getOutput(5),d24.getOutput(6),d24.getOutput(7),d24.getOutput(8),d24.getOutput(9),d24.getOutput(10),d24.getOutput(11),d24.getOutput(12),d24.getOutput(13),d24.getOutput(14),d24.getOutput(15),d25.getOutput(0),d25.getOutput(1),d25.getOutput(2),d25.getOutput(3),d25.getOutput(4),d25.getOutput(5),d25.getOutput(6),d25.getOutput(7),d25.getOutput(8),d25.getOutput(9),d25.getOutput(10),d25.getOutput(11),d25.getOutput(12),d25.getOutput(13),d25.getOutput(14),d25.getOutput(15),d26.getOutput(0),d26.getOutput(1),d26.getOutput(2),d26.getOutput(3),d26.getOutput(4),d26.getOutput(5),d26.getOutput(6),d26.getOutput(7),d26.getOutput(8),d26.getOutput(9),d26.getOutput(10),d26.getOutput(11),d26.getOutput(12),d26.getOutput(13),d26.getOutput(14),d26.getOutput(15),d27.getOutput(0),d27.getOutput(1),d27.getOutput(2),d27.getOutput(3),d27.getOutput(4),d27.getOutput(5),d27.getOutput(6),d27.getOutput(7),d27.getOutput(8),d27.getOutput(9),d27.getOutput(10),d27.getOutput(11),d27.getOutput(12),d27.getOutput(13),d27.getOutput(14),d27.getOutput(15),d28.getOutput(0),d28.getOutput(1),d28.getOutput(2),d28.getOutput(3),d28.getOutput(4),d28.getOutput(5),d28.getOutput(6),d28.getOutput(7),d28.getOutput(8),d28.getOutput(9),d28.getOutput(10),d28.getOutput(11),d28.getOutput(12),d28.getOutput(13),d28.getOutput(14),d28.getOutput(15),d29.getOutput(0),d29.getOutput(1),d29.getOutput(2),d29.getOutput(3),d29.getOutput(4),d29.getOutput(5),d29.getOutput(6),d29.getOutput(7),d29.getOutput(8),d29.getOutput(9),d29.getOutput(10),d29.getOutput(11),d29.getOutput(12),d29.getOutput(13),d29.getOutput(14),d29.getOutput(15),d30.getOutput(0),d30.getOutput(1),d30.getOutput(2),d30.getOutput(3),d30.getOutput(4),d30.getOutput(5),d30.getOutput(6),d30.getOutput(7),d30.getOutput(8),d30.getOutput(9),d30.getOutput(10),d30.getOutput(11),d30.getOutput(12),d30.getOutput(13),d30.getOutput(14),d30.getOutput(15),d31.getOutput(0),d31.getOutput(1),d31.getOutput(2),d31.getOutput(3),d31.getOutput(4),d31.getOutput(5),d31.getOutput(6),d31.getOutput(7),d31.getOutput(8),d31.getOutput(9),d31.getOutput(10),d31.getOutput(11),d31.getOutput(12),d31.getOutput(13),d31.getOutput(14),d31.getOutput(15),d32.getOutput(0),d32.getOutput(1),d32.getOutput(2),d32.getOutput(3),d32.getOutput(4),d32.getOutput(5),d32.getOutput(6),d32.getOutput(7),d32.getOutput(8),d32.getOutput(9),d32.getOutput(10),d32.getOutput(11),d32.getOutput(12),d32.getOutput(13),d32.getOutput(14),d32.getOutput(15),d33.getOutput(0),d33.getOutput(1),d33.getOutput(2),d33.getOutput(3),d33.getOutput(4),d33.getOutput(5),d33.getOutput(6),d33.getOutput(7),d33.getOutput(8),d33.getOutput(9),d33.getOutput(10),d33.getOutput(11),d33.getOutput(12),d33.getOutput(13),d33.getOutput(14),d33.getOutput(15));


    }
}
