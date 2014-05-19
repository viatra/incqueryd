package org.eclipse.incquery.patternlanguage.rdf.tests;

import com.google.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.incquery.patternlanguage.patternLanguage.Constraint;
import org.eclipse.incquery.patternlanguage.patternLanguage.EntityType;
import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern;
import org.eclipse.incquery.patternlanguage.patternLanguage.PatternBody;
import org.eclipse.incquery.patternlanguage.rdf.RdfPatternLanguageInjectorProvider;
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.Base;
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.Iri;
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfClass;
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
      _builder.append("check(\'SegmentLength <= \"0\"^^xsd:integer\');");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final RdfPatternModel model = this.parser.parse(_builder);
      Base _base = model.getBase();
      String _iri = _base.getIri();
      Assert.assertEquals("http://www.semanticweb.org/ontologies/2011/1/TrainRequirementOntology.owl#", _iri);
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
          EntityType _type = ((RdfClassConstraint)firstConstraint).getType();
          final EntityType type = _type;
          boolean _matched_1 = false;
          if (!_matched_1) {
            if (type instanceof RdfClass) {
              _matched_1=true;
              Iri _class_ = ((RdfClass)type).getClass_();
              String _iri_1 = _class_.getIri();
              Assert.assertEquals("Segment", _iri_1);
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
