package hu.bme.mit.incqueryd.retemonitoring.metrics;


public class BetaNodeMetrics extends ReteNodeMetrics {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int leftIndexerSize;
	private int rightIndexerSize;
	
	public BetaNodeMetrics(String reteNode, String hostName, String nodeType,
			int updateMessagesSent, int changesCount, int leftIndexerSize, int rightIndexerSize) {
		super(reteNode, hostName, nodeType, updateMessagesSent, changesCount);
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
	
}
