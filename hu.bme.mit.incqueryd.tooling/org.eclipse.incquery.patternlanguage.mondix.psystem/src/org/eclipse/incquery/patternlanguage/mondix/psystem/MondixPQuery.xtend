package org.eclipse.incquery.patternlanguage.mondix.psystem

import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern
import org.eclipse.incquery.patternlanguage.util.psystem.GenericPQuery
import static extension org.eclipse.incquery.patternlanguage.mondix.psystem.MondixPBody.*
import eu.mondo.mondix.incquery.MondixScope

public class MondixPQuery {

	static def toPQuery(Pattern pattern, MondixPModel model) {
		new GenericPQuery(pattern, [patternBody, query | toPBody(patternBody, pattern, query, model)]) {
			
			override getPreferredScopeClass() {
				MondixScope
			}
			
		}
	}

}