package distributed.rete.database;

import hu.bme.mit.train.util.Utility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

import javax.script.Bindings;
import javax.script.ScriptEngine;
import javax.script.ScriptException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.thinkaurelius.faunus.FaunusPipeline;
import com.thinkaurelius.faunus.FaunusVertex;
import com.thinkaurelius.faunus.formats.graphson.FaunusGraphSONUtility;
import com.thinkaurelius.faunus.tinkerpop.gremlin.FaunusGremlinScriptEngineFactory;
import com.tinkerpop.blueprints.Direction;
import com.tinkerpop.blueprints.Edge;
import com.tinkerpop.blueprints.Vertex;

import distributed.rete.exceptions.DatabaseClientException;

public class TitanFaunusClient extends DatabaseClient {

	protected final ScriptEngine engine;
	protected final String hostname;
	protected final String extension = ".faunus-graphson";

	public TitanFaunusClient(final String serverUrl, final String filename) {
		super(serverUrl, filename);

		FaunusGremlinScriptEngineFactory factory = new FaunusGremlinScriptEngineFactory();
		engine = factory.getScriptEngine();
		this.hostname = serverUrl;
	}

	@Override
	public void load() {
		// calling initialization function -- now works only with a hardwired metamodel
		initialize();

		final String loadProperties = "scripts/cassandra-load.properties";

		final Bindings bindings = engine.createBindings();
		bindings.put("hostname", hostname);
		bindings.put("filename", filename + extension);
		bindings.put("loadProperties", loadProperties);

		final String scriptPath = "scripts/faunus-load.txt";

		try {
			final String load = Utility.readFile(scriptPath, Charset.defaultCharset());
			final FaunusPipeline pipe = (FaunusPipeline) engine.eval(load, bindings);
			pipe.submit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void initialize() {
		System.out.println("<initialize>");

		final String scriptPath = "scripts/faunus-initialize.txt";
		final Bindings bindings = engine.createBindings();
		bindings.put("hostname", hostname);
		try {
			final String load = Utility.readFile(scriptPath, Charset.defaultCharset());
			engine.eval(load, bindings);
		} catch (Exception e) {
			System.out.println("Error during initialization.");
		}

		System.out.println("</initialize>");
	}

	@Override
	public void close() {
	}

	@Override
	public Iterable<?> retrieveNodes(String typeName) {
		return null;
	}

	public Multimap<Object, Object> collectEdges(final String edgeLabel) throws DatabaseClientException {
		// Titan (and the property graph domain) uses uppercase edge labels
		final String titanEdgeLabel = edgeLabel.toUpperCase();

		Multimap<Object, Object> vertexPairs = ArrayListMultimap.create();
		Path path = new Path(filename + extension);
		Configuration conf = new Configuration();
		conf.setBoolean("fs.hdfs.impl.disable.cache", true);
		FileSystem fs;
		try {
			fs = FileSystem.get(conf);

			BufferedReader br = new BufferedReader(new InputStreamReader(fs.open(path)));

			// process each line of the GraphSON file
			String line = br.readLine();
			while (line != null) {
				processLine(line, titanEdgeLabel, vertexPairs);
				line = br.readLine();
			}

			br.close();
			fs.close();
		} catch (IOException e) {
			throw new DatabaseClientException("Error during edge collection.", e);
		}

		if (edgeLabel.equals("ROUTE_ROUTEDEFINITION")) {
			System.out.println(vertexPairs);
		}

		return vertexPairs;
	}

	protected void processLine(final String line, final String edgeLabel, final Multimap<Object, Object> vertexPairs) throws IOException {
		FaunusVertex v1 = FaunusGraphSONUtility.fromJSON(line);
		Long v1Id = (Long) v1.getId();

		Iterable<Edge> edges = v1.getEdges(Direction.OUT, edgeLabel);
		for (Edge edge : edges) {
			Vertex v2 = edge.getVertex(Direction.IN);
			Long v2Id = (Long) v2.getId();
			vertexPairs.put(v1Id, v2Id);
		}
	}

	@Override
	public void deleteEdge(final Object sourceVertexId, final Object destinationVertexId, final String edgeLabel) throws DatabaseClientException {
		// Titan (and the property graph domain) uses uppercase edge labels
		final String titanEdgeLabel = edgeLabel.toUpperCase();
		
		System.out.println("deleting edge: " + sourceVertexId + "->" + destinationVertexId);
		System.out.println("<deleteEdges>");

		final Bindings bindings = engine.createBindings();
		bindings.put("hostname", hostname);

		final String script = String.format(""
				+ "conf = new BaseConfiguration();\n"
				+ "conf.setProperty('storage.hostname', hostname);\n"
				+ "conf.setProperty('storage.backend', 'cassandra');\n"
				+ "g = TitanFactory.open(conf);\n"
				+ "g.V('idx', %s).outE.as('edge').inV.filter{it.idx == %s}.back('edge').remove();\n" // TODO: utilise edgeLabel for faster deletion
				+ "g.stopTransaction(SUCCESS);\n",
				sourceVertexId, destinationVertexId
				);

		Object result = null;
		try {
			result = engine.eval(script, bindings);
		} catch (ScriptException e) {
			e.printStackTrace();
		}
		System.out.println("result: " + result);

		System.out.println("</deleteEdges>");
	}

	@Override
	public String getExtension() {
		return extension;
	}

}
