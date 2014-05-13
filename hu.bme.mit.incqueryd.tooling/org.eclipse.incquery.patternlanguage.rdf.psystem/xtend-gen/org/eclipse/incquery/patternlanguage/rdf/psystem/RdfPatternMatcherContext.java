package org.eclipse.incquery.patternlanguage.rdf.psystem;

import java.util.Collection;
import org.eclipse.incquery.runtime.matchers.IPatternMatcherContext;
import org.openrdf.model.Graph;

@SuppressWarnings("all")
public class RdfPatternMatcherContext implements IPatternMatcherContext {
  private final Graph metamodel;
  
  public RdfPatternMatcherContext(final Graph metamodel) {
    this.metamodel = metamodel;
  }
  
  public IPatternMatcherContext.EdgeInterpretation edgeInterpretation() {
    return IPatternMatcherContext.EdgeInterpretation.TERNARY;
  }
  
  public IPatternMatcherContext.GeneralizationQueryDirection allowedGeneralizationQueryDirection() {
    return IPatternMatcherContext.GeneralizationQueryDirection.SUPERTYPE_ONLY_SMART_NOTIFICATIONS;
  }
  
  public Object binaryEdgeSourceType(final Object typeObject) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  public Object binaryEdgeTargetType(final Object typeObject) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  public Collection<?> enumerateDirectBinaryEdgeSubtypes(final Object typeObject) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  public Collection<?> enumerateDirectBinaryEdgeSupertypes(final Object typeObject) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  public Collection<?> enumerateDirectSubtypes(final Object typeObject) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  public Collection<?> enumerateDirectSupertypes(final Object typeObject) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  public Collection<?> enumerateDirectTernaryEdgeSubtypes(final Object typeObject) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  public Collection<?> enumerateDirectTernaryEdgeSupertypes(final Object typeObject) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  public Collection<?> enumerateDirectUnarySubtypes(final Object typeObject) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  public Collection<?> enumerateDirectUnarySupertypes(final Object typeObject) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  public boolean isBinaryEdgeMultiplicityOneTo(final Object typeObject) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  public boolean isBinaryEdgeMultiplicityToOne(final Object typeObject) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  public boolean isBinaryEdgeType(final Object typeObject) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  public boolean isTernaryEdgeMultiplicityOneTo(final Object typeObject) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  public boolean isTernaryEdgeMultiplicityToOne(final Object typeObject) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  public boolean isTernaryEdgeType(final Object typeObject) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  public boolean isUnaryType(final Object typeObject) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  public void logDebug(final String message) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  public void logError(final String message) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  public void logError(final String message, final Throwable cause) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  public void logFatal(final String message) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  public void logFatal(final String message, final Throwable cause) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  public void logWarning(final String message) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  public void logWarning(final String message, final Throwable cause) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  public String printType(final Object typeObject) {
    return typeObject.toString();
  }
  
  public void reportPatternDependency(final Object pattern) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  public Object ternaryEdgeSourceType(final Object typeObject) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  public Object ternaryEdgeTargetType(final Object typeObject) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
}
