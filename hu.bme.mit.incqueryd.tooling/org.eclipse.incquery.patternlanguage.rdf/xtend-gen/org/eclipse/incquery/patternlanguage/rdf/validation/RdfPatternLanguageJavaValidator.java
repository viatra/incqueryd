package org.eclipse.incquery.patternlanguage.rdf.validation;

import com.google.common.collect.Sets;
import hu.bme.mit.incqueryd.rdf.RdfUtils;
import java.net.URL;
import java.util.Collections;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.incquery.patternlanguage.patternLanguage.PatternModel;
import org.eclipse.incquery.patternlanguage.rdf.IriUtils;
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.Iri;
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfPatternLanguagePackage;
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.Vocabulary;
import org.eclipse.incquery.patternlanguage.rdf.validation.AbstractRdfPatternLanguageJavaValidator;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.openrdf.model.impl.URIImpl;

@SuppressWarnings("all")
public class RdfPatternLanguageJavaValidator extends AbstractRdfPatternLanguageJavaValidator {
  public void checkPackageDeclaration(final PatternModel model) {
  }
  
  @Check
  public void checkVocabulary(final Vocabulary vocabulary) {
    try {
      String _location = vocabulary.getLocation();
      URL _uRL = new URL(_location);
      RdfUtils.load(Collections.<URL>unmodifiableSet(Sets.<URL>newHashSet(_uRL)));
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        final Exception e = (Exception)_t;
        EAttribute _vocabulary_Location = RdfPatternLanguagePackage.eINSTANCE.getVocabulary_Location();
        this.error("Invalid RDF vocabulary", vocabulary, _vocabulary_Location);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  @Check
  public void checkIri(final Iri iri) {
    try {
      String _asString = IriUtils.asString(iri);
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
}
