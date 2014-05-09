package org.eclipse.incquery.patternlanguage.rdf.psystem;

import java.util.Collection;
import org.eclipse.incquery.runtime.matchers.IPatternMatcherContext;
import org.eclipse.incquery.runtime.matchers.IPatternMatcherContext.EdgeInterpretation;
import org.eclipse.incquery.runtime.matchers.IPatternMatcherContext.GeneralizationQueryDirection;
import org.openrdf.model.Graph;

@SuppressWarnings("all")
public class RdfPatternMatcherContext implements IPatternMatcherContext {
  private final Graph metamodel;
  
  public RdfPatternMatcherContext(final Graph metamodel) {
    this.metamodel = metamodel;
  }
  
  public EdgeInterpretation edgeInterpretation() {
    return EdgeInterpretation.TERNARY;
  }
  
  public GeneralizationQueryDirection allowedGeneralizationQueryDirection() {
    return GeneralizationQueryDirection.SUPERTYPE_ONLY_SMART_NOTIFICATIONS;
  }
  
  public Object binaryEdgeSourceType(final Object typeObject) {
    UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException("TODO: auto-generated method stub");
    throw _unsupportedOperationException;
  }
  
  public Object binaryEdgeTargetType(final Object typeObject) {
    UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException("TODO: auto-generated method stub");
    throw _unsupportedOperationException;
  }
  
  public Collection<? extends Object> enumerateDirectBinaryEdgeSubtypes(final Object typeObject) {
    UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException("TODO: auto-generated method stub");
    throw _unsupportedOperationException;
  }
  
  public Collection<? extends Object> enumerateDirectBinaryEdgeSupertypes(final Object typeObject) {
    UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException("TODO: auto-generated method stub");
    throw _unsupportedOperationException;
  }
  
  public Collection<? extends Object> enumerateDirectSubtypes(final Object typeObject) {
    UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException("TODO: auto-generated method stub");
    throw _unsupportedOperationException;
  }
  
  public Collection<? extends Object> enumerateDirectSupertypes(final Object typeObject) {
    UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException("TODO: auto-generated method stub");
    throw _unsupportedOperationException;
  }
  
  public Collection<? extends Object> enumerateDirectTernaryEdgeSubtypes(final Object typeObject) {
    UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException("TODO: auto-generated method stub");
    throw _unsupportedOperationException;
  }
  
  public Collection<? extends Object> enumerateDirectTernaryEdgeSupertypes(final Object typeObject) {
    UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException("TODO: auto-generated method stub");
    throw _unsupportedOperationException;
  }
  
  public Collection<? extends Object> enumerateDirectUnarySubtypes(final Object typeObject) {
    UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException("TODO: auto-generated method stub");
    throw _unsupportedOperationException;
  }
  
  public Collection<? extends Object> enumerateDirectUnarySupertypes(final Object typeObject) {
    UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException("TODO: auto-generated method stub");
    throw _unsupportedOperationException;
  }
  
  public boolean isBinaryEdgeMultiplicityOneTo(final Object typeObject) {
    UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException("TODO: auto-generated method stub");
    throw _unsupportedOperationException;
  }
  
  public boolean isBinaryEdgeMultiplicityToOne(final Object typeObject) {
    UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException("TODO: auto-generated method stub");
    throw _unsupportedOperationException;
  }
  
  public boolean isBinaryEdgeType(final Object typeObject) {
    UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException("TODO: auto-generated method stub");
    throw _unsupportedOperationException;
  }
  
  public boolean isTernaryEdgeMultiplicityOneTo(final Object typeObject) {
    UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException("TODO: auto-generated method stub");
    throw _unsupportedOperationException;
  }
  
  public boolean isTernaryEdgeMultiplicityToOne(final Object typeObject) {
    UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException("TODO: auto-generated method stub");
    throw _unsupportedOperationException;
  }
  
  public boolean isTernaryEdgeType(final Object typeObject) {
    UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException("TODO: auto-generated method stub");
    throw _unsupportedOperationException;
  }
  
  public boolean isUnaryType(final Object typeObject) {
    UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException("TODO: auto-generated method stub");
    throw _unsupportedOperationException;
  }
  
  public void logDebug(final String message) {
    UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException("TODO: auto-generated method stub");
    throw _unsupportedOperationException;
  }
  
  public void logError(final String message) {
    UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException("TODO: auto-generated method stub");
    throw _unsupportedOperationException;
  }
  
  public void logError(final String message, final Throwable cause) {
    UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException("TODO: auto-generated method stub");
    throw _unsupportedOperationException;
  }
  
  public void logFatal(final String message) {
    UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException("TODO: auto-generated method stub");
    throw _unsupportedOperationException;
  }
  
  public void logFatal(final String message, final Throwable cause) {
    UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException("TODO: auto-generated method stub");
    throw _unsupportedOperationException;
  }
  
  public void logWarning(final String message) {
    UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException("TODO: auto-generated method stub");
    throw _unsupportedOperationException;
  }
  
  public void logWarning(final String message, final Throwable cause) {
    UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException("TODO: auto-generated method stub");
    throw _unsupportedOperationException;
  }
  
  public String printType(final Object typeObject) {
    UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException("TODO: auto-generated method stub");
    throw _unsupportedOperationException;
  }
  
  public void reportPatternDependency(final Object pattern) {
    UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException("TODO: auto-generated method stub");
    throw _unsupportedOperationException;
  }
  
  public Object ternaryEdgeSourceType(final Object typeObject) {
    UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException("TODO: auto-generated method stub");
    throw _unsupportedOperationException;
  }
  
  public Object ternaryEdgeTargetType(final Object typeObject) {
    UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException("TODO: auto-generated method stub");
    throw _unsupportedOperationException;
  }
}
