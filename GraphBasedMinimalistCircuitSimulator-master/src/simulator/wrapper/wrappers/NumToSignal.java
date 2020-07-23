package simulator.wrapper.wrappers;

import simulator.control.Simulator;
import simulator.network.Link;

import java.util.ArrayList;

public class NumToSignal  {
    private ArrayList<Link> out;
    private int in;
    public NumToSignal(int i) {
        this.in=i;
        this.out=new ArrayList<>();


    }

    public ArrayList<Link> getOut() {
        boolean[] bits = new boolean[32];
        for (int i =0 ; i <32; i++) {
            bits[i] = (in & (1 << i)) != 0;
        }
        for (int i = 31; i >-1 ; i--) {
            this.out.add(bits[i]? Simulator.trueLogic: Simulator.falseLogic);
        }
//        for (int i = 0; i < 32; i++) {
//            System.out.println(out.get(i).getSignal());
//
//        }
        return out;
    }

    public void setOut(ArrayList<Link> out) {
        this.out = out;
    }

    public static void main(String[] args) {
        int input = 15;
        ArrayList<Link> i=new NumToSignal(15).getOut();
    }
}
