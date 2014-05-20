package org.eclipse.incquery.patternlanguage.rdf.psystem

import org.eclipse.incquery.runtime.matchers.IPatternMatcherContext
import org.openrdf.model.Model
import org.openrdf.model.Resource
import org.openrdf.model.vocabulary.RDF
import org.openrdf.model.vocabulary.RDFS
import org.apache.log4j.Logger
import org.openrdf.model.Value

class RdfPatternMatcherContext implements IPatternMatcherContext {

	val Model vocabulary
	val Logger logger = Logger.getLogger(RdfPatternMatcherContext)

	new(Model vocabulary) {
		this.vocabulary = vocabulary
	}

	// Unary

	override isUnaryType(Object typeObject) {
		vocabulary.contains(typeObject as Resource, RDF.TYPE, RDFS.CLASS) // XXX eliminate casts?
	}

	override enumerateDirectUnarySubtypes(Object typeObject) {
		vocabulary.filter(null, RDFS.SUBCLASSOF, typeObject as Resource).map[subject].toSet
	}

	override enumerateDirectUnarySupertypes(Object typeObject) {
		vocabulary.filter(typeObject as Resource, RDFS.SUBCLASSOF, null).map[object].toSet
	}

	// Binary

	override isBinaryEdgeType(Object typeObject) {
		false
	}

	override binaryEdgeSourceType(Object typeObject) {
		throw new UnsupportedOperationException
	}

	override binaryEdgeTargetType(Object typeObject) {
		throw new UnsupportedOperationException
	}

	override isBinaryEdgeMultiplicityOneTo(Object typeObject) {
		throw new UnsupportedOperationException
	}

	override isBinaryEdgeMultiplicityToOne(Object typeObject) {
		throw new UnsupportedOperationException
	}

	override enumerateDirectBinaryEdgeSubtypes(Object typeObject) {
		throw new UnsupportedOperationException
	}

	override enumerateDirectBinaryEdgeSupertypes(Object typeObject) {
		throw new UnsupportedOperationException
	}

	// Ternary

	override isTernaryEdgeType(Object typeObject) {
		vocabulary.contains(typeObject as Resource, RDF.TYPE, RDF.PROPERTY)
	}

	override ternaryEdgeSourceType(Object typeObject) {
		vocabulary.filter(typeObject as Resource, RDFS.DOMAIN, null).map[object].head
	}

	override ternaryEdgeTargetType(Object typeObject) {
		vocabulary.filter(typeObject as Resource, RDFS.RANGE, null).map[object].head
	}

	override isTernaryEdgeMultiplicityOneTo(Object typeObject) {
		false // TODO SPARQL? based on http://www.w3.org/TR/owl-guide/#owl_cardinality
	}

	override isTernaryEdgeMultiplicityToOne(Object typeObject) {
		false // TODO SPARQL? based on http://www.w3.org/TR/owl-guide/#owl_cardinality
	}

	override enumerateDirectTernaryEdgeSubtypes(Object typeObject) {
		vocabulary.filter(null, RDFS.SUBPROPERTYOF, typeObject as Resource).map[subject].toSet
	}

	override enumerateDirectTernaryEdgeSupertypes(Object typeObject) {
		vocabulary.filter(typeObject as Resource, RDFS.SUBPROPERTYOF, null).map[object].toSet
	}

	// Generic

	override edgeInterpretation() {
		IPatternMatcherContext.EdgeInterpretation.TERNARY
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

	override reportPatternDependency(Object pattern) {
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