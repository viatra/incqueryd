package hu.bme.mit.incqueryd.arch.language.ui.labeling

import com.google.inject.Inject
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider
import org.eclipse.incquery.runtime.rete.recipes.ReteNodeRecipe
import org.eclipse.xtext.ui.label.DefaultEObjectLabelProvider

/**
 * Provides labels for a EObjects.
 *
 * see http://www.eclipse.org/Xtext/documentation.html#labelProvider
 */
class ArchLanguageLabelProvider extends DefaultEObjectLabelProvider {

	@Inject
	new(AdapterFactoryLabelProvider delegate) {
		super(delegate);
	}

	def String text(ReteNodeRecipe nodeRecipe) '''
		URI: «nodeRecipe.eResource.URI»«nodeRecipe.eResource.getURIFragment(nodeRecipe)»
		traceInfo: «nodeRecipe.traceInfo»
	'''

}
