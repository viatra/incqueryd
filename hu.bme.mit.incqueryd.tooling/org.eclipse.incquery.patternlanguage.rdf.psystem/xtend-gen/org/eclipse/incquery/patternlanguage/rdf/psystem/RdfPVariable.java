package org.eclipse.incquery.patternlanguage.rdf.psystem;

import org.eclipse.emf.common.util.EList;
import org.eclipse.incquery.patternlanguage.patternLanguage.AggregatedValue;
import org.eclipse.incquery.patternlanguage.patternLanguage.AggregatorExpression;
import org.eclipse.incquery.patternlanguage.patternLanguage.BoolValue;
import org.eclipse.incquery.patternlanguage.patternLanguage.CountAggregator;
import org.eclipse.incquery.patternlanguage.patternLanguage.DoubleValue;
import org.eclipse.incquery.patternlanguage.patternLanguage.IntValue;
import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern;
import org.eclipse.incquery.patternlanguage.patternLanguage.PatternCall;
import org.eclipse.incquery.patternlanguage.patternLanguage.StringValue;
import org.eclipse.incquery.patternlanguage.patternLanguage.ValueReference;
import org.eclipse.incquery.patternlanguage.patternLanguage.Variable;
import org.eclipse.incquery.patternlanguage.patternLanguage.VariableReference;
import org.eclipse.incquery.patternlanguage.patternLanguage.VariableValue;
import org.eclipse.incquery.patternlanguage.rdf.psystem.PUtils;
import org.eclipse.incquery.patternlanguage.rdf.psystem.RdfPModel;
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfLiteral;
import org.eclipse.incquery.runtime.matchers.psystem.PBody;
import org.eclipse.incquery.runtime.matchers.psystem.PVariable;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.PatternMatchCounter;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PQuery;
import org.eclipse.incquery.runtime.matchers.tuple.Tuple;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class RdfPVariable {
  public static PVariable toPVariable(final ValueReference it, final PBody pBody, final RdfPModel model) {
    PVariable _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (it instanceof IntValue) {
        _matched=true;
        int _value = ((IntValue)it).getValue();
        _switchResult = RdfPVariable.convertLiteralValue(Integer.valueOf(_value), pBody);
      }
    }
    if (!_matched) {
      if (it instanceof DoubleValue) {
        _matched=true;
        double _value = ((DoubleValue)it).getValue();
        _switchResult = RdfPVariable.convertLiteralValue(Double.valueOf(_value), pBody);
      }
    }
    if (!_matched) {
      if (it instanceof BoolValue) {
        _matched=true;
        boolean _isValue = ((BoolValue)it).isValue();
        _switchResult = RdfPVariable.convertLiteralValue(Boolean.valueOf(_isValue), pBody);
      }
    }
    if (!_matched) {
      if (it instanceof StringValue) {
        _matched=true;
        String _value = ((StringValue)it).getValue();
        _switchResult = RdfPVariable.convertLiteralValue(_value, pBody);
      }
    }
    if (!_matched) {
      if (it instanceof RdfLiteral) {
        _matched=true;
        _switchResult = RdfPVariable.convertLiteralValue(it, pBody);
      }
    }
    if (!_matched) {
      if (it instanceof VariableValue) {
        _matched=true;
        _switchResult = RdfPVariable.convertVariableValue(((VariableValue)it), pBody);
      }
    }
    if (!_matched) {
      if (it instanceof AggregatedValue) {
        _matched=true;
        _switchResult = RdfPVariable.convertAggregatedValue(((AggregatedValue)it), pBody, model);
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
  
  public static PVariable convertLiteralValue(final Object value, final PBody pBody) {
    return pBody.newConstantVariable(value);
  }
  
  public static PVariable convertVariableValue(final VariableValue variableValue, final PBody pBody) {
    VariableReference _value = variableValue.getValue();
    Variable _variable = _value.getVariable();
    return PUtils.toPVariable(_variable, pBody);
  }
  
  public static PVariable convertAggregatedValue(final AggregatedValue aggregatedValue, final PBody pBody, final RdfPModel model) {
    PVariable _xblockexpression = null;
    {
      final PVariable result = pBody.newVirtualVariable();
      final PatternCall call = aggregatedValue.getCall();
      final Pattern patternRef = call.getPatternRef();
      final PQuery calledQuery = model.findQueryOf(patternRef);
      EList<ValueReference> _parameters = call.getParameters();
      final Tuple tuple = model.toTuple(_parameters, pBody);
      AggregatorExpression _aggregator = aggregatedValue.getAggregator();
      final AggregatorExpression aggregator = _aggregator;
      boolean _matched = false;
      if (!_matched) {
        if (aggregator instanceof CountAggregator) {
          _matched=true;
          new PatternMatchCounter(pBody, tuple, calledQuery, result);
        }
      }
      if (!_matched) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("Unsupported aggregator expression ");
        _builder.append(aggregator, "");
        throw new RuntimeException(_builder.toString());
      }
      _xblockexpression = result;
    }
    return _xblockexpression;
  }
}
