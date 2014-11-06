package org.eclipse.incquery.patternlanguage.mondix.psystem;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import java.util.List;
import org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.MondixPatternModel;
import org.eclipse.incquery.patternlanguage.mondix.psystem.MondixPQuery;
import org.eclipse.incquery.patternlanguage.mondix.psystem.MondixPVariable;
import org.eclipse.incquery.patternlanguage.mondix.psystem.MondixPatternMatcherContext;
import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern;
import org.eclipse.incquery.patternlanguage.patternLanguage.ValueReference;
import org.eclipse.incquery.runtime.matchers.psystem.PBody;
import org.eclipse.incquery.runtime.matchers.psystem.PVariable;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PQuery;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;
import org.eclipse.incquery.runtime.matchers.tuple.Tuple;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@SuppressWarnings("all")
public class MondixPModel {
  private final MondixPatternModel patternModel;
  
  public final MondixPatternMatcherContext context;
  
  private final LoadingCache<Pattern, PQuery> queries = CacheBuilder.newBuilder().<Pattern, PQuery>build(new CacheLoader<Pattern, PQuery>() {
    @Override
    public PQuery load(final Pattern it) throws Exception {
      return MondixPQuery.toPQuery(it, MondixPModel.this);
    }
  });
  
  public PQuery findQueryOf(final Pattern pattern) {
    try {
      return this.queries.get(pattern);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public MondixPModel(final MondixPatternModel patternModel) {
    this.patternModel = patternModel;
    MondixPatternMatcherContext _mondixPatternMatcherContext = new MondixPatternMatcherContext();
    this.context = _mondixPatternMatcherContext;
  }
  
  public Tuple toTuple(final List<ValueReference> valueReferences, final PBody pBody) {
    FlatTuple _xblockexpression = null;
    {
      final Function1<ValueReference, PVariable> _function = new Function1<ValueReference, PVariable>() {
        public PVariable apply(final ValueReference it) {
          return MondixPVariable.toPVariable(it, pBody, MondixPModel.this);
        }
      };
      final PVariable[] elements = ((PVariable[])Conversions.unwrapArray(ListExtensions.<ValueReference, PVariable>map(valueReferences, _function), PVariable.class));
      _xblockexpression = new FlatTuple(elements);
    }
    return _xblockexpression;
  }
}
