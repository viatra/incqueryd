package hu.bme.mit.incqueryd.retemonitoring.metrics;

import java.io.Serializable;
import java.util.List;

public class ReteNodeMetrics implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String reteNode;
	private String hostName;
	private String nodeType;
	private String nodeClass;
	private String actorPath;
	
	private int updateMessagesSent;
	private int changesCount;
	
	private List<ReteSubscriber> subscribers;
	
	public ReteNodeMetrics(String reteNode, String hostName, String nodeType, String nodeclass,
			String actorPath, int updateMessagesSent, int changesCount, List<ReteSubscriber> subscribers) {
		super();
		this.reteNode = reteNode;
		this.hostName = hostName;
		this.nodeType = nodeType;
		this.updateMessagesSent = updateMessagesSent;
		this.changesCount = changesCount;
		this.nodeClass = nodeclass;
		this.actorPath = actorPath;
		this.subscribers = subscribers;
	}

	public String getReteNode() {
		return reteNode;
	}
	
	public int getUpdateMessagesSent() {
		return updateMessagesSent;
	}
	
	public void setReteNode(String reteNode) {
		this.reteNode = reteNode;
	}
	
	public void setUpdateMessagesSent(int updateMessagesSent) {
		this.updateMessagesSent = updateMessagesSent;
	}
	
	public String getHostName() {
		return hostName;
	}
	
	public void setHostName(String hostName) {
		this.hostName = hostName;
	}
	
	public int getChangesCount() {
		return changesCount;
	}
	
	public void setChangesCount(int changesCount) {
		this.changesCount = changesCount;
	}
	
	public String getNodeType() {
		return nodeType;
	}
	
	public String toString() {
		String str = "Node: " + reteNode + ", Type: " + nodeType + ", Class: " + nodeClass + ", Actor: " + actorPath + ", Host: " + hostName + ", UpdateMessages: " + updateMessagesSent + ", Changes: " + changesCount;
		for(ReteSubscriber subscriber: subscribers) {
			str += "\n\t - " + subscriber.getReteNode() + " : " + subscriber.getSlot();
		}
		return str;
	}
}
