package org.eclipse.incquery.patternlanguage.rdf.psystem

import org.eclipse.incquery.patternlanguage.patternLanguage.CompareConstraint
import org.eclipse.incquery.patternlanguage.patternLanguage.Constraint
import org.eclipse.incquery.patternlanguage.patternLanguage.PatternCompositionConstraint
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfCheckConstraint
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfClassConstraint
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfPropertyConstraint
import org.eclipse.incquery.runtime.matchers.psystem.PBody
import org.eclipse.incquery.runtime.matchers.psystem.PConstraint
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.Equality
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.ExpressionEvaluation
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.Inequality
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.NegativePatternCall
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.BinaryTransitiveClosure
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.PositivePatternCall
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeConstraint
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple

import static extension org.eclipse.incquery.patternlanguage.rdf.RdfPatternLanguageUtils.*
import static extension org.eclipse.incquery.patternlanguage.rdf.psystem.RdfPVariable.*
import static extension org.eclipse.incquery.patternlanguage.util.psystem.PUtils.*

class RdfPConstraint {

	static def PConstraint toPConstraint(Constraint it, PBody pBody, RdfPModel model) {
		switch it {
			PatternCompositionConstraint: convertPatternCompositionConstraint(pBody, model)
			CompareConstraint: convertCompareConstraint(pBody, model)
			RdfClassConstraint: convertClassConstraint(pBody, model)
			RdfPropertyConstraint: convertPropertyConstraint(pBody, model)
			RdfCheckConstraint: convertCheckConstraint(pBody)
			default: throw new IllegalArgumentException('''Unhandled case «it»''')
		}
	}

	static def PConstraint convertPatternCompositionConstraint(PatternCompositionConstraint constraint, PBody pBody, RdfPModel model) { // based on EPMToPBody
		val call = constraint.call
        val patternRef = call.patternRef
        val calledQuery = model.findQueryOf(patternRef)
        val tuple = model.toTuple(call.parameters, pBody)
        if (!call.transitive) {
            if (constraint.negative) {
                new NegativePatternCall(pBody, tuple, calledQuery)
            } else {
				new PositivePatternCall(pBody, tuple, calledQuery)
			}
        } else {
            if (tuple.size != 2) {
                throw new RuntimeException('''Transitive closure only supported for binary patterns «constraint»''')
            } else if (constraint.negative) {
                throw new RuntimeException('''Unsupported negated transitive closure «constraint»''')
            } else {
                new BinaryTransitiveClosure(pBody, tuple, calledQuery)
            }
        }
	}

	static def PConstraint convertCompareConstraint(CompareConstraint constraint, PBody pBody, RdfPModel model) {
		val left = constraint.leftOperand.toPVariable(pBody, model)
        val right = constraint.rightOperand.toPVariable(pBody, model)
        switch (constraint.feature) {
			case EQUALITY: new Equality(pBody, left, right)
			case INEQUALITY: new Inequality(pBody, left, right, false)
		}
	}

	static def TypeConstraint convertClassConstraint(RdfClassConstraint constraint, PBody pBody, RdfPModel model) {
		val pVariable = constraint.variable.variable.toPVariable(pBody)
		val resource = constraint.type.toRdfResource
		new TypeConstraint(pBody, new FlatTuple(pVariable), new RdfInputKey(resource, 1))
	}

	static def PConstraint convertPropertyConstraint(RdfPropertyConstraint constraint, PBody pBody, RdfPModel model) {
		val source = constraint.source.variable.toPVariable(pBody)
		val target = constraint.target.toPVariable(pBody, model)
		val resource = constraint.refType.toRdfResource
		new TypeConstraint(pBody, new FlatTuple(source, target), new RdfInputKey(resource, 2))
	}

	static def PConstraint convertCheckConstraint(RdfCheckConstraint constraint, PBody pBody) {
		val evaluator = new JavaScriptExpressionEvaluator(constraint.expression, pBody.allVariables.map[name].toSet)
		new ExpressionEvaluation(pBody, evaluator, null)
	}

}