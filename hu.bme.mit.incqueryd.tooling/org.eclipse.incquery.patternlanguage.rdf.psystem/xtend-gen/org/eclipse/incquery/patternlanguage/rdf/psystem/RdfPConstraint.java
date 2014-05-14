package org.eclipse.incquery.patternlanguage.rdf.psystem;

import org.eclipse.emf.common.util.EList;
import org.eclipse.incquery.patternlanguage.patternLanguage.CompareConstraint;
import org.eclipse.incquery.patternlanguage.patternLanguage.CompareFeature;
import org.eclipse.incquery.patternlanguage.patternLanguage.Constraint;
import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern;
import org.eclipse.incquery.patternlanguage.patternLanguage.PatternCall;
import org.eclipse.incquery.patternlanguage.patternLanguage.PatternCompositionConstraint;
import org.eclipse.incquery.patternlanguage.patternLanguage.RelationType;
import org.eclipse.incquery.patternlanguage.patternLanguage.Type;
import org.eclipse.incquery.patternlanguage.patternLanguage.ValueReference;
import org.eclipse.incquery.patternlanguage.patternLanguage.Variable;
import org.eclipse.incquery.patternlanguage.patternLanguage.VariableReference;
import org.eclipse.incquery.patternlanguage.rdf.psystem.PUtils;
import org.eclipse.incquery.patternlanguage.rdf.psystem.RdfPatternMatcherContext;
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.Iri;
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfCheckConstraint;
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfClass;
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfClassConstraint;
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfProperty;
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfPropertyConstraint;
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
public class RdfPConstraint {
  public static PConstraint create(final Constraint constraint, final PBody pBody, final RdfPatternMatcherContext context) {
    PConstraint _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (constraint instanceof PatternCompositionConstraint) {
        _matched=true;
        _switchResult = RdfPConstraint.createPatternCompositionConstraint(((PatternCompositionConstraint)constraint), pBody);
      }
    }
    if (!_matched) {
      if (constraint instanceof CompareConstraint) {
        _matched=true;
        _switchResult = RdfPConstraint.createCompareConstraint(((CompareConstraint)constraint), pBody);
      }
    }
    if (!_matched) {
      if (constraint instanceof RdfClassConstraint) {
        _matched=true;
        _switchResult = RdfPConstraint.createClassConstraint(((RdfClassConstraint)constraint), pBody, context);
      }
    }
    if (!_matched) {
      if (constraint instanceof RdfPropertyConstraint) {
        _matched=true;
        _switchResult = RdfPConstraint.createPropertyConstraint(((RdfPropertyConstraint)constraint), pBody, context);
      }
    }
    if (!_matched) {
      if (constraint instanceof RdfCheckConstraint) {
        _matched=true;
        _switchResult = RdfPConstraint.createCheckConstraint(((RdfCheckConstraint)constraint));
      }
    }
    if (!_matched) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Unhandled case ");
      _builder.append(constraint, "");
      throw new IllegalArgumentException(_builder.toString());
    }
    return _switchResult;
  }
  
  public static PConstraint createPatternCompositionConstraint(final PatternCompositionConstraint constraint, final PBody pBody) {
    BasePConstraint _xblockexpression = null;
    {
      final PatternCall call = constraint.getCall();
      final Pattern patternRef = call.getPatternRef();
      final PQuery calledQuery = RdfPConstraint.findQuery(patternRef);
      EList<ValueReference> _parameters = call.getParameters();
      final Tuple tuple = PUtils.toTuple(_parameters, pBody);
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
        _xifexpression = _xifexpression_1;
      } else {
        BinaryTransitiveClosure _xifexpression_2 = null;
        int _size = tuple.getSize();
        boolean _notEquals = (_size != 2);
        if (_notEquals) {
          throw new RuntimeException("Transitive closure only supported for binary patterns");
        } else {
          BinaryTransitiveClosure _xifexpression_3 = null;
          boolean _isNegative_1 = constraint.isNegative();
          if (_isNegative_1) {
            throw new RuntimeException("Unsupported negated transitive closure");
          } else {
            _xifexpression_3 = new BinaryTransitiveClosure(pBody, tuple, calledQuery);
          }
          _xifexpression_2 = _xifexpression_3;
        }
        _xifexpression = _xifexpression_2;
      }
      _xblockexpression = _xifexpression;
    }
    return ((BasePConstraint)_xblockexpression);
  }
  
  public static PQuery findQuery(final Pattern pattern) {
    return null;
  }
  
  public static PConstraint createCompareConstraint(final CompareConstraint constraint, final PBody pBody) {
    DeferredPConstraint _xblockexpression = null;
    {
      ValueReference _leftOperand = constraint.getLeftOperand();
      final PVariable left = PUtils.toPVariable(_leftOperand, pBody);
      ValueReference _rightOperand = constraint.getRightOperand();
      final PVariable right = PUtils.toPVariable(_rightOperand, pBody);
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
  
  public static TypeUnary createClassConstraint(final RdfClassConstraint constraint, final PBody pBody, final RdfPatternMatcherContext context) {
    TypeUnary _xblockexpression = null;
    {
      VariableReference _variable = constraint.getVariable();
      final Variable variable = PUtils.resolve(_variable);
      _xblockexpression = RdfPConstraint.toTypeConstraint(variable, pBody, context);
    }
    return _xblockexpression;
  }
  
  public static PConstraint createPropertyConstraint(final RdfPropertyConstraint constraint, final PBody pBody, final RdfPatternMatcherContext context) {
    TypeBinary _switchResult = null;
    RelationType _refType = constraint.getRefType();
    final RelationType refType = _refType;
    boolean _matched = false;
    if (!_matched) {
      if (refType instanceof RdfProperty) {
        _matched=true;
        TypeBinary _xblockexpression = null;
        {
          VariableReference _source = constraint.getSource();
          Variable _resolve = PUtils.resolve(_source);
          final PVariable source = PUtils.toPVariable(_resolve, pBody);
          ValueReference _target = constraint.getTarget();
          final PVariable target = PUtils.toPVariable(_target, pBody);
          final Iri typeObject = ((RdfProperty)refType).getProperty();
          final String typeString = context.printType(typeObject);
          _xblockexpression = new TypeBinary(pBody, context, source, target, typeObject, typeString);
        }
        _switchResult = _xblockexpression;
      }
    }
    if (!_matched) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Constraint\'s reference must be ");
      _builder.append(RdfProperty.class, "");
      throw new IllegalArgumentException(_builder.toString());
    }
    return _switchResult;
  }
  
  public static PConstraint createCheckConstraint(final RdfCheckConstraint constraint) {
    return null;
  }
  
  public static TypeUnary toTypeConstraint(final Variable parameter, final PBody pBody, final RdfPatternMatcherContext context) {
    TypeUnary _switchResult = null;
    Type _type = parameter.getType();
    final Type type = _type;
    boolean _matched = false;
    if (!_matched) {
      if (type instanceof RdfClass) {
        _matched=true;
        TypeUnary _xblockexpression = null;
        {
          final PVariable pVariable = PUtils.toPVariable(parameter, pBody);
          String _printType = context.printType(type);
          _xblockexpression = new TypeUnary(pBody, pVariable, type, _printType);
        }
        _switchResult = _xblockexpression;
      }
    }
    if (!_matched) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Parameter\'s type must be ");
      _builder.append(RdfClass.class, "");
      throw new IllegalArgumentException(_builder.toString());
    }
    return _switchResult;
  }
}
