package hu.bme.mit.incqueryd.stats;

import hu.bme.mit.bigmodel.fourstore.FourStoreDriverCrud;
import hu.bme.mit.incqueryd.arch.util.ArchUtil;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

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

				if (typeInputRecipe instanceof UnaryInputRecipe) {
					size = driver.getNodeSize(typeInputRecipe.getTypeName());
				} else if (typeInputRecipe instanceof BinaryInputRecipe) {
					size = driver.getEdgeSize(typeInputRecipe.getTypeName());
				}

				stats.put(typeName, size);
			}
		}

		Properties props = new Properties();
		for (Map.Entry<String, Long> entry : stats.entrySet()) {
			props.setProperty(entry.getKey(), entry.getValue().toString());
		}

		File f = new File(statsFile);
		OutputStream out = new FileOutputStream(f);
		props.store(out, "");

	}

}
