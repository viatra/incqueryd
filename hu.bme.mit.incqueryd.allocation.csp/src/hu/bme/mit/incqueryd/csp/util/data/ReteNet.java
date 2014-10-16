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

		createNodes();
		createEdges();

	}
	
	private void createNodes() {
		EList<ReteNodeRecipe> recipeNodes = recipe.getRecipeNodes();

		for (ReteNodeRecipe reteNodeRecipe : recipeNodes) {
			if (reteNodeRecipe instanceof TypeInputRecipe) {
				Long memoryStats = inputStats.get(((TypeInputRecipe) reteNodeRecipe).getTypeName());
				
			}
			else if (reteNodeRecipe instanceof BetaRecipe || reteNodeRecipe instanceof ProductionRecipe ) {
				
				
			} else {
				
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
				

				
			} else if (reteNodeRecipe instanceof AlphaRecipe) {
				ReteNodeRecipe parent = ((AlphaRecipe) reteNodeRecipe).getParent();
				
				ReteNode parentNode = getReteNodeById(ArchUtil.getJsonEObjectUri(parent));
				
				
			} else if (reteNodeRecipe instanceof MultiParentNodeRecipe) {
				MultiParentNodeRecipe multiParentNodeRecipe = ((MultiParentNodeRecipe) reteNodeRecipe);
				EList<ReteNodeRecipe> parents = multiParentNodeRecipe.getParents();
				
				for (ReteNodeRecipe parent : parents) {
					ReteNode parentNode = getReteNodeById(ArchUtil.getJsonEObjectUri(parent));
					
				}
			}
		}
		
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
}
