package faunus.project;

import javax.script.ScriptEngine;

import com.thinkaurelius.faunus.tinkerpop.gremlin.FaunusGremlinScriptEngineFactory;

/*
 * Remarks:
 * - set FAUNUS_HOME to your the Faunus x.y.z distribution's location
 * - if not using a Hadoop cluster's HDFS, the titan-cassandra-output.properties file's path has to be relative to the current working directory
 *   (by default: the projects home dir).
 */

public class FaunusMain {
	public static void main(String[] args) throws Exception {

		FaunusGremlinScriptEngineFactory factory = new FaunusGremlinScriptEngineFactory();
		ScriptEngine engine = factory.getScriptEngine();

		Worker worker = new Worker(engine);
		
		Timer.instance.startTimer();
		
		worker.listHdfs();
		Timer.instance.restartTimer();
		
		final String hostname = "localhost";
		final String filename = "testBig_User_1.faunus-graphson";

		worker.initialize(hostname);
		Timer.instance.restartTimer();
		
//		worker.load(hostname, filename);
//		Timer.instance.restartTimer();
		
		worker.listVertexPairsFromFile(filename);
		Timer.instance.restartTimer();
		
//		worker.listVertexPairs();
//		Timer.instance.restartTimer();	
//		
//		EdgeFileParser parser = new EdgeFileParser();		
//		parser.parseOutput();
//		Timer.instance.restartTimer();
	}
}
