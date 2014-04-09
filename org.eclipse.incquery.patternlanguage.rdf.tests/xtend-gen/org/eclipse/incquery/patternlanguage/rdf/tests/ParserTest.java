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
  public void base() {
    try {
      final String expectedBaseIri = "<http://example.org/>";
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("base ");
      _builder.append(expectedBaseIri, "");
      final PatternModel model = this.parser.parse(_builder);
      Base _base = model.getBase();
      String _iri = _base.getIri();
      Assert.assertEquals(expectedBaseIri, _iri);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
