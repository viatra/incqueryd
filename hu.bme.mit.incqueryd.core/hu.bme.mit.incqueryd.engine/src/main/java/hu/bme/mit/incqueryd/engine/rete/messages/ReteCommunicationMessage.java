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

import java.io.Serializable;

import scala.collection.immutable.Stack;
import akka.actor.ActorRef;

/**
 * 
 * @author szarnyasg
 * 
 */
public abstract class ReteCommunicationMessage implements Serializable {

	private static final long serialVersionUID = 1L;
	protected Stack<ActorRef> route;

	public ReteCommunicationMessage(final Stack<ActorRef> route) {
		super();
		this.route = route;
	}

	public Stack<ActorRef> getRoute() {
		return route;
	}

	@Override
	public boolean equals(final Object o) {
		if (!(o instanceof ReteCommunicationMessage))
			return false;
		final ReteCommunicationMessage readyMessage = (ReteCommunicationMessage) o;
		
		return route.equals(readyMessage.getRoute());
	}
}
