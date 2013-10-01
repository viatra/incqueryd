package graphloader.database.indexers;

import graphloader.database.ClientFacade;

import com.datastax.driver.core.ResultSet;

public class IndexerFactory {

	protected ResultSet currentResultSet;
	protected ClientFacade clientFacade;
	protected ResultSet edgeResultSet;
	
	public IndexerFactory(ClientFacade clientFacade) {
		this.clientFacade = clientFacade;
	}

	public VertexIndexer createVertexIndexer() {
		return new VertexIndexer(clientFacade, null);
	}
	
	public VertexIndexer createVertexIndexer(String criteria) {
		return new VertexIndexer(clientFacade, criteria);
	}

	public EdgeIndexer createEdgeIndexer() {
		return new EdgeIndexer(clientFacade, null);
	}
	
	public EdgeIndexer createEdgeIndexer(String criteria) {
		return new EdgeIndexer(clientFacade, criteria);
	}

//	public DenormalizedVertexIndexer createDenormalizedVertexIndexer(ClientFacade clientFacade, String criteria) {
//		return new DenormalizedVertexIndexer(clientFacade, criteria);	
//	}
	
	public TupleVertexIndexer createTupleVertexIndexer(ClientFacade clientFacade, String criteria) {
		return new TupleVertexIndexer(clientFacade, criteria);	
	}
		
//	public Collection<PropertyGraphVertex> queryVertices() {
//		return queryVertices(null);
//	}
	
//	public Collection<PropertyGraphVertex> queryVertices(String criteria) {
//		Collection<PropertyGraphVertex> vertices = new LinkedList<>();
//		ResultSet resultSet = runQueryOnVertices(criteria);
//
//		for (Row row : resultSet) {
//			PropertyGraphVertex vertex = rowToVertex(row);
//			vertices.add(vertex);
//		}
//
//		return vertices;
//	}

//	public Collection<PropertyGraphEdge> queryEdges() {
//		return queryEdges(null, null);
//	}
	
//	public Collection<PropertyGraphEdge> queryEdges(ClientFacade clientFacade, String criteria) {
//		Collection<PropertyGraphEdge> edges = new LinkedList<>();
//		ResultSet runQuery = runQueryOnEdges(clientFacade, criteria);	
//		for (Row row : runQuery) {
//			PropertyGraphEdge edge = rowToEdge(row);
//			edges.add(edge);
//		}
//		return edges;
//	}
		
}
