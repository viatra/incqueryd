package org.eclipse.incquery.patternlanguage.rdf;

import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.Iri;
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.Prefix;

@SuppressWarnings("all")
public class IriUtils {
  public static String getValue(final Iri it) {
    Prefix _prefix = it.getPrefix();
    String _iri = _prefix.getIri();
    String _iri_1 = it.getIri();
    return (_iri + _iri_1);
  }
}
