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
    private Boolean[] memory;

    public Memory(String label, Link... links) {
        super(label, links);
        memory = new Boolean[65536];
        for (int i = 0; i < 32; ++i) {
            addOutputLink(false);
        }
    }

    private int address() {
        int temp = 0;
        for (int i = 2; i < 34; ++i) {
            if(inputs.size() > i) {
                if(getInput(i).getSignal()) {
                    temp += Math.pow(2, 33 - i);
                }
            }
        }
        return temp;
    }

    private void memoryWrite() {
        for(int i = 34; i < 66; ++i) {
            memory[address() + i - 34] = getInput(i).getSignal();
        }
    }

    private void memoryRead(){
        for (int i = 0; i < 32; ++i) {
            getOutput(i).setSignal(memory[address() + i]);
        }
    }

    @Override
    public void evaluate() {
        if (getInput(1).getSignal()) {
            memoryWrite();
        } else
        if (getInput(1).getSignal()) {

            memoryRead();
        }
    }

    public void setMemory(Boolean[] memory) {
        this.memory = memory;
    }

    public Boolean[] getMemory() {
        return memory;
    }
}
