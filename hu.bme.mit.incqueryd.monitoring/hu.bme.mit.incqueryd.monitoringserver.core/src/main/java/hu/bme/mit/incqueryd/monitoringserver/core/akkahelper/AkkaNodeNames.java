package hu.bme.mit.incqueryd.monitoringserver.core.akkahelper;

import java.util.ArrayList;
import java.util.List;

public class AkkaNodeNames {

	private List<String> names;
	
	public AkkaNodeNames(){
		names = new ArrayList<String>();
	}
	
	public List<String> getNodeNames(){
		return names;
	}

	public void add(String name) {
		
		names.add(name);
		
	}
	
}
