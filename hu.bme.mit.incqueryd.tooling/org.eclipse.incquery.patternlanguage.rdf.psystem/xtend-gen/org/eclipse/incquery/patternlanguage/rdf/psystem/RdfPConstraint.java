package org.eclipse.incquery.patternlanguage.rdf.psystem;

import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.incquery.patternlanguage.patternLanguage.CompareConstraint;
import org.eclipse.incquery.patternlanguage.patternLanguage.Constraint;
import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern;
import org.eclipse.incquery.patternlanguage.patternLanguage.PatternCall;
import org.eclipse.incquery.patternlanguage.patternLanguage.PatternCompositionConstraint;
import org.eclipse.incquery.patternlanguage.patternLanguage.ValueReference;
import org.eclipse.incquery.patternlanguage.patternLanguage.Variable;
import org.eclipse.incquery.patternlanguage.patternLanguage.VariableReference;
import org.eclipse.incquery.patternlanguage.rdf.psystem.PUtils;
import org.eclipse.incquery.patternlanguage.rdf.psystem.RdfPatternMatcherContext;
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfCheckConstraint;
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfPathExpressionConstraint;
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.TypeConstraint;
import org.eclipse.incquery.runtime.matchers.psystem.BasePConstraint;
import org.eclipse.incquery.runtime.matchers.psystem.PBody;
import org.eclipse.incquery.runtime.matchers.psystem.PConstraint;
import org.eclipse.incquery.runtime.matchers.psystem.PVariable;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.NegativePatternCall;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.BinaryTransitiveClosure;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.PositivePatternCall;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeUnary;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PQuery;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;
import org.eclipse.incquery.runtime.matchers.tuple.Tuple;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;

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
        _switchResult = null;
      }
    }
    if (!_matched) {
      if (constraint instanceof TypeConstraint) {
        _matched=true;
        _switchResult = RdfPConstraint.createTypeConstraint(((TypeConstraint)constraint), pBody, context);
      }
    }
    if (!_matched) {
      if (constraint instanceof RdfPathExpressionConstraint) {
        _matched=true;
        _switchResult = null;
      }
    }
    if (!_matched) {
      if (constraint instanceof RdfCheckConstraint) {
        _matched=true;
        _switchResult = null;
      }
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
      final Tuple pNodeTuple = RdfPConstraint.getPNodeTuple(_parameters, pBody);
      BasePConstraint _xifexpression = null;
      boolean _isTransitive = call.isTransitive();
      boolean _not = (!_isTransitive);
      if (_not) {
        BasePConstraint _xifexpression_1 = null;
        boolean _isNegative = constraint.isNegative();
        if (_isNegative) {
          _xifexpression_1 = new NegativePatternCall(pBody, pNodeTuple, calledQuery);
        } else {
          _xifexpression_1 = new PositivePatternCall(pBody, pNodeTuple, calledQuery);
        }
        _xifexpression = _xifexpression_1;
      } else {
        BinaryTransitiveClosure _xifexpression_2 = null;
        int _size = pNodeTuple.getSize();
        boolean _notEquals = (_size != 2);
        if (_notEquals) {
          throw new RuntimeException("Transitive closure only supported for binary patterns");
        } else {
          BinaryTransitiveClosure _xifexpression_3 = null;
          boolean _isNegative_1 = constraint.isNegative();
          if (_isNegative_1) {
            throw new RuntimeException("Unsupported negated transitive closure");
          } else {
            _xifexpression_3 = new BinaryTransitiveClosure(pBody, pNodeTuple, calledQuery);
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
  
  public static Tuple getPNodeTuple(final List<ValueReference> valueReferences, final PBody pBody) {
    FlatTuple _xblockexpression = null;
    {
      final Function1<ValueReference,PVariable> _function = new Function1<ValueReference,PVariable>() {
        public PVariable apply(final ValueReference it) {
          return PUtils.toPVariable(it, pBody);
        }
      };
      final List<PVariable> elements = ListExtensions.<ValueReference, PVariable>map(valueReferences, _function);
      _xblockexpression = new FlatTuple(elements);
    }
    return _xblockexpression;
  }
  
  public static TypeUnary createTypeConstraint(final TypeConstraint constraint, final PBody pBody, final RdfPatternMatcherContext context) {
    TypeUnary _xblockexpression = null;
    {
      VariableReference _var = constraint.getVar();
      final Variable variable = PUtils.resolve(_var);
      _xblockexpression = PUtils.toTypeConstraint(variable, pBody, context);
    }
    return _xblockexpression;
  }
}
