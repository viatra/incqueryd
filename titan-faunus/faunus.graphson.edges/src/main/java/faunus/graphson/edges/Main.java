package faunus.graphson.edges;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import com.thinkaurelius.faunus.FaunusVertex;
import com.thinkaurelius.faunus.formats.graphson.FaunusGraphSONUtility;
import com.tinkerpop.blueprints.Direction;
import com.tinkerpop.blueprints.Edge;
import com.tinkerpop.blueprints.Vertex;

public class Main {

	public static void main(String[] args) throws IllegalArgumentException, IOException {
		// if (true) return;

		final String filename = "testBig_User_1.faunus-graphson";
		final String hadoopConf = System.getenv("HADOOP_CONF");

		Path path = new Path(filename);
		Configuration conf = new Configuration();
		conf.addResource(new Path(hadoopConf + "/core-site.xml"));
		FileSystem fs = FileSystem.get(conf);

		BufferedReader br = new BufferedReader(new InputStreamReader(fs.open(path)));
		String line = br.readLine();

		while (line != null) {
			processLine(line);
			line = br.readLine();
		}
		;
	}

	private static void edgesFromLocalFs() throws FileNotFoundException, IOException {
		final long start = System.nanoTime();
		final String file = "testBig_User_1.faunus-graphson";
		// final String file = "/home/szarnyasg/hdd/models/testBig_User_1024.faunus-graphson";
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line;
		while ((line = br.readLine()) != null) {
			processLine(line);
		}
		br.close();
		final long stop = System.nanoTime();
		final long delta = (stop - start) / 1000000000;
		// System.out.println(delta);
	}

	private static void processLine(String line) throws IOException {
		FaunusVertex v = FaunusGraphSONUtility.fromJSON(line);
		// System.out.println(v);
		// Iterable<Edge> allEdges = v.getEdges(Direction.BOTH);

		String[] labels = {
				"SWITCHPOSITION_SWITCH",
				"ROUTE_SWITCHPOSITION",
				"TRACKELEMENT_SENSOR",
				"ROUTE_ROUTEDEFINITION"
		};

		System.out.println("id: " + v);
		for (String label : labels) {
			Iterable<Edge> edges = v.getEdges(Direction.OUT, label);
			System.out.println(label);
			for (Edge edge : edges) {
				Vertex v2 = edge.getVertex(Direction.IN);
				System.out.println(v2);
			}
		}
	}
}
