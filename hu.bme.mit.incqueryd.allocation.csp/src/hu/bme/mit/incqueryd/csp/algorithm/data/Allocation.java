package hu.bme.mit.incqueryd.csp.algorithm.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Allocation {
	
	private Map<String, List<Node>> allocations = new HashMap<>();
	private long cost;
	private long communication;
	
	public void addNode(String container, Node node){
		List<Node> nodesOfContainer = allocations.get(container);
		
		if(nodesOfContainer == null){
			nodesOfContainer = new ArrayList<Node>();
			nodesOfContainer.add(node);
			allocations.put(container, nodesOfContainer);
		}
		else{
			nodesOfContainer.add(node);
		}
	}
	
	public Map<String, List<Node>> getAllocations() {
		return allocations;
	}
	
	@Override
	public String toString() {
		StringBuilder response = new StringBuilder();
		for (String container : allocations.keySet()) {
			response.append(container + ": ");
			for (Node node : allocations.get(container)) {
				response.append(node.getName() + ", ");
			}
			response.append("\n");
		}
		response.append("cost: " + cost);
		response.append("\n");
		response.append("communication: " + communication);
		return response.toString();
	}
	
	public long getCost() {
		return cost;
	}
	
	public long getCommunication() {
		return communication;
	}
	
	public void setCost(long cost) {
		this.cost = cost;
	}
	
	public void setCommunication(long communication) {
		this.communication = communication;
	}

}
