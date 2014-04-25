package hu.bme.mit.incqueryd.rete.messages;

import hu.bme.mit.incqueryd.rete.dataunits.ChangeSet;
import hu.bme.mit.incqueryd.rete.dataunits.ReteNodeSlot;

import java.io.Serializable;

import scala.collection.immutable.Stack;
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
		return "UpdateMessage [changeSet=" + changeSet.getChangeType() + ", " + changeSet.getTuples() + ", nodeSlot="
				+ nodeSlot + ", senderStack=" + senderStack + "]";
	}

	@Override
    public boolean equals(final Object o) {
        if (!(o instanceof UpdateMessage))
            return false;
        final UpdateMessage updateMessage = (UpdateMessage) o;

        // comparing fields
        return getChangeSet().equals(updateMessage.getChangeSet()) //
        		&& getNodeSlot().equals(updateMessage.getNodeSlot()) //
        		&& getSenderStack().equals(updateMessage.getSenderStack());
    }
}
