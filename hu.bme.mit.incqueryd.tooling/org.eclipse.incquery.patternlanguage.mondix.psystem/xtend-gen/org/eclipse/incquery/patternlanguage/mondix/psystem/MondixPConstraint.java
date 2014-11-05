package org.eclipse.incquery.patternlanguage.mondix.psystem;

import org.eclipse.emf.common.util.EList;
import org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.EdgeConstraint;
import org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.NodeConstraint;
import org.eclipse.incquery.patternlanguage.mondix.psystem.MondixPModel;
import org.eclipse.incquery.patternlanguage.mondix.psystem.MondixPVariable;
import org.eclipse.incquery.patternlanguage.patternLanguage.CompareConstraint;
import org.eclipse.incquery.patternlanguage.patternLanguage.CompareFeature;
import org.eclipse.incquery.patternlanguage.patternLanguage.Constraint;
import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern;
import org.eclipse.incquery.patternlanguage.patternLanguage.PatternCall;
import org.eclipse.incquery.patternlanguage.patternLanguage.PatternCompositionConstraint;
import org.eclipse.incquery.patternlanguage.patternLanguage.ValueReference;
import org.eclipse.incquery.patternlanguage.patternLanguage.Variable;
import org.eclipse.incquery.patternlanguage.patternLanguage.VariableReference;
import org.eclipse.incquery.patternlanguage.util.psystem.PUtils;
import org.eclipse.incquery.runtime.matchers.psystem.BasePConstraint;
import org.eclipse.incquery.runtime.matchers.psystem.DeferredPConstraint;
import org.eclipse.incquery.runtime.matchers.psystem.PBody;
import org.eclipse.incquery.runtime.matchers.psystem.PConstraint;
import org.eclipse.incquery.runtime.matchers.psystem.PVariable;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.Equality;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.Inequality;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.NegativePatternCall;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.BinaryTransitiveClosure;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.PositivePatternCall;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeBinary;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeUnary;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PQuery;
import org.eclipse.incquery.runtime.matchers.tuple.Tuple;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class MondixPConstraint {
  public static PConstraint toPConstraint(final Constraint it, final PBody pBody, final MondixPModel model) {
    PConstraint _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (it instanceof PatternCompositionConstraint) {
        _matched=true;
        _switchResult = MondixPConstraint.convertPatternCompositionConstraint(((PatternCompositionConstraint)it), pBody, model);
      }
    }
    if (!_matched) {
      if (it instanceof CompareConstraint) {
        _matched=true;
        _switchResult = MondixPConstraint.convertCompareConstraint(((CompareConstraint)it), pBody, model);
      }
    }
    if (!_matched) {
      if (it instanceof NodeConstraint) {
        _matched=true;
        _switchResult = MondixPConstraint.convertNodeConstraint(((NodeConstraint)it), pBody, model);
      }
    }
    if (!_matched) {
      if (it instanceof EdgeConstraint) {
        _matched=true;
        _switchResult = MondixPConstraint.convertEdgeConstraint(((EdgeConstraint)it), pBody, model);
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
  
  public static PConstraint convertPatternCompositionConstraint(final PatternCompositionConstraint constraint, final PBody pBody, final MondixPModel model) {
    BasePConstraint _xblockexpression = null;
    {
      final PatternCall call = constraint.getCall();
      final Pattern patternRef = call.getPatternRef();
      final PQuery calledQuery = model.findQueryOf(patternRef);
      EList<ValueReference> _parameters = call.getParameters();
      final Tuple tuple = model.toTuple(_parameters, pBody);
      BasePConstraint _xifexpression = null;
      boolean _isTransitive = call.isTransitive();
      boolean _not = (!_isTransitive);
      if (_not) {
        BasePConstraint _xifexpression_1 = null;
        boolean _isNegative = constraint.isNegative();
        if (_isNegative) {
          _xifexpression_1 = new NegativePatternCall(pBody, tuple, calledQuery);
        } else {
          _xifexpression_1 = new PositivePatternCall(pBody, tuple, calledQuery);
        }
        _xifexpression = ((BasePConstraint)_xifexpression_1);
      } else {
        BinaryTransitiveClosure _xifexpression_2 = null;
        int _size = tuple.getSize();
        boolean _notEquals = (_size != 2);
        if (_notEquals) {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("Transitive closure only supported for binary patterns ");
          _builder.append(constraint, "");
          throw new RuntimeException(_builder.toString());
        } else {
          BinaryTransitiveClosure _xifexpression_3 = null;
          boolean _isNegative_1 = constraint.isNegative();
          if (_isNegative_1) {
            StringConcatenation _builder_1 = new StringConcatenation();
            _builder_1.append("Unsupported negated transitive closure ");
            _builder_1.append(constraint, "");
            throw new RuntimeException(_builder_1.toString());
          } else {
            _xifexpression_3 = new BinaryTransitiveClosure(pBody, tuple, calledQuery);
          }
          _xifexpression_2 = _xifexpression_3;
        }
        _xifexpression = _xifexpression_2;
      }
      _xblockexpression = ((BasePConstraint)_xifexpression);
    }
    return ((BasePConstraint)_xblockexpression);
  }
  
  public static PConstraint convertCompareConstraint(final CompareConstraint constraint, final PBody pBody, final MondixPModel model) {
    DeferredPConstraint _xblockexpression = null;
    {
      ValueReference _leftOperand = constraint.getLeftOperand();
      final PVariable left = MondixPVariable.toPVariable(_leftOperand, pBody, model);
      ValueReference _rightOperand = constraint.getRightOperand();
      final PVariable right = MondixPVariable.toPVariable(_rightOperand, pBody, model);
      DeferredPConstraint _switchResult = null;
      CompareFeature _feature = constraint.getFeature();
      if (_feature != null) {
        switch (_feature) {
          case EQUALITY:
            _switchResult = new Equality(pBody, left, right);
            break;
          case INEQUALITY:
            _switchResult = new Inequality(pBody, left, right, false);
            break;
          default:
            break;
        }
      }
      _xblockexpression = _switchResult;
    }
    return _xblockexpression;
  }
  
  public static TypeUnary convertNodeConstraint(final NodeConstraint constraint, final PBody pBody, final MondixPModel model) {
    TypeUnary _xblockexpression = null;
    {
      VariableReference _variable = constraint.getVariable();
      final Variable variable = _variable.getVariable();
      final PVariable pVariable = PUtils.toPVariable(variable, pBody);
      final String typeObject = constraint.getType();
      final String typeString = model.context.printType(typeObject);
      _xblockexpression = new TypeUnary(pBody, pVariable, typeObject, typeString);
    }
    return _xblockexpression;
  }
  
  public static PConstraint convertEdgeConstraint(final EdgeConstraint constraint, final PBody pBody, final MondixPModel model) {
    TypeBinary _xblockexpression = null;
    {
      final String refType = constraint.getRefType();
      VariableReference _source = constraint.getSource();
      Variable _variable = _source.getVariable();
      final PVariable source = PUtils.toPVariable(_variable, pBody);
      ValueReference _target = constraint.getTarget();
      final PVariable target = MondixPVariable.toPVariable(_target, pBody, model);
      final String typeObject = refType;
      final String typeString = model.context.printType(typeObject);
      _xblockexpression = new TypeBinary(pBody, model.context, source, target, typeObject, typeString);
    }
    return _xblockexpression;
  }
}
