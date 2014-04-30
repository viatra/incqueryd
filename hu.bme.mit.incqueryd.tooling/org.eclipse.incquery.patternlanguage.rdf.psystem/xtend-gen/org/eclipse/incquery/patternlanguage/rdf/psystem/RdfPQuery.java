package org.eclipse.incquery.patternlanguage.rdf.psystem;

import com.google.common.base.Objects;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.incquery.patternlanguage.patternLanguage.Annotation;
import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern;
import org.eclipse.incquery.patternlanguage.patternLanguage.PatternBody;
import org.eclipse.incquery.patternlanguage.patternLanguage.Type;
import org.eclipse.incquery.patternlanguage.patternLanguage.Variable;
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.PatternModel;
import org.eclipse.incquery.runtime.matchers.psystem.PBody;
import org.eclipse.incquery.runtime.matchers.psystem.annotations.PAnnotation;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PDisjunction;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PQuery;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PQuery.PQueryStatus;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class RdfPQuery implements PQuery {
  private final Pattern pattern;
  
  private final List<PParameter> parameters;
  
  private final List<PAnnotation> annotations;
  
  private final PQueryStatus status;
  
  private final List<PBody> bodies;
  
  public RdfPQuery(final Pattern pattern, final PatternModel patternModel) {
    this.pattern = pattern;
    EList<Variable> _parameters = pattern.getParameters();
    final Function1<Variable,PParameter> _function = new Function1<Variable,PParameter>() {
      public PParameter apply(final Variable parameter) {
        String _name = parameter.getName();
        Type _type = parameter.getType();
        String _typename = _type.getTypename();
        PParameter _pParameter = new PParameter(_name, _typename);
        return _pParameter;
      }
    };
    List<PParameter> _map = ListExtensions.<Variable, PParameter>map(_parameters, _function);
    this.parameters = _map;
    EList<Annotation> _annotations = pattern.getAnnotations();
    final Function1<Annotation,PAnnotation> _function_1 = new Function1<Annotation,PAnnotation>() {
      public PAnnotation apply(final Annotation annotation) {
        String _name = annotation.getName();
        PAnnotation _pAnnotation = new PAnnotation(_name);
        final Procedure1<PAnnotation> _function = new Procedure1<PAnnotation>() {
          public void apply(final PAnnotation it) {
          }
        };
        PAnnotation _doubleArrow = ObjectExtensions.<PAnnotation>operator_doubleArrow(_pAnnotation, _function);
        return _doubleArrow;
      }
    };
    List<PAnnotation> _map_1 = ListExtensions.<Annotation, PAnnotation>map(_annotations, _function_1);
    this.annotations = _map_1;
    EList<PatternBody> _bodies = pattern.getBodies();
    final Function1<PatternBody,PBody> _function_2 = new Function1<PatternBody,PBody>() {
      public PBody apply(final PatternBody body) {
        PBody _pBody = new PBody(RdfPQuery.this);
        final Procedure1<PBody> _function = new Procedure1<PBody>() {
          public void apply(final PBody it) {
          }
        };
        PBody _doubleArrow = ObjectExtensions.<PBody>operator_doubleArrow(_pBody, _function);
        return _doubleArrow;
      }
    };
    List<PBody> _map_2 = ListExtensions.<PatternBody, PBody>map(_bodies, _function_2);
    this.bodies = _map_2;
    this.status = PQueryStatus.OK;
  }
  
  public void checkMutability() throws IllegalStateException {
  }
  
  public List<PAnnotation> getAllAnnotations() {
    return this.annotations;
  }
  
  public Set<PQuery> getAllReferredQueries() {
    UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException("TODO: auto-generated method stub");
    throw _unsupportedOperationException;
  }
  
  public List<PAnnotation> getAnnotationsByName(final String annotationName) {
    final Function1<PAnnotation,Boolean> _function = new Function1<PAnnotation,Boolean>() {
      public Boolean apply(final PAnnotation it) {
        String _name = it.getName();
        boolean _equals = Objects.equal(_name, annotationName);
        return Boolean.valueOf(_equals);
      }
    };
    Iterable<PAnnotation> _filter = IterableExtensions.<PAnnotation>filter(this.annotations, _function);
    List<PAnnotation> _list = IterableExtensions.<PAnnotation>toList(_filter);
    return _list;
  }
  
  public Set<PQuery> getDirectReferredQueries() {
    UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException("TODO: auto-generated method stub");
    throw _unsupportedOperationException;
  }
  
  public PAnnotation getFirstAnnotationByName(final String annotationName) {
    final Function1<PAnnotation,Boolean> _function = new Function1<PAnnotation,Boolean>() {
      public Boolean apply(final PAnnotation it) {
        String _name = it.getName();
        boolean _equals = Objects.equal(_name, annotationName);
        return Boolean.valueOf(_equals);
      }
    };
    PAnnotation _findFirst = IterableExtensions.<PAnnotation>findFirst(this.annotations, _function);
    return _findFirst;
  }
  
  public String getFullyQualifiedName() {
    String _name = this.pattern.getName();
    return _name;
  }
  
  public List<String> getParameterNames() {
    final Function1<PParameter,String> _function = new Function1<PParameter,String>() {
      public String apply(final PParameter it) {
        String _name = it.getName();
        return _name;
      }
    };
    List<String> _map = ListExtensions.<PParameter, String>map(this.parameters, _function);
    return _map;
  }
  
  public List<PParameter> getParameters() {
    return this.parameters;
  }
  
  public Integer getPositionOfParameter(final String parameterName) {
    Integer _xblockexpression = null;
    {
      List<String> _parameterNames = this.getParameterNames();
      final int index = _parameterNames.indexOf(parameterName);
      Integer _xifexpression = null;
      int _minus = (-1);
      boolean _equals = (index == _minus);
      if (_equals) {
        _xifexpression = null;
      } else {
        _xifexpression = Integer.valueOf(index);
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
  
  public PQueryStatus getStatus() {
    return this.status;
  }
  
  public boolean isMutable() {
    return false;
  }
  
  public PDisjunction getDisjunctBodies() {
    UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException("TODO: auto-generated method stub");
    throw _unsupportedOperationException;
  }
}
