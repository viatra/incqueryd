package hu.bme.mit.incqueryd.rete.nodes;

import org.apache.commons.lang.NotImplementedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.incquery.runtime.rete.recipes.AntiJoinRecipe;
import org.eclipse.incquery.runtime.rete.recipes.EqualityFilterRecipe;
import org.eclipse.incquery.runtime.rete.recipes.InequalityFilterRecipe;
import org.eclipse.incquery.runtime.rete.recipes.JoinRecipe;
import org.eclipse.incquery.runtime.rete.recipes.TrimmerRecipe;

public class ReteNodeFactory {

	/**
	 * Creates a rete node from a Rete recipe
	 * @param recipe
	 * @return
	 */
	public static ReteNode createNode(final EObject recipe) {
//		switch (conf.getType()) {
//		case ANTIJOIN:
//			return new AntiJoinNode((AntiJoinRecipe) recipe);
//		case EQUALITY:
//			return new EqualityNode((EqualityFilterRecipe) recipe);
//		case INEQUALITY:
//			return new InequalityNode((InequalityFilterRecipe) recipe);
//		case JOIN:
//			return new JoinNode((JoinRecipe) recipe);
//		case TRIMMER:
//			return new TrimmerNode((TrimmerRecipe) recipe);
//		default:
//			throw new NotImplementedException(recipe.getClass().getSimpleName() + " recipe class is not supported.");
//		}
		
		System.out.println("hello");
		if (recipe instanceof AntiJoinRecipe) {
			System.out.println("x");
			return new AntiJoinNode((AntiJoinRecipe) recipe);
		} else if (recipe instanceof JoinRecipe) {
			System.out.println("y");
			return new JoinNode((JoinRecipe) recipe);
		} else if (recipe instanceof EqualityFilterRecipe) {
			return new EqualityNode((EqualityFilterRecipe) recipe);
		} else if (recipe instanceof InequalityFilterRecipe) {
			return new InequalityNode((InequalityFilterRecipe) recipe);
		} else if (recipe instanceof TrimmerRecipe) {
			return new TrimmerNode((TrimmerRecipe) recipe);
		} else {
			throw new NotImplementedException(recipe.getClass().getSimpleName() + " recipe class is not supported.");
		}
		
	}

}
