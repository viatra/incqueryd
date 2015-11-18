package org.eclipse.incquery.patternlanguage.rdf.conversion;

import com.google.common.base.Objects;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.conversion.impl.AbstractNullSafeConverter;
import org.eclipse.xtext.nodemodel.INode;

@SuppressWarnings("all")
public class RawIriValueConverter extends AbstractNullSafeConverter<String> {
  private String unescape(final String string, final String forbidden) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("\\\\");
    _builder.append(forbidden, "");
    return string.replace(_builder, forbidden);
  }
  
  private String escape(final String string, final String forbidden) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("\\\\");
    _builder.append(forbidden, "");
    return string.replace(forbidden, _builder);
  }
  
  @Override
  public String internalToString(final String value) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<");
    String _escape = this.escape(value, "<");
    _builder.append(_escape, "");
    _builder.append(">");
    return _builder.toString();
  }
  
  @Override
  protected String internalToValue(final String string, final INode node) throws ValueConverterException {
    String _xifexpression = null;
    boolean _equals = Objects.equal(string, null);
    if (_equals) {
      _xifexpression = null;
    } else {
      String _xifexpression_1 = null;
      boolean _matches = string.matches("<.*>");
      if (_matches) {
        int _length = string.length();
        int _minus = (_length - 1);
        String _substring = string.substring(1, _minus);
        _xifexpression_1 = this.unescape(_substring, "<");
      } else {
        _xifexpression_1 = string;
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }
}
