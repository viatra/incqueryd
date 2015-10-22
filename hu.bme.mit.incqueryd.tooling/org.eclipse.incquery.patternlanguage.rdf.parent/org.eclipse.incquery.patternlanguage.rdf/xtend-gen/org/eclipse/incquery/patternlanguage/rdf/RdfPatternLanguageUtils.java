package org.eclipse.incquery.patternlanguage.rdf;

import com.google.common.base.Objects;
import hu.bme.mit.incqueryd.rdf.RdfUtils;
import java.net.URL;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.Iri;
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.IriPrefix;
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfPatternModel;
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.Vocabulary;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.openrdf.model.Model;
import org.openrdf.model.Resource;
import org.openrdf.model.impl.URIImpl;

@SuppressWarnings("all")
public class RdfPatternLanguageUtils {
  public static String asString(final Iri iri) {
    String _xblockexpression = null;
    {
      String _elvis = null;
      IriPrefix _prefix = iri.getPrefix();
      String _value = null;
      if (_prefix!=null) {
        _value=_prefix.getValue();
      }
      if (_value != null) {
        _elvis = _value;
      } else {
        RdfPatternModel _containerOfType = EcoreUtil2.<RdfPatternModel>getContainerOfType(iri, RdfPatternModel.class);
        String _baseIriValue = null;
        if (_containerOfType!=null) {
          _baseIriValue=_containerOfType.getBaseIriValue();
        }
        _elvis = _baseIriValue;
      }
      final String prefix = _elvis;
      StringConcatenation _builder = new StringConcatenation();
      _builder.append(prefix, "");
      String _value_1 = iri.getValue();
      _builder.append(_value_1, "");
      _xblockexpression = _builder.toString();
    }
    return _xblockexpression;
  }
  
  public static Resource toRdfResource(final Iri iri) {
    String _asString = RdfPatternLanguageUtils.asString(iri);
    return RdfPatternLanguageUtils.toRdfResource(_asString);
  }
  
  public static Resource toRdfResource(final String iriString) {
    return new URIImpl(iriString);
  }
  
  public static Model getVocabulary(final EObject object) {
    try {
      Model _xblockexpression = null;
      {
        final RdfPatternModel patternModel = EcoreUtil2.<RdfPatternModel>getContainerOfType(object, RdfPatternModel.class);
        EList<Vocabulary> _vocabularies = patternModel.getVocabularies();
        final Function1<Vocabulary, URL> _function = new Function1<Vocabulary, URL>() {
          @Override
          public URL apply(final Vocabulary it) {
            return RdfPatternLanguageUtils.getUrl(it);
          }
        };
        List<URL> _map = ListExtensions.<Vocabulary, URL>map(_vocabularies, _function);
        Set<URL> _set = IterableExtensions.<URL>toSet(_map);
        _xblockexpression = RdfUtils.load(_set);
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public static URL getUrl(final Vocabulary vocabulary) {
    try {
      URL _xblockexpression = null;
      {
        String _location = vocabulary.getLocation();
        final URI uri = URI.createURI(_location);
        final org.eclipse.emf.ecore.resource.Resource containingResource = vocabulary.eResource();
        URI _xifexpression = null;
        boolean _or = false;
        boolean _isRelative = uri.isRelative();
        boolean _not = (!_isRelative);
        if (_not) {
          _or = true;
        } else {
          boolean _equals = Objects.equal(containingResource, null);
          _or = _equals;
        }
        if (_or) {
          _xifexpression = uri;
        } else {
          URI _uRI = containingResource.getURI();
          _xifexpression = uri.resolve(_uRI);
        }
        final URI resolvedUri = _xifexpression;
        String _string = resolvedUri.toString();
        _xblockexpression = new URL(_string);
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
