package hu.bme.mit.incqueryd.rete.nodes;

import hu.bme.mit.incqueryd.util.ReteNodeConfiguration;

import org.apache.commons.lang.NotImplementedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.incquery.runtime.rete.recipes.BetaRecipe;
import org.eclipse.incquery.runtime.rete.recipes.EqualityFilterRecipe;
import org.eclipse.incquery.runtime.rete.recipes.InequalityFilterRecipe;
import org.eclipse.incquery.runtime.rete.recipes.JoinRecipe;
import org.eclipse.incquery.runtime.rete.recipes.TrimmerRecipe;

public class ReteNodeFactory {

	public static ReteNode createNode(final ReteNodeConfiguration conf, final EObject recipe) {
		switch (conf.getType()) {
		case ANTIJOIN:
			return new AntiJoinNode((BetaRecipe) recipe);
		case EQUALITY:
			return new EqualityNode((EqualityFilterRecipe) recipe);
		case INEQUALITY:
			return new InequalityNode((InequalityFilterRecipe) recipe);
		case JOIN:
			return new JoinNode((JoinRecipe) recipe);
		case TRIMMER:
			return new TrimmerNode((TrimmerRecipe) recipe);
		default:
			throw new NotImplementedException(recipe.getClass().getSimpleName() + " recipe class is not supported.");
		}
	}

}
