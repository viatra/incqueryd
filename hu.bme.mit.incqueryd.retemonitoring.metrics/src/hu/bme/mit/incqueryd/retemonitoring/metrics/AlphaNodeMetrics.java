package hu.bme.mit.incqueryd.retemonitoring.metrics;

import java.util.List;


public class AlphaNodeMetrics extends ReteNodeMetrics {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public AlphaNodeMetrics(String reteNode, String hostName, String processName, String nodeType, String nodeclass,
			String actorPath, int updateMessagesSent, int changesCount, List<ReteSubscriber> subscribers) {
		super(reteNode, hostName, processName, nodeType, nodeclass, actorPath, updateMessagesSent, changesCount, subscribers);
	}
	
	public String toString() {
		return super.toString();
	}
	
	public boolean shouldAlarm(AlphaNodeMetrics metrics, double percent) {
		return super.shouldAlarm(metrics, percent);
	}

}
