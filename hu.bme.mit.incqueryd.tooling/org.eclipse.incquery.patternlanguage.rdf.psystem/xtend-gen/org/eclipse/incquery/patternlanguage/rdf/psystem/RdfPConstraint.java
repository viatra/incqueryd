package org.eclipse.incquery.patternlanguage.rdf.psystem;

import org.eclipse.incquery.patternlanguage.patternLanguage.Constraint;
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfCheckConstraint;
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfPathExpressionConstraint;
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.TypeConstraint;
import org.eclipse.incquery.runtime.matchers.psystem.PConstraint;

@SuppressWarnings("all")
public class RdfPConstraint {
  public static PConstraint create(final Constraint constraint) {
    PConstraint _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (constraint instanceof TypeConstraint) {
        final TypeConstraint _typeConstraint = (TypeConstraint)constraint;
        _matched=true;
        _switchResult = null;
      }
    }
    if (!_matched) {
      if (constraint instanceof RdfPathExpressionConstraint) {
        final RdfPathExpressionConstraint _rdfPathExpressionConstraint = (RdfPathExpressionConstraint)constraint;
        _matched=true;
        _switchResult = null;
      }
    }
    if (!_matched) {
      if (constraint instanceof RdfCheckConstraint) {
        final RdfCheckConstraint _rdfCheckConstraint = (RdfCheckConstraint)constraint;
        _matched=true;
        _switchResult = null;
      }
    }
    return _switchResult;
  }
}
