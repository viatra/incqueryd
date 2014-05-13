package org.eclipse.incquery.patternlanguage.rdf.psystem;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.incquery.patternlanguage.patternLanguage.Annotation;
import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern;
import org.eclipse.incquery.patternlanguage.patternLanguage.PatternBody;
import org.eclipse.incquery.patternlanguage.patternLanguage.Variable;
import org.eclipse.incquery.patternlanguage.rdf.psystem.PUtils;
import org.eclipse.incquery.patternlanguage.rdf.psystem.RdfPBody;
import org.eclipse.incquery.patternlanguage.rdf.psystem.RdfPatternMatcherContext;
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfPatternModel;
import org.eclipse.incquery.runtime.matchers.psystem.IQueryReference;
import org.eclipse.incquery.runtime.matchers.psystem.PBody;
import org.eclipse.incquery.runtime.matchers.psystem.PConstraint;
import org.eclipse.incquery.runtime.matchers.psystem.annotations.PAnnotation;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PDisjunction;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PQuery;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@SuppressWarnings("all")
public class RdfPQuery implements PQuery {
  private final List<PAnnotation> annotations;
  
  public List<PAnnotation> getAllAnnotations() {
    return this.annotations;
  }
  
  public List<PAnnotation> getAnnotationsByName(final String annotationName) {
    final Function1<PAnnotation,Boolean> _function = new Function1<PAnnotation,Boolean>() {
      public Boolean apply(final PAnnotation it) {
        String _name = it.getName();
        return Boolean.valueOf(Objects.equal(_name, annotationName));
      }
    };
    Iterable<PAnnotation> _filter = IterableExtensions.<PAnnotation>filter(this.annotations, _function);
    return IterableExtensions.<PAnnotation>toList(_filter);
  }
  
  public PAnnotation getFirstAnnotationByName(final String annotationName) {
    final Function1<PAnnotation,Boolean> _function = new Function1<PAnnotation,Boolean>() {
      public Boolean apply(final PAnnotation it) {
        String _name = it.getName();
        return Boolean.valueOf(Objects.equal(_name, annotationName));
      }
    };
    return IterableExtensions.<PAnnotation>findFirst(this.annotations, _function);
  }
  
  private final List<PParameter> parameters;
  
  public List<PParameter> getParameters() {
    return this.parameters;
  }
  
  public List<String> getParameterNames() {
    final Function1<PParameter,String> _function = new Function1<PParameter,String>() {
      public String apply(final PParameter it) {
        return it.getName();
      }
    };
    return ListExtensions.<PParameter, String>map(this.parameters, _function);
  }
  
  public Integer getPositionOfParameter(final String parameterName) {
    Integer _xblockexpression = null;
    {
      List<String> _parameterNames = this.getParameterNames();
      final int index = _parameterNames.indexOf(parameterName);
      Integer _xifexpression = null;
      int _minus = (-1);
      boolean _equals = (index == _minus);
      if (_equals) {
        _xifexpression = null;
      } else {
        _xifexpression = Integer.valueOf(index);
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  private final PQuery.PQueryStatus status = PQuery.PQueryStatus.OK;
  
  public PQuery.PQueryStatus getStatus() {
    return this.status;
  }
  
  public boolean isMutable() {
    return false;
  }
  
  public void checkMutability() throws IllegalStateException {
  }
  
  private final PDisjunction disjunction;
  
  public PDisjunction getDisjunctBodies() {
    return this.disjunction;
  }
  
  public Set<PQuery> getDirectReferredQueries() {
    PDisjunction _disjunctBodies = this.getDisjunctBodies();
    Set<PBody> _bodies = _disjunctBodies.getBodies();
    final Function1<PBody,Iterable<PQuery>> _function = new Function1<PBody,Iterable<PQuery>>() {
      public Iterable<PQuery> apply(final PBody body) {
        Set<PConstraint> _constraints = body.getConstraints();
        Iterable<IQueryReference> _filter = Iterables.<IQueryReference>filter(_constraints, IQueryReference.class);
        final Function1<IQueryReference,PQuery> _function = new Function1<IQueryReference,PQuery>() {
          public PQuery apply(final IQueryReference it) {
            return it.getReferredQuery();
          }
        };
        return IterableExtensions.<IQueryReference, PQuery>map(_filter, _function);
      }
    };
    Iterable<Iterable<PQuery>> _map = IterableExtensions.<PBody, Iterable<PQuery>>map(_bodies, _function);
    Iterable<PQuery> _flatten = Iterables.<PQuery>concat(_map);
    return IterableExtensions.<PQuery>toSet(_flatten);
  }
  
  public Set<PQuery> getAllReferredQueries() {
    Set<PQuery> _xblockexpression = null;
    {
      final HashSet<PQuery> processedQueries = Sets.<PQuery>newHashSet(((PQuery) this));
      final Set<PQuery> foundQueries = this.getDirectReferredQueries();
      final HashSet<PQuery> newQueries = Sets.<PQuery>newHashSet(foundQueries);
      boolean _containsAll = processedQueries.containsAll(newQueries);
      boolean _not = (!_containsAll);
      boolean _while = _not;
      while (_while) {
        {
          Iterator<PQuery> _iterator = newQueries.iterator();
          final PQuery query = _iterator.next();
          processedQueries.add(query);
          newQueries.remove(query);
          final Set<PQuery> referred = query.getDirectReferredQueries();
          referred.removeAll(processedQueries);
          foundQueries.addAll(referred);
          newQueries.addAll(referred);
        }
        boolean _containsAll_1 = processedQueries.containsAll(newQueries);
        boolean _not_1 = (!_containsAll_1);
        _while = _not_1;
      }
      _xblockexpression = foundQueries;
    }
    return _xblockexpression;
  }
  
  private final String fullyQualifiedName;
  
  public String getFullyQualifiedName() {
    return this.fullyQualifiedName;
  }
  
  public RdfPQuery(final Pattern pattern, final RdfPatternModel patternModel, final RdfPatternMatcherContext context) {
    EList<Variable> _parameters = pattern.getParameters();
    final Function1<Variable,PParameter> _function = new Function1<Variable,PParameter>() {
      public PParameter apply(final Variable it) {
        return PUtils.toPParameter(it);
      }
    };
    List<PParameter> _map = ListExtensions.<Variable, PParameter>map(_parameters, _function);
    this.parameters = _map;
    EList<Annotation> _annotations = pattern.getAnnotations();
    final Function1<Annotation,PAnnotation> _function_1 = new Function1<Annotation,PAnnotation>() {
      public PAnnotation apply(final Annotation it) {
        return PUtils.toPAnnotation(it);
      }
    };
    List<PAnnotation> _map_1 = ListExtensions.<Annotation, PAnnotation>map(_annotations, _function_1);
    this.annotations = _map_1;
    EList<PatternBody> _bodies = pattern.getBodies();
    final Function1<PatternBody,PBody> _function_2 = new Function1<PatternBody,PBody>() {
      public PBody apply(final PatternBody body) {
        return RdfPBody.create(body, pattern, RdfPQuery.this, context);
      }
    };
    List<PBody> _map_2 = ListExtensions.<PatternBody, PBody>map(_bodies, _function_2);
    Set<PBody> _set = IterableExtensions.<PBody>toSet(_map_2);
    PDisjunction _pDisjunction = new PDisjunction(this, _set);
    this.disjunction = _pDisjunction;
    String _name = pattern.getName();
    this.fullyQualifiedName = _name;
  }
}
