package org.eclipse.incquery.patternlanguage.rdf.tests;

import com.google.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.incquery.patternlanguage.patternLanguage.Constraint;
import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern;
import org.eclipse.incquery.patternlanguage.patternLanguage.PatternBody;
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.Iri;
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfClassConstraint;
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfPatternModel;
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.TypeId;
import org.eclipse.incquery.patternlanguage.rdf.tests.RdfPatternLanguageInjectorProvider;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@InjectWith(RdfPatternLanguageInjectorProvider.class)
@RunWith(XtextRunner.class)
@SuppressWarnings("all")
public class ParserTest {
  @Inject
  private ParseHelper<RdfPatternModel> parser;
  
  public final static String POS_LENGTH_SOURCE = new Function0<String>() {
    public String apply() {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("vocabulary <https://opensourceprojects.eu/p/mondo/trainbenchmark/ci/cf1bdd52087e7f5169aa1b1ee300b8eb6e6081b2/tree/src/hu.bme.mit.trainbenchmark.generator.rdf/src/main/resources/railway.owl.clear?format=raw>");
      _builder.newLine();
      _builder.newLine();
      _builder.append("base <http://www.semanticweb.org/ontologies/2011/1/TrainRequirementOntology.owl#>");
      _builder.newLine();
      _builder.append("prefix xsd: <http://www.w3.org/2001/XMLSchema#>");
      _builder.newLine();
      _builder.newLine();
      _builder.append("pattern posLength(Segment, SegmentLength) {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("<Segment>(Segment);");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("<Segment_length>(Segment, SegmentLength);");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("check(\'SegmentLength <= 0\');");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      return _builder.toString();
    }
  }.apply();
  
  @Test
  public void posLength() {
    try {
      final RdfPatternModel model = this.parser.parse(ParserTest.POS_LENGTH_SOURCE);
      Resource _eResource = model.eResource();
      EList<Resource.Diagnostic> _errors = _eResource.getErrors();
      boolean _isEmpty = _errors.isEmpty();
      Assert.assertTrue(_isEmpty);
      String _baseIriValue = model.getBaseIriValue();
      Assert.assertEquals("http://www.semanticweb.org/ontologies/2011/1/TrainRequirementOntology.owl#", _baseIriValue);
      EList<Pattern> _patterns = model.getPatterns();
      Pattern _head = IterableExtensions.<Pattern>head(_patterns);
      EList<PatternBody> _bodies = _head.getBodies();
      PatternBody _head_1 = IterableExtensions.<PatternBody>head(_bodies);
      EList<Constraint> _constraints = _head_1.getConstraints();
      Constraint _head_2 = IterableExtensions.<Constraint>head(_constraints);
      final Constraint firstConstraint = _head_2;
      boolean _matched = false;
      if (!_matched) {
        if (firstConstraint instanceof RdfClassConstraint) {
          _matched=true;
          TypeId _type = ((RdfClassConstraint)firstConstraint).getType();
          final TypeId typeId = _type;
          boolean _matched_1 = false;
          if (!_matched_1) {
            if (typeId instanceof Iri) {
              _matched_1=true;
              String _value = ((Iri)typeId).getValue();
              Assert.assertEquals("Segment", _value);
            }
          }
          if (!_matched_1) {
            Assert.fail();
          }
        }
      }
      if (!_matched) {
        Assert.fail();
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
