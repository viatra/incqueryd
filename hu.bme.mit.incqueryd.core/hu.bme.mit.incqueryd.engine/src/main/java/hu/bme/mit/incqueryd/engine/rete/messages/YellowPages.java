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
import java.util.Map;

import akka.actor.ActorRef;

public class YellowPages implements Serializable {

	private static final long serialVersionUID = 1L;
	
	final Map<String, ActorRef> emfUriToActorRef;
	protected final ActorRef monitoringServerAddress;
	
	public YellowPages(final Map<String, ActorRef> emfUriToActorRef, final ActorRef monitoringServerAddress) {
		this.emfUriToActorRef = emfUriToActorRef;
		this.monitoringServerAddress = monitoringServerAddress;
	}
	
	public Map<String, ActorRef> getEmfUriToActorRef() {
		return emfUriToActorRef;
	}
	
	public ActorRef getMonitoringServerAddress() {
		return monitoringServerAddress;
	}
	
}
