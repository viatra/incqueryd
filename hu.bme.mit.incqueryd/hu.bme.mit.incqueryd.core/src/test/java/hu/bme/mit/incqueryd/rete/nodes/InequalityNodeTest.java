package hu.bme.mit.incqueryd.rete.nodes;

import hu.bme.mit.incqueryd.rete.dataunits.ChangeSet;
import hu.bme.mit.incqueryd.rete.dataunits.ChangeType;
import hu.bme.mit.incqueryd.rete.dataunits.Tuple;
import hu.bme.mit.incqueryd.util.RecipeDeserializer;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.incquery.runtime.rete.recipes.InequalityFilterRecipe;
import org.eclipse.incquery.runtime.rete.recipes.RecipesFactory;
import org.junit.Test;

/**
 * Test cases for the {@link InequalityNode} class.
 * 
 * @author szarnyasg
 * 
 */
public class InequalityNodeTest extends AlphaNodeTest {
	
	public InequalityNodeTest() {
		super("Inequality");
	}
	
	@Override
	protected AlphaNode createAlphaNode(final String recipeFile) throws IOException {
		final InequalityFilterRecipe recipe = (InequalityFilterRecipe) (RecipeDeserializer.deserializeFromFile(recipeFile));
		final InequalityNode filterNode = new InequalityNode(recipe);
		return filterNode;
	}

	@Override
	@Test
	public void test() {
		//<3462, 3655, 3463, 3631, 3462>
		//<814, 1061, 815, 1077, 1068>
		final InequalityFilterRecipe recipe = RecipesFactory.eINSTANCE.createInequalityFilterRecipe();
		recipe.setSubject(0);
		recipe.getInequals().add(1);
		
		final InequalityNode node = new InequalityNode(recipe);
		final Set<Tuple> tuples = new HashSet<>();
		tuples.add(new Tuple(1, 1));
		tuples.add(new Tuple(1, 2));
		
		final ChangeSet changeSet = new ChangeSet(tuples, ChangeType.POSITIVE);
		final ChangeSet result = node.update(changeSet);
		
		System.out.println(result);
		
	}
	
}
