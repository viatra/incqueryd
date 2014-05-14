package org.eclipse.incquery.patternlanguage.rdf.psystem;

import java.util.List;
import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern;
import org.eclipse.incquery.patternlanguage.patternLanguage.ValueReference;
import org.eclipse.incquery.patternlanguage.rdf.psystem.RdfPVariable;
import org.eclipse.incquery.runtime.matchers.psystem.PBody;
import org.eclipse.incquery.runtime.matchers.psystem.PVariable;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PQuery;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;
import org.eclipse.incquery.runtime.matchers.tuple.Tuple;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@SuppressWarnings("all")
public class RdfPUtils {
  public static Tuple toTuple(final List<ValueReference> valueReferences, final PBody pBody) {
    FlatTuple _xblockexpression = null;
    {
      final Function1<ValueReference,PVariable> _function = new Function1<ValueReference,PVariable>() {
        public PVariable apply(final ValueReference it) {
          return RdfPVariable.toPVariable(it, pBody);
        }
      };
      final List<PVariable> elements = ListExtensions.<ValueReference, PVariable>map(valueReferences, _function);
      _xblockexpression = new FlatTuple(elements);
    }
    return _xblockexpression;
  }
  
  public static PQuery findQueryOf(final Pattern pattern) {
    return null;
  }
}
