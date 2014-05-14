package org.eclipse.incquery.patternlanguage.rdf.psystem;

import org.eclipse.incquery.patternlanguage.patternLanguage.AggregatedValue;
import org.eclipse.incquery.patternlanguage.patternLanguage.ValueReference;
import org.eclipse.incquery.patternlanguage.patternLanguage.Variable;
import org.eclipse.incquery.patternlanguage.patternLanguage.VariableReference;
import org.eclipse.incquery.patternlanguage.patternLanguage.VariableValue;
import org.eclipse.incquery.patternlanguage.rdf.psystem.PUtils;
import org.eclipse.incquery.runtime.matchers.psystem.PBody;
import org.eclipse.incquery.runtime.matchers.psystem.PVariable;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class RdfPVariable {
  public static PVariable toPVariable(final ValueReference it, final PBody pBody) {
    PVariable _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (it instanceof VariableValue) {
        _matched=true;
        _switchResult = RdfPVariable.convertVariableValue(((VariableValue)it), pBody);
      }
    }
    if (!_matched) {
      if (it instanceof AggregatedValue) {
        _matched=true;
        _switchResult = RdfPVariable.convertAggregatedValue(((AggregatedValue)it), pBody);
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
  
  public static PVariable convertVariableValue(final VariableValue variableValue, final PBody pBody) {
    VariableReference _value = variableValue.getValue();
    Variable _variable = _value.getVariable();
    return PUtils.toPVariable(_variable, pBody);
  }
  
  public static PVariable convertAggregatedValue(final AggregatedValue aggregatedValue, final PBody pBody) {
    return null;
  }
}
