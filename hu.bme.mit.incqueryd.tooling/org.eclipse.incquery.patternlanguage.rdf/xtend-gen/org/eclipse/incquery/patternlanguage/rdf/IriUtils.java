package org.eclipse.incquery.patternlanguage.rdf;

import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.Iri;
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.IriPrefix;
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfPatternModel;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.EcoreUtil2;

@SuppressWarnings("all")
public class IriUtils {
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
}
