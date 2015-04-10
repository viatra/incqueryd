package org.eclipse.incquery.patternlanguage.rdf.conversion

import org.eclipse.xtext.conversion.impl.AbstractLexerBasedConverter
import org.eclipse.xtext.nodemodel.INode
import org.eclipse.xtext.conversion.ValueConverterException

class RawIriValueConverter extends AbstractLexerBasedConverter<String> {

	override toValue(String string, INode node) throws ValueConverterException {
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

	private def unescape(String string, String forbidden) {
		string.replace('''\\«forbidden»''', forbidden)
	}

	override toEscapedString(String value) {
		'''<«value.escape('<')»>'''
	}

	private def escape(String string, String forbidden) {
		string.replace(forbidden, '''\\«forbidden»''')
	}

}