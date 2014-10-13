package hu.bme.mit.incqueryd.stats;

import hu.bme.mit.bigmodel.fourstore.FourStoreDriverCrud;
import hu.bme.mit.incqueryd.arch.util.ArchUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.cli.ParseException;
import org.eclipse.incquery.runtime.rete.recipes.BinaryInputRecipe;
import org.eclipse.incquery.runtime.rete.recipes.ReteNodeRecipe;
import org.eclipse.incquery.runtime.rete.recipes.ReteRecipe;
import org.eclipse.incquery.runtime.rete.recipes.TypeInputRecipe;
import org.eclipse.incquery.runtime.rete.recipes.UnaryInputRecipe;

public class StatsMain {

	public static void main(final String[] args) throws ParseException, IOException {
		StatsConfiguration statsConfiguration = new StatsConfiguration(args);
		String recipeFile = statsConfiguration.getRecipe();
		String statsFile = statsConfiguration.getStats();

		Map<String, Long> stats = new HashMap<>();

		FourStoreDriverCrud driver = new FourStoreDriverCrud("trainbenchmark_cluster", false);
		ReteRecipe rr = ArchUtil.loadRecipe(recipeFile);
		for (ReteNodeRecipe recipe : rr.getRecipeNodes()) {
			if (recipe instanceof TypeInputRecipe) {
				final TypeInputRecipe typeInputRecipe = (TypeInputRecipe) recipe;
				String typeName = typeInputRecipe.getTypeName();
				long size = 0;
				long arity = 0;

				if (typeInputRecipe instanceof UnaryInputRecipe) {
					size = driver.getNodeSize(typeInputRecipe.getTypeName());
					arity = 1;
				} else if (typeInputRecipe instanceof BinaryInputRecipe) {
					size = driver.getEdgeSize(typeInputRecipe.getTypeName());
					arity = 2;
				}

				stats.put(typeName + "_size", size);
				stats.put(typeName + "_arity", arity);
			}
		}

		StatsUtil.saveStats(statsFile, stats);
		Map<String, Long> loadStats = StatsUtil.loadStats(statsFile);
		System.out.println(loadStats);
	}


}
