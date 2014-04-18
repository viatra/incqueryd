package clustergraphloader.bootable;

import akka.actor.ActorSystem;
import akka.kernel.Bootable;

import com.typesafe.config.ConfigFactory;

public class RemoteBootable implements Bootable {
	private ActorSystem system;

	public RemoteBootable() {
		system = ActorSystem.create("ClusterGraphLoader", ConfigFactory.load().getConfig("clustergraphloader"));
		System.out.println("ClusterGraphLoader actorsystem initialized.");
	}

	public void startup() {
	}

	public void shutdown() {
		system.shutdown();
	}
}
