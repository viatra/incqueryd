package org.eclipse.incquery.patternlanguage.rdf.conversion;

import org.eclipse.incquery.patternlanguage.rdf.conversion.RawIriValueConverter;
import org.eclipse.xtext.common.services.DefaultTerminalConverters;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverter;

@SuppressWarnings("all")
public class RdfPatternLanguageValueConverterService extends DefaultTerminalConverters {
  @ValueConverter(rule = "RawIri")
  public IValueConverter<String> getRawIriValueConverter() {
    return new RawIriValueConverter();
  }
}
