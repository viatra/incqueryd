package org.eclipse.incquery.patternlanguage.rdf.psystem;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import java.util.List;
import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern;
import org.eclipse.incquery.patternlanguage.patternLanguage.ValueReference;
import org.eclipse.incquery.patternlanguage.rdf.RdfPatternLanguageUtils;
import org.eclipse.incquery.patternlanguage.rdf.psystem.RdfPQuery;
import org.eclipse.incquery.patternlanguage.rdf.psystem.RdfPVariable;
import org.eclipse.incquery.patternlanguage.rdf.psystem.RdfPatternMatcherContext;
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfPatternModel;
import org.eclipse.incquery.runtime.matchers.psystem.PBody;
import org.eclipse.incquery.runtime.matchers.psystem.PVariable;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PQuery;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;
import org.eclipse.incquery.runtime.matchers.tuple.Tuple;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.openrdf.model.Model;

@SuppressWarnings("all")
public class RdfPModel {
  private final RdfPatternModel patternModel;
  
  public final RdfPatternMatcherContext context;
  
  private final LoadingCache<Pattern, PQuery> queries = CacheBuilder.newBuilder().<Pattern, PQuery>build(new CacheLoader<Pattern, PQuery>() {
    @Override
    public PQuery load(final Pattern it) throws Exception {
      return RdfPQuery.toPQuery(it, RdfPModel.this);
    }
  });
  
  public PQuery findQueryOf(final Pattern pattern) {
    try {
      return this.queries.get(pattern);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public RdfPModel(final RdfPatternModel patternModel) {
    this.patternModel = patternModel;
    final Model vocabulary = RdfPatternLanguageUtils.getVocabulary(patternModel);
    RdfPatternMatcherContext _rdfPatternMatcherContext = new RdfPatternMatcherContext(vocabulary);
    this.context = _rdfPatternMatcherContext;
  }
  
  public Tuple toTuple(final List<ValueReference> valueReferences, final PBody pBody) {
    FlatTuple _xblockexpression = null;
    {
      final Function1<ValueReference, PVariable> _function = new Function1<ValueReference, PVariable>() {
        public PVariable apply(final ValueReference it) {
          return RdfPVariable.toPVariable(it, pBody, RdfPModel.this);
        }
      };
      final PVariable[] elements = ((PVariable[])Conversions.unwrapArray(ListExtensions.<ValueReference, PVariable>map(valueReferences, _function), PVariable.class));
      _xblockexpression = new FlatTuple(elements);
    }
    return _xblockexpression;
  }
}
