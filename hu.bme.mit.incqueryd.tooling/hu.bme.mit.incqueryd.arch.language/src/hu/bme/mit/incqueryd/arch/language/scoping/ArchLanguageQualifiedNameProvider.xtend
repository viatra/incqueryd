package hu.bme.mit.incqueryd.arch.language.scoping

import org.eclipse.incquery.runtime.rete.recipes.ReteNodeRecipe
import org.eclipse.xtext.naming.DefaultDeclarativeQualifiedNameProvider
import org.eclipse.xtext.naming.QualifiedName
import static extension java.lang.Integer.*

class ArchLanguageQualifiedNameProvider extends DefaultDeclarativeQualifiedNameProvider {

	def QualifiedName qualifiedName(ReteNodeRecipe reteNodeRecipe) {
		val typeName = reteNodeRecipe.eClass.name
		val fragmentHash = reteNodeRecipe.eResource.getURIFragment(reteNodeRecipe).hashCode.toHexString
		val resourceHash = reteNodeRecipe.eResource.URI.hashCode.toHexString
		QualifiedName.create('''«typeName»_«fragmentHash»_«resourceHash»''')
	}

}
