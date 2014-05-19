package org.eclipse.incquery.patternlanguage.rdf.tests;

import com.google.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.incquery.patternlanguage.patternLanguage.Constraint;
import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern;
import org.eclipse.incquery.patternlanguage.patternLanguage.PatternBody;
import org.eclipse.incquery.patternlanguage.rdf.RdfPatternLanguageInjectorProvider;
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.Iri;
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfClassConstraint;
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfPatternModel;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.xbase.lib.Exceptions;
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
  
  @Test
  public void posLength() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("base <http://www.semanticweb.org/ontologies/2011/1/TrainRequirementOntology.owl#>");
      _builder.newLine();
      _builder.append("prefix xsd: <http://www.w3.org/2001/XMLSchema#>");
      _builder.newLine();
      _builder.newLine();
      _builder.append("pattern posLength(Segment, SegmentLength) {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Segment(Segment);");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Segment_length(Segment, SegmentLength);");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("check(SegmentLength, \'SegmentLength <= \"0\"^^xsd:integer\');");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final RdfPatternModel model = this.parser.parse(_builder);
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
          Iri _type = ((RdfClassConstraint)firstConstraint).getType();
          String _value = _type.getValue();
          Assert.assertEquals("Segment", _value);
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
