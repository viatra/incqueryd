package hu.bme.mit.incqueryd.rete.messages;

import hu.bme.mit.incqueryd.rete.dataunits.ChangeSet;
import hu.bme.mit.incqueryd.rete.dataunits.ReteNodeSlot;

import java.io.Serializable;
import java.util.Stack;

import akka.actor.ActorRef;

/**
 * 
 * @author szarnyasg
 *
 */
public class UpdateMessage implements Serializable {

    private static final long serialVersionUID = 1L;

    protected ChangeSet changeSet;
    protected ReteNodeSlot nodeSlot;
    protected Stack<ActorRef> senderStack;

    public UpdateMessage(final ChangeSet changeSet, final ReteNodeSlot nodeSlot, final Stack<ActorRef> senderStack) {
        this.changeSet = changeSet;
        this.nodeSlot = nodeSlot;
        this.senderStack = senderStack;
    }

    public ChangeSet getChangeSet() {
        return changeSet;
    }

    public ReteNodeSlot getNodeSlot() {
        return nodeSlot;
    }

    public Stack<ActorRef> getSenderStack() {
        return senderStack;
    }

    @Override
    public String toString() {
        return "UpdateMessage [changeSet=" + changeSet + ", nodeSlot=" + nodeSlot + ", senderStack=" + senderStack
                + "]";
    }

}
