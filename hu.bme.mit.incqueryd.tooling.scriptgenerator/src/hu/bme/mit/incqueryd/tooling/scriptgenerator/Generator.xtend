package hu.bme.mit.incqueryd.tooling.scriptgenerator

import arch.Configuration
import org.eclipse.core.resources.IFile
import org.eclipse.incquery.runtime.rete.recipes.JoinRecipe
import org.eclipse.incquery.runtime.rete.recipes.BetaRecipe
import org.eclipse.incquery.runtime.rete.recipes.ExistenceJoinRecipe
import org.eclipse.incquery.runtime.rete.recipes.TrimmerRecipe
import org.eclipse.incquery.runtime.rete.recipes.UniquenessEnforcerRecipe
import org.eclipse.incquery.runtime.rete.recipes.ProductionRecipe

class Generator {

	public def generateScripts(IFile file, Configuration configuration) {
		val fileHandler = new FileHandler();
		fileHandler.writeFile(file, "deploy.sh", configuration.generateConfiguration);
	}

	def CharSequence generateConfiguration(Configuration configuration) {
		println
		println("Generating configuration")
		println("------------------------")
		println

		println("::: " + configuration);
		println("::: " + configuration.clusters);
		println("::: " + configuration.clusters.size);

		configuration.clusters.forEach [
			println("# Cluster: " + it.traceInfo)
			val nodes = it.infrastructureNodes
			nodes.forEach [
				println("#  - Machine: " + it.traceInfo)
			]
		]

		println("# Rete recipes")
		configuration.reteRecipes.forEach[
			it.recipeNodes.forEach [
				val lines = it.traceInfo.split("\\n");
				println("# - Rete recipe: " + lines.get(0))
				
				// only inspect concrete classes 
				switch (it) {
					ExistenceJoinRecipe: println("AntiJoin recipe")
					JoinRecipe: println("Join recipe")
					ProductionRecipe: println("Production recipe")
					UniquenessEnforcerRecipe: println("UniquenessEnforcer recipe")
					TrimmerRecipe: println("Trimmer recipe")
				}
			]]

		return "";
	}

}
