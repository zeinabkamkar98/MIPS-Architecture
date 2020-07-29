package simulator.gates.combinational;

import simulator.network.Link;
import simulator.network.Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* a bit-addressable memory with 4byte-word with 16bit address bus
 *   in:
 *       0 : write signal
 *       1 -> 16: address
 *       17 -> 48: data in
 *   out:
 *       0 -> 31 : data out */
public class Memory extends Node {
    private Boolean[] memory;
    private List<Link> memIn;

    public Memory(String label, Link... links) {
        super(label, links);
        memIn = new ArrayList<>();
        memory = new Boolean[65536];
        Arrays.fill(memory,false);
        for (int i = 0; i < 32; ++i) {
            addOutputLink(false);
        }
        memory[7]=true;
        memory[9]=true;
        memory[12]=true;
        memory[14]=true;
        memory[15]=true;
        memory[17]=true;
        memory[20]=true;
        memory[26]=true;
        memory[7+32]=true;
        memory[10+32]=true;
        memory[12+32]=true;
        memory[14+32]=true;
        memory[15+32]=true;
        memory[17+32]=true;
        memory[19+32]=true;
        memory[26+32]=true;
        memory[28+32]=true;
        memory[30+32]=true;
        memory[7+64]=true;
        memory[9+64]=true;
        memory[12+64]=true;
        memory[15+64]=true;
        memory[17+64]=true;
        memory[19+64]=true;
        memory[20+64]=true;
        memory[26+64]=true;
        memory[30+64]=true;
        memory[7+96]=true;
        memory[9+96]=true;
        memory[10+96]=true;
        memory[12+96]=true;
        memory[14+96]=true;
        memory[17+96]=true;
        memory[26+96]=true;
    }

    private int address() {
        int temp = 0;
        for (int i = 1; i < 17; ++i) {
            if(inputs.size() > i) {
                if(getInput(i).getSignal()) {
                    temp += Math.pow(2, 16 - i);
                }
            }
        }
        return temp;
    }

    private void memoryWrite() {
        int address = address();

        for(int i = 17; i < 49; ++i) {
            if (address + i - 17 <= 65535) {
                memory[address + i - 17] = getInput(i).getSignal();
            }
        }
    }

    private void memoryRead(){
        int address = address();

        for (int i = 0; i < 32; ++i) {
            if (address + i <= 65535) {
                getOutput(i).setSignal(memory[address + i]);
            }
        }
    }

    public List<Link> getMemIn() {
        return memIn;
    }

    @Override
    public Link getInput(int index) {
        return memIn.get(index);
    }

    @Override
    public void evaluate() {
        if (getInput(0).getSignal())
            memoryWrite();
        memoryRead();
    }

    public void setMemory(Boolean[] memory) {
        this.memory = memory;
    }

    public Boolean[] getMemory() {
        return memory;
    }
}