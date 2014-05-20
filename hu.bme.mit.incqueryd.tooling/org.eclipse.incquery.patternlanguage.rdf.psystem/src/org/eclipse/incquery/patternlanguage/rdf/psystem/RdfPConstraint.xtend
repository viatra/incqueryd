package org.eclipse.incquery.patternlanguage.rdf.psystem

import org.eclipse.incquery.patternlanguage.patternLanguage.CompareConstraint
import org.eclipse.incquery.patternlanguage.patternLanguage.Constraint
import org.eclipse.incquery.patternlanguage.patternLanguage.PatternCompositionConstraint
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.Iri
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
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeTernary
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeUnary
import org.openrdf.model.Resource
import org.openrdf.model.impl.URIImpl

import static org.eclipse.incquery.patternlanguage.patternLanguage.CompareFeature.*

import static extension org.eclipse.incquery.patternlanguage.rdf.IriUtils.*
import static extension org.eclipse.incquery.patternlanguage.rdf.psystem.PUtils.*
import static extension org.eclipse.incquery.patternlanguage.rdf.psystem.RdfPUtils.*
import static extension org.eclipse.incquery.patternlanguage.rdf.psystem.RdfPVariable.*

class RdfPConstraint {

	static def PConstraint toPConstraint(Constraint it, PBody pBody, RdfPatternMatcherContext context) {
		switch it {
			PatternCompositionConstraint: convertPatternCompositionConstraint(pBody)
			CompareConstraint: convertCompareConstraint(pBody)
			RdfClassConstraint: convertClassConstraint(pBody, context)
			RdfPropertyConstraint: convertPropertyConstraint(pBody, context)
			RdfCheckConstraint: convertCheckConstraint
			default: throw new IllegalArgumentException('''Unhandled case «it»''')
		}
	}

	static def PConstraint convertPatternCompositionConstraint(PatternCompositionConstraint constraint, PBody pBody) { // based on EPMToPBody
		val call = constraint.call
        val patternRef = call.patternRef
        val calledQuery = findQueryOf(patternRef)
        val tuple = call.parameters.toTuple(pBody)
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

	static def PConstraint convertCompareConstraint(CompareConstraint constraint, PBody pBody) {
		val left = constraint.leftOperand.toPVariable(pBody)
        val right = constraint.rightOperand.toPVariable(pBody)
        switch (constraint.feature) {
			case EQUALITY: new Equality(pBody, left, right)
			case INEQUALITY: new Inequality(pBody, left, right, false)
		}
	}

	static def TypeUnary convertClassConstraint(RdfClassConstraint constraint, PBody pBody, RdfPatternMatcherContext context) {
		val variable = constraint.variable.variable
		val pVariable = variable.toPVariable(pBody)
		val typeObject = constraint.type.toRdfResource
		val typeString = context.printType(typeObject)
		new TypeUnary(pBody, pVariable, typeObject, typeString)
	}

	static def PConstraint convertPropertyConstraint(RdfPropertyConstraint constraint, PBody pBody, RdfPatternMatcherContext context) {
		val refType = constraint.refType
		val source = constraint.source.variable.toPVariable(pBody)
		val target = constraint.target.toPVariable(pBody)
		val typeObject = refType.toRdfResource
		val typeString = context.printType(typeObject)
		new TypeTernary(pBody, context, pBody.newVirtualVariable, source, target, typeObject, typeString)
	}

	static def PConstraint convertCheckConstraint(RdfCheckConstraint constraint) {
		// TODO
	}

	static def Resource toRdfResource(Iri iri) {
		new URIImpl(iri.asString)
	}

}