package org.eclipse.incquery.patternlanguage.rdf.validation;

import hu.bme.mit.incqueryd.rdf.RdfUtils;
import java.net.URL;
import java.util.Collections;
import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.incquery.patternlanguage.rdf.RdfPatternLanguageUtils;
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.Iri;
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfClassConstraint;
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfPatternLanguagePackage;
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfPropertyConstraint;
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.Vocabulary;
import org.eclipse.incquery.patternlanguage.rdf.validation.AbstractRdfPatternLanguageValidator;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.CheckType;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.openrdf.model.Model;
import org.openrdf.model.Resource;
import org.openrdf.model.impl.URIImpl;

/**
 * Custom validation rules.
 * 
 * see http://www.eclipse.org/Xtext/documentation.html#validation
 */
@SuppressWarnings("all")
public class RdfPatternLanguageValidator extends AbstractRdfPatternLanguageValidator {
  private final static Logger logger = Logger.getLogger(RdfPatternLanguageValidator.class);
  
  @Check
  public void checkIri(final Iri iri) {
    try {
      String _asString = RdfPatternLanguageUtils.asString(iri);
      new URIImpl(_asString);
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        final Exception e = (Exception)_t;
        EAttribute _iri_Value = RdfPatternLanguagePackage.eINSTANCE.getIri_Value();
        this.error("Invalid IRI, consider specifying a base IRI", iri, _iri_Value);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  @Check(CheckType.NORMAL)
  public void checkVocabulary(final Vocabulary vocabulary) {
    try {
      URL _url = RdfPatternLanguageUtils.getUrl(vocabulary);
      RdfUtils.load(Collections.<URL>unmodifiableSet(CollectionLiterals.<URL>newHashSet(_url)));
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        final Exception e = (Exception)_t;
        EAttribute _vocabulary_Location = RdfPatternLanguagePackage.eINSTANCE.getVocabulary_Location();
        this.warning("Can\'t load RDF vocabulary", vocabulary, _vocabulary_Location);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  @Check(CheckType.NORMAL)
  public void checkClassConstraint(final RdfClassConstraint classConstraint) {
    try {
      final Model vocabulary = RdfPatternLanguageUtils.getVocabulary(classConstraint);
      Iri _type = classConstraint.getType();
      final Resource type = RdfPatternLanguageUtils.toRdfResource(_type);
      boolean _isClass = RdfUtils.isClass(type, vocabulary);
      boolean _not = (!_isClass);
      if (_not) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("Class ");
        Iri _type_1 = classConstraint.getType();
        String _asString = RdfPatternLanguageUtils.asString(_type_1);
        _builder.append(_asString, "");
        _builder.append(" not found in any vocabulary");
        EReference _rdfClassConstraint_Type = RdfPatternLanguagePackage.eINSTANCE.getRdfClassConstraint_Type();
        this.warning(_builder.toString(), classConstraint, _rdfClassConstraint_Type);
      }
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        final Exception e = (Exception)_t;
        RdfPatternLanguageValidator.logger.warn(e);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  @Check(CheckType.NORMAL)
  public void checkPropertyConstraint(final RdfPropertyConstraint propertyConstraint) {
    try {
      final Model vocabulary = RdfPatternLanguageUtils.getVocabulary(propertyConstraint);
      Iri _refType = propertyConstraint.getRefType();
      final Resource refType = RdfPatternLanguageUtils.toRdfResource(_refType);
      boolean _isProperty = RdfUtils.isProperty(refType, vocabulary);
      boolean _not = (!_isProperty);
      if (_not) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("Property ");
        Iri _refType_1 = propertyConstraint.getRefType();
        String _asString = RdfPatternLanguageUtils.asString(_refType_1);
        _builder.append(_asString, "");
        _builder.append(" not found in any vocabulary");
        EReference _rdfPropertyConstraint_RefType = RdfPatternLanguagePackage.eINSTANCE.getRdfPropertyConstraint_RefType();
        this.warning(_builder.toString(), propertyConstraint, _rdfPropertyConstraint_RefType);
      }
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        final Exception e = (Exception)_t;
        RdfPatternLanguageValidator.logger.warn(e);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
}
