package org.eclipse.incquery.patternlanguage.mondix.psystem

import org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.BinaryRelationConstraint
import org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.UnaryRelationConstraint
import org.eclipse.incquery.patternlanguage.patternLanguage.CompareConstraint
import org.eclipse.incquery.patternlanguage.patternLanguage.Constraint
import org.eclipse.incquery.patternlanguage.patternLanguage.PatternCompositionConstraint
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

import static extension org.eclipse.incquery.patternlanguage.mondix.psystem.MondixPVariable.*
import static extension org.eclipse.incquery.patternlanguage.util.psystem.PUtils.*

class MondixPConstraint {

	static def PConstraint toPConstraint(Constraint it, PBody pBody, MondixPModel model) {
		switch it {
			PatternCompositionConstraint: convertPatternCompositionConstraint(pBody, model)
			CompareConstraint: convertCompareConstraint(pBody, model)
			UnaryRelationConstraint: convertUnaryRelationConstraint(pBody, model)
			BinaryRelationConstraint: convertBinaryRelationConstraint(pBody, model)
			default: throw new IllegalArgumentException('''Unhandled case «it»''')
		}
	}

	static def PConstraint convertPatternCompositionConstraint(PatternCompositionConstraint constraint, PBody pBody, MondixPModel model) { // based on EPMToPBody
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

	static def PConstraint convertCompareConstraint(CompareConstraint constraint, PBody pBody, MondixPModel model) {
		val left = constraint.leftOperand.toPVariable(pBody, model)
        val right = constraint.rightOperand.toPVariable(pBody, model)
        switch (constraint.feature) {
			case EQUALITY: new Equality(pBody, left, right)
			case INEQUALITY: new Inequality(pBody, left, right, false)
		}
	}

	static def TypeUnary convertUnaryRelationConstraint(UnaryRelationConstraint constraint, PBody pBody, MondixPModel model) {
		val variable = constraint.variable.variable
		val pVariable = variable.toPVariable(pBody)
		val typeObject = constraint.relation.name
		val typeString = model.context.printType(typeObject)
		new TypeUnary(pBody, pVariable, typeObject, typeString)
	}

	static def PConstraint convertBinaryRelationConstraint(BinaryRelationConstraint constraint, PBody pBody, MondixPModel model) {
		val refType = constraint.relation
		val source = constraint.source.variable.toPVariable(pBody)
		val target = constraint.target.toPVariable(pBody, model)
		val typeObject = refType.name
		val typeString = model.context.printType(typeObject)
		new TypeBinary(pBody, model.context, source, target, typeObject, typeString)
	}

}