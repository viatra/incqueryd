package org.eclipse.incquery.patternlanguage.rdf.psystem

import org.eclipse.incquery.runtime.matchers.context.common.BaseInputKeyWrapper
import org.openrdf.model.Resource

class RdfInputKey extends BaseInputKeyWrapper<Resource> {

	new(Resource wrappedKey, int arity) {
		super(wrappedKey)
		this.arity = arity
	}
	
	val int arity

	override getArity() {
		arity
	}
	
	override getPrettyPrintableName() {
		stringID
	}
	
	override getStringID() {
		wrappedKey.stringValue
	}
	
	override isEnumerable() {
		true
	}
	
}