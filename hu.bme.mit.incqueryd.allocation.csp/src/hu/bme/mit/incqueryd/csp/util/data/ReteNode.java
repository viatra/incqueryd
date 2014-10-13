package hu.bme.mit.incqueryd.csp.util.data;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.incquery.runtime.rete.recipes.ReteNodeRecipe;

public class ReteNode {
	
	protected ReteNodeRecipe reteNode;
	protected List<ReteEdge> parents = new ArrayList<>();
	protected boolean validData;
	protected int rawData;
	
	public ReteNode(ReteNodeRecipe reteNode, int rawData) {
		this.reteNode = reteNode;
		this.rawData = rawData;
	}
	
	public ReteNodeRecipe getReteNode() {
		return reteNode;
	}
	
	public void createEdge (ReteNode parent, int weight) {
		parents.add(new ReteEdge(parent, weight));
	}
	
	public int getRawData() {
		return rawData;
	}
	
	public void setRawData(int rawData) {
		this.rawData = rawData;
	}

}
