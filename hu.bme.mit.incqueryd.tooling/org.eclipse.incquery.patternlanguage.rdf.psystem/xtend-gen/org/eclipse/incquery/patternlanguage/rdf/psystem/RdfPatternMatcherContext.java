package org.eclipse.incquery.patternlanguage.rdf.psystem;

import java.util.Collection;
import org.apache.log4j.Logger;
import org.eclipse.incquery.runtime.matchers.IPatternMatcherContext;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.openrdf.model.Model;
import org.openrdf.model.Resource;
import org.openrdf.model.Statement;
import org.openrdf.model.Value;
import org.openrdf.model.vocabulary.RDF;
import org.openrdf.model.vocabulary.RDFS;

@SuppressWarnings("all")
public class RdfPatternMatcherContext implements IPatternMatcherContext {
  private final Model vocabulary;
  
  private final Logger logger = Logger.getLogger(RdfPatternMatcherContext.class);
  
  public RdfPatternMatcherContext(final Model vocabulary) {
    this.vocabulary = vocabulary;
  }
  
  public boolean isUnaryType(final Object typeObject) {
    return this.vocabulary.contains(((Resource) typeObject), RDF.TYPE, RDFS.CLASS);
  }
  
  public Collection<?> enumerateDirectUnarySubtypes(final Object typeObject) {
    Model _filter = this.vocabulary.filter(null, RDFS.SUBCLASSOF, ((Resource) typeObject));
    final Function1<Statement,Resource> _function = new Function1<Statement,Resource>() {
      public Resource apply(final Statement it) {
        return it.getSubject();
      }
    };
    Iterable<Resource> _map = IterableExtensions.<Statement, Resource>map(_filter, _function);
    return IterableExtensions.<Resource>toSet(_map);
  }
  
  public Collection<?> enumerateDirectUnarySupertypes(final Object typeObject) {
    Model _filter = this.vocabulary.filter(((Resource) typeObject), RDFS.SUBCLASSOF, null);
    final Function1<Statement,Value> _function = new Function1<Statement,Value>() {
      public Value apply(final Statement it) {
        return it.getObject();
      }
    };
    Iterable<Value> _map = IterableExtensions.<Statement, Value>map(_filter, _function);
    return IterableExtensions.<Value>toSet(_map);
  }
  
  public boolean isBinaryEdgeType(final Object typeObject) {
    return this.vocabulary.contains(((Resource) typeObject), RDF.TYPE, RDF.PROPERTY);
  }
  
  public Object binaryEdgeSourceType(final Object typeObject) {
    Model _filter = this.vocabulary.filter(((Resource) typeObject), RDFS.DOMAIN, null);
    final Function1<Statement,Value> _function = new Function1<Statement,Value>() {
      public Value apply(final Statement it) {
        return it.getObject();
      }
    };
    Iterable<Value> _map = IterableExtensions.<Statement, Value>map(_filter, _function);
    return IterableExtensions.<Value>head(_map);
  }
  
  public Object binaryEdgeTargetType(final Object typeObject) {
    Model _filter = this.vocabulary.filter(((Resource) typeObject), RDFS.RANGE, null);
    final Function1<Statement,Value> _function = new Function1<Statement,Value>() {
      public Value apply(final Statement it) {
        return it.getObject();
      }
    };
    Iterable<Value> _map = IterableExtensions.<Statement, Value>map(_filter, _function);
    return IterableExtensions.<Value>head(_map);
  }
  
  public boolean isBinaryEdgeMultiplicityOneTo(final Object typeObject) {
    return false;
  }
  
  public boolean isBinaryEdgeMultiplicityToOne(final Object typeObject) {
    return false;
  }
  
  public Collection<?> enumerateDirectBinaryEdgeSubtypes(final Object typeObject) {
    Model _filter = this.vocabulary.filter(null, RDFS.SUBPROPERTYOF, ((Resource) typeObject));
    final Function1<Statement,Resource> _function = new Function1<Statement,Resource>() {
      public Resource apply(final Statement it) {
        return it.getSubject();
      }
    };
    Iterable<Resource> _map = IterableExtensions.<Statement, Resource>map(_filter, _function);
    return IterableExtensions.<Resource>toSet(_map);
  }
  
  public Collection<?> enumerateDirectBinaryEdgeSupertypes(final Object typeObject) {
    Model _filter = this.vocabulary.filter(((Resource) typeObject), RDFS.SUBPROPERTYOF, null);
    final Function1<Statement,Value> _function = new Function1<Statement,Value>() {
      public Value apply(final Statement it) {
        return it.getObject();
      }
    };
    Iterable<Value> _map = IterableExtensions.<Statement, Value>map(_filter, _function);
    return IterableExtensions.<Value>toSet(_map);
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
        throw new IllegalArgumentException(RdfPatternMatcherContext.INVALID);
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
        throw new IllegalArgumentException(RdfPatternMatcherContext.INVALID);
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
