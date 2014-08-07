package hu.bme.mit.incqueryd.rete.actors;

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