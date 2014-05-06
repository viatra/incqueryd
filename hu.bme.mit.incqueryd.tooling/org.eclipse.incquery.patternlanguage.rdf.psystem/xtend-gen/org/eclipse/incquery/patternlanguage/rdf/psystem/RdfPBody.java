package org.eclipse.incquery.patternlanguage.rdf.psystem;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
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
import org.eclipse.incquery.runtime.matchers.psystem.PBody;
import org.eclipse.incquery.runtime.matchers.psystem.PConstraint;
import org.eclipse.incquery.runtime.matchers.psystem.PVariable;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PQuery;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class RdfPBody {
  public static PBody create(final PatternBody body, final Pattern pattern, final PQuery query) {
    PBody _pBody = new PBody(query);
    final Procedure1<PBody> _function = new Procedure1<PBody>() {
      public void apply(final PBody pBody) {
        EList<Variable> _parameters = pattern.getParameters();
        final Function1<Variable,ExportedParameter> _function = new Function1<Variable,ExportedParameter>() {
          public ExportedParameter apply(final Variable parameter) {
            PVariable _pVariable = RdfPBody.toPVariable(parameter, pBody);
            String _name = parameter.getName();
            ExportedParameter _exportedParameter = new ExportedParameter(pBody, _pVariable, _name);
            return _exportedParameter;
          }
        };
        List<ExportedParameter> _map = ListExtensions.<Variable, ExportedParameter>map(_parameters, _function);
        pBody.setExportedParameters(_map);
        Set<PConstraint> _constraints = pBody.getConstraints();
        EList<Variable> _parameters_1 = pattern.getParameters();
        final Function1<Variable,Boolean> _function_1 = new Function1<Variable,Boolean>() {
          public Boolean apply(final Variable it) {
            Type _type = it.getType();
            boolean _notEquals = (!Objects.equal(_type, null));
            return Boolean.valueOf(_notEquals);
          }
        };
        Iterable<Variable> _filter = IterableExtensions.<Variable>filter(_parameters_1, _function_1);
        final Function1<Variable,PConstraint> _function_2 = new Function1<Variable,PConstraint>() {
          public PConstraint apply(final Variable parameter) {
            return null;
          }
        };
        Iterable<PConstraint> _map_1 = IterableExtensions.<Variable, PConstraint>map(_filter, _function_2);
        Iterables.<PConstraint>addAll(_constraints, _map_1);
        Set<PConstraint> _constraints_1 = pBody.getConstraints();
        EList<Constraint> _constraints_2 = body.getConstraints();
        final Function1<Constraint,PConstraint> _function_3 = new Function1<Constraint,PConstraint>() {
          public PConstraint apply(final Constraint it) {
            PConstraint _create = RdfPConstraint.create(it);
            return _create;
          }
        };
        List<PConstraint> _map_2 = ListExtensions.<Constraint, PConstraint>map(_constraints_2, _function_3);
        _constraints_1.addAll(_map_2);
      }
    };
    PBody _doubleArrow = ObjectExtensions.<PBody>operator_doubleArrow(_pBody, _function);
    return _doubleArrow;
  }
  
  public static PVariable toPVariable(final Variable variable, final PBody pBody) {
    PVariable _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (variable instanceof ParameterRef) {
        final ParameterRef _parameterRef = (ParameterRef)variable;
        _matched=true;
        Variable _referredParam = _parameterRef.getReferredParam();
        PVariable _pVariable = RdfPBody.toPVariable(_referredParam, pBody);
        _switchResult = _pVariable;
      }
    }
    if (!_matched) {
      String _name = variable.getName();
      PVariable _orCreateVariableByName = pBody.getOrCreateVariableByName(_name);
      _switchResult = _orCreateVariableByName;
    }
    return _switchResult;
  }
}
