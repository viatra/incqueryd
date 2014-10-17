package hu.bme.mit.incqueryd.csp.util.data;

import hu.bme.mit.incqueryd.arch.util.ArchUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.incquery.runtime.rete.recipes.AlphaRecipe;
import org.eclipse.incquery.runtime.rete.recipes.BetaRecipe;
import org.eclipse.incquery.runtime.rete.recipes.MultiParentNodeRecipe;
import org.eclipse.incquery.runtime.rete.recipes.ProductionRecipe;
import org.eclipse.incquery.runtime.rete.recipes.ReteNodeRecipe;
import org.eclipse.incquery.runtime.rete.recipes.ReteRecipe;
import org.eclipse.incquery.runtime.rete.recipes.TypeInputRecipe;

public class ReteNet {

	protected List<ReteNode> reteNodes = new ArrayList<>();

	protected ReteRecipe recipe;
	protected Map<String, Long> inputStats;

	public ReteNet(ReteRecipe recipe, Map<String, Long> inputStats) {
		this.recipe = recipe;
		this.inputStats = inputStats;
	}

	public void create() {

		createNodes(); // 1st phase is creation of nodes
		createEdges(); // 2nd phase is creation of edges
		calculateHeuristicsInTheNet(); // 3rd phase

	}
	
	private void createNodes() {
		EList<ReteNodeRecipe> recipeNodes = recipe.getRecipeNodes();

		for (ReteNodeRecipe reteNodeRecipe : recipeNodes) {
			if (reteNodeRecipe instanceof TypeInputRecipe) {
				String typeName = ((TypeInputRecipe) reteNodeRecipe).getTypeName();
				Long tuples = inputStats.get(typeName + "_size");
				Long arity = inputStats.get(typeName + "_arity");
				
				InputReteNode node = new InputReteNode(reteNodeRecipe, tuples.intValue(), arity.intValue());
				reteNodes.add(node);
			}
			else if (reteNodeRecipe instanceof BetaRecipe) {
				BetaRecipe recipe = (BetaRecipe) reteNodeRecipe;
				reteNodes.add(new BetaReteNode(recipe));
			}
			else if (reteNodeRecipe instanceof ProductionRecipe ) {
				reteNodes.add(new ProductionReteNode(reteNodeRecipe));
			}
			else if (reteNodeRecipe instanceof MultiParentNodeRecipe) {
				reteNodes.add(new MultiParentReteNode(reteNodeRecipe));
			}
			else {
				reteNodes.add(new AlphaReteNode(reteNodeRecipe));
			}
		}
	}
	
	private void createEdges() {
		
		for (ReteNode node : reteNodes) {
			ReteNodeRecipe reteNodeRecipe = node.getReteNode();
			
			if (reteNodeRecipe instanceof BetaRecipe) {
				BetaRecipe betaRecipe = (BetaRecipe) reteNodeRecipe;
				ReteNodeRecipe leftParent = betaRecipe.getLeftParent().getParent();
				ReteNodeRecipe rightParent = betaRecipe.getRightParent().getParent();
				
				ReteNode leftParentNode = getReteNodeById(ArchUtil.getJsonEObjectUri(leftParent));
				ReteNode rightParentNode = getReteNodeById(ArchUtil.getJsonEObjectUri(rightParent));
				
				BetaReteNode betaNode = (BetaReteNode) node;
				betaNode.createLeftParentEdge(leftParentNode);
				betaNode.createRightParentEdge(rightParentNode);
				
			} else if (reteNodeRecipe instanceof AlphaRecipe) {
				ReteNodeRecipe parent = ((AlphaRecipe) reteNodeRecipe).getParent();
				ReteNode parentNode = getReteNodeById(ArchUtil.getJsonEObjectUri(parent));
				
				AlphaReteNode alphaNode = (AlphaReteNode) node;
				alphaNode.createParentEdge(parentNode);
				
			} else if (reteNodeRecipe instanceof ProductionRecipe) {
				ProductionRecipe productionNodeRecipe = ((ProductionRecipe) reteNodeRecipe);
				EList<ReteNodeRecipe> parents = productionNodeRecipe.getParents();
				ProductionReteNode prodNode = (ProductionReteNode) node;
				for (ReteNodeRecipe parent : parents) {
					ReteNode parentNode = getReteNodeById(ArchUtil.getJsonEObjectUri(parent));
					prodNode.createParentEdge(parentNode);
				}
				
			}
			else if (reteNodeRecipe instanceof MultiParentNodeRecipe) {
				MultiParentNodeRecipe multiParentNodeRecipe = ((MultiParentNodeRecipe) reteNodeRecipe);
				EList<ReteNodeRecipe> parents = multiParentNodeRecipe.getParents();
				MultiParentReteNode multiNode = (MultiParentReteNode) node;
				for (ReteNodeRecipe parent : parents) {
					ReteNode parentNode = getReteNodeById(ArchUtil.getJsonEObjectUri(parent));
					multiNode.createParentEdge(parentNode);
				}
			}
		}
		
	}

	
	private void calculateHeuristicsInTheNet() {
		List<ReteNode> notReadyNodes = new ArrayList<>();
		
		for (ReteNode reteNode : reteNodes) {
			boolean isReady = reteNode.calculateHeuristics();
			if(!isReady) {
				notReadyNodes.add(reteNode);
			}
		}
		
		do {
			List<ReteNode> readyNodes = new ArrayList<>();
			for (ReteNode reteNode : notReadyNodes) {
				boolean isReady = reteNode.calculateHeuristics();
				if(isReady) readyNodes.add(reteNode);
			}
			
			for (ReteNode readyNode : readyNodes) {
				notReadyNodes.remove(readyNode);
			}
			
			readyNodes.clear();
		}while(!notReadyNodes.isEmpty());
	}
	
	
	//Private helper methods
	private ReteNode getReteNodeById(String id) {
		for (ReteNode node : reteNodes) {
			if(ArchUtil.getJsonEObjectUri(node.getReteNode()) == id) {
				return node;
			}
		}
		
		return null;
	}
	
	public void print() {
		for (ReteNode node : reteNodes) {
			node.print();
			System.out.println();
		}
	}
}
