package hu.bme.mit.incqueryd.retemonitoring.metrics;

import java.io.Serializable;

public class ReteNodeMetrics implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String reteNode;
	private String hostName;
	private String nodeType;
	
	private int updateMessagesSent;
	private int changesCount;
	
	public ReteNodeMetrics(String reteNode, String hostName, String nodeType,
			int updateMessagesSent, int changesCount) {
		super();
		this.reteNode = reteNode;
		this.hostName = hostName;
		this.nodeType = nodeType;
		this.updateMessagesSent = updateMessagesSent;
		this.changesCount = changesCount;
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
		return "Node: " + reteNode + ", Type: " + nodeType + ", Host:" + hostName + ", UpdateMessages: " + updateMessagesSent + ", Changes: " + changesCount;
	}
}
