package hu.bme.mit.incqueryd.csp.util.data;

import org.eclipse.incquery.runtime.rete.recipes.ReteNodeRecipe;

public class MemoryReteNode extends ReteNode {
	
	protected int memory;
	protected int rawData;

	public MemoryReteNode(ReteNodeRecipe reteNode, int raw) {
		super(reteNode);
		this.rawData = raw;
		memory = 1000;
	}
	
	public int getMemory() {
		return memory;
	}
	
	public void setMemory(int memory) {
		this.memory = memory;
	}

	public int getRawData() {
		return rawData;
	}
	
	public void setRawData(int rawData) {
		this.rawData = rawData;
	}
}
