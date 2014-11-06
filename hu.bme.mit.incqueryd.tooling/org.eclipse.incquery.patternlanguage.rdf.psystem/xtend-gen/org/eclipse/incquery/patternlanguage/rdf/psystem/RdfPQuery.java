package org.eclipse.incquery.patternlanguage.rdf.psystem;

import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern;
import org.eclipse.incquery.patternlanguage.patternLanguage.PatternBody;
import org.eclipse.incquery.patternlanguage.rdf.psystem.RdfPBody;
import org.eclipse.incquery.patternlanguage.rdf.psystem.RdfPModel;
import org.eclipse.incquery.patternlanguage.util.psystem.GenericPQuery;
import org.eclipse.incquery.runtime.matchers.psystem.PBody;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PQuery;
import org.eclipse.xtext.xbase.lib.Functions.Function2;

@SuppressWarnings("all")
public class RdfPQuery {
  public static GenericPQuery toPQuery(final Pattern pattern, final RdfPModel model) {
    final Function2<PatternBody, PQuery, PBody> _function = new Function2<PatternBody, PQuery, PBody>() {
      public PBody apply(final PatternBody patternBody, final PQuery query) {
        return RdfPBody.toPBody(patternBody, pattern, query, model);
      }
    };
    return new GenericPQuery(pattern, _function);
  }
}
