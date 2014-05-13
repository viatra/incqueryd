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
        _matched=true;
        _switchResult = null;
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
}
