package org.eclipse.incquery.patternlanguage.rdf.psystem;

import com.google.common.base.Objects;
import org.eclipse.emf.common.util.EList;
import org.eclipse.incquery.patternlanguage.patternLanguage.Annotation;
import org.eclipse.incquery.patternlanguage.patternLanguage.AnnotationParameter;
import org.eclipse.incquery.patternlanguage.patternLanguage.BoolValue;
import org.eclipse.incquery.patternlanguage.patternLanguage.DoubleValue;
import org.eclipse.incquery.patternlanguage.patternLanguage.IntValue;
import org.eclipse.incquery.patternlanguage.patternLanguage.ListValue;
import org.eclipse.incquery.patternlanguage.patternLanguage.ParameterRef;
import org.eclipse.incquery.patternlanguage.patternLanguage.StringValue;
import org.eclipse.incquery.patternlanguage.patternLanguage.Type;
import org.eclipse.incquery.patternlanguage.patternLanguage.ValueReference;
import org.eclipse.incquery.patternlanguage.patternLanguage.Variable;
import org.eclipse.incquery.patternlanguage.patternLanguage.VariableReference;
import org.eclipse.incquery.patternlanguage.patternLanguage.VariableValue;
import org.eclipse.incquery.runtime.matchers.psystem.PBody;
import org.eclipse.incquery.runtime.matchers.psystem.PVariable;
import org.eclipse.incquery.runtime.matchers.psystem.annotations.PAnnotation;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class PUtils {
  public static PAnnotation toPAnnotation(final Annotation annotation) {
    String _name = annotation.getName();
    PAnnotation _pAnnotation = new PAnnotation(_name);
    final Procedure1<PAnnotation> _function = new Procedure1<PAnnotation>() {
      public void apply(final PAnnotation it) {
        EList<AnnotationParameter> _parameters = annotation.getParameters();
        for (final AnnotationParameter parameter : _parameters) {
          String _name = parameter.getName();
          ValueReference _value = parameter.getValue();
          Object _value_1 = PUtils.getValue(_value);
          it.addAttribute(_name, _value_1);
        }
      }
    };
    return ObjectExtensions.<PAnnotation>operator_doubleArrow(_pAnnotation, _function);
  }
  
  public static Object getValue(final ValueReference it) {
    Object _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (it instanceof BoolValue) {
        _matched=true;
        _switchResult = Boolean.valueOf(((BoolValue)it).isValue());
      }
    }
    if (!_matched) {
      if (it instanceof DoubleValue) {
        _matched=true;
        _switchResult = Double.valueOf(((DoubleValue)it).getValue());
      }
    }
    if (!_matched) {
      if (it instanceof IntValue) {
        _matched=true;
        _switchResult = Integer.valueOf(((IntValue)it).getValue());
      }
    }
    if (!_matched) {
      if (it instanceof StringValue) {
        _matched=true;
        _switchResult = ((StringValue)it).getValue();
      }
    }
    if (!_matched) {
      if (it instanceof VariableReference) {
        _matched=true;
        _switchResult = ((VariableReference)it).getVar();
      }
    }
    if (!_matched) {
      if (it instanceof VariableValue) {
        _matched=true;
        VariableReference _value = ((VariableValue)it).getValue();
        _switchResult = _value.getVar();
      }
    }
    if (!_matched) {
      if (it instanceof ListValue) {
        _matched=true;
        EList<ValueReference> _values = ((ListValue)it).getValues();
        final Function1<ValueReference, Object> _function = new Function1<ValueReference, Object>() {
          public Object apply(final ValueReference it) {
            return PUtils.getValue(it);
          }
        };
        _switchResult = ListExtensions.<ValueReference, Object>map(_values, _function);
      }
    }
    if (!_matched) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Unhandled case ");
      _builder.append(it, "");
      throw new IllegalArgumentException(_builder.toString());
    }
    return _switchResult;
  }
  
  public static PVariable toPVariable(final Variable variable, final PBody pBody) {
    PVariable _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (variable instanceof ParameterRef) {
        _matched=true;
        Variable _referredParam = ((ParameterRef)variable).getReferredParam();
        _switchResult = PUtils.toPVariable(_referredParam, pBody);
      }
    }
    if (!_matched) {
      String _name = variable.getName();
      _switchResult = pBody.getOrCreateVariableByName(_name);
    }
    return _switchResult;
  }
  
  public static PParameter toPParameter(final Variable parameter) {
    PParameter _xifexpression = null;
    Type _type = parameter.getType();
    boolean _equals = Objects.equal(_type, null);
    if (_equals) {
      String _name = parameter.getName();
      _xifexpression = new PParameter(_name);
    } else {
      String _name_1 = parameter.getName();
      Type _type_1 = parameter.getType();
      String _typename = _type_1.getTypename();
      _xifexpression = new PParameter(_name_1, _typename);
    }
    return _xifexpression;
  }
}
