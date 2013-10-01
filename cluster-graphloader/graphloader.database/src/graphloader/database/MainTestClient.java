package graphloader.database;

import graphloader.propertygraph.PropertyGraphEdge;
import graphloader.propertygraph.PropertyGraphVertex;

import java.io.UnsupportedEncodingException;

import org.apache.cassandra.thrift.InvalidRequestException;
import org.apache.cassandra.thrift.NotFoundException;
import org.apache.cassandra.thrift.SchemaDisagreementException;
import org.apache.cassandra.thrift.TimedOutException;
import org.apache.cassandra.thrift.UnavailableException;
import org.apache.thrift.TException;

public class MainTestClient {
	public static void main(String[] args) throws TException, InvalidRequestException, UnavailableException, UnsupportedEncodingException, NotFoundException,
			TimedOutException, SchemaDisagreementException {
		
		ClientFacade thriftFacade = new ClientFacade("localhost", 9160);
		thriftFacade.dropKeyspace();
		thriftFacade.createKeyspace();
		thriftFacade.useKeyspace();

		PropertyGraphEdge edge = new PropertyGraphEdge();
		edge.setId(1);
		edge.setLabel("labelvalue");
		edge.setProperty("weight", "5");
		edge.setProperty("somekey", "somevalue");
		edge.setSourceVertexId(5);
		edge.setTargetVertexId(10);
		

		PropertyGraphVertex vertex = new PropertyGraphVertex();
		vertex.setId(1);
		vertex.setProperty("asddweight", "5");
		vertex.setProperty("asddsomekey", "somevalue");
		
		thriftFacade.createColumnFamilyForEdges();
		thriftFacade.createColumnFamilyForVertices();
		
		thriftFacade.insertEdge(edge);
		thriftFacade.insertVertex(vertex);		

		thriftFacade.stopClient();
	}

}
