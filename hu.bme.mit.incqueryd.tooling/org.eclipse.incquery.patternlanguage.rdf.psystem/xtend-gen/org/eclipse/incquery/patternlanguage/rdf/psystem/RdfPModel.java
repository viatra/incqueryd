package org.eclipse.incquery.patternlanguage.rdf.psystem;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import hu.bme.mit.incqueryd.rdf.RdfUtils;
import java.net.URL;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern;
import org.eclipse.incquery.patternlanguage.patternLanguage.ValueReference;
import org.eclipse.incquery.patternlanguage.rdf.psystem.RdfPQuery;
import org.eclipse.incquery.patternlanguage.rdf.psystem.RdfPVariable;
import org.eclipse.incquery.patternlanguage.rdf.psystem.RdfPatternMatcherContext;
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfPatternModel;
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.Vocabulary;
import org.eclipse.incquery.runtime.matchers.psystem.PBody;
import org.eclipse.incquery.runtime.matchers.psystem.PVariable;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PQuery;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;
import org.eclipse.incquery.runtime.matchers.tuple.Tuple;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.openrdf.model.Model;

@SuppressWarnings("all")
public class RdfPModel {
  private final RdfPatternModel patternModel;
  
  public final RdfPatternMatcherContext context;
  
  private final Cache<Pattern,PQuery> queries = CacheBuilder.newBuilder().<Pattern, PQuery>build(new CacheLoader<Pattern,PQuery>() {
    @Override
    public PQuery load(final Pattern pattern) throws Exception {
      return new RdfPQuery(pattern, RdfPModel.this);
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
    try {
      this.patternModel = patternModel;
      EList<Vocabulary> _vocabularies = patternModel.getVocabularies();
      final Function1<Vocabulary,URL> _function = new Function1<Vocabulary,URL>() {
        public URL apply(final Vocabulary it) {
          try {
            String _location = it.getLocation();
            return new URL(_location);
          } catch (Throwable _e) {
            throw Exceptions.sneakyThrow(_e);
          }
        }
      };
      List<URL> _map = ListExtensions.<Vocabulary, URL>map(_vocabularies, _function);
      Set<URL> _set = IterableExtensions.<URL>toSet(_map);
      final Model vocabulary = RdfUtils.load(_set);
      RdfPatternMatcherContext _rdfPatternMatcherContext = new RdfPatternMatcherContext(vocabulary);
      this.context = _rdfPatternMatcherContext;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public Tuple toTuple(final List<ValueReference> valueReferences, final PBody pBody) {
    FlatTuple _xblockexpression = null;
    {
      final Function1<ValueReference,PVariable> _function = new Function1<ValueReference,PVariable>() {
        public PVariable apply(final ValueReference it) {
          return RdfPVariable.toPVariable(it, pBody, RdfPModel.this);
        }
      };
      final List<PVariable> elements = ListExtensions.<ValueReference, PVariable>map(valueReferences, _function);
      _xblockexpression = new FlatTuple(elements);
    }
    return _xblockexpression;
  }
}
