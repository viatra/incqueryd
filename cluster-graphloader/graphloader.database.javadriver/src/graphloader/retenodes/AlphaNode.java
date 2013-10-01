package graphloader.retenodes;

import graphloader.database.ClientFacade;
import graphloader.propertygraph.PropertyGraphElement;

public class AlphaNode extends Node {

	protected ClientFacade clientFacade;
	
	public AlphaNode(ClientFacade clientFacade) {
		this.clientFacade = clientFacade;
		
	}
	
	
	PropertyGraphElement get() {
		return null;
		
	}
	
}
