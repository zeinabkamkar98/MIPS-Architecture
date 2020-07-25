package simulator.gates.combinational;

import simulator.network.Link;
import simulator.network.Node;
/*
Inputs:
in[0]:read signal
in[2]:Write signal
in[2:33]:Address,needed for accesing memory
in[34:65]:Data,Which is going to be written in memory at given address

Outputs:
out[0:31]:Data,which is read from memory

*/
public class Memory extends Node {
    private Boolean[] memoryP1;
    private Boolean[] memoryP2;

    public Memory(String label, Link... links) {
        super(label, links);
        memoryP1 = new Boolean[65536];
        memoryP2 = new Boolean[65536];
        for (int i = 0; i < 32; ++i) {
            addOutputLink(false);
        }
    }

    private int address() {
        int temp = 0;
        for (int i = 18; i < 34; ++i) {
            if(inputs.size() > i) {
                if(getInput(i).getSignal()) {
                    temp += Math.pow(2, 33 - i);
                }
            }
        }
        if (temp==214748364) return 0;
        return temp;
    }

    private void memoryWrite() {
        if (address()<65536-32)
            for(int i = 34; i < 66; ++i) {
                memoryP1[address() + i - 34] = getInput(i).getSignal();
            }
        else{for(int i = 34; i < 66; ++i) {
            memoryP2[address()-65536 + i ] = getInput(i).getSignal();
        }}
    }

    private void memoryRead(){
        if (address()<65536)
            for (int i = 0; i < 32; ++i) {
                getOutput(i).setSignal(memoryP1[address() + i]);
            }
        else{
            for (int i = 0; i < 32; ++i) {
                getOutput(i).setSignal(memoryP2[address()-65536 + i]);}

        }
    }

    @Override
    public void evaluate() {
        if (getInput(1).getSignal()) {
            memoryWrite();
        } else
        if (getInput(0).getSignal()) {

            memoryRead();
        }
    }

    public void setMemory(Boolean[] memoryP1,Boolean[] memoryP2) {
        this.memoryP1 = memoryP1;
        this.memoryP2 = memoryP2;
    }

    public Boolean[] getMemoryP1() {
        return memoryP1;
    }
    public Boolean[] getMemoryP2() {
        return memoryP2;
    }
}
