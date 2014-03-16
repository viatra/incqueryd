package hu.bme.mit.incqueryd.main;

import hu.bme.mit.trainbenchmark.benchmark.config.IncQueryDBenchmarkConfig;

import org.apache.commons.cli.ParseException;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipselabs.emfjson.resource.JsResourceFactoryImpl;

/**
 * 
 * @author szarnyasg
 * 
 */
public class IncQueryDMain {

	public static void main(final String[] args) throws Exception {
		new ParseException("asdf");
		
//		final ReteNodeRecipe recipe = RecipesFactory.eINSTANCE.createTrimmerRecipe();
//		final String recipeString = RecipeSerializer.serializeToString(recipe);
		
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("json", new JsResourceFactoryImpl());

		
		final IncQueryDBenchmarkConfig bc = new IncQueryDBenchmarkConfig(args);
				
		final IncQueryDWorker worker = new IncQueryDWorker(bc);
		worker.work();
	}

}
