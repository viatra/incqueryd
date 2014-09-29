package hu.bme.mit.incqueryd.fourstore;

import hu.bme.mit.incqueryd.arch.util.ArchUtil;

import java.io.IOException;

import org.eclipse.incquery.runtime.rete.recipes.ConstantRecipe;
import org.eclipse.incquery.runtime.rete.recipes.ReteNodeRecipe;
import org.eclipse.incquery.runtime.rete.recipes.ReteRecipe;

public class RecipeTest {
	public static void main(String[] args) throws IOException {
		
		String recipePath = "/home/szarnyasg/git/incqueryd/hu.bme.mit.incqueryd.queries/recipes/debug.recipe";
		
		ReteRecipe recipeFile = ArchUtil.loadRecipe(recipePath);
		
		for (ReteNodeRecipe recipe : recipeFile.getRecipeNodes() ) {
			if (recipe instanceof ConstantRecipe) {
				ConstantRecipe constantNode = (ConstantRecipe) recipe;
				System.out.println(constantNode.getConstantValues());
			}
		}
		
		
	}
}
