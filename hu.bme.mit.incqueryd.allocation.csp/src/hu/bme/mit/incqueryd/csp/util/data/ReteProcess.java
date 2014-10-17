package hu.bme.mit.incqueryd.csp.util.data;

import java.util.ArrayList;
import java.util.List;

public class ReteProcess {
	
	private int id;
	private int memory;
	private List<ReteNode> reteNodes = new ArrayList<>();
	
	public ReteProcess(int id, int memory, ReteNode node) {
		this.id = id;
		this.memory = memory;
		reteNodes.add(node);
		node.setProcessId(this.id);
	}
	
	public void addNode(ReteNode node) {
		reteNodes.add(0, node);
		node.setProcessId(this.id);
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
	
	public void print() {
		System.out.println("Process " + id + " begins");
		for (ReteNode reteNode : reteNodes) {
			reteNode.print();
			System.out.println();
		}
		System.out.println("Process " + id + " over");
	}
}
