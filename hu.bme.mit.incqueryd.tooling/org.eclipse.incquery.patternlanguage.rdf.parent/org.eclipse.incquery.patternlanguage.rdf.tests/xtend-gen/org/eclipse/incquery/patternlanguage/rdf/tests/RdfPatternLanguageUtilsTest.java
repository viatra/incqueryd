package org.eclipse.incquery.patternlanguage.rdf.tests;

import org.eclipse.emf.common.util.EList;
import org.eclipse.incquery.patternlanguage.patternLanguage.Constraint;
import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern;
import org.eclipse.incquery.patternlanguage.patternLanguage.PatternBody;
import org.eclipse.incquery.patternlanguage.patternLanguage.PatternLanguageFactory;
import org.eclipse.incquery.patternlanguage.rdf.RdfPatternLanguageUtils;
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.Iri;
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.IriPrefix;
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfClassConstraint;
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfPatternLanguageFactory;
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfPatternModel;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class RdfPatternLanguageUtilsTest {
  @Extension
  private final PatternLanguageFactory factory = PatternLanguageFactory.eINSTANCE;
  
  @Extension
  private final RdfPatternLanguageFactory rdfFactory = RdfPatternLanguageFactory.eINSTANCE;
  
  @Test
  public void simple() {
    final String iriValue = "iri";
    Iri _createIri = this.rdfFactory.createIri();
    final Procedure1<Iri> _function = new Procedure1<Iri>() {
      @Override
      public void apply(final Iri it) {
        it.setValue(iriValue);
      }
    };
    final Iri iri = ObjectExtensions.<Iri>operator_doubleArrow(_createIri, _function);
    String _asString = RdfPatternLanguageUtils.asString(iri);
    Assert.assertEquals(iriValue, _asString);
  }
  
  @Test
  public void prefixed() {
    final String iriPrefixValue = "prefix";
    IriPrefix _createIriPrefix = this.rdfFactory.createIriPrefix();
    final Procedure1<IriPrefix> _function = new Procedure1<IriPrefix>() {
      @Override
      public void apply(final IriPrefix it) {
        it.setValue(iriPrefixValue);
      }
    };
    final IriPrefix iriPrefix = ObjectExtensions.<IriPrefix>operator_doubleArrow(_createIriPrefix, _function);
    final String iriValue = "iri";
    Iri _createIri = this.rdfFactory.createIri();
    final Procedure1<Iri> _function_1 = new Procedure1<Iri>() {
      @Override
      public void apply(final Iri it) {
        it.setValue(iriValue);
        it.setPrefix(iriPrefix);
      }
    };
    final Iri iri = ObjectExtensions.<Iri>operator_doubleArrow(_createIri, _function_1);
    String _asString = RdfPatternLanguageUtils.asString(iri);
    Assert.assertEquals((iriPrefixValue + iriValue), _asString);
  }
  
  @Test
  public void base() {
    final String iriValue = "iri";
    Iri _createIri = this.rdfFactory.createIri();
    final Procedure1<Iri> _function = new Procedure1<Iri>() {
      @Override
      public void apply(final Iri it) {
        it.setValue(iriValue);
      }
    };
    final Iri iri = ObjectExtensions.<Iri>operator_doubleArrow(_createIri, _function);
    final String modelBaseIriValue = "base";
    RdfPatternModel _createRdfPatternModel = this.rdfFactory.createRdfPatternModel();
    final Procedure1<RdfPatternModel> _function_1 = new Procedure1<RdfPatternModel>() {
      @Override
      public void apply(final RdfPatternModel it) {
        it.setBaseIriValue(modelBaseIriValue);
        EList<Pattern> _patterns = it.getPatterns();
        Pattern _createPattern = RdfPatternLanguageUtilsTest.this.factory.createPattern();
        final Procedure1<Pattern> _function = new Procedure1<Pattern>() {
          @Override
          public void apply(final Pattern it) {
            EList<PatternBody> _bodies = it.getBodies();
            PatternBody _createPatternBody = RdfPatternLanguageUtilsTest.this.factory.createPatternBody();
            final Procedure1<PatternBody> _function = new Procedure1<PatternBody>() {
              @Override
              public void apply(final PatternBody it) {
                EList<Constraint> _constraints = it.getConstraints();
                RdfClassConstraint _createRdfClassConstraint = RdfPatternLanguageUtilsTest.this.rdfFactory.createRdfClassConstraint();
                final Procedure1<RdfClassConstraint> _function = new Procedure1<RdfClassConstraint>() {
                  @Override
                  public void apply(final RdfClassConstraint it) {
                    it.setType(iri);
                  }
                };
                RdfClassConstraint _doubleArrow = ObjectExtensions.<RdfClassConstraint>operator_doubleArrow(_createRdfClassConstraint, _function);
                _constraints.add(_doubleArrow);
              }
            };
            PatternBody _doubleArrow = ObjectExtensions.<PatternBody>operator_doubleArrow(_createPatternBody, _function);
            _bodies.add(_doubleArrow);
          }
        };
        Pattern _doubleArrow = ObjectExtensions.<Pattern>operator_doubleArrow(_createPattern, _function);
        _patterns.add(_doubleArrow);
      }
    };
    ObjectExtensions.<RdfPatternModel>operator_doubleArrow(_createRdfPatternModel, _function_1);
    String _asString = RdfPatternLanguageUtils.asString(iri);
    Assert.assertEquals((modelBaseIriValue + iriValue), _asString);
  }
}
