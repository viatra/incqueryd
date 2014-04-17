package titan.java.client;

import javax.script.Bindings;
import javax.script.ScriptEngine;
import javax.script.ScriptException;

import org.apache.commons.configuration.BaseConfiguration;
import org.apache.commons.configuration.Configuration;

import com.thinkaurelius.titan.core.TitanFactory;
import com.thinkaurelius.titan.core.TitanGraph;
import com.thinkaurelius.titan.core.TitanProperty;
import com.thinkaurelius.titan.graphdb.vertices.CacheVertex;
import com.tinkerpop.gremlin.groovy.GremlinGroovyPipeline;
import com.tinkerpop.gremlin.groovy.jsr223.GremlinGroovyScriptEngine;
import com.tinkerpop.pipes.util.structures.Row;
import com.tinkerpop.pipes.util.structures.Table;

public class TitanQueries {

	protected ScriptEngine engine; 
	protected Bindings bindings;
	
	public TitanQueries(final String host) {
		Configuration conf = new BaseConfiguration();
		conf.setProperty("storage.backend", "cassandra");
		conf.setProperty("storage.hostname", host);
		TitanGraph g = TitanFactory.open(conf);

		engine = new GremlinGroovyScriptEngine();
		bindings = engine.createBindings();
		bindings.put("g", g);
	}
	
	public void queryVertex() throws ScriptException {
		final String script = "g.V('type', 'Route');";
		
		Object results = engine.eval(script, bindings);
		GremlinGroovyPipeline<?, ?> pipeline = (GremlinGroovyPipeline<?, ?>) results;
		
		int n = 0;
		while (pipeline.hasNext()) {
			n++;
			Object o = pipeline.next();
			System.out.println(o.getClass());
			CacheVertex vertex = (CacheVertex) o;
			System.out.println(vertex.getProperty("idx"));			
		}
		
		System.out.println("Count: " + n);
	}
	
	public void queryVertexPair() throws ScriptException {
		final String script = "t = new Table(); g.V('type', 'Route').as('route').outE('ROUTE_ROUTEDEFINITION').inV.as('sensor').table(t).iterate(); t;";
		
		Object results = engine.eval(script, bindings);
		
		Table table = (Table) results;
		for (Row<?> row : table) {
			System.out.println(row);
			CacheVertex route = (CacheVertex) row.getColumn(0);
			CacheVertex sensor = (CacheVertex) row.getColumn(1);
			
			System.out.println(route + " - " + sensor);
			//printProperties("Route", route);
			//printProperties("Sensor", sensor);
		}
	}

	private void printProperties(String label, CacheVertex vertex) {
		System.out.println(label);
		Iterable<TitanProperty> properties = vertex.getProperties();
		for (TitanProperty titanProperty : properties) {
			System.out.println("- " + titanProperty.getPropertyKey().getName() + ": " + titanProperty.getValue());
		}
	}
	
}
