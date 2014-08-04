package hu.bme.mit.incqueryd.retemonitoring.metrics;

import java.util.List;

public class InputNodeMetrics extends MemoryNodeMetrics {

	public InputNodeMetrics(String reteNode, String hostName, String nodeType, String nodeclass,
			String actorPath, int updateMessagesSent, int changesCount, int tuples, double memory, List<ReteSubscriber> subscribers) {
		super(reteNode, hostName, nodeType, nodeclass, actorPath, updateMessagesSent, changesCount, memory, subscribers);
		this.tuples = tuples;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int tuples;
	
	public int getTuples() {
		return tuples;
	}
	
	public String toString() {
		return super.toString() + ", Tuples: " + tuples;
	}
	
	public boolean shouldAlarm(InputNodeMetrics metrics, double percent) {
		return super.shouldAlarm(metrics, percent);
	}

}
