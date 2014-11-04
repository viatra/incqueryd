package org.eclipse.incquery.patternlanguage.mondix.psystem;

import java.util.Collection;
import java.util.Collections;
import org.apache.log4j.Logger;
import org.eclipse.incquery.runtime.matchers.IPatternMatcherContext;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.openrdf.model.Value;

@SuppressWarnings("all")
public class MondixPatternMatcherContext implements IPatternMatcherContext {
  private final Logger logger = Logger.getLogger(MondixPatternMatcherContext.class);
  
  public boolean isUnaryType(final Object typeObject) {
    return true;
  }
  
  public Collection<?> enumerateDirectUnarySubtypes(final Object typeObject) {
    return Collections.<Object>unmodifiableSet(CollectionLiterals.<Object>newHashSet());
  }
  
  public Collection<?> enumerateDirectUnarySupertypes(final Object typeObject) {
    return Collections.<Object>unmodifiableSet(CollectionLiterals.<Object>newHashSet());
  }
  
  public boolean isBinaryEdgeType(final Object typeObject) {
    return true;
  }
  
  public Object binaryEdgeSourceType(final Object typeObject) {
    return Collections.<Object>unmodifiableSet(CollectionLiterals.<Object>newHashSet());
  }
  
  public Object binaryEdgeTargetType(final Object typeObject) {
    return Collections.<Object>unmodifiableSet(CollectionLiterals.<Object>newHashSet());
  }
  
  public boolean isBinaryEdgeMultiplicityOneTo(final Object typeObject) {
    return false;
  }
  
  public boolean isBinaryEdgeMultiplicityToOne(final Object typeObject) {
    return false;
  }
  
  public Collection<?> enumerateDirectBinaryEdgeSubtypes(final Object typeObject) {
    return Collections.<Object>unmodifiableSet(CollectionLiterals.<Object>newHashSet());
  }
  
  public Collection<?> enumerateDirectBinaryEdgeSupertypes(final Object typeObject) {
    return Collections.<Object>unmodifiableSet(CollectionLiterals.<Object>newHashSet());
  }
  
  public boolean isTernaryEdgeType(final Object typeObject) {
    return false;
  }
  
  public Object ternaryEdgeSourceType(final Object typeObject) {
    throw new UnsupportedOperationException();
  }
  
  public Object ternaryEdgeTargetType(final Object typeObject) {
    throw new UnsupportedOperationException();
  }
  
  public boolean isTernaryEdgeMultiplicityOneTo(final Object typeObject) {
    throw new UnsupportedOperationException();
  }
  
  public boolean isTernaryEdgeMultiplicityToOne(final Object typeObject) {
    throw new UnsupportedOperationException();
  }
  
  public Collection<?> enumerateDirectTernaryEdgeSubtypes(final Object typeObject) {
    throw new UnsupportedOperationException();
  }
  
  public Collection<?> enumerateDirectTernaryEdgeSupertypes(final Object typeObject) {
    throw new UnsupportedOperationException();
  }
  
  public IPatternMatcherContext.EdgeInterpretation edgeInterpretation() {
    return IPatternMatcherContext.EdgeInterpretation.BINARY;
  }
  
  public IPatternMatcherContext.GeneralizationQueryDirection allowedGeneralizationQueryDirection() {
    return IPatternMatcherContext.GeneralizationQueryDirection.BOTH;
  }
  
  private final static String INVALID = "Invalid type object";
  
  public Collection<?> enumerateDirectSubtypes(final Object typeObject) {
    Collection<?> _xifexpression = null;
    boolean _isUnaryType = this.isUnaryType(typeObject);
    if (_isUnaryType) {
      _xifexpression = this.enumerateDirectUnarySubtypes(typeObject);
    } else {
      Collection<?> _xifexpression_1 = null;
      boolean _isTernaryEdgeType = this.isTernaryEdgeType(typeObject);
      if (_isTernaryEdgeType) {
        _xifexpression_1 = this.enumerateDirectTernaryEdgeSubtypes(typeObject);
      } else {
        throw new IllegalArgumentException(MondixPatternMatcherContext.INVALID);
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }
  
  public Collection<?> enumerateDirectSupertypes(final Object typeObject) {
    Collection<?> _xifexpression = null;
    boolean _isUnaryType = this.isUnaryType(typeObject);
    if (_isUnaryType) {
      _xifexpression = this.enumerateDirectUnarySupertypes(typeObject);
    } else {
      Collection<?> _xifexpression_1 = null;
      boolean _isTernaryEdgeType = this.isTernaryEdgeType(typeObject);
      if (_isTernaryEdgeType) {
        _xifexpression_1 = this.enumerateDirectTernaryEdgeSupertypes(typeObject);
      } else {
        throw new IllegalArgumentException(MondixPatternMatcherContext.INVALID);
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }
  
  public String printType(final Object typeObject) {
    return ((Value) typeObject).stringValue();
  }
  
  public void reportPatternDependency(final Object pattern) {
  }
  
  public void logDebug(final String message) {
    this.logger.debug(message);
  }
  
  public void logWarning(final String message) {
    this.logger.warn(message);
  }
  
  public void logWarning(final String message, final Throwable cause) {
    this.logger.warn(message, cause);
  }
  
  public void logError(final String message) {
    this.logger.error(message);
  }
  
  public void logError(final String message, final Throwable cause) {
    this.logger.error(message, cause);
  }
  
  public void logFatal(final String message) {
    this.logger.fatal(message);
  }
  
  public void logFatal(final String message, final Throwable cause) {
    this.logger.fatal(message, cause);
  }
}
