package hu.bme.mit.incqueryd.rete.actors;

import akka.actor.ActorSystem;
import akka.kernel.Bootable;

import com.typesafe.config.ConfigFactory;

public class IncQueryDMicrokernel implements Bootable {

	public static final String ACTOR_SYSTEM_NAME = "IncQuery-D";

	private ActorSystem system;

	@Override
	public void startup() {
		system = ActorSystem.create(ACTOR_SYSTEM_NAME, ConfigFactory.parseString(
				"akka.actor.provider = akka.remote.RemoteActorRefProvider\n" +
				"akka.remote.netty.hostname = \"" + System.getenv("localHost") + "\"\n" + 
				"akka.remote.netty.message-frame-size = 10000000000"));
	}

	@Override
	public void shutdown() {
		system.shutdown();
	}

}