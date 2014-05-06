package org.eclipse.incquery.patternlanguage.rdf.psystem;

import com.google.common.base.Objects;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.incquery.patternlanguage.patternLanguage.Annotation;
import org.eclipse.incquery.patternlanguage.patternLanguage.AnnotationParameter;
import org.eclipse.incquery.patternlanguage.patternLanguage.BoolValue;
import org.eclipse.incquery.patternlanguage.patternLanguage.DoubleValue;
import org.eclipse.incquery.patternlanguage.patternLanguage.IntValue;
import org.eclipse.incquery.patternlanguage.patternLanguage.ListValue;
import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern;
import org.eclipse.incquery.patternlanguage.patternLanguage.PatternBody;
import org.eclipse.incquery.patternlanguage.patternLanguage.StringValue;
import org.eclipse.incquery.patternlanguage.patternLanguage.Type;
import org.eclipse.incquery.patternlanguage.patternLanguage.ValueReference;
import org.eclipse.incquery.patternlanguage.patternLanguage.Variable;
import org.eclipse.incquery.patternlanguage.patternLanguage.VariableReference;
import org.eclipse.incquery.patternlanguage.patternLanguage.VariableValue;
import org.eclipse.incquery.patternlanguage.rdf.psystem.RdfPBody;
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfPatternModel;
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
  private final List<PAnnotation> annotations;
  
  public List<PAnnotation> getAllAnnotations() {
    return this.annotations;
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
  
  public static PAnnotation toPAnnotation(final Annotation annotation) {
    String _name = annotation.getName();
    PAnnotation _pAnnotation = new PAnnotation(_name);
    final Procedure1<PAnnotation> _function = new Procedure1<PAnnotation>() {
      public void apply(final PAnnotation it) {
        EList<AnnotationParameter> _parameters = annotation.getParameters();
        for (final AnnotationParameter parameter : _parameters) {
          String _name = parameter.getName();
          ValueReference _value = parameter.getValue();
          Object _value_1 = RdfPQuery.getValue(_value);
          it.addAttribute(_name, _value_1);
        }
      }
    };
    PAnnotation _doubleArrow = ObjectExtensions.<PAnnotation>operator_doubleArrow(_pAnnotation, _function);
    return _doubleArrow;
  }
  
  public static Object getValue(final ValueReference it) {
    Object _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (it instanceof BoolValue) {
        final BoolValue _boolValue = (BoolValue)it;
        _matched=true;
        boolean _isValue = _boolValue.isValue();
        _switchResult = Boolean.valueOf(_isValue);
      }
    }
    if (!_matched) {
      if (it instanceof DoubleValue) {
        final DoubleValue _doubleValue = (DoubleValue)it;
        _matched=true;
        double _value = _doubleValue.getValue();
        _switchResult = Double.valueOf(_value);
      }
    }
    if (!_matched) {
      if (it instanceof IntValue) {
        final IntValue _intValue = (IntValue)it;
        _matched=true;
        int _value = _intValue.getValue();
        _switchResult = Integer.valueOf(_value);
      }
    }
    if (!_matched) {
      if (it instanceof StringValue) {
        final StringValue _stringValue = (StringValue)it;
        _matched=true;
        String _value = _stringValue.getValue();
        _switchResult = _value;
      }
    }
    if (!_matched) {
      if (it instanceof VariableReference) {
        final VariableReference _variableReference = (VariableReference)it;
        _matched=true;
        String _var = ((VariableReference)_variableReference).getVar();
        _switchResult = _var;
      }
    }
    if (!_matched) {
      if (it instanceof VariableValue) {
        final VariableValue _variableValue = (VariableValue)it;
        _matched=true;
        VariableReference _value = _variableValue.getValue();
        String _var = _value.getVar();
        _switchResult = _var;
      }
    }
    if (!_matched) {
      if (it instanceof ListValue) {
        final ListValue _listValue = (ListValue)it;
        _matched=true;
        EList<ValueReference> _values = _listValue.getValues();
        final Function1<ValueReference,Object> _function = new Function1<ValueReference,Object>() {
          public Object apply(final ValueReference it) {
            Object _value = RdfPQuery.getValue(it);
            return _value;
          }
        };
        List<Object> _map = ListExtensions.<ValueReference, Object>map(_values, _function);
        _switchResult = _map;
      }
    }
    if (!_matched) {
      IllegalArgumentException _illegalArgumentException = new IllegalArgumentException("Unknown attribute parameter type");
      throw _illegalArgumentException;
    }
    return _switchResult;
  }
  
  private final List<PParameter> parameters;
  
  public List<PParameter> getParameters() {
    return this.parameters;
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
  
  public static PParameter toPParameter(final Variable parameter) {
    String _name = parameter.getName();
    Type _type = parameter.getType();
    String _typename = _type.getTypename();
    PParameter _pParameter = new PParameter(_name, _typename);
    return _pParameter;
  }
  
  private final PQueryStatus status;
  
  public PQueryStatus getStatus() {
    return this.status;
  }
  
  public boolean isMutable() {
    return false;
  }
  
  public void checkMutability() throws IllegalStateException {
  }
  
  private final PDisjunction disjunction;
  
  public PDisjunction getDisjunctBodies() {
    return this.disjunction;
  }
  
  public Set<PQuery> getAllReferredQueries() {
    UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException("TODO: auto-generated method stub");
    throw _unsupportedOperationException;
  }
  
  public Set<PQuery> getDirectReferredQueries() {
    UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException("TODO: auto-generated method stub");
    throw _unsupportedOperationException;
  }
  
  private final String fullyQualifiedName;
  
  public String getFullyQualifiedName() {
    return this.fullyQualifiedName;
  }
  
  public RdfPQuery(final Pattern pattern, final RdfPatternModel patternModel) {
    EList<Variable> _parameters = pattern.getParameters();
    final Function1<Variable,PParameter> _function = new Function1<Variable,PParameter>() {
      public PParameter apply(final Variable it) {
        PParameter _pParameter = RdfPQuery.toPParameter(it);
        return _pParameter;
      }
    };
    List<PParameter> _map = ListExtensions.<Variable, PParameter>map(_parameters, _function);
    this.parameters = _map;
    EList<Annotation> _annotations = pattern.getAnnotations();
    final Function1<Annotation,PAnnotation> _function_1 = new Function1<Annotation,PAnnotation>() {
      public PAnnotation apply(final Annotation it) {
        PAnnotation _pAnnotation = RdfPQuery.toPAnnotation(it);
        return _pAnnotation;
      }
    };
    List<PAnnotation> _map_1 = ListExtensions.<Annotation, PAnnotation>map(_annotations, _function_1);
    this.annotations = _map_1;
    EList<PatternBody> _bodies = pattern.getBodies();
    final Function1<PatternBody,PBody> _function_2 = new Function1<PatternBody,PBody>() {
      public PBody apply(final PatternBody body) {
        PBody _create = RdfPBody.create(body, pattern, RdfPQuery.this);
        return _create;
      }
    };
    List<PBody> _map_2 = ListExtensions.<PatternBody, PBody>map(_bodies, _function_2);
    Set<PBody> _set = IterableExtensions.<PBody>toSet(_map_2);
    PDisjunction _pDisjunction = new PDisjunction(this, _set);
    this.disjunction = _pDisjunction;
    this.status = PQueryStatus.OK;
    String _name = pattern.getName();
    this.fullyQualifiedName = _name;
  }
}
