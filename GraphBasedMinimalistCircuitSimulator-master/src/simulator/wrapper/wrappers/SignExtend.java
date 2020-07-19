
package simulator.wrapper.wrappers;

        import simulator.control.Simulator;
        import simulator.network.Link;
        import simulator.wrapper.Wrapper;

public class SignExtend extends Wrapper {
    public SignExtend(String label, String stream, Link... links) {
        super(label, stream, links);
    }
    //input=>0=in(h),...15=in(l)
    //output=>0,1,2,...,15=in(0),16=in(0),17=in(1),...,31=in(15)
    @Override
    public void initialize() {

        for(int i=0;i<16;i++){
            addOutput(getInput(0));
        }
        for(int i=0;i<16;i++){
            addOutput(getInput(i));
        }

    }
}
