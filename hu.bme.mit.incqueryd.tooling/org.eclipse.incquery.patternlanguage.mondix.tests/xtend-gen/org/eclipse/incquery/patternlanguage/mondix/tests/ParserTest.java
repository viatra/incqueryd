package org.eclipse.incquery.patternlanguage.mondix.tests;

import com.google.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.incquery.patternlanguage.mondix.MondixPatternLanguageInjectorProvider;
import org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.MondixPatternModel;
import org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.NodeConstraint;
import org.eclipse.incquery.patternlanguage.patternLanguage.Constraint;
import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern;
import org.eclipse.incquery.patternlanguage.patternLanguage.PatternBody;
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

@InjectWith(MondixPatternLanguageInjectorProvider.class)
@RunWith(XtextRunner.class)
@SuppressWarnings("all")
public class ParserTest {
  @Inject
  private ParseHelper<MondixPatternModel> parser;
  
  public final static String POS_LENGTH_SOURCE = new Function0<String>() {
    public String apply() {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("pattern posLength(Segment, SegmentLength) {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Segment(Segment);");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Segment_length(Segment, SegmentLength);");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      return _builder.toString();
    }
  }.apply();
  
  @Test
  public void posLength() {
    try {
      final MondixPatternModel model = this.parser.parse(ParserTest.POS_LENGTH_SOURCE);
      Resource _eResource = model.eResource();
      EList<Resource.Diagnostic> _errors = _eResource.getErrors();
      boolean _isEmpty = _errors.isEmpty();
      Assert.assertTrue(_isEmpty);
      EList<Pattern> _patterns = model.getPatterns();
      Pattern _head = IterableExtensions.<Pattern>head(_patterns);
      EList<PatternBody> _bodies = _head.getBodies();
      PatternBody _head_1 = IterableExtensions.<PatternBody>head(_bodies);
      EList<Constraint> _constraints = _head_1.getConstraints();
      Constraint _head_2 = IterableExtensions.<Constraint>head(_constraints);
      final Constraint firstConstraint = _head_2;
      boolean _matched = false;
      if (!_matched) {
        if (firstConstraint instanceof NodeConstraint) {
          _matched=true;
          String _type = ((NodeConstraint)firstConstraint).getType();
          Assert.assertEquals("Segment", _type);
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
