package hu.bme.mit.incqueryd.reteeditor;

import hu.bme.mit.incqueryd.reteeditor.iternal.AlphaNodeReferenceService;

import org.eclipse.sapphire.Element;
import org.eclipse.sapphire.ElementType;
import org.eclipse.sapphire.ReferenceValue;
import org.eclipse.sapphire.ValueProperty;
import org.eclipse.sapphire.modeling.annotations.PossibleValues;
import org.eclipse.sapphire.modeling.annotations.Reference;
import org.eclipse.sapphire.modeling.annotations.Required;
import org.eclipse.sapphire.modeling.annotations.Service;

public interface AlphaNodeRef extends Element {
	ElementType TYPE = new ElementType(AlphaNodeRef.class);

	// *** Entity ***

	@Reference(target = AlphaNode.class)
	@Service(impl = AlphaNodeReferenceService.class)
	@Required
	@PossibleValues(property = "/AlphaNodes/Name")
	ValueProperty PROP_ALPHANODE = new ValueProperty(TYPE, "AlphaNode");

	ReferenceValue<String, AlphaNode> getAlphaNode();

	void setAlphaNode(String value);

}
