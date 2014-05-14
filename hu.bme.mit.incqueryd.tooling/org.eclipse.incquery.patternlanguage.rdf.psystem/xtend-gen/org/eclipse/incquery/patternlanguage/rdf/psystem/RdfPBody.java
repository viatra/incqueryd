package org.eclipse.incquery.patternlanguage.rdf.psystem;

import com.google.common.collect.Iterables;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.incquery.patternlanguage.patternLanguage.Constraint;
import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern;
import org.eclipse.incquery.patternlanguage.patternLanguage.PatternBody;
import org.eclipse.incquery.patternlanguage.patternLanguage.Variable;
import org.eclipse.incquery.patternlanguage.rdf.psystem.PUtils;
import org.eclipse.incquery.patternlanguage.rdf.psystem.RdfPConstraint;
import org.eclipse.incquery.patternlanguage.rdf.psystem.RdfPatternMatcherContext;
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
  public static PBody toPBody(final PatternBody body, final Pattern pattern, final PQuery query, final RdfPatternMatcherContext context) {
    PBody _pBody = new PBody(query);
    final Procedure1<PBody> _function = new Procedure1<PBody>() {
      public void apply(final PBody pBody) {
        EList<Variable> _parameters = pattern.getParameters();
        final Function1<Variable,ExportedParameter> _function = new Function1<Variable,ExportedParameter>() {
          public ExportedParameter apply(final Variable parameter) {
            PVariable _pVariable = PUtils.toPVariable(parameter, pBody);
            String _name = parameter.getName();
            return new ExportedParameter(pBody, _pVariable, _name);
          }
        };
        List<ExportedParameter> _map = ListExtensions.<Variable, ExportedParameter>map(_parameters, _function);
        pBody.setExportedParameters(_map);
        Set<PConstraint> _constraints = pBody.getConstraints();
        EList<Variable> _parameters_1 = pattern.getParameters();
        final Function1<Variable,TypeUnary> _function_1 = new Function1<Variable,TypeUnary>() {
          public TypeUnary apply(final Variable parameter) {
            return RdfPConstraint.toTypeConstraint(parameter, pBody, context);
          }
        };
        List<TypeUnary> _map_1 = ListExtensions.<Variable, TypeUnary>map(_parameters_1, _function_1);
        EList<Constraint> _constraints_1 = body.getConstraints();
        final Function1<Constraint,PConstraint> _function_2 = new Function1<Constraint,PConstraint>() {
          public PConstraint apply(final Constraint constraint) {
            return RdfPConstraint.create(constraint, pBody, context);
          }
        };
        List<PConstraint> _map_2 = ListExtensions.<Constraint, PConstraint>map(_constraints_1, _function_2);
        Iterable<PConstraint> _plus = Iterables.<PConstraint>concat(_map_1, _map_2);
        Iterables.<PConstraint>addAll(_constraints, _plus);
      }
    };
    return ObjectExtensions.<PBody>operator_doubleArrow(_pBody, _function);
  }
}
