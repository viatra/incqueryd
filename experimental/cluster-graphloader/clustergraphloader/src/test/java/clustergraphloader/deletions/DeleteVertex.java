package clustergraphloader.deletions;

import org.junit.Test;

import clustergraphloader.database.ClientFacade;
import clustergraphloader.propertygraph.PropertyGraphVertex;

public class DeleteVertex {
	
	@Test
	public void test1() {
		ClientFacade client = new ClientFacade("192.168.175.101");
		client.useKeyspace();
		PropertyGraphVertex vertex = new PropertyGraphVertex();
		vertex.setId(2);
		client.deleteVertex(vertex);
	}
}
