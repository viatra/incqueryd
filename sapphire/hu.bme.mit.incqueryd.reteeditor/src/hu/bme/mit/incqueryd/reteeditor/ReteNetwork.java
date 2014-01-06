package hu.bme.mit.incqueryd.reteeditor;

import org.eclipse.sapphire.Element;
import org.eclipse.sapphire.ElementList;
import org.eclipse.sapphire.ElementType;
import org.eclipse.sapphire.ListProperty;
import org.eclipse.sapphire.modeling.annotations.Label;
import org.eclipse.sapphire.modeling.annotations.Type;

public interface ReteNetwork extends Element {
	ElementType TYPE = new ElementType(ReteNetwork.class);

	// *** AlphaNodes ***
	@Type(base = AlphaNode.class)
	@Label(standard = "nodes")
	ListProperty PROP_ALPHANODES = new ListProperty(TYPE, "AlphaNodes");

	ElementList<ReteNode> getAlphaNodes();

//	// *** BetaNodes ***
//	@Type(base = AlphaNode.class)
//	@Label(standard = "nodes")
//	ListProperty PROP_BETANODES = new ListProperty(TYPE, "BetaNodes");
//
//	ElementList<ReteNode> getBetaNodes();

	// *** ProductionNodes ***
	@Type(base = ProductionNode.class)
	@Label(standard = "nodes")
	ListProperty PROP_PRODUCTIONNODES = new ListProperty(TYPE, "ProductionNodes");

	ElementList<ReteNode> getProductionNodes();

	
}
