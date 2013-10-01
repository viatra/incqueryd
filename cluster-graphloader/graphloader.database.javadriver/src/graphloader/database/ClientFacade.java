package graphloader.database;

import graphloader.events.EdgeTrigger;
import graphloader.events.VertexTrigger;
import graphloader.propertygraph.PropertyGraphEdge;
import graphloader.propertygraph.PropertyGraphVertex;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.ResultSetFuture;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.exceptions.InvalidConfigurationInQueryException;
import com.datastax.driver.core.querybuilder.Insert;
import com.datastax.driver.core.querybuilder.QueryBuilder;

public class ClientFacade {

	protected Collection<VertexTrigger> vertexTriggers = new HashSet<>();
	protected Collection<EdgeTrigger> edgeTriggers = new HashSet<>();
	protected Collection<String> vertexColumns = new ArrayList<>();
	protected Collection<String> edgeColumns = new ArrayList<>();

	protected Collection<String> vertexEdgeVertexColumns = new ArrayList<>();
	protected Collection<String> vertexEdgeEdgeColumns = new ArrayList<>();

	Cluster cluster;
	Session session;
	protected AsyncBulkInsertListener listener = new AsyncBulkInsertListener();
	protected Executor executor = Executors.newSingleThreadExecutor();

	public ClientFacade(String host) {

		cluster = Cluster.builder().addContactPoints(host).build();
		session = cluster.connect("system");

		// drop keyspace if it exists
		try {
			runQuerySync("DROP KEYSPACE graph");
		} catch (InvalidConfigurationInQueryException exception) {
			System.out.println("cannot drop keyspace");
		}

		// create and use keyspace
		String createKeyspace =
				"CREATE KEYSPACE graph" +
						" WITH REPLICATION = { 'class' : 'SimpleStrategy', 'replication_factor' : 1 }";
		runQuerySync(createKeyspace);
		String useKeyspace = "USE graph";
		runQuerySync(useKeyspace);

		// create column family for vertices
		String createColumnFamilyForVertices =
				"CREATE TABLE vertices (" +
						" id text PRIMARY KEY," +
						// " type text," +
						")";
		runQuerySync(createColumnFamilyForVertices);

		// create column family for edges
		String createColumnFamilyForEdges =
				"CREATE TABLE edges (" +
						" id text PRIMARY KEY," +
						" sourcevertexid text," +
						" targetvertexid text," +
						" label text," +
						// " type text," +
						")";
		runQuerySync(createColumnFamilyForEdges);
		createIndex("edges", "sourcevertexid");
		createIndex("edges", "targetvertexid");
		createIndex("edges", "label");

		// create column family for the denormalized vertex-edge data
		String createColumnFamilyForVertexEdges =
				"CREATE TABLE vertex_edges (" +
						" vertex_id text," +
						" edge_id text," +
						" edge_sourcevertexid text," +
						" edge_targetvertexid text," +
						" edge_label text," +
						// " type text," +
						" PRIMARY KEY (vertex_id, edge_id)" +
						")";
		runQuerySync(createColumnFamilyForVertexEdges);
		createIndex("vertex_edges", "edge_sourcevertexid");
		createIndex("vertex_edges", "edge_targetvertexid");
		createIndex("vertex_edges", "edge_label");

		// initialize triggers
		edgeTriggers.add(new EdgeTrigger());
		vertexTriggers.add(new VertexTrigger());
	}

	public void insertVertex(PropertyGraphVertex vertex) {				
		Map<String, String> properties = vertex.getProperties();
		insertMissingColumns(vertexColumns, properties, "vertices");

		final int fixedColumnCount = 1;
		final int totalColumnCount = fixedColumnCount + properties.size();
		String[] names = new String[totalColumnCount];
		String[] values = new String[totalColumnCount];
		names[0] = "id";
		values[0] = Integer.toString(vertex.getId());

		int i = fixedColumnCount;
		for (Map.Entry<String, String> property : properties.entrySet()) {
			names[i] = property.getKey();
			values[i] = property.getValue();
			i++;
		}
		Insert insert = QueryBuilder.insertInto("graph", "vertices");
		insert.values(names, values);
		runInsert(insert);

		// firing triggers
		// for (VertexTrigger vertexTrigger : vertexTriggers) {
		// vertexTrigger.fire("vertex inserted " + vertex.getId());
		// }
	}

