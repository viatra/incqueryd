/**
 *  Copyright (C) 2009-2013 Typesafe Inc. <http://www.typesafe.com>
 */
package distributed.rete.bootable;

import akka.actor.ActorSystem;
import akka.kernel.Bootable;

import com.typesafe.config.ConfigFactory;

public class RemoteBootable implements Bootable {
	private ActorSystem system;

	public RemoteBootable() {
		system = ActorSystem.create("ReteNet", ConfigFactory.load().getConfig("calculator"));
		System.out.println("ReteNet actorsystem initialized.");
	}

	public void startup() {
	}

	public void shutdown() {
		system.shutdown();
	}
}
