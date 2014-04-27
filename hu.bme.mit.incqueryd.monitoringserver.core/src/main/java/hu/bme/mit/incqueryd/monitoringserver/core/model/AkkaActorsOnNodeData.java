package hu.bme.mit.incqueryd.monitoringserver.core.model;

import java.util.ArrayList;
import java.util.List;

public class AkkaActorsOnNodeData {

	private List<AkkaActorMonitoringData> actors;
	
	public AkkaActorsOnNodeData() {
		actors = new ArrayList<AkkaActorMonitoringData>();
	}
	
	public List<AkkaActorMonitoringData> getActors() {
		return actors;
	}
	
	public void addActor(AkkaActorMonitoringData actorData) {
		actors.add(actorData);
	}
	
	public void setNode(String node) {
		for (AkkaActorMonitoringData actor : actors) {
			actor.setNode(node);
		}
	}
}
