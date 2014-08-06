package hu.bme.mit.incqueryd.osmonitoringagent.core;

import akka.japi.Creator;

public class OSMonitorCreator implements Creator<OSMonitor> {

	protected OSMonitor monitor;
	
	@Override
	public OSMonitor create() throws Exception {
		monitor = new OSMonitor();
		return monitor;
	}
	
	public OSMonitor getMonitor() {
		return monitor;
	}

}
