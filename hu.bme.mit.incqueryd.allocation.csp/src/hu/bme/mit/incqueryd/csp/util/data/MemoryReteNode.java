package hu.bme.mit.incqueryd.csp.util.data;

import org.eclipse.incquery.runtime.rete.recipes.ReteNodeRecipe;


public abstract class MemoryReteNode extends ReteNode {
	
	protected int memory;

	public MemoryReteNode(ReteNodeRecipe node) {
		super(node);
	}
	
	public int getMemory() {
		return memory;
	}
	
	public void setMemory(int memory) {
		this.memory = memory;
	}

}
