package hu.bme.mit.incqueryd.reteeditor;

import hu.bme.mit.incqueryd.reteeditor.iternal.ReteNodeReferenceService;

import org.eclipse.sapphire.Element;
import org.eclipse.sapphire.ElementType;
import org.eclipse.sapphire.ReferenceValue;
import org.eclipse.sapphire.ValueProperty;
import org.eclipse.sapphire.modeling.annotations.PossibleValues;
import org.eclipse.sapphire.modeling.annotations.Reference;
import org.eclipse.sapphire.modeling.annotations.Required;
import org.eclipse.sapphire.modeling.annotations.Service;

public interface ReteNodeRef extends Element {
	ElementType TYPE = new ElementType(ReteNodeRef.class);

	// *** Entity ***

	@Reference(target = ReteNode.class)
	@Service(impl = ReteNodeReferenceService.class)
	@Required
	@PossibleValues(property = "/Entities/Name")
	ValueProperty PROP_RETENODE = new ValueProperty(TYPE, "ReteNode");

	ReferenceValue<String, ReteNode> getReteNode();

	void setReteNode(String value);

}
