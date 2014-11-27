/*******************************************************************************
 * Copyright (c) 2010-2014, Gabor Szarnyas, Istvan Rath and Daniel Varro
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Gabor Szarnyas - initial API and implementation
 *******************************************************************************/
package hu.bme.mit.incqueryd.engine.rete.messages;

import hu.bme.mit.incqueryd.engine.rete.dataunits.ChangeSet;
import hu.bme.mit.incqueryd.engine.rete.dataunits.ReteNodeSlot;
import scala.collection.immutable.Stack;
import akka.actor.ActorRef;

/**
 * 
 * @author szarnyasg
 * 
 */
public class UpdateMessage extends ReteCommunicationMessage {

	private static final long serialVersionUID = 1L;

	protected ChangeSet changeSet;
	protected ReteNodeSlot nodeSlot;
	protected ActorRef target;
	
	public UpdateMessage(final ChangeSet changeSet, final ReteNodeSlot nodeSlot, final Stack<ActorRef> route) {
		super(route);
		
		this.changeSet = changeSet;
		this.nodeSlot = nodeSlot;
	}

	public UpdateMessage(final ChangeSet changeSet, final ReteNodeSlot nodeSlot, final Stack<ActorRef> route, final ActorRef target) {
		super(route);
		
		this.changeSet = changeSet;
		this.nodeSlot = nodeSlot;
		this.target = target;
	}
	
	public ActorRef getTarget() {
		return target;
	}
	
	public ChangeSet getChangeSet() {
		return changeSet;
	}

	public ReteNodeSlot getNodeSlot() {
		return nodeSlot;
	}

	@Override
	public String toString() {
		return "UpdateMessage [changeSet=" + changeSet.getChangeType() + ", " + changeSet.getTuples() + ", nodeSlot="
				+ nodeSlot + ", route=" + route + "]";
	}

	@Override
    public boolean equals(final Object o) {
        if (!(o instanceof UpdateMessage))
            return false;
        final UpdateMessage updateMessage = (UpdateMessage) o;

        // comparing fields
        return getChangeSet().equals(updateMessage.getChangeSet()) //
        		&& getNodeSlot().equals(updateMessage.getNodeSlot()) //
        		&& getRoute().equals(updateMessage.getRoute());
    }
}
