package hu.bme.mit.incqueryd.retemonitoring.metrics;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import akka.actor.ActorRef;

public class MonitoredActorCollection implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<ActorRef> actorRefs;
	
	public MonitoredActorCollection(Collection<ActorRef> actorRefs) {
		this.actorRefs = new ArrayList<>(actorRefs);
	}
	
	public List<ActorRef> getActorRefs() {
		return actorRefs;
	}
}
