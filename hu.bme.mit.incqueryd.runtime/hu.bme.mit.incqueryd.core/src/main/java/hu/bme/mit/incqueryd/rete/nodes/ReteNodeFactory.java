package hu.bme.mit.incqueryd.rete.nodes;

import hu.bme.mit.incqueryd.util.ReteNodeConfiguration;

import java.io.IOException;
import java.util.Collection;

import org.apache.commons.lang.NotImplementedException;
import org.eclipse.incquery.runtime.rete.recipes.AntiJoinRecipe;
import org.eclipse.incquery.runtime.rete.recipes.CheckRecipe;
import org.eclipse.incquery.runtime.rete.recipes.EqualityFilterRecipe;
import org.eclipse.incquery.runtime.rete.recipes.InequalityFilterRecipe;
import org.eclipse.incquery.runtime.rete.recipes.JoinRecipe;
import org.eclipse.incquery.runtime.rete.recipes.ProductionRecipe;
import org.eclipse.incquery.runtime.rete.recipes.ReteNodeRecipe;
import org.eclipse.incquery.runtime.rete.recipes.TrimmerRecipe;
import org.eclipse.incquery.runtime.rete.recipes.UniquenessEnforcerRecipe;

public class ReteNodeFactory {

	/**
	 * Creates a Rete node from a Rete recipe
	 * 
	 * @param recipe
	 * @return An instantiated ReteNode.
	 * @throws IOException 
	 */
	public static ReteNode createNode(final ReteNodeConfiguration conf) throws IOException {		
		final ReteNodeRecipe recipe = conf.getReteNodeRecipe();
		final Collection<String> cacheMachines = conf.getCacheMachines();
		
		if (recipe instanceof AntiJoinRecipe) {
			return new AntiJoinNode((AntiJoinRecipe) recipe);
		} else if (recipe instanceof JoinRecipe) {
			return new JoinNode((JoinRecipe) recipe);
		} else if (recipe instanceof EqualityFilterRecipe) {
			return new EqualityNode((EqualityFilterRecipe) recipe);
		} else if (recipe instanceof InequalityFilterRecipe) {
			return new InequalityNode((InequalityFilterRecipe) recipe);
		} else if (recipe instanceof TrimmerRecipe) {
			return new TrimmerNode((TrimmerRecipe) recipe);
		} else if (recipe instanceof UniquenessEnforcerRecipe) {
			return new InputNode((UniquenessEnforcerRecipe) recipe, cacheMachines);
		} else if (recipe instanceof ProductionRecipe) {
			return new ProductionNode((ProductionRecipe) recipe);
		} else if (recipe instanceof CheckRecipe) {
			return new TermEvaluatorNode((CheckRecipe) recipe);
		}
		else {
			throw new NotImplementedException(recipe.getClass().getSimpleName() + " recipe class is not supported.");
		}
	}

}
