package hu.bme.mit.incqueryd.csp.util.data;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.incquery.runtime.rete.recipes.ReteNodeRecipe;

public class ReteNode {
	
	protected ReteNodeRecipe reteNode;
	
	protected List<ReteEdge> parents = new ArrayList<>();
	
	public ReteNode(ReteNodeRecipe reteNode) {
		this.reteNode = reteNode;
	}
	
	public ReteNodeRecipe getReteNode() {
		return reteNode;
	}
	
	public void createEdge (ReteNode parent, int weight) {
		parents.add(new ReteEdge(parent, weight));
	}

}
