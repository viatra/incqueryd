package org.eclipse.incquery.patternlanguage.rdf.psystem

import hu.bme.mit.incqueryd.rdf.RdfUtils
import org.apache.log4j.Logger
import org.eclipse.incquery.runtime.matchers.context.IPatternMatcherContext
import org.openrdf.model.Model
import org.openrdf.model.Resource
import org.openrdf.model.Value
import org.openrdf.model.vocabulary.RDFS

class RdfPatternMatcherContext implements IPatternMatcherContext {

	val Model vocabulary
	val Logger logger = Logger.getLogger(RdfPatternMatcherContext)

	new(Model vocabulary) {
		this.vocabulary = vocabulary
	}

	// XXX eliminate casts?

	// Unary

	override isUnaryType(Object typeObject) {
		RdfUtils.isClass(typeObject as Resource, vocabulary) || RdfUtils.isDatatype(typeObject as Resource, vocabulary)
	}

	override enumerateDirectUnarySubtypes(Object typeObject) {
		vocabulary.filter(null, RDFS.SUBCLASSOF, typeObject as Resource).map[subject].toSet
	}

	override enumerateDirectUnarySupertypes(Object typeObject) {
		vocabulary.filter(typeObject as Resource, RDFS.SUBCLASSOF, null).map[object].toSet
	}

	// Binary

	override isBinaryEdgeType(Object typeObject) {
		RdfUtils.isProperty(typeObject as Resource, vocabulary)
	}

	override binaryEdgeSourceType(Object typeObject) {
		vocabulary.filter(typeObject as Resource, RDFS.DOMAIN, null).map[object].head
	}

	override binaryEdgeTargetType(Object typeObject) {
		vocabulary.filter(typeObject as Resource, RDFS.RANGE, null).map[object].head
	}

	override isBinaryEdgeMultiplicityOneTo(Object typeObject) {
		false // TODO SPARQL? based on http://www.w3.org/TR/owl-guide/#owl_cardinality
	}

	override isBinaryEdgeMultiplicityToOne(Object typeObject) {
		false // TODO SPARQL? based on http://www.w3.org/TR/owl-guide/#owl_cardinality
	}

	override enumerateDirectBinaryEdgeSubtypes(Object typeObject) {
		vocabulary.filter(null, RDFS.SUBPROPERTYOF, typeObject as Resource).map[subject].toSet
	}

	override enumerateDirectBinaryEdgeSupertypes(Object typeObject) {
		vocabulary.filter(typeObject as Resource, RDFS.SUBPROPERTYOF, null).map[object].toSet
	}

	// Ternary

	override isTernaryEdgeType(Object typeObject) {
		false
	}

	override ternaryEdgeSourceType(Object typeObject) {
		throw new UnsupportedOperationException
	}

	override ternaryEdgeTargetType(Object typeObject) {
		throw new UnsupportedOperationException
	}

	override isTernaryEdgeMultiplicityOneTo(Object typeObject) {
		throw new UnsupportedOperationException
	}

	override isTernaryEdgeMultiplicityToOne(Object typeObject) {
		throw new UnsupportedOperationException
	}

	override enumerateDirectTernaryEdgeSubtypes(Object typeObject) {
		throw new UnsupportedOperationException
	}

	override enumerateDirectTernaryEdgeSupertypes(Object typeObject) {
		throw new UnsupportedOperationException
	}

	// Generic

	override edgeInterpretation() {
		IPatternMatcherContext.EdgeInterpretation.BINARY
	}

	override allowedGeneralizationQueryDirection() {
		IPatternMatcherContext.GeneralizationQueryDirection.BOTH
	}

	static val INVALID = "Invalid type object"

	override enumerateDirectSubtypes(Object typeObject) { // TODO extract this unorthogonal logic
		if (isUnaryType(typeObject)) {
			enumerateDirectUnarySubtypes(typeObject)
		} else if (isTernaryEdgeType(typeObject)) {
			enumerateDirectTernaryEdgeSubtypes(typeObject)
		} else {
			throw new IllegalArgumentException(INVALID)
		}
	}

	override enumerateDirectSupertypes(Object typeObject) { // TODO extract this unorthogonal logic
		if (isUnaryType(typeObject)) {
			enumerateDirectUnarySupertypes(typeObject)
		} else if (isTernaryEdgeType(typeObject)) {
			enumerateDirectTernaryEdgeSupertypes(typeObject)
		} else {
			throw new IllegalArgumentException(INVALID)
		}
	}

	override printType(Object typeObject) {
		(typeObject as Value).stringValue
	}

	// Logging

	override logDebug(String message) {
		logger.debug(message)
	}

	override logWarning(String message) {
		logger.warn(message)
	}

	override logWarning(String message, Throwable cause) {
		logger.warn(message, cause)
	}

	override logError(String message) {
		logger.error(message)
	}

	override logError(String message, Throwable cause) {
		logger.error(message, cause)
	}

	override logFatal(String message) {
		logger.fatal(message)
	}

	override logFatal(String message, Throwable cause) {
		logger.fatal(message, cause)
	}

}