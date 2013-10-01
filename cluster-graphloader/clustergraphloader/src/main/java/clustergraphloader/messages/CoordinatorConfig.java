package clustergraphloader.messages;

import java.io.Serializable;
import java.util.List;

import akka.actor.ActorRef;

/**
 * Class for storing a collection of actors.
 * @author szarnyasg
 *
 */
public class CoordinatorConfig implements Serializable {

	private static final long serialVersionUID = 1L;
	protected final List<ActorRef> actors;
	protected final String fileName;
	protected String cassandraIp;
	
	public CoordinatorConfig(String cassandraIp, List<ActorRef> actors, String fileName) {
		this.cassandraIp = cassandraIp;
		this.actors = actors;
		this.fileName = fileName;
	}
	
	public String getCassandraIp() {
		return cassandraIp;
	}
	
	public List<ActorRef> getActors() {
		return actors;
	}
		
	public String getFileName() {
		return fileName;
	}
	
}
