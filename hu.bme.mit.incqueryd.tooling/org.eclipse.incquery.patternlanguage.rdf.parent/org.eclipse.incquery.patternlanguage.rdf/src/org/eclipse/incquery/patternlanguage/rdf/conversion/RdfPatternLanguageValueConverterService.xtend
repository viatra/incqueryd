package org.eclipse.incquery.patternlanguage.rdf.conversion

import org.eclipse.xtext.common.services.DefaultTerminalConverters
import org.eclipse.xtext.conversion.ValueConverter
import org.eclipse.xtext.conversion.IValueConverter

class RdfPatternLanguageValueConverterService extends DefaultTerminalConverters {

	@ValueConverter(rule="RawIri")
	def IValueConverter<String> getRawIriValueConverter() {
		new RawIriValueConverter
	}

}
