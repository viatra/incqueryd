//package graphloader.database;
//
//import graphloader.events.EdgeTrigger;
//import graphloader.events.VertexTrigger;
//import graphloader.propertygraph.PropertyGraphEdge;
//import graphloader.propertygraph.PropertyGraphElement;
//import graphloader.propertygraph.PropertyGraphVertex;
//
//import java.io.UnsupportedEncodingException;
//import java.nio.ByteBuffer;
//import java.util.Collection;
//import java.util.HashMap;
//import java.util.HashSet;
//import java.util.Iterator;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Map;
//import java.util.Map.Entry;
//
//import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;
//import javax.xml.crypto.dsig.spec.HMACParameterSpec;
//
//import org.apache.cassandra.thrift.Cassandra;
//import org.apache.cassandra.thrift.Cassandra.Client;
//import org.apache.cassandra.thrift.Column;
//import org.apache.cassandra.thrift.Column._Fields;
//import org.apache.cassandra.thrift.ColumnParent;
//import org.apache.cassandra.thrift.Compression;
//import org.apache.cassandra.thrift.ConsistencyLevel;
//import org.apache.cassandra.thrift.CqlMetadata;
//import org.apache.cassandra.thrift.CqlPreparedResult;
//import org.apache.cassandra.thrift.CqlResult;
//import org.apache.cassandra.thrift.CqlResultType;
//import org.apache.cassandra.thrift.CqlRow;
//import org.apache.cassandra.thrift.InvalidRequestException;
//import org.apache.cassandra.thrift.SchemaDisagreementException;
//import org.apache.cassandra.thrift.TimedOutException;
//import org.apache.cassandra.thrift.UnavailableException;
//import org.apache.thrift.TException;
//import org.apache.thrift.meta_data.FieldMetaData;
//import org.apache.thrift.protocol.TBinaryProtocol;
//import org.apache.thrift.protocol.TProtocol;
//import org.apache.thrift.transport.TFramedTransport;
//import org.apache.thrift.transport.TSocket;
//import org.apache.thrift.transport.TTransport;
//
//public class ClientFacadeWithCollections {
//
//	static final Compression COMPRESSION_LEVEL = Compression.NONE;
//	static final ConsistencyLevel CONSISTENCY_LEVEL = ConsistencyLevel.ALL;
//	static final String SOURCE_VERTEX_ID = "sourcevertexid";
//	static final String TARGET_VERTEX_ID = "targetvertexid";
//	static final String LABEL = "label";
//	static final String KEY = "key";
//	static final String EDGE_COLUMN_FAMILY_NAME = "edges";
//	static final String VERTEX_COLUMN_FAMILY_NAME = "vertices";
//	static final String KEYSPACE_NAME = "graph";
//	private TTransport tr;
//	private Client client;
//	private Collection<EdgeTrigger> edgeTriggers = new HashSet<>();
//	private Collection<VertexTrigger> vertexTriggers = new HashSet<>();
//
//	public ClientFacadeWithCollections(String host, int port) throws InvalidRequestException, TException {
//		tr = new TFramedTransport(new TSocket(host, port));
//		TProtocol proto = new TBinaryProtocol(tr);
//		client = new Cassandra.Client(proto);
//		tr.open();
//		client.set_cql_version("3.0.0");
//
//		// initialize triggers
//		edgeTriggers.add(new EdgeTrigger());
//		vertexTriggers.add(new VertexTrigger());
//	}
//
//	public void stopClient() {
//		tr.close();
//	}
//
//	public void useKeyspace() throws InvalidRequestException, UnavailableException, TimedOutException, SchemaDisagreementException,
//			TException {
//		String cqlUseKeyspace = "USE " + KEYSPACE_NAME;
//		executeCql3Query(cqlUseKeyspace);
//	}
//
//	public void createKeyspace() throws InvalidRequestException, UnavailableException, TimedOutException, SchemaDisagreementException,
//			TException {
//		String cqlCreateKeyspace =
//				String.format(
//						"CREATE KEYSPACE %s" +
//								" WITH REPLICATION = { 'class' : 'SimpleStrategy', 'replication_factor' : 1 }",
//						KEYSPACE_NAME);
//		executeCql3Query(cqlCreateKeyspace);
//	}
//
//	public void dropKeyspace() throws UnavailableException, TimedOutException, SchemaDisagreementException, TException {
//		String cqlDropKeyspace = String.format("DROP KEYSPACE %s", KEYSPACE_NAME);
//		try {
//			executeCql3Query(cqlDropKeyspace);
//		} catch (InvalidRequestException e) {
//			// the keyspace did not exist
//			System.out.println("[WARN] Cannot drop non existing keyspace");
//		}
//	}
//
//	public void executeCql3Query(String query) throws InvalidRequestException, UnavailableException, TimedOutException, SchemaDisagreementException,
//			TException {
//		// client.execute_cql3_query(ByteBuffer.wrap(query.getBytes()),
//		// COMPRESSION_LEVEL, CONSISTENCY_LEVEL);
//
//		// super prepared query
//		CqlPreparedResult cqlPreparedResult = client.prepare_cql3_query(ByteBuffer.wrap(query.getBytes()), COMPRESSION_LEVEL);
//		List<ByteBuffer> values = new LinkedList<>();
//		client.execute_prepared_cql3_query(cqlPreparedResult.getItemId(), values, CONSISTENCY_LEVEL);
//
//	}
//
//	public void executeCql3QueryWithResults(String query) throws InvalidRequestException, UnavailableException, TimedOutException, SchemaDisagreementException,
//			TException {
//		thrift_executeCql3QueryWithResults();
//	}
//
//	public void thrift_executeCql3QueryWithResults() throws InvalidRequestException, UnavailableException, TimedOutException, SchemaDisagreementException,
//			TException {
//
//		// String query = "SELECT * FROM vertices";
//		// CqlResult cqlResult =
//		// client.execute_cql3_query(ByteBuffer.wrap(query.getBytes()),
//		// COMPRESSION_LEVEL.NONE, CONSISTENCY_LEVEL.ALL);
//		//
//		// System.out.println(cqlResult.getSchema());
//		//
//		// Iterator<CqlRow> rowsIterator = cqlResult.getRowsIterator();
//		// while (rowsIterator.hasNext()) {
//		// CqlRow cqlRow = rowsIterator.next();
//		// Iterator<Column> columnsIterator = cqlRow.getColumnsIterator();
//		// while (columnsIterator.hasNext()) {
//		// Column cqlColumn = columnsIterator.next();
//		//
//		// byte[] name = cqlColumn.getName();
//		// String nameString = new String(name);
//		// System.out.print(nameString + ": ");
//		//
//		// byte[] value = cqlColumn.getValue();
//		// String string = new String(value);
//		// System.out.println(string);
//		// }
//		// }
//
//	}
//
//	public void insertMap(String row_id, ColumnParent parent, Map<String, Object> map, long timestamp) throws UnsupportedEncodingException,
//			InvalidRequestException, UnavailableException, TimedOutException, TException {
//		for (Map.Entry<String, Object> entry : map.entrySet()) {
//			String key = entry.getKey();
//			String value = entry.getValue().toString();
//			insertColumn(row_id, parent, key, value, timestamp);
//		}
//	}
//
//	public void insertColumn(String rowId, ColumnParent parent, String key, int value, long timestamp) throws UnsupportedEncodingException,
//			InvalidRequestException, UnavailableException, TimedOutException, TException {
//		insertColumn(rowId, parent, key, String.valueOf(value), timestamp);
//	}
//
//	public void insertColumn(String rowId, ColumnParent parent, String key, String value, long timestamp) throws UnsupportedEncodingException,
//			InvalidRequestException, UnavailableException, TimedOutException, TException {
//		Column nameColumn = new Column(toByteBuffer(key));
//
//		// for integers:
//		// ByteBuffer b = ByteBuffer.allocate(8);
//		// b.putLong(value);
//		// byte[] byteArray = b.array();
//		// nameColumn.setValue(byteArray);
//
//		nameColumn.setValue(toByteBuffer(value));
//		nameColumn.setTimestamp(timestamp);
//		client.insert(toByteBuffer(rowId), parent, nameColumn, CONSISTENCY_LEVEL);
//	}
//
//	public ByteBuffer toByteBuffer(String value) throws UnsupportedEncodingException {
//		return ByteBuffer.wrap(value.getBytes("UTF-8"));
//	}
//
//	public String toString(ByteBuffer buffer) throws UnsupportedEncodingException {
//		byte[] bytes = new byte[buffer.remaining()];
//		buffer.get(bytes);
//		return new String(bytes, "UTF-8");
//	}
//
//	public void createColumnFamilyForVertices() throws InvalidRequestException, UnavailableException, TimedOutException, SchemaDisagreementException,
//			TException {
//		String cqlCreateColumnFamilyForVertices =
//				String.format(
//						"CREATE TABLE %s (" +
//								" id text PRIMARY KEY," +
//								" properties map<text, text>" +
//								")",
//						VERTEX_COLUMN_FAMILY_NAME
//						);
//		executeCql3Query(cqlCreateColumnFamilyForVertices);
//		System.err.println(cqlCreateColumnFamilyForVertices);
//	}
//
//	public void createColumnFamilyForEdges() throws InvalidRequestException, UnavailableException, TimedOutException, SchemaDisagreementException, TException {
//		String cqlCreateColumnFamilyForEdges =
//				String.format(
//						"CREATE TABLE %s (" +
//								" id text PRIMARY KEY," +
//								" sourcevertexid text," +
//								" targetvertexid text," +
//								" label text," +
//								" properties map<text, text> " +
//								")",
//						EDGE_COLUMN_FAMILY_NAME
//						);
//		executeCql3Query(cqlCreateColumnFamilyForEdges);
//	}
//
//	public void insertVertex(PropertyGraphVertex vertex) throws UnsupportedEncodingException, InvalidRequestException, UnavailableException, TimedOutException,
//			TException, SchemaDisagreementException {
//		ColumnParent vertexColumnFamily = new ColumnParent(VERTEX_COLUMN_FAMILY_NAME);
//		long timestamp = System.currentTimeMillis();
//		String rowId = vertex.getId().toString();
//		// insertMap(rowId, vertexColumnFamily, vertex.getProperties(),
//		// timestamp);
//
//		// cqlsh:graph>
//		// INSERT INTO users (user_id, first_name, last_name, emails)
//		// VALUES('frodo', 'Frodo', 'Baggins',
//		// {
//		// '2012-9-24' : 'enter mordor',
//		// '2012-10-2 12:00' : 'throw ring into mount doom'
//		// }
//		// );
//		/*
//		 * boolean first = true; String keyValuePairs = ""; for (Entry<String,
//		 * Object> property : vertex.getProperties().entrySet()) { if (first) {
//		 * first = false; } else { keyValuePairs += ",\n  "; }
//		 * 
//		 * keyValuePairs += property.getKey() + " : " + property.getValue(); }
//		 * String properties = String.format("{\n  %s\n}", keyValuePairs);
//		 * System.out.println(properties);
//		 */
//
//		String q =
//				String.format(
//						"INSERT INTO %s (id, properties) VALUES('%s', %s)",
//						VERTEX_COLUMN_FAMILY_NAME,
//						vertex.getId(),
//						generatePropertiesString(vertex)
//						);
//		System.out.println(q);
//		executeCql3Query(q);
//
//		// firing triggers
//		for (VertexTrigger vertexTrigger : vertexTriggers) {
//			vertexTrigger.fire("vertex inserted " + rowId);
//		}
//	}
//
//	public void insertEdge(PropertyGraphEdge edge) throws UnsupportedEncodingException, InvalidRequestException, UnavailableException, TimedOutException,
//			TException, SchemaDisagreementException {
//		ColumnParent edgeColumnFamily = new ColumnParent(EDGE_COLUMN_FAMILY_NAME);
//		long timestamp = System.currentTimeMillis();
//		String rowId = edge.getId().toString();
//		/*
//		 * insertColumn(rowId, edgeColumnFamily, SOURCE_VERTEX_ID,
//		 * edge.getSourceVertexId(), timestamp); insertColumn(rowId,
//		 * edgeColumnFamily, DESTINATION_VERTEX_ID, "40", timestamp);
//		 * insertColumn(rowId, edgeColumnFamily, LABEL, "mylabel", timestamp);
//		 * insertMap(rowId, edgeColumnFamily, edge.getProperties(), timestamp);
//		 */
//
//		String q =
//				String.format(
//						"INSERT INTO %s (id, sourcevertexid, targetvertexid, label, properties) VALUES('%s', '%s', '%s', '%s', %s)",
//						EDGE_COLUMN_FAMILY_NAME,
//						edge.getId(),
//						Integer.toString(edge.getSourceVertexId()),
//						Integer.toString(edge.getTargetVertexId()),
//						edge.getLabel(),
//						generatePropertiesString(edge)
//						);
//		System.out.println(q);
//		executeCql3Query(q);
//
//		// firing triggers
//		for (EdgeTrigger edgeTrigger : edgeTriggers) {
//			edgeTrigger.fire("edge inserted " + rowId);
//		}
//	}
//
//	private String generatePropertiesString(PropertyGraphElement edge) {
//		boolean first = true;
//		String keyValuePairs = "";
//		for (Entry<String, String> property : edge.getProperties().entrySet()) {
//			if (first) {
//				first = false;
//			} else {
//				keyValuePairs += ",\n  ";
//			}
//
//			keyValuePairs += String.format("'%s' : '%s'", property.getKey(), property.getValue());
//		}
//		String properties = String.format("{\n  %s\n}", keyValuePairs);
//		return properties;
//	}
//
//}
