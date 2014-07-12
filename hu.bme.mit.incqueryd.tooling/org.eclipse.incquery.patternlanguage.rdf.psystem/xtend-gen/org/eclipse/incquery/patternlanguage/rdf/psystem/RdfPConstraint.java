package org.eclipse.incquery.patternlanguage.rdf.psystem;

import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.incquery.patternlanguage.patternLanguage.CompareConstraint;
import org.eclipse.incquery.patternlanguage.patternLanguage.CompareFeature;
import org.eclipse.incquery.patternlanguage.patternLanguage.Constraint;
import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern;
import org.eclipse.incquery.patternlanguage.patternLanguage.PatternCall;
import org.eclipse.incquery.patternlanguage.patternLanguage.PatternCompositionConstraint;
import org.eclipse.incquery.patternlanguage.patternLanguage.ValueReference;
import org.eclipse.incquery.patternlanguage.patternLanguage.Variable;
import org.eclipse.incquery.patternlanguage.patternLanguage.VariableReference;
import org.eclipse.incquery.patternlanguage.rdf.RdfPatternLanguageUtils;
import org.eclipse.incquery.patternlanguage.rdf.psystem.JavaScriptExpressionEvaluator;
import org.eclipse.incquery.patternlanguage.rdf.psystem.PUtils;
import org.eclipse.incquery.patternlanguage.rdf.psystem.RdfPModel;
import org.eclipse.incquery.patternlanguage.rdf.psystem.RdfPVariable;
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.Iri;
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfCheckConstraint;
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfClassConstraint;
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfPropertyConstraint;
import org.eclipse.incquery.runtime.matchers.psystem.BasePConstraint;
import org.eclipse.incquery.runtime.matchers.psystem.DeferredPConstraint;
import org.eclipse.incquery.runtime.matchers.psystem.PBody;
import org.eclipse.incquery.runtime.matchers.psystem.PConstraint;
import org.eclipse.incquery.runtime.matchers.psystem.PVariable;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.Equality;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.ExpressionEvaluation;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.Inequality;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.NegativePatternCall;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.BinaryTransitiveClosure;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.PositivePatternCall;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeBinary;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeUnary;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PQuery;
import org.eclipse.incquery.runtime.matchers.tuple.Tuple;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.openrdf.model.Resource;

@SuppressWarnings("all")
public class RdfPConstraint {
  public static PConstraint toPConstraint(final Constraint it, final PBody pBody, final RdfPModel model) {
    PConstraint _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (it instanceof PatternCompositionConstraint) {
        _matched=true;
        _switchResult = RdfPConstraint.convertPatternCompositionConstraint(((PatternCompositionConstraint)it), pBody, model);
      }
    }
    if (!_matched) {
      if (it instanceof CompareConstraint) {
        _matched=true;
        _switchResult = RdfPConstraint.convertCompareConstraint(((CompareConstraint)it), pBody, model);
      }
    }
    if (!_matched) {
      if (it instanceof RdfClassConstraint) {
        _matched=true;
        _switchResult = RdfPConstraint.convertClassConstraint(((RdfClassConstraint)it), pBody, model);
      }
    }
    if (!_matched) {
      if (it instanceof RdfPropertyConstraint) {
        _matched=true;
        _switchResult = RdfPConstraint.convertPropertyConstraint(((RdfPropertyConstraint)it), pBody, model);
      }
    }
    if (!_matched) {
      if (it instanceof RdfCheckConstraint) {
        _matched=true;
        _switchResult = RdfPConstraint.convertCheckConstraint(((RdfCheckConstraint)it), pBody);
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
  
  public static PConstraint convertPatternCompositionConstraint(final PatternCompositionConstraint constraint, final PBody pBody, final RdfPModel model) {
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
  
  public static PConstraint convertCompareConstraint(final CompareConstraint constraint, final PBody pBody, final RdfPModel model) {
    DeferredPConstraint _xblockexpression = null;
    {
      ValueReference _leftOperand = constraint.getLeftOperand();
      final PVariable left = RdfPVariable.toPVariable(_leftOperand, pBody, model);
      ValueReference _rightOperand = constraint.getRightOperand();
      final PVariable right = RdfPVariable.toPVariable(_rightOperand, pBody, model);
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
  
  public static TypeUnary convertClassConstraint(final RdfClassConstraint constraint, final PBody pBody, final RdfPModel model) {
    TypeUnary _xblockexpression = null;
    {
      VariableReference _variable = constraint.getVariable();
      final Variable variable = _variable.getVariable();
      final PVariable pVariable = PUtils.toPVariable(variable, pBody);
      Iri _type = constraint.getType();
      final Resource typeObject = RdfPatternLanguageUtils.toRdfResource(_type);
      final String typeString = model.context.printType(typeObject);
      _xblockexpression = new TypeUnary(pBody, pVariable, typeObject, typeString);
    }
    return _xblockexpression;
  }
  
  public static PConstraint convertPropertyConstraint(final RdfPropertyConstraint constraint, final PBody pBody, final RdfPModel model) {
    TypeBinary _xblockexpression = null;
    {
      final Iri refType = constraint.getRefType();
      VariableReference _source = constraint.getSource();
      Variable _variable = _source.getVariable();
      final PVariable source = PUtils.toPVariable(_variable, pBody);
      ValueReference _target = constraint.getTarget();
      final PVariable target = RdfPVariable.toPVariable(_target, pBody, model);
      final Resource typeObject = RdfPatternLanguageUtils.toRdfResource(refType);
      final String typeString = model.context.printType(typeObject);
      _xblockexpression = new TypeBinary(pBody, model.context, source, target, typeObject, typeString);
    }
    return _xblockexpression;
  }
  
  public static PConstraint convertCheckConstraint(final RdfCheckConstraint constraint, final PBody pBody) {
    ExpressionEvaluation _xblockexpression = null;
    {
      String _expression = constraint.getExpression();
      Set<PVariable> _allVariables = pBody.getAllVariables();
      final Function1<PVariable, String> _function = new Function1<PVariable, String>() {
        public String apply(final PVariable it) {
          return it.getName();
        }
      };
      Iterable<String> _map = IterableExtensions.<PVariable, String>map(_allVariables, _function);
      Set<String> _set = IterableExtensions.<String>toSet(_map);
      final JavaScriptExpressionEvaluator evaluator = new JavaScriptExpressionEvaluator(_expression, _set);
      _xblockexpression = new ExpressionEvaluation(pBody, evaluator, null);
    }
    return _xblockexpression;
  }
}