package clustergraphloader.database;

import static com.datastax.driver.core.querybuilder.QueryBuilder.eq;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import clustergraphloader.propertygraph.PropertyGraphEdge;
import clustergraphloader.propertygraph.PropertyGraphVertex;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.ResultSetFuture;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.Statement;
import com.datastax.driver.core.exceptions.InvalidQueryException;
import com.datastax.driver.core.querybuilder.Insert;
import com.datastax.driver.core.querybuilder.QueryBuilder;

public class ClientFacade {

	// the columns for the vertexes and edges already stored in the columny
	// family
	protected Collection<String> vertexColumns = new ArrayList<>();
	protected Collection<String> edgeColumns = new ArrayList<>();

	// database objects from DataStax driver
	protected Cluster cluster;
	protected Session session;

	// objects for asynchronous, parallel insertion
	protected AsyncBulkInsertListener listener = new AsyncBulkInsertListener();
	protected Executor executor = Executors.newSingleThreadExecutor();

	// default column count
	protected final int vertexColumnCount = 1;
	protected final int fixedColumnCount = 4;

	// CQL3 scripts for creating the keyspace and column families
	protected final String dropKeyspace = "DROP KEYSPACE graph";
	protected final String useKeyspace = "USE graph";
	protected final String createKeyspace =
			"CREATE KEYSPACE graph" +
					" WITH REPLICATION = { 'class' : 'SimpleStrategy', 'replication_factor' : 1 }";
	protected final String createColumnFamilyForVertices =
			"CREATE TABLE vertices (" +
					" id text PRIMARY KEY," +
					")";
	protected final String createColumnFamilyForEdges =
			"CREATE TABLE edges (" +
					" id text PRIMARY KEY," +
					" sourcevertexid text," +
					" targetvertexid text," +
					" label text," +
					")";

	/**
	 * Constructor for creating a new {@link ClientFacade} for a given host.
	 * 
	 * @param host
	 */
	public ClientFacade(String host) {
		cluster = Cluster.builder().addContactPoints(host).build();
		session = cluster.connect("system");
	}

	public void resetDatabase() {
		// drop keyspace if it exists
		try {
			runQuery(dropKeyspace);
		} catch (InvalidQueryException exception) {
			System.out.println("(cannot drop keyspace)");
		}

		// create and use keyspace
		runQuery(createKeyspace);
		useKeyspace();

		// create column family for vertices
		runQuery(createColumnFamilyForVertices);
		// create column family for edges
		runQuery(createColumnFamilyForEdges);

		// create indices
		createIndex("edges", "sourcevertexid");
		createIndex("edges", "targetvertexid");
		createIndex("edges", "label");
	}

	public void useKeyspace() {
		runQuery(useKeyspace);
	}

	/**
	 * Close the connection.
	 */
	public void close() {
		session.shutdown();
		cluster.shutdown();
	}

	/**
	 * Inserts a {@link PropertyGraphVertex} in the database.
	 * 
	 * @param vertex
	 */
	public void insertVertex(PropertyGraphVertex vertex) {
		Map<String, String> properties = vertex.getProperties();
		insertMissingColumns(vertexColumns, properties, "vertices");

		final int totalColumnCount = vertexColumnCount + properties.size();
		String[] names = new String[totalColumnCount];
		String[] values = new String[totalColumnCount];
		names[0] = "id";
		values[0] = Integer.toString(vertex.getId());

		int i = vertexColumnCount;
		for (Map.Entry<String, String> property : properties.entrySet()) {
			names[i] = property.getKey();
			values[i] = property.getValue();
			i++;
		}

		// building the insert query
		Insert insert = QueryBuilder.insertInto("graph", "vertices");
		insert.values(names, values);

		// runInsert(insert);
		runInsertAsync(insert);
	}

	/**
	 * Inserts a {@link PropertyGraphEdge} in the database.
	 * 
	 * @param edge
	 */
	public void insertEdge(PropertyGraphEdge edge) {
		Map<String, String> properties = edge.getProperties();
		insertMissingColumns(edgeColumns, properties, "edges");

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

		// building the insert query
		Insert insert = QueryBuilder.insertInto("graph", "edges");
		insert.values(names, values);

		// runInsert(insert);
		runInsertAsync(insert);
	}

	/**
	 * Deletes a {@link PropertyGraphVertex} from the database.
	 * 
	 * @param vertex
	 */
	public void deleteVertex(PropertyGraphVertex vertex) {
		String id = Integer.toString(vertex.getId());
		Statement delete = QueryBuilder.delete().from("vertices").where(eq("id", id));
		session.execute(delete);
	}

	/**
	 * Deletes a {@link PropertyGraphEdge} from the database.
	 * 
	 * @param edge
	 */
	public void deleteEdge(PropertyGraphEdge edge) {
		String id = Integer.toString(edge.getId());
		Statement delete = QueryBuilder.delete().from("edges").where(eq("id", id));
		session.execute(delete);
	}

	/**
	 * Runs a query synchronously and returns the {@link ResultSet}.
	 * 
	 * @param query
	 * @return
	 */
	protected ResultSet runQuery(String query) {
		return session.execute(query);
	}

	/**
	 * Runs a query asynchronously and returns a {@link ResultSetFuture} object.
	 * 
	 * @param query
	 * @return
	 */
	protected ResultSetFuture runQueryAsync(String query) {
		return session.executeAsync(query);
	}

	/**
	 * Runs an {@link Insert} operation synchronously.
	 * 
	 * @param insert
	 */
	protected void runInsert(Insert insert) {
		session.execute(insert);
	}

	/**
	 * Runs and {@link Insert} operation asynchronously and return the
	 * {@link ResultSetFuture}.
	 * 
	 * @param insert
	 */
	protected void runInsertAsync(Insert insert) {
		ResultSetFuture resultSetFuture = session.executeAsync(insert);
		listener.insert();
		resultSetFuture.addListener(listener, executor);
	}

	/**
	 * Inserts the missing columns to the column family.
	 * 
	 * @param columnsCollection
	 * @param properties
	 * @param columnFamily
	 */
	protected void insertMissingColumns(Collection<String> columnsCollection, Map<String, String> properties,
			String columnFamily) {

		try {
			for (String columnName : properties.keySet()) {
				addColumnIfNotExists(columnsCollection, columnFamily, columnName);
			}
		} catch (InvalidQueryException e) {
			// this exception is expected
			// TODO: centralize the insertion of missing columns (?)
		}
	}

	/**
	 * Adds column is it does not exist.
	 * 
	 * @param columnsCollection
	 * @param columnFamily
	 * @param columnName
	 */
	protected void addColumnIfNotExists(Collection<String> columnsCollection, String columnFamily, String columnName) {
		if (!columnsCollection.contains(columnName)) {
			columnsCollection.add(columnName);
			String alterQuery =
					String.format("ALTER TABLE %s ADD %s text", columnFamily, columnName);
			runQuery(alterQuery);

			// also create an index
			createIndex(columnFamily, columnName);
		}
	}

	/**
	 * Creates index for a given column in a given column family.
	 * 
	 * @param columnFamily
	 * @param columnName
	 */
	protected void createIndex(String columnFamily, String columnName) {
		String createIndex =
				String.format(
						"CREATE INDEX %s_%s ON %s (%s)",
						columnFamily, columnName,
						columnFamily, columnName
						);
		runQuery(createIndex);
	}

	/**
	 * Wait for asynchronous calls to complete.
	 */
	public void waitForFutures() {
		System.out.println("Waiting for all futures to complete.");
		long start = System.nanoTime();

		synchronized (listener) {
			if (!listener.isFinished()) {
				try {
					listener.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

		long end = System.nanoTime();
		long diff = (end - start) / 1000000L;

		System.out.println("Waited " + diff + " ms");
	}

}
