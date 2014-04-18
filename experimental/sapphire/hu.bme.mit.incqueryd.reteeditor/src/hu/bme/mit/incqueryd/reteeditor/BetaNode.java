package hu.bme.mit.incqueryd.reteeditor;

import org.eclipse.sapphire.ElementType;
import org.eclipse.sapphire.Value;
import org.eclipse.sapphire.ValueProperty;
import org.eclipse.sapphire.modeling.annotations.DefaultValue;
import org.eclipse.sapphire.modeling.annotations.EnumSerialization;
import org.eclipse.sapphire.modeling.annotations.Label;
import org.eclipse.sapphire.modeling.annotations.Type;

public interface BetaNode extends ReteNode {
	ElementType TYPE = new ElementType(BetaNode.class);

	// *** Kind ***
	enum Kind {
		@Label(standard = "join")
		@EnumSerialization(primary = "join")
		JOIN,

		@Label(standard = "antijoin")
		@EnumSerialization(primary = "antijoin")
		ANTIJOIN,
	}

	@Type(base = Kind.class)
	@Label(standard = "kind")
	@DefaultValue(text = "")
	ValueProperty PROP_KIND = new ValueProperty(TYPE, "Kind");

	Value<Kind> getKind();

	void setKind(String value);

	// void setKind(Kind value);

}
