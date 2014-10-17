package hu.bme.mit.incqueryd.csp.util.data;

import java.util.ArrayList;
import java.util.List;

public class ReteProcess {
	
	private int id;
	private int memory;
	private List<ReteNode> reteNodes = new ArrayList<>();
	
	public ReteProcess(int id, int memory) {
		this.id = id;
		this.memory = memory;
	}
	
	public void addNode(ReteNode node) {
		reteNodes.add(0, node);
	}
	
	public boolean contains(ReteNode node) {
		return reteNodes.contains(node);
	}

	public int getMemory() {
		return memory;
	}
	
	public int getId() {
		return id;
	}
}