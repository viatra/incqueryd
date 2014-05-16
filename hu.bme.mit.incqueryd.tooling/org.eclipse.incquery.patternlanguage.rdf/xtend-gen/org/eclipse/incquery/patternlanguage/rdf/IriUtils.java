package org.eclipse.incquery.patternlanguage.rdf;

import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.Base;
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.Iri;
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.Prefix;
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfPatternModel;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.EcoreUtil2;

@SuppressWarnings("all")
public class IriUtils {
  public static String getValue(final Iri iri) {
    String _xblockexpression = null;
    {
      String _elvis = null;
      Prefix _prefix = iri.getPrefix();
      String _iri = null;
      if (_prefix!=null) {
        _iri=_prefix.getIri();
      }
      if (_iri != null) {
        _elvis = _iri;
      } else {
        RdfPatternModel _containerOfType = EcoreUtil2.<RdfPatternModel>getContainerOfType(iri, RdfPatternModel.class);
        Base _base = null;
        if (_containerOfType!=null) {
          _base=_containerOfType.getBase();
        }
        String _iri_1 = null;
        if (_base!=null) {
          _iri_1=_base.getIri();
        }
        _elvis = _iri_1;
      }
      final String prefix = _elvis;
      StringConcatenation _builder = new StringConcatenation();
      _builder.append(prefix, "");
      String _iri_2 = iri.getIri();
      _builder.append(_iri_2, "");
      _xblockexpression = _builder.toString();
    }
    return _xblockexpression;
  }
}
