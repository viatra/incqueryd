package neo4jloader.main;

import java.io.FileInputStream;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.kernel.EmbeddedGraphDatabase;

import com.tinkerpop.blueprints.impls.neo4j.Neo4jGraph;
import com.tinkerpop.blueprints.util.io.graphml.GraphMLReader;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		
		String dbFile = "neo4j-graph";
		String xmlFile = "testBig_User_1.graphml";
		GraphDatabaseService rawGraph = new EmbeddedGraphDatabase(dbFile);		
		
		Neo4jGraph graph = new Neo4jGraph(rawGraph);
		try {
			GraphMLReader.inputGraph(graph, new FileInputStream(xmlFile));
		} catch (Exception e) {
			e.printStackTrace();
		}						
		graph.shutdown();	
		
		long stopTime = System.currentTimeMillis();
		long delta = stopTime - startTime;
		System.out.println("Total time: " + delta / 1000 + "s " + delta % 1000 + "ms");
	}

}
