package hu.bme.mit.incqueryd.retemonitoring.metrics;

import java.util.List;


public class BetaNodeMetrics extends MemoryNodeMetrics {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int leftIndexerSize;
	private int rightIndexerSize;
	
	public BetaNodeMetrics(String reteNode, String hostName, String processName, String nodeType, String nodeclass,
			String actorPath, int updateMessagesSent, int changesCount, int leftIndexerSize, int rightIndexerSize, double memory, List<ReteSubscriber> subscribers) {
		super(reteNode, hostName, processName, nodeType, nodeclass, actorPath, updateMessagesSent, changesCount, memory, subscribers);
		this.leftIndexerSize = leftIndexerSize;
		this.rightIndexerSize = rightIndexerSize;
	}

	public int getLeftIndexerSize() {
		return leftIndexerSize;
	}
	
	public int getRightIndexerSize() {
		return rightIndexerSize;
	}
	
	public void setLeftIndexerSize(int leftSize) {
		this.leftIndexerSize = leftSize;
	}
	
	public void setRightIndexerSize(int rightSize) {
		this.rightIndexerSize = rightSize;
	}
	
	public String toString() {
		return super.toString() + ", Primary indexer: " + leftIndexerSize + ", Secondary indexer: " + rightIndexerSize;
	}
	
	public boolean shouldAlarm(BetaNodeMetrics metrics, double percent) {
		return super.shouldAlarm(metrics, percent);
	}
	
}
