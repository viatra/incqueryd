package org.eclipse.incquery.patternlanguage.rdf.conversion

import org.eclipse.xtext.conversion.ValueConverterException
import org.eclipse.xtext.conversion.impl.AbstractNullSafeConverter
import org.eclipse.xtext.nodemodel.INode

class RawIriValueConverter extends AbstractNullSafeConverter<String> {

	private def unescape(String string, String forbidden) {
		string.replace('''\\«forbidden»''', forbidden)
	}

	private def escape(String string, String forbidden) {
		string.replace(forbidden, '''\\«forbidden»''')
	}
	
	override public internalToString(String value) {
		'''<«value.escape('<')»>'''
	}
	
	override protected internalToValue(String string, INode node) throws ValueConverterException {
		if (string == null) {
			null
		} else {
			if (string.matches("<.*>")) {
				string.substring(1, string.length - 1).unescape('<')
			} else {
				string
			}
		}
	}

}