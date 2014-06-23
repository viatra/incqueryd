package hu.bme.mit.incqueryd.retemonitoring.metrics;

import java.util.List;

public class InputNodeMetrics extends ReteNodeMetrics {

	public InputNodeMetrics(String reteNode, String hostName, String nodeType, String nodeclass,
			String actorPath, int updateMessagesSent, int changesCount, int tuples, List<ReteSubscriber> subscribers) {
		super(reteNode, hostName, nodeType, nodeclass, actorPath, updateMessagesSent, changesCount, subscribers);
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

}
