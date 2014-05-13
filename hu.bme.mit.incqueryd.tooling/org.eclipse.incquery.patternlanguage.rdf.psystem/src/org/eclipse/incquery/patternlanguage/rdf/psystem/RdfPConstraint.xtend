package org.eclipse.incquery.patternlanguage.rdf.psystem

import java.util.List
import org.eclipse.incquery.patternlanguage.patternLanguage.CompareConstraint
import org.eclipse.incquery.patternlanguage.patternLanguage.Constraint
import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern
import org.eclipse.incquery.patternlanguage.patternLanguage.PatternCompositionConstraint
import org.eclipse.incquery.patternlanguage.patternLanguage.ValueReference
import org.eclipse.incquery.patternlanguage.patternLanguage.Variable
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfCheckConstraint
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfPathExpressionConstraint
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.TypeConstraint
import org.eclipse.incquery.runtime.matchers.psystem.PBody
import org.eclipse.incquery.runtime.matchers.psystem.PConstraint
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.NegativePatternCall
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.BinaryTransitiveClosure
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.PositivePatternCall
import org.eclipse.incquery.runtime.matchers.psystem.queries.PQuery
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple
import org.eclipse.incquery.runtime.matchers.tuple.Tuple

import static extension org.eclipse.incquery.patternlanguage.rdf.psystem.PUtils.*
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeUnary

class RdfPConstraint {

	static def PConstraint create(Constraint constraint, PBody pBody, RdfPatternMatcherContext context) {
		switch constraint {
			PatternCompositionConstraint: {
				createPatternCompositionConstraint(constraint, pBody)
			}
			CompareConstraint: {
				// TODO
			}
			TypeConstraint: {
				createTypeConstraint(constraint, pBody, context)
			}
			RdfPathExpressionConstraint: {
				// TODO
			}
			RdfCheckConstraint: {
				// TODO
			}
		}
	}

	static def PConstraint createPatternCompositionConstraint(PatternCompositionConstraint constraint, PBody pBody) { // based on EPMToPBody
		val call = constraint.call
        val patternRef = call.patternRef
        val calledQuery = findQuery(patternRef)
        val pNodeTuple = getPNodeTuple(call.parameters, pBody)
        if (!call.transitive) {
            if (constraint.negative) {
                new NegativePatternCall(pBody, pNodeTuple, calledQuery)
            } else {
				new PositivePatternCall(pBody, pNodeTuple, calledQuery)
			}
        } else {
            if (pNodeTuple.size != 2) {
                throw new RuntimeException("Transitive closure only supported for binary patterns")
            } else if (constraint.negative) {
                throw new RuntimeException("Unsupported negated transitive closure")
            } else {
                new BinaryTransitiveClosure(pBody, pNodeTuple, calledQuery)
            }
        }
	}

	static def PQuery findQuery(Pattern pattern) {
		// TODO
	}

	static def Tuple getPNodeTuple(List<ValueReference> valueReferences, PBody pBody) {
        val elements = valueReferences.map[it.toPVariable(pBody)]
        new FlatTuple(elements)
    }

	static def TypeUnary createTypeConstraint(TypeConstraint constraint, PBody pBody, RdfPatternMatcherContext context) {
		val Variable variable = constraint.^var.resolve
		variable.toTypeConstraint(pBody, context)
	}

}