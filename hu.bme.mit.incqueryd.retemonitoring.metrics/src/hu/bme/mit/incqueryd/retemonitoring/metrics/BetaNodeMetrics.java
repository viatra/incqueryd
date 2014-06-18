package hu.bme.mit.incqueryd.retemonitoring.metrics;


public class BetaNodeMetrics extends ReteNodeMetrics {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int leftIndexerSize;
	private int rightIndexerSize;
	
	public BetaNodeMetrics(String reteNode, String hostName,
			long updateMessagesSent, int leftIndexerSize, int rightIndexerSize) {
		super(reteNode, hostName, updateMessagesSent);
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
	
}
