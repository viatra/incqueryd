package clustergraphloader.graphml;

import java.io.IOException;
import java.io.InputStream;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.log4j.Logger;

/**
 * Abstract superclass for all GraphML parsing objects.
 * 
 * @author szarnyasg
 * 
 */
public abstract class GraphMlParser {
	// for the complete definition of the GraphML format, look here:
	// http://graphml.graphdrawing.org/specification/schema_element.xsd.htm

	// elements
	static final String GRAPH = "graph";
	static final String NODE = "node";
	static final String EDGE = "edge";
	static final String DATA = "data";

	// attributes
	static final String ID = "id";
	static final String EDGEDEFAULT = "edgedefault";
	static final String KEY = "key";
	static final String SOURCE = "source";
	static final String TARGET = "target";
	static final String LABEL = "label";

	// logger
	protected final Logger logger = Logger.getLogger(GraphMlParserFirstPass.class);

	// HDFS variables
	protected InputStream graphMlStream;
	protected FileSystem fileSystem;
	protected Path path;

	public GraphMlParser() {
		super();
	}

	public void initializeFileSystem(String fileName) {
		Configuration conf = new Configuration();
		
		// TODO change absolute URL to relative URL
		conf.addResource(new Path("/home/szarnyasg/hadoop-1.1.2/conf/core-site.xml"));
		conf.addResource(new Path("/home/szarnyasg/hadoop-1.1.2/conf/hdfs-site.xml"));
		
		try {
			fileSystem = FileSystem.get(conf);
			path = new Path(fileName);
			
			if (!fileSystem.exists(path)) {
				System.err.println("File does not exists");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void initializeInputStream() {
		try {
			graphMlStream = fileSystem.open(path); // returns a FSDataInputStream
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
