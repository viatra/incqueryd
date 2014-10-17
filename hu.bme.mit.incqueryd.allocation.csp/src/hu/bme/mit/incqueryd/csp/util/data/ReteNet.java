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
	protected List<ReteEdge> reteEdges = new ArrayList<>();

	protected ReteRecipe recipe;
	protected Map<String, Long> inputStats;
	
	protected List<ReteProcess> processes = new ArrayList<>();

	public ReteNet(ReteRecipe recipe, Map<String, Long> inputStats) {
		this.recipe = recipe;
		this.inputStats = inputStats;
	}

	public void create() {

		createNodes(); // 1st phase is creation of nodes
		createEdges(); // 2nd phase is creation of edges
		calculateHeuristicsInTheNet(); // 3rd phase
		createProcesses();

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
				ReteEdge left = betaNode.createLeftParentEdge(leftParentNode);
				ReteEdge right = betaNode.createRightParentEdge(rightParentNode);
				
				reteEdges.add(left);
				reteEdges.add(right);
				
			} else if (reteNodeRecipe instanceof AlphaRecipe) {
				ReteNodeRecipe parent = ((AlphaRecipe) reteNodeRecipe).getParent();
				ReteNode parentNode = getReteNodeById(ArchUtil.getJsonEObjectUri(parent));
				
				AlphaReteNode alphaNode = (AlphaReteNode) node;
				ReteEdge parentEdge = alphaNode.createParentEdge(parentNode);
				
				reteEdges.add(parentEdge);
				
			} else if (reteNodeRecipe instanceof ProductionRecipe) {
				ProductionRecipe productionNodeRecipe = ((ProductionRecipe) reteNodeRecipe);
				EList<ReteNodeRecipe> parents = productionNodeRecipe.getParents();
				ProductionReteNode prodNode = (ProductionReteNode) node;
				for (ReteNodeRecipe parent : parents) {
					ReteNode parentNode = getReteNodeById(ArchUtil.getJsonEObjectUri(parent));
					ReteEdge parentEdge = prodNode.createParentEdge(parentNode);
					
					reteEdges.add(parentEdge);
				}
				
			}
			else if (reteNodeRecipe instanceof MultiParentNodeRecipe) {
				MultiParentNodeRecipe multiParentNodeRecipe = ((MultiParentNodeRecipe) reteNodeRecipe);
				EList<ReteNodeRecipe> parents = multiParentNodeRecipe.getParents();
				MultiParentReteNode multiNode = (MultiParentReteNode) node;
				for (ReteNodeRecipe parent : parents) {
					ReteNode parentNode = getReteNodeById(ArchUtil.getJsonEObjectUri(parent));
					ReteEdge parentEdge = multiNode.createParentEdge(parentNode);
					
					reteEdges.add(parentEdge);
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
	
	
	private void createProcesses() {
		List<ReteNode> remainingNodes = new ArrayList<>();
		
		int id = 0;
		for (ReteNode reteNode : reteNodes) {
			if (reteNode instanceof BetaReteNode) {
				BetaReteNode betaNode = (BetaReteNode) reteNode;
				ReteProcess reteProcess = new ReteProcess(++id, betaNode.getMemory(), betaNode);
				processes.add(reteProcess);
			}
			else if (reteNode instanceof InputReteNode) {
				InputReteNode inputNode = (InputReteNode) reteNode;
				ReteProcess reteProcess = new ReteProcess(++id, inputNode.getMemory(), inputNode);
				processes.add(reteProcess);
			}
			else if (reteNode instanceof ProductionReteNode) {
				ProductionReteNode productionNode = (ProductionReteNode) reteNode;
				ReteProcess reteProcess = new ReteProcess(++id, productionNode.getMemory(), productionNode);
				processes.add(reteProcess);
			}
			else {
				remainingNodes.add(reteNode);
			}
		}
		
		do {
			
		}while(!remainingNodes.isEmpty());
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
