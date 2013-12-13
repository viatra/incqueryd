package hu.bme.mit.incqueryd.databases;

import hu.bme.mit.incqueryd.exceptions.DatabaseClientException;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.script.Bindings;
import javax.script.ScriptEngine;
import javax.script.ScriptException;

import org.apache.commons.io.FileUtils;
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

public class TitanFaunusClient extends DatabaseClient {

    protected final ScriptEngine engine;
    protected final String hostname;
    protected final String extension = ".faunus-graphson";

    public TitanFaunusClient(final String serverUrl, final String filename) {
        super(serverUrl, filename);

        final FaunusGremlinScriptEngineFactory factory = new FaunusGremlinScriptEngineFactory();
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
            final File scriptFile = new File(scriptPath);
            final String load = FileUtils.readFileToString(scriptFile);
            final FaunusPipeline pipe = (FaunusPipeline) engine.eval(load, bindings);
            pipe.submit();
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }

    public void initialize() {
        System.out.println("<initialize>");

        final String scriptPath = "scripts/faunus-initialize.txt";
        final Bindings bindings = engine.createBindings();
        bindings.put("hostname", hostname);
        try {
            final File scriptFile = new File(scriptPath);
            final String load = FileUtils.readFileToString(scriptFile);
            engine.eval(load, bindings);
        } catch (final Exception e) {
            System.out.println("Error during initialization.");
            e.printStackTrace();
        }

        System.out.println("</initialize>");
    }

    @Override
    public void close() {
    }

    @Override
    public Iterable<?> retrieveNodes(final String typeName) {
        return null;
    }

    @Override
    public Multimap<Object, Object> collectEdges(final String edgeLabel) throws DatabaseClientException {
        // Titan (and the property graph domain) uses uppercase edge labels
        final String titanEdgeLabel = edgeLabel.toUpperCase();

        final Multimap<Object, Object> vertexPairs = ArrayListMultimap.create();
        final Path path = new Path(filename + extension);
        final Configuration conf = new Configuration();
        conf.setBoolean("fs.hdfs.impl.disable.cache", true);
        FileSystem fs;
        try {
            fs = FileSystem.get(conf);

            final BufferedReader br = new BufferedReader(new InputStreamReader(fs.open(path)));

            // process each line of the GraphSON file
            String line = br.readLine();
            while (line != null) {
                processLine(line, titanEdgeLabel, vertexPairs);
                line = br.readLine();
            }

            br.close();
            fs.close();
        } catch (final IOException e) {
            throw new DatabaseClientException("Error during edge collection.", e);
        }

        if (edgeLabel.equals("ROUTE_ROUTEDEFINITION")) {
            System.out.println(vertexPairs);
        }

        return vertexPairs;
    }

    protected void processLine(final String line, final String edgeLabel, final Multimap<Object, Object> vertexPairs)
            throws IOException {
        final FaunusVertex v1 = FaunusGraphSONUtility.fromJSON(line);
        final Long v1Id = (Long) v1.getId();

        final Iterable<Edge> edges = v1.getEdges(Direction.OUT, edgeLabel);
        for (final Edge edge : edges) {
            final Vertex v2 = edge.getVertex(Direction.IN);
            final Long v2Id = (Long) v2.getId();
            vertexPairs.put(v1Id, v2Id);
        }
    }

    @Override
    public void deleteEdge(final Object sourceVertexId, final Object destinationVertexId, final String edgeLabel)
            throws DatabaseClientException {
        // Titan (and the property graph domain) uses uppercase edge labels
        final String titanEdgeLabel = edgeLabel.toUpperCase();

        System.out.println("deleting edge: " + sourceVertexId + "->" + destinationVertexId);
        System.out.println("<deleteEdges>");

        final Bindings bindings = engine.createBindings();
        bindings.put("hostname", hostname);

        // example from the testBig_User_1 model:
        // g.V('idx', 4968).outE('ROUTE_SWITCHPOSITION').as('edge').inV.filter{it.idx == 5573}.back('edge').remove();
        final String script = String.format("" + "conf = new BaseConfiguration();\n"
                + "conf.setProperty('storage.hostname', hostname);\n"
                + "conf.setProperty('storage.backend', 'cassandra');\n" + "g = TitanFactory.open(conf);\n"
                + "g.V('idx', %s).outE('%s').as('edge').inV.filter{it.idx == %s}.back('edge').remove();\n"
                + "g.stopTransaction(SUCCESS);\n", sourceVertexId, titanEdgeLabel, destinationVertexId);

        Object result = null;
        try {
            result = engine.eval(script, bindings);
        } catch (final ScriptException e) {
            e.printStackTrace();
        }
        System.out.println("result: " + result);

        // final String script2 = String.format(""
        // + "conf = new BaseConfiguration();\n"
        // + "conf.setProperty('storage.hostname', hostname);\n"
        // + "conf.setProperty('storage.backend', 'cassandra');\n"
        // + "g = TitanFactory.open(conf);\n"
        // + "g.E.count()");
        //
        // Object result2 = null;
        // try {
        // result2 = engine.eval(script2, bindings);
        // } catch (final ScriptException e) {
        // e.printStackTrace();
        // }
        // System.out.println("count: " + result2);

        System.out.println("</deleteEdges>");
    }

    @Override
    public String getExtension() {
        return extension;
    }

}
