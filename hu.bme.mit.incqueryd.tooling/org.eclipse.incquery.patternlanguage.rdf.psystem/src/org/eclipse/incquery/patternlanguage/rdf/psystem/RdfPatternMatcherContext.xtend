package org.eclipse.incquery.patternlanguage.rdf.psystem

import org.eclipse.incquery.runtime.matchers.IPatternMatcherContext
import org.eclipse.incquery.runtime.matchers.IPatternMatcherContext.EdgeInterpretation
import org.eclipse.incquery.runtime.matchers.IPatternMatcherContext.GeneralizationQueryDirection
import org.openrdf.model.Graph

class RdfPatternMatcherContext implements IPatternMatcherContext {

	val Graph metamodel

	new(Graph metamodel) {
		this.metamodel = metamodel
	}

	override edgeInterpretation() {
		EdgeInterpretation.TERNARY
	}

	override allowedGeneralizationQueryDirection() {
		GeneralizationQueryDirection.SUPERTYPE_ONLY_SMART_NOTIFICATIONS
	}

	override binaryEdgeSourceType(Object typeObject) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}

	override binaryEdgeTargetType(Object typeObject) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}

	override enumerateDirectBinaryEdgeSubtypes(Object typeObject) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}

	override enumerateDirectBinaryEdgeSupertypes(Object typeObject) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}

	override enumerateDirectSubtypes(Object typeObject) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}

	override enumerateDirectSupertypes(Object typeObject) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}

	override enumerateDirectTernaryEdgeSubtypes(Object typeObject) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}

	override enumerateDirectTernaryEdgeSupertypes(Object typeObject) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}

	override enumerateDirectUnarySubtypes(Object typeObject) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}

	override enumerateDirectUnarySupertypes(Object typeObject) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}

	override isBinaryEdgeMultiplicityOneTo(Object typeObject) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}

	override isBinaryEdgeMultiplicityToOne(Object typeObject) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}

	override isBinaryEdgeType(Object typeObject) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}

	override isTernaryEdgeMultiplicityOneTo(Object typeObject) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}

	override isTernaryEdgeMultiplicityToOne(Object typeObject) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}

	override isTernaryEdgeType(Object typeObject) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}

	override isUnaryType(Object typeObject) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}

	override logDebug(String message) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}

	override logError(String message) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}

	override logError(String message, Throwable cause) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}

	override logFatal(String message) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}

	override logFatal(String message, Throwable cause) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}

	override logWarning(String message) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}

	override logWarning(String message, Throwable cause) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}

	override printType(Object typeObject) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}

	override reportPatternDependency(Object pattern) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}

	override ternaryEdgeSourceType(Object typeObject) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}

	override ternaryEdgeTargetType(Object typeObject) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}

}