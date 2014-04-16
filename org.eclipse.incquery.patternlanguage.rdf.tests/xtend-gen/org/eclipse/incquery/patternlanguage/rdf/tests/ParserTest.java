package org.eclipse.incquery.patternlanguage.rdf.tests;

import com.google.inject.Inject;
import org.eclipse.incquery.patternlanguage.rdf.RdfPatternLanguageInjectorProvider;
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.Base;
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.PatternModel;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@InjectWith(RdfPatternLanguageInjectorProvider.class)
@RunWith(XtextRunner.class)
@SuppressWarnings("all")
public class ParserTest {
  @Inject
  private ParseHelper<PatternModel> parser;
  
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
      _builder.append("check(SegmentLength <= \"0\"^^xsd:integer);");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final PatternModel model = this.parser.parse(_builder);
      Base _base = model.getBase();
      String _iri = _base.getIri();
      Assert.assertEquals("<http://www.semanticweb.org/ontologies/2011/1/TrainRequirementOntology.owl#>", _iri);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
