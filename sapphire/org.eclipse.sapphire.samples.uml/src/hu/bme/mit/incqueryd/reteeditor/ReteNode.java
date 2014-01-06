package hu.bme.mit.incqueryd.reteeditor;

import org.eclipse.sapphire.Element;
import org.eclipse.sapphire.ElementType;
import org.eclipse.sapphire.Value;
import org.eclipse.sapphire.ValueProperty;
import org.eclipse.sapphire.modeling.annotations.Label;
import org.eclipse.sapphire.modeling.annotations.Required;

public interface ReteNode extends Element {
	ElementType TYPE = new ElementType(ReteNode.class);

	// *** Name ***
	@Label(standard = "name")
	@Required
	ValueProperty PROP_NAME = new ValueProperty(TYPE, "Name");

	Value<String> getName();

	void setName(String value);

}
