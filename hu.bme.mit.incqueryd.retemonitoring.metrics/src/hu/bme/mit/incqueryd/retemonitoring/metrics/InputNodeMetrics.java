package hu.bme.mit.incqueryd.retemonitoring.metrics;

public class InputNodeMetrics extends ReteNodeMetrics {

	public InputNodeMetrics(String reteNode, String hostName,
			int updateMessagesSent, int changesCount, int tuples) {
		super(reteNode, hostName, updateMessagesSent, changesCount);
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

}
