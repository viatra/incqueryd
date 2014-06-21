package hu.bme.mit.incqueryd.arch.language.validation

import arch.ArchPackage
import arch.Configuration
import arch.RecipeImport
import arch.ReteRole
import com.google.inject.Inject
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl
import org.eclipse.incquery.runtime.rete.recipes.RecipesPackage
import org.eclipse.incquery.runtime.rete.recipes.ReteNodeRecipe
import org.eclipse.incquery.runtime.rete.recipes.ReteRecipe
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.eclipse.xtext.validation.Check
import org.eclipse.xtext.validation.CheckType

import static extension org.eclipse.xtext.EcoreUtil2.*

/**
 * Custom validation rules.
 *
 * see http://www.eclipse.org/Xtext/documentation.html#validation
 */
class ArchLanguageValidator extends AbstractArchLanguageValidator {

	@Inject
	IQualifiedNameProvider qualifiedNameProvider

	@Check(CheckType.NORMAL)
	def void checkAllNodeRecipesAreMapped(RecipeImport recipeImport) {
		val reteRecipe = recipeImport.loadRecipe
		reteRecipe.recipeNodes.forEach[recipeNode |
			if (!recipeNode.isMappedIn(recipeImport.getContainerOfType(Configuration))) {
				warning('''Node recipe «qualifiedNameProvider.getFullyQualifiedName(recipeNode)» is unmapped''', ArchPackage.eINSTANCE.recipeImport_ImportURI)
			}
		]
	}

	static def ReteRecipe loadRecipe(RecipeImport recipeImport) {
		Resource.Factory.Registry.INSTANCE.extensionToFactoryMap.put("recipe", new XMIResourceFactoryImpl)
		RecipesPackage.eINSTANCE.eClass
		val resourceSet = new ResourceSetImpl
		val uri = URI.createURI(recipeImport.importURI).resolve(recipeImport.eResource.URI)
		val resource = resourceSet.getResource(uri, true)
		resource.getContents().get(0) as ReteRecipe
	}

	static def boolean isMappedIn(ReteNodeRecipe nodeRecipe, Configuration configuration) {
		configuration.mappings.exists[mapping |
			mapping.roles.filter(ReteRole).exists[reteRole |
				reteRole.nodeRecipe == nodeRecipe
			]
		]
	}

}
