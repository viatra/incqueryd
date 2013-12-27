package hu.bme.mit.incqueryd.rete.sandbox;

import java.io.Serializable;

/**
 * Dummy message for tinkering with the Akka test framework.
 * 
 * @author szarnyasg
 * 
 */
public class DummyMessage implements Serializable {

    private static final long serialVersionUID = 1L;

    protected int x;

    public DummyMessage(final int x) {
        super();
        this.x = x;
    }
    
    public int getX() {
        return x;
    }
    
    @Override
    public String toString() {
        return "DummyMessage, x = " + x;
    }
    
}
