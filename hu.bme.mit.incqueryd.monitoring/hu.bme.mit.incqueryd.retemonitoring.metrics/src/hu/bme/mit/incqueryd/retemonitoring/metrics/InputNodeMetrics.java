package hu.bme.mit.incqueryd.retemonitoring.metrics;

import java.util.List;

public class InputNodeMetrics extends MemoryNodeMetrics {

	public InputNodeMetrics(String reteNode, String hostName, String processName, String nodeType, String nodeclass,
			String actorPath, int updateMessagesSent, int changesCount, int tuples, double memory, List<ReteSubscriber> subscribers, String typeName) {
		super(reteNode, hostName, processName, nodeType, nodeclass, actorPath, updateMessagesSent, changesCount, memory, subscribers);
		this.tuples = tuples;
		this.typeName = typeName;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int tuples;
	private String typeName;
	
	public int getTuples() {
		return tuples;
	}
	
	public String getTypeName() {
		return typeName;
	}
	
	public String toString() {
		return super.toString() + ", Tuples: " + tuples;
	}
	
	public boolean shouldAlarm(InputNodeMetrics metrics, double percent) {
		return super.shouldAlarm(metrics, percent);
	}

}
