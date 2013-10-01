package clustergraphloader.deletions;

import org.junit.Test;

import clustergraphloader.database.ClientFacade;
import clustergraphloader.propertygraph.PropertyGraphEdge;
import clustergraphloader.propertygraph.PropertyGraphVertex;

public class DeleteEdge {
	
	@Test
	public void test1() {
		ClientFacade client = new ClientFacade("192.168.175.101");
		client.useKeyspace();
		PropertyGraphEdge edge = new PropertyGraphEdge();
		edge.setId(1);
		client.deleteEdge(edge);
	}
}
