package hu.bme.mit.incqueryd.retemonitoring.metrics;

import java.util.List;

public class MemoryNodeMetrics extends ReteNodeMetrics {
	
	private double memory;

	public MemoryNodeMetrics(String reteNode, String hostName, String nodeType,
			String nodeclass, String actorPath, int updateMessagesSent,
			int changesCount, double memory, List<ReteSubscriber> subscribers) {
		super(reteNode, hostName, nodeType, nodeclass, actorPath, updateMessagesSent,
				changesCount, subscribers);
		this.memory = memory;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public double getMemory() {
		return memory;
	}
	
	public void setMemory(double memory) {
		this.memory = memory;
	}
	
	public String toString() {
		return super.toString() + ", Memory: " + memory;
	}

}
