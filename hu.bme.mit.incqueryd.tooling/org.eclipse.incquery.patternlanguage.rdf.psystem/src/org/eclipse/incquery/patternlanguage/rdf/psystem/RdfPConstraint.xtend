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
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.Inequality
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.NegativePatternCall
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.BinaryTransitiveClosure
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.PositivePatternCall
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeBinary
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeUnary

import static org.eclipse.incquery.patternlanguage.patternLanguage.CompareFeature.*

import static extension org.eclipse.incquery.patternlanguage.rdf.RdfPatternLanguageUtils.*
import static extension org.eclipse.incquery.patternlanguage.util.psystem.PUtils.*
import static extension org.eclipse.incquery.patternlanguage.rdf.psystem.RdfPVariable.*
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.ExpressionEvaluation

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

	static def TypeUnary convertClassConstraint(RdfClassConstraint constraint, PBody pBody, RdfPModel model) {
		val variable = constraint.variable.variable
		val pVariable = variable.toPVariable(pBody)
		val typeObject = constraint.type.toRdfResource
		val typeString = model.context.printType(typeObject)
		new TypeUnary(pBody, pVariable, typeObject, typeString)
	}

	static def PConstraint convertPropertyConstraint(RdfPropertyConstraint constraint, PBody pBody, RdfPModel model) {
		val refType = constraint.refType
		val source = constraint.source.variable.toPVariable(pBody)
		val target = constraint.target.toPVariable(pBody, model)
		val typeObject = refType.toRdfResource
		val typeString = model.context.printType(typeObject)
		new TypeBinary(pBody, model.context, source, target, typeObject, typeString)
	}

	static def PConstraint convertCheckConstraint(RdfCheckConstraint constraint, PBody pBody) {
		val evaluator = new JavaScriptExpressionEvaluator(constraint.expression, pBody.allVariables.map[name].toSet)
		new ExpressionEvaluation(pBody, evaluator, null)
	}

}