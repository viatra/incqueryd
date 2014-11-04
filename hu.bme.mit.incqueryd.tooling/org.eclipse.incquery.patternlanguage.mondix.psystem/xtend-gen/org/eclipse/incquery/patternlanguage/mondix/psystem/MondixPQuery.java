package org.eclipse.incquery.patternlanguage.mondix.psystem;

import org.eclipse.incquery.patternlanguage.mondix.psystem.MondixPBody;
import org.eclipse.incquery.patternlanguage.mondix.psystem.MondixPModel;
import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern;
import org.eclipse.incquery.patternlanguage.patternLanguage.PatternBody;
import org.eclipse.incquery.patternlanguage.util.psystem.GenericPQuery;
import org.eclipse.incquery.runtime.matchers.psystem.PBody;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PQuery;
import org.eclipse.xtext.xbase.lib.Functions.Function2;

@SuppressWarnings("all")
public class MondixPQuery {
  public static GenericPQuery toPQuery(final Pattern pattern, final MondixPModel model) {
    final Function2<PatternBody, PQuery, PBody> _function = new Function2<PatternBody, PQuery, PBody>() {
      public PBody apply(final PatternBody patternBody, final PQuery query) {
        return MondixPBody.toPBody(patternBody, pattern, query, model);
      }
    };
    return new GenericPQuery(pattern, _function);
  }
}
