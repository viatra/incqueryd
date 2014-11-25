package org.eclipse.incquery.patternlanguage.mondix.psystem

import org.apache.log4j.Logger
import org.eclipse.incquery.runtime.matchers.context.IPatternMatcherContext

class MondixPatternMatcherContext implements IPatternMatcherContext {

	val Logger logger = Logger.getLogger(MondixPatternMatcherContext)

	// XXX eliminate casts?

	// Unary

	override isUnaryType(Object typeObject) {
		true
	}

	override enumerateDirectUnarySubtypes(Object typeObject) {
		#{}
	}

	override enumerateDirectUnarySupertypes(Object typeObject) {
		#{}
	}

	// Binary

	override isBinaryEdgeType(Object typeObject) {
		true
	}

	override binaryEdgeSourceType(Object typeObject) {
		#{}
	}

	override binaryEdgeTargetType(Object typeObject) {
		#{}
	}

	override isBinaryEdgeMultiplicityOneTo(Object typeObject) {
		false
	}

	override isBinaryEdgeMultiplicityToOne(Object typeObject) {
		false
	}

	override enumerateDirectBinaryEdgeSubtypes(Object typeObject) {
		#{}
	}

	override enumerateDirectBinaryEdgeSupertypes(Object typeObject) {
		#{}
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
		typeObject.toString
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