package org.eclipse.incquery.patternlanguage.rdf.psystem

import org.eclipse.incquery.runtime.matchers.psystem.PConstraint
import org.eclipse.incquery.patternlanguage.patternLanguage.Constraint
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.TypeConstraint
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfPathExpressionConstraint
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfCheckConstraint

class RdfPConstraint {

	static def PConstraint create(Constraint constraint) {
		switch constraint {
			TypeConstraint: {

			}
			RdfPathExpressionConstraint: {

			}
			RdfCheckConstraint: {

			}
			// TODO
		}
	}

}