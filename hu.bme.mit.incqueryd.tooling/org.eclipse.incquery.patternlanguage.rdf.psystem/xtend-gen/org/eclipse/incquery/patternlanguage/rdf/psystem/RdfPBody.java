package org.eclipse.incquery.patternlanguage.rdf.psystem;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.incquery.patternlanguage.patternLanguage.Constraint;
import org.eclipse.incquery.patternlanguage.patternLanguage.ParameterRef;
import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern;
import org.eclipse.incquery.patternlanguage.patternLanguage.PatternBody;
import org.eclipse.incquery.patternlanguage.patternLanguage.Type;
import org.eclipse.incquery.patternlanguage.patternLanguage.Variable;
import org.eclipse.incquery.patternlanguage.rdf.psystem.RdfPConstraint;
import org.eclipse.incquery.patternlanguage.rdf.psystem.RdfPatternMatcherContext;
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfClass;
import org.eclipse.incquery.runtime.matchers.psystem.PBody;
import org.eclipse.incquery.runtime.matchers.psystem.PConstraint;
import org.eclipse.incquery.runtime.matchers.psystem.PVariable;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeUnary;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PQuery;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class RdfPBody {
  public static PBody create(final PatternBody body, final Pattern pattern, final PQuery query, final RdfPatternMatcherContext context) {
    PBody _pBody = new PBody(query);
    final Procedure1<PBody> _function = new Procedure1<PBody>() {
      public void apply(final PBody pBody) {
        EList<Variable> _parameters = pattern.getParameters();
        final Function1<Variable,ExportedParameter> _function = new Function1<Variable,ExportedParameter>() {
          public ExportedParameter apply(final Variable parameter) {
            PVariable _pVariable = RdfPBody.toPVariable(parameter, pBody);
            String _name = parameter.getName();
            return new ExportedParameter(pBody, _pVariable, _name);
          }
        };
        List<ExportedParameter> _map = ListExtensions.<Variable, ExportedParameter>map(_parameters, _function);
        pBody.setExportedParameters(_map);
        Set<PConstraint> _constraints = pBody.getConstraints();
        EList<Variable> _parameters_1 = pattern.getParameters();
        final Function1<Variable,List<TypeUnary>> _function_1 = new Function1<Variable,List<TypeUnary>>() {
          public List<TypeUnary> apply(final Variable parameter) {
            List<TypeUnary> _switchResult = null;
            Type _type = parameter.getType();
            final Type type = _type;
            boolean _matched = false;
            if (!_matched) {
              if (type instanceof RdfClass) {
                _matched=true;
                List<TypeUnary> _xblockexpression = null;
                {
                  final PVariable pVariable = RdfPBody.toPVariable(parameter, pBody);
                  String _printType = context.printType(type);
                  TypeUnary _typeUnary = new TypeUnary(pBody, pVariable, type, _printType);
                  _xblockexpression = Collections.<TypeUnary>unmodifiableList(Lists.<TypeUnary>newArrayList(_typeUnary));
                }
                _switchResult = _xblockexpression;
              }
            }
            if (!_matched) {
              _switchResult = Collections.<TypeUnary>unmodifiableList(Lists.<TypeUnary>newArrayList());
            }
            return _switchResult;
          }
        };
        List<List<TypeUnary>> _map_1 = ListExtensions.<Variable, List<TypeUnary>>map(_parameters_1, _function_1);
        Iterable<PConstraint> _flatten = Iterables.<PConstraint>concat(_map_1);
        Iterables.<PConstraint>addAll(_constraints, _flatten);
        Set<PConstraint> _constraints_1 = pBody.getConstraints();
        EList<Constraint> _constraints_2 = body.getConstraints();
        final Function1<Constraint,PConstraint> _function_2 = new Function1<Constraint,PConstraint>() {
          public PConstraint apply(final Constraint it) {
            return RdfPConstraint.create(it);
          }
        };
        List<PConstraint> _map_2 = ListExtensions.<Constraint, PConstraint>map(_constraints_2, _function_2);
        _constraints_1.addAll(_map_2);
      }
    };
    return ObjectExtensions.<PBody>operator_doubleArrow(_pBody, _function);
  }
  
  public static PVariable toPVariable(final Variable variable, final PBody pBody) {
    PVariable _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (variable instanceof ParameterRef) {
        _matched=true;
        Variable _referredParam = ((ParameterRef)variable).getReferredParam();
        _switchResult = RdfPBody.toPVariable(_referredParam, pBody);
      }
    }
    if (!_matched) {
      String _name = variable.getName();
      _switchResult = pBody.getOrCreateVariableByName(_name);
    }
    return _switchResult;
  }
}
