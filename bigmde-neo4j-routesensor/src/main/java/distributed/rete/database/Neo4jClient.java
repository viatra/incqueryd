package distributed.rete.database;

import java.util.Collection;
import java.util.Map;

import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.index.IndexHits;
import org.neo4j.graphdb.index.ReadableIndex;
import org.neo4j.helpers.collection.IteratorUtil;
import org.neo4j.helpers.collection.MapUtil;
import org.neo4j.rest.graphdb.RestAPI;
import org.neo4j.rest.graphdb.RestAPIFacade;
import org.neo4j.rest.graphdb.query.RestCypherQueryEngine;
import org.neo4j.rest.graphdb.query.RestGremlinQueryEngine;

public class Neo4jClient {

	protected String serverUrl;
	protected RestAPI restApi;

	public Neo4jClient(String serverUrl) {
		// increase the default timeout (30 seconds) for the Neo4j REST API
		// calls to 120 minutes (should be more than enough)
		System.setProperty("org.neo4j.rest.read_timeout", "7200");
		
		this.serverUrl = serverUrl;
		restApi = new RestAPIFacade(serverUrl);
	}

	public void close() {		
		restApi.close();
	}

	public void load(String filePath) {
		String query = String.format("g.clear(); g.loadGraphML('%s')", filePath);
		runGremlinQuery(query);
	}

	public Iterable<Node> retrieveNodes(String typeName) {
		ReadableIndex<Node> autoNodeIndex = restApi.index().getNodeAutoIndexer().getAutoIndex();
		IndexHits<Node> indexHits = autoNodeIndex.get("type", typeName);
		return indexHits;
	}

	public Collection<Map<String, Object>> runCyperQuery(String query) {		
		RestCypherQueryEngine queryEngine = new RestCypherQueryEngine(restApi);
		Collection<Map<String, Object>> result = IteratorUtil.asCollection(queryEngine.query(query, MapUtil.map()));
		return result;
	}

	public void runGremlinQuery(String query) {
		RestGremlinQueryEngine queryEngine = new RestGremlinQueryEngine(restApi);
		queryEngine.query(query, MapUtil.map());
	}

	public String getServerUrl() {
		return serverUrl;
	}
	
	public void deleteRouteRouteDefinitionEdge(Long routeId, Long sensorId) {
		// deleting the tuple from the database
		// n.b. this is a synchronous call
		String deleteQuery = "START\n" +
				"  route=node:node_auto_index(idx='" + routeId + "'),\n" +
				"  sensor=node:node_auto_index(idx='" + sensorId + "')\n" +
				"MATCH (route)-[r:ROUTE_ROUTEDEFINITION]->(sensor)\n" +
				"DELETE r";
		runCyperQuery(deleteQuery);
	}
}
