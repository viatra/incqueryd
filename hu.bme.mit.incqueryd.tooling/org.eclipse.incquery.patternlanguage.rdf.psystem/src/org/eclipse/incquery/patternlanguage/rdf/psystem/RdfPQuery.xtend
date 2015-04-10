package org.eclipse.incquery.patternlanguage.rdf.psystem

import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern
import org.eclipse.incquery.patternlanguage.util.psystem.GenericPQuery
import static extension org.eclipse.incquery.patternlanguage.rdf.psystem.RdfPBody.*

class RdfPQuery {

	static def toPQuery(Pattern pattern, RdfPModel model) {
		new GenericPQuery(pattern, [patternBody, query | toPBody(patternBody, pattern, query, model)]) {
			
			override getPreferredScopeClass() {
				throw new UnsupportedOperationException("TODO")
			}
			
		}
	}

}