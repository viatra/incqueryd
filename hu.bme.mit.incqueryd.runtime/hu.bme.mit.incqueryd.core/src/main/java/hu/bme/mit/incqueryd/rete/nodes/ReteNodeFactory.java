package hu.bme.mit.incqueryd.rete.nodes;

import hu.bme.mit.incqueryd.util.ReteNodeConfiguration;

import java.io.IOException;
import java.util.List;

import org.apache.commons.lang.NotImplementedException;
import org.eclipse.incquery.runtime.rete.recipes.AntiJoinRecipe;
import org.eclipse.incquery.runtime.rete.recipes.CheckRecipe;
import org.eclipse.incquery.runtime.rete.recipes.EqualityFilterRecipe;
import org.eclipse.incquery.runtime.rete.recipes.InequalityFilterRecipe;
import org.eclipse.incquery.runtime.rete.recipes.JoinRecipe;
import org.eclipse.incquery.runtime.rete.recipes.ProductionRecipe;
import org.eclipse.incquery.runtime.rete.recipes.ReteNodeRecipe;
import org.eclipse.incquery.runtime.rete.recipes.TrimmerRecipe;
import org.eclipse.incquery.runtime.rete.recipes.TypeInputRecipe;

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
		final List<String> cacheMachineIps = conf.getCacheMachineIps();

		if (recipe instanceof AntiJoinRecipe) {
			return new AntiJoinNode((AntiJoinRecipe) recipe, cacheMachineIps);
		} else if (recipe instanceof JoinRecipe) {
			return new JoinNode((JoinRecipe) recipe, cacheMachineIps);
		} else if (recipe instanceof EqualityFilterRecipe) {
			return new EqualityNode((EqualityFilterRecipe) recipe);
		} else if (recipe instanceof InequalityFilterRecipe) {
			return new InequalityNode((InequalityFilterRecipe) recipe);
		} else if (recipe instanceof TrimmerRecipe) {
			return new TrimmerNode((TrimmerRecipe) recipe);
		} else if (recipe instanceof TypeInputRecipe) {
			return new InputNode((TypeInputRecipe) recipe, cacheMachineIps, conf.getConnectionString());
		} else if (recipe instanceof ProductionRecipe) {
			return new ProductionNode((ProductionRecipe) recipe);
		} else if (recipe instanceof CheckRecipe) {
			return new CheckNode((CheckRecipe) recipe);
		} else {
			throw new NotImplementedException(recipe.getClass().getSimpleName() + " recipe class is not supported.");
		}
	}

}
