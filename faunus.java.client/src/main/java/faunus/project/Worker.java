package faunus.project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;

import javax.script.Bindings;
import javax.script.ScriptEngine;
import javax.script.ScriptException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import com.thinkaurelius.faunus.FaunusPipeline;
import com.thinkaurelius.faunus.FaunusVertex;
import com.thinkaurelius.faunus.Tokens;
import com.thinkaurelius.faunus.formats.graphson.FaunusGraphSONUtility;
import com.thinkaurelius.faunus.hdfs.HDFSTools;
import com.thinkaurelius.faunus.hdfs.TextFileLineIterator;
import com.thinkaurelius.faunus.tinkerpop.gremlin.Imports;
import com.tinkerpop.blueprints.Direction;
import com.tinkerpop.blueprints.Edge;
import com.tinkerpop.blueprints.Vertex;

public class Worker {

	private ScriptEngine engine;

	public Worker(ScriptEngine engine) {
		this.engine = engine;
	}

	public void listHdfs() throws ScriptException {
		System.out.println("<listHdfs>");
		
		// import everything the Gremlin shell does
		String script = "";
		for (String importName : Imports.getImports()) {
			script += "import " + importName + ";\n";
		}
		script += ""
				+ "hdfs = FileSystem.get(new Configuration());\n"
				+ "hdfs.ls();\n";
		
		@SuppressWarnings("unchecked")
		final ArrayList<String> files = (ArrayList<String>) engine.eval(script);

		for (String file : files) {
			System.out.println(file);
		}
		System.out.println("</listHdfs>");
	}

	public void initialize(final String hostname) {
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

	public void load(final String hostname, final String filename) throws Exception {
		
		System.out.println("<load>");

		final String loadProperties = "scripts/cassandra-load.properties";
		
		final Bindings bindings = engine.createBindings();
		bindings.put("hostname", hostname);
		bindings.put("filename", filename);
		bindings.put("loadProperties", loadProperties);

		final String scriptPath = "scripts/faunus-load.txt";
		final String load = Utility.readFile(scriptPath, Charset.defaultCharset());
		final FaunusPipeline pipe = (FaunusPipeline) engine.eval(load, bindings);
		pipe.submit();

		System.out.println("</load>");
	}

	public void listVertexPairs() throws Exception {
		System.out.println("<listVertexPairs>");
		Bindings bindings = engine.createBindings();

		bindings.put("queryProperties",	"scripts/cassandra-query.properties");
		bindings.put("edgeTypesGroovyScript", "EdgeTypes.groovy");
		final String listVertexPairs = ""
				+ "v1Type = 'Route';"
				+ "conf = new Configuration();"
				+ "conf.setBoolean('storage.batch-loading', true);"
				+ "g = FaunusFactory.open(queryProperties, conf);"
				+ "g.V.script(edgeTypesGroovyScript, 'cassandrathrift');";

		// TODO remove this is we want to retrieve multiple edge type instances in one MR run
		// + "g.V.has('type', v1Type).script(edgeTypesGroovyScript, 'cassandrathrift');"

		final FaunusPipeline pipe = (FaunusPipeline) engine.eval(listVertexPairs, bindings);
		pipe.submit();

		final FileSystem hdfs = FileSystem.get(pipe.getGraph().getConf());
		final Path output = HDFSTools.getOutputsFinalJob(hdfs, pipe.getGraph().getOutputLocation().toString());
		final Iterator<?> it = new TextFileLineIterator(hdfs, hdfs.globStatus(new Path(output.toString() + "/"
				+ Tokens.SIDEEFFECT + "*")), Long.MAX_VALUE);
		// while (it.hasNext()) {
		// System.out.println(it.next());
		// }

		System.out.println("</listVertexPairs>");
	}

	public void listVertexPairsFromFile(final String filename) throws IOException {
		System.out.println("<listVertexPairsFromFile>");

		String[] labels = {
				"SWITCHPOSITION_SWITCH",
				"ROUTE_SWITCHPOSITION",
				"TRACKELEMENT_SENSOR",
				"ROUTE_ROUTEDEFINITION"
		};
		for (String label : labels) {
			System.out.println(label);
			extractEdges(label, filename);
		}
		
		System.out.println("</listVertexPairsFromFile>");
	}
	
	private void extractEdges(final String label, final String filename) throws IOException {
		final String hadoopConf = System.getenv("HADOOP_CONF");

		Path path = new Path(filename);
		Configuration conf = new Configuration();
		conf.addResource(new Path(hadoopConf + "/core-site.xml"));
		FileSystem fs = FileSystem.get(conf);

		BufferedReader br = new BufferedReader(new InputStreamReader(fs.open(path)));

		// process each line of the GraphSON file
		String line = br.readLine();
		while (line != null) {
			processLine(line, label);
			line = br.readLine();
		}

		br.close();
		fs.close();
	}

	private void processLine(String line, String label) throws IOException {
		FaunusVertex v1 = FaunusGraphSONUtility.fromJSON(line);

		//System.out.print(v1 + ": ");
		Iterable<Edge> edges = v1.getEdges(Direction.OUT, label);
		for (Edge edge : edges) {
			Vertex v2 = edge.getVertex(Direction.IN);
			//System.out.print(v2 + ", ");
		}
		//System.out.println();
	}

}
