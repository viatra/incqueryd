package hu.bme.mit.incqueryd.retemonitoring.metrics;

public class InputNodeMetrics extends ReteNodeMetrics {

	public InputNodeMetrics(String reteNode, String hostName, String nodeType,
			int updateMessagesSent, int changesCount, int tuples) {
		super(reteNode, hostName, nodeType, updateMessagesSent, changesCount);
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
