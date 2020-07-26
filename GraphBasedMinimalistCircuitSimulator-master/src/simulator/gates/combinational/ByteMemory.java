package simulator.gates.combinational;

import simulator.network.Link;
import simulator.network.Node;

import java.util.Arrays;

/* a byte-addressable memory with 4byte-word with 16bit address bus
 *   in:
 *       0 : write signal
 *       1 -> 16: address
 *       17 -> 48: data in
 *   out:
 *       0 -> 31 : data out */
public class ByteMemory extends Node {
    private Boolean[][] memory;

    public ByteMemory(String label, Link... links) {
        super(label, links);
        memory = new Boolean[65536][8];
        for(int i=0;i<65536;i++){
            Arrays.fill(memory[i],false);
        }
        memory[0][7]=true;
        memory[9/8][9%8]=true;
        memory[12/8][12%8]=true;
        memory[15/8][15%8]=true;
        memory[14/8][14%8]=true;
        memory[17/8][17%8]=true;
        memory[20/8][20%8]=true;
        memory[26/8][26%8]=true;
        memory[39/8][39%8]=true;
        memory[42/8][42%8]=true;
        memory[44/8][44%8]=true;
        memory[47/8][47%8]=true;
        memory[46/8][46%8]=true;
        memory[49/8][49%8]=true;
        memory[52/8][52%8]=true;
        memory[58/8][58%8]=true;


        for (int i = 0; i < 32; ++i) {
            addOutputLink(false);
        }
    }

// memory[7]=true;         memory[9]=true;         memory[12]=true;         memory[15]=true;         memory[14]=true;         memory[17]=true;         memory[20]=true;         memory[26]=true;         memory[7+32]=true;         memory[10+32]=true;         memory[12+32]=true;         memory[15+32]=true;         memory[14+32]=true;         memory[17+32]=true;         memory[20+32]=true;         memory[26+32]=true;
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

        for (int i = 0; i < 4; ++i) {
            if (address + i <= 65535) {
                for (int j = 0; j < 8; ++j) {
                    memory[address + i][j] = getInput(i * 8 + j + 17).getSignal();
                }
            }
        }
    }

    private void memoryRead(){
        int address = address();

        for (int i = 0; i < 4; ++i) {
            if (address + i <= 65535) {
                for (int j = 0; j < 8; ++j) {
                    getOutput(i * 8 + j).setSignal(memory[address + i][j]);
                }
            }
        }
    }

    @Override
    public void evaluate() {
        if (getInput(0).getSignal())
            memoryWrite();
        memoryRead();
    }

    public void setMemory(Boolean[][] memory) {
        this.memory = memory;
    }

    public Boolean[][] getMemory() {
        return memory;
    }
}
