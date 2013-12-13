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
    protected Stack<ActorRef> sender = new Stack<>();

    public UpdateMessage(final ChangeSet changeSet, final ReteNodeSlot nodeSlot) {
        this.changeSet = changeSet;
        this.nodeSlot = nodeSlot;
    }

    public ChangeSet getChangeSet() {
        return changeSet;
    }

    public ReteNodeSlot getNodeSlot() {
        return nodeSlot;
    }

    public Stack<ActorRef> getSender() {
        return sender;
    }

    public void setSender(final Stack<ActorRef> sender) {
        this.sender = sender;
    }

}
