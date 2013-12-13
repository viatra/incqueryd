package hu.bme.mit.incqueryd.rete.messages;

import hu.bme.mit.incqueryd.rete.dataunits.ReteNodeSlot;
import hu.bme.mit.incqueryd.rete.dataunits.Tuple;

import java.io.Serializable;
import java.util.Set;
import java.util.Stack;

import akka.actor.ActorRef;

public class UpdateMessage implements Serializable {

    private static final long serialVersionUID = 1L;

    protected UpdateType updateType;
    protected ReteNodeSlot nodeSlot;
    protected Set<Tuple> tuples;
    protected Stack<ActorRef> sender = new Stack<>();

    public UpdateMessage(final UpdateType updateType, final ReteNodeSlot nodeSlot, final Set<Tuple> tuples) {
        this.updateType = updateType;
        this.nodeSlot = nodeSlot;
        this.tuples = tuples;
    }

    public UpdateType getUpdateType() {
        return updateType;
    }

    public ReteNodeSlot getNodeSlot() {
        return nodeSlot;
    }

    public Set<Tuple> getTuples() {
        return tuples;
    }

    public Stack<ActorRef> getSender() {
        return sender;
    }

    public void setSender(final Stack<ActorRef> sender) {
        this.sender = sender;
    }

}
