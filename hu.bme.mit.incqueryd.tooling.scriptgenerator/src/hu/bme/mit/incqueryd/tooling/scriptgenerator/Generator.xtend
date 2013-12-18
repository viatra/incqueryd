package hu.bme.mit.incqueryd.tooling.scriptgenerator

import akka.actor.ActorSystem
import arch.Configuration
import infrastructure.Machine
import org.eclipse.core.resources.IFile
import org.eclipse.incquery.runtime.rete.recipes.AntiJoinRecipe
import org.eclipse.incquery.runtime.rete.recipes.JoinRecipe
import org.eclipse.incquery.runtime.rete.recipes.ProductionRecipe
import org.eclipse.incquery.runtime.rete.recipes.TrimmerRecipe
import org.eclipse.incquery.runtime.rete.recipes.UniquenessEnforcerRecipe

class Generator {

	public def generateScripts(IFile file, Configuration configuration) {
		val fileHandler = new FileHandler();
		fileHandler.writeFile(file, "deploy.sh", configuration.generateConfiguration);
	}

	def CharSequence generateConfiguration(Configuration configuration) {

		configuration.clusters.forEach [
			println("# Cluster: " + it.traceInfo)
			val nodes = it.infrastructureNodes
			nodes.forEach [
				if (it instanceof Machine) {
					val m = it as Machine
					println("#  - Machine: " + m.ip);				
				}
			]
		]
		val system = ActorSystem.create("incqueryd-local");
		
		
		println
		println("Generating configuration")
		println("------------------------")
		println

		println("# Rete recipes")
		configuration.reteRecipes.forEach[
			it.recipeNodes.forEach [
				val lines = it.traceInfo.split("\\n");
				println("# - Rete recipe: " + lines.get(0))
				// only inspect concrete classes
				switch (it) {
					AntiJoinRecipe: antiJoin(it)
					JoinRecipe: join(it)
					ProductionRecipe: production(it)
					UniquenessEnforcerRecipe: uniquenessEnforcer(it)
					TrimmerRecipe: trimmer(it)
				}
			]]

		configuration.mappings.forEach[
			println(it)			
		];

		return "";
	}

	def void antiJoin(AntiJoinRecipe recipe) {
		println("AntiJoin recipe")
	}

	def void join(JoinRecipe recipe) {
		println("Join recipe")
	}

	def void production(ProductionRecipe recipe) {
		println("Production recipe")
	}

	def void uniquenessEnforcer(UniquenessEnforcerRecipe recipe) {
		println("UniquenessEnforcer recipe")
	}

	def void trimmer(TrimmerRecipe recipe) {
		println("Trimmer recipe")
	}

}