	public void insertEdge(PropertyGraphEdge edge) {
		Map<String, String> properties = edge.getProperties();
		insertMissingColumns(edgeColumns, properties, "edges");

		final int fixedColumnCount = 4;
		final int totalColumnCount = fixedColumnCount + properties.size();
		String[] names = new String[totalColumnCount];
		String[] values = new String[totalColumnCount];
		names[0] = "id";
		names[1] = "label";
		names[2] = "sourcevertexid";
		names[3] = "targetvertexid";
		values[0] = String.valueOf(edge.getId());
		values[1] = edge.getLabel();
		values[2] = String.valueOf(edge.getSourceVertexId());
		values[3] = String.valueOf(edge.getTargetVertexId());

		int i = fixedColumnCount;
		for (Map.Entry<String, String> property : properties.entrySet()) {
			names[i] = property.getKey();
			values[i] = property.getValue();
			i++;
		}
		Insert insert = QueryBuilder.insertInto("graph", "edges");
		insert.values(names, values);
		runInsert(insert);

		// firing triggers
		// for (EdgeTrigger edgeTrigger : edgeTriggers) {
		// edgeTrigger.fire("edge inserted " + edge.getId());
		// }
	}

	public ResultSet runQuerySync(String query) {
		return session.execute(query);
	}
	
	public ResultSetFuture runQueryAsync(String query) {
		return session.executeAsync(query);
	}

	public ResultSet runInsert(Insert insert) {
		return session.execute(insert);
	}

	public ResultSetFuture runInsertAsync(Insert insert) {
		return session.executeAsync(insert);
	}

	protected void insertMissingColumns(Collection<String> columnsCollection, Map<String, String> properties, String columnFamily) {
		insertMissingColumns(columnsCollection, properties, columnFamily, "");
	}

	protected void insertMissingColumns(Collection<String> columnsCollection, Map<String, String> properties, String columnFamily, String columnNamePrefix) {
		for (String key : properties.keySet()) {
			String columnName = columnNamePrefix + key;
			addColumnIfNotExists(columnsCollection, columnFamily, columnName);
		}
	}

	protected void addColumnIfNotExists(Collection<String> columnsCollection, String columnFamily, String columnName) {
		if (!columnsCollection.contains(columnName)) {
			columnsCollection.add(columnName);
			String alterQuery =
					String.format("ALTER TABLE %s ADD %s text", columnFamily, columnName);
			runQuerySync(alterQuery);

			// also create an index
			createIndex(columnFamily, columnName);
		}
	}

	protected void createIndex(String columnFamily, String columnName) {
		String createIndex =
				String.format(
						"CREATE INDEX %s_%s ON %s (%s)",
						columnFamily, columnName,
						columnFamily, columnName
						);
		runQuerySync(createIndex);
	}

	public void insertVertexWithEdge(PropertyGraphVertex vertex, PropertyGraphEdge edge) {
		if (edge.getSourceVertexId() == vertex.getId() || edge.getTargetVertexId() == vertex.getId()) {
			// --[E]-->(V) || (V)--[E]-->
			Map<String, String> vertexProperties = vertex.getProperties();
			Map<String, String> edgeProperties = edge.getProperties();
			insertMissingColumns(vertexEdgeVertexColumns, vertexProperties, "vertex_edges", "vertex_");
			insertMissingColumns(vertexEdgeEdgeColumns, edgeProperties, "vertex_edges", "edge_");

			final int fixedColumnCount = 4;
			final int totalColumnCount = fixedColumnCount + vertexProperties.size() + edgeProperties.size();
			String[] names = new String[totalColumnCount];
			String[] values = new String[totalColumnCount];
			names[0] = "vertex_id";
			names[1] = "edge_id";
			names[2] = "edge_label";
			names[3] = "edge_sourcevertexid";
			names[4] = "edge_targetvertexid";
			values[0] = String.valueOf(vertex.getId());
			values[1] = String.valueOf(edge.getId());
			values[2] = edge.getLabel();
			values[3] = String.valueOf(edge.getSourceVertexId());
			values[4] = String.valueOf(edge.getTargetVertexId());

			int i = fixedColumnCount;
			for (Map.Entry<String, String> property : vertexProperties.entrySet()) {
				names[i] = "vertex_" + property.getKey();
				values[i] = property.getValue();
				i++;
			}
			for (Map.Entry<String, String> property : edgeProperties.entrySet()) {
				names[i] = "edge_" + property.getKey();
				values[i] = property.getValue();
				i++;
			}
			Insert insert = QueryBuilder.insertInto("graph", "vertex_edges");
			insert.values(names, values);
			ResultSetFuture resultSetFuture = runInsertAsync(insert);
			listener.insert();
			resultSetFuture.addListener(listener, executor);
		}
	}
}
