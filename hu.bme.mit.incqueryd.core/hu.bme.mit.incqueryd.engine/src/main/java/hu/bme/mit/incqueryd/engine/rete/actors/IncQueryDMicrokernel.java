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
package hu.bme.mit.incqueryd.engine.rete.actors;

import akka.actor.ActorSystem;
import akka.kernel.Bootable;

public class IncQueryDMicrokernel implements Bootable {

	public static final String ACTOR_SYSTEM_NAME = "IncQuery-D";

	private ActorSystem system;

	@Override
	public void startup() {
		system = ActorSystem.create(ACTOR_SYSTEM_NAME);
	}

	@Override
	public void shutdown() {
		system.shutdown();
	}

}