package hu.bme.mit.train.generator;

import hu.bme.mit.train.common.RuntimeConstants;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.codehaus.jettison.json.JSONObject;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.RelationshipType;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.neo4j.kernel.impl.util.FileUtils;

import com.thinkaurelius.faunus.FaunusVertex;
import com.thinkaurelius.faunus.formats.graphson.FaunusGraphSONUtility;
import com.tinkerpop.blueprints.Direction;
import com.tinkerpop.blueprints.Edge;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.blueprints.impls.neo4j.Neo4jGraph;
import com.tinkerpop.blueprints.util.io.graphml.GraphMLWriter;
import com.tinkerpop.blueprints.util.io.graphson.GraphSONUtility;
import com.tinkerpop.blueprints.util.io.graphson.GraphSONWriter;

/**
 * Generate the Ontology instance model.
 */
public class Generator_Neo4j implements IGenerator {

	// program arguments example: -scenario User -syntax Neo4j -sizes 1-8

	private long idx;

	// the path should end with a '/' character
	public final String DB_ROOT_PATH = RuntimeConstants.modelProjectPath + "/models/";
	private GraphDatabaseService graphDb;

	public void initModel(String dbPath) {
		// ************ BACKEND INIT ************
		// Init graph database
		graphDb = new GraphDatabaseFactory().newEmbeddedDatabase(dbPath);

		setRootNodeProperties();
	}

	private void setRootNodeProperties() {
		Transaction tx = null;
		tx = graphDb.beginTx();

		// graphDb.getReferenceNode().delete();
		graphDb.getReferenceNode().setProperty("type", "root");

		tx.success();
		tx.finish();
	}

	final String signalType = "Signal";
	final String routeType = "Route";
	final String switchType = "Switch";
	final String sensorType = "Sensor";
	final String segmentType = "Segment";
	final String switchPositionType = "SwitchPosition";

	final String relation_ROUTE_ENTRY = "ROUTE_ENTRY";
	final String relation_ROUTE_EXIT = "ROUTE_EXIT";
	final String relation_ROUTE_ROUTEDEFINITION = "ROUTE_ROUTEDEFINITION";
	final String relation_ROUTE_SWITCHPOSITION = "ROUTE_SWITCHPOSITION";
	final String relation_TRACKELEMENT_SENSOR = "TRACKELEMENT_SENSOR";
	final String relation_TRACKELEMENT_CONNECTSTO = "TRACKELEMENT_CONNECTSTO";
	final String relation_SWITCHPOSITION_SWITCH = "SWITCHPOSITION_SWITCH";

	final String signal_go_state = "SIGNAL_STATE_KIND_GO";

	public void testFillUpFile(GeneratorConfig generatorConstants) {
		String dbPath = DB_ROOT_PATH + "testBig" + generatorConstants.variant + generatorConstants.Size + ".neo4j";

		// String fileName = DB_ROOT_PATH + "testBig" +
		// generatorConstants.variant + generatorConstants.Size;
		String fileName = "/home/szarnyasg/hdd/models/" + "testBig" + generatorConstants.variant
				+ generatorConstants.Size;

		// on the first run delete the previous database directories
		if (new File(dbPath).exists()) {
			try {
				FileUtils.deleteRecursively(new File(dbPath));
				System.out.println("Database directory deleted: " + dbPath);
			} catch (IOException e) {
				System.out.println("Cannot delete database directory:" + dbPath);
			}
		}

		initModel(dbPath);

		Random random = new Random(generatorConstants.RANDOM);
		int rnd;
		idx = 0;

		Transaction tx = null;
		try {
			for (int l = 0; l < generatorConstants.MAX_IndividualContainer; l++) {
				Node prevSig = null;
				Node firstSig = null;

				String prevSigName = null;
				String firstSigName = null;

				List<Node> firstTracks = null;
				List<Node> prevTracks = null;

				for (int i = 0; i < generatorConstants.MAX_Routes; i++) {
					// starting Neo4j transaction
					tx = graphDb.beginTx();

					final String routeName = "Route" + i;
					idx++;

					Node route = graphDb.createNode();
					route.setProperty("type", routeType);

					route.setProperty("name", routeName);
					route.setProperty("idx", idx);

					if (prevSig == null)
					{
						prevSigName = "Signal" + i + "a";
						idx++;

						prevSig = graphDb.createNode();
						prevSig.setProperty("type", signalType);

						prevSig.setProperty("name", prevSigName);
						prevSig.setProperty("Signal_actualState", signal_go_state);
						prevSig.setProperty("idx", idx);
						firstSig = prevSig;
					}

					if (prevSigName == null) {
						prevSigName = "Signal" + i + "a";
						idx++;

						firstSigName = prevSigName;
					}

					Node sig2;
					String sig2Name = "";
					if (i != generatorConstants.MAX_Routes - 1)
					{
						sig2Name = "Signal" + i + "b";
						idx++;

						sig2 = graphDb.createNode();
						sig2.setProperty("type", signalType);

						sig2.setProperty("name", sig2Name);
						sig2.setProperty("Signal_actualState", signal_go_state);
						sig2.setProperty("idx", idx);
					} else {
						sig2 = firstSig;
						sig2Name = firstSigName;
					}

					rnd = random.nextInt(100);
					if (rnd >= generatorConstants.signalNeighborErrorPercent) {
						Relationship routeEntry = route.createRelationshipTo(prevSig, TrainRelationship.ROUTE_ENTRY);
//						routeEntry.setProperty("edgetype", relation_ROUTE_ENTRY);
					}

					rnd = random.nextInt(100);
					if (rnd >= generatorConstants.signalNeighborErrorPercent) {
						Relationship routeExit = route.createRelationshipTo(sig2, TrainRelationship.ROUTE_EXIT);
//						routeExit.setProperty("edgetype", relation_ROUTE_EXIT);
					}

					int swps = random.nextInt(generatorConstants.MAX_SwPs);

					List<Node> currTracks = new ArrayList<Node>();
					List<String> currTracksName = new ArrayList<String>();

					for (int j = 0; j < swps; j++)
					{
						final String switchName = "Switch" + j + "_" + i;
						idx++;

						Node sw = graphDb.createNode();
						sw.setProperty("type", switchType);

						sw.setProperty("name", switchName);
						sw.setProperty("idx", idx);

						currTracks.add(sw);

						currTracksName.add(switchName);

						int sensors = random.nextInt(generatorConstants.MAX_Sensors);

						for (int k = 0; k < sensors; k++)
						{
							idx++;
							final String sensorName = "Sensor" + k + "_" + j + "_" + i;

							Node sen = graphDb.createNode();
							sen.setProperty("type", sensorType);

							sen.setProperty("name", sensorName);
							sen.setProperty("idx", idx);

							rnd = random.nextInt(100);
							if (rnd >= generatorConstants.switchSensorErrorPercent)
							{
								Relationship trackElementSensor = sw.createRelationshipTo(sen,
										TrainRelationship.TRACKELEMENT_SENSOR);
//								trackElementSensor.setProperty("edgetype", relation_TRACKELEMENT_SENSOR);

								int rnd2 = random.nextInt(100);
								if (rnd2 >= generatorConstants.routeSensorErrorPercent)
								{
									Relationship routeRouteDefinition = route.createRelationshipTo(sen,
											TrainRelationship.ROUTE_ROUTEDEFINITION);
//									routeRouteDefinition.setProperty("edgetype", relation_ROUTE_ROUTEDEFINITION);
								}
							}

							for (int m = 0; m < generatorConstants.MAX_Segments; m++) {
								int segmentLength;
								final String segmentName = "Segment" + m + "_" + k + "_" + j + "_" + i;
								idx++;

								rnd = random.nextInt(100);
								if (rnd < generatorConstants.posLengthErrorPercent) {
									segmentLength = -1 * random.nextInt(1000);
								} else {
									segmentLength = random.nextInt(1000);
								}

								Node seg = graphDb.createNode();
								seg.setProperty("type", segmentType);

								seg.setProperty("name", segmentName);
								seg.setProperty("idx", idx);
								seg.setProperty("Segment_length", segmentLength);

								Relationship trackElementSensor = seg.createRelationshipTo(sen,
										TrainRelationship.TRACKELEMENT_SENSOR);
//								trackElementSensor.setProperty("edgetype", relation_TRACKELEMENT_SENSOR);

								currTracks.add(seg);
							}
						}

						String switchPositionName = "SwitchPosition" + j + "_" + i;
						idx++;

						int state = random.nextInt(4);

						Node swp = graphDb.createNode();
						swp.setProperty("type", switchPositionType);

						swp.setProperty("name", switchPositionName);
						swp.setProperty("idx", idx);

						// not implemented in the Cypher version
						sw.setProperty("Switch_actualState", state);

						rnd = random.nextInt(100);
						if (rnd < generatorConstants.switchSetErrorPercent)
						{
							swp.setProperty("SwitchPosition_switchState", 3 - state);
						} else {
							swp.setProperty("SwitchPosition_switchState", state);
						}

						Relationship switchPositionSwitch = swp.createRelationshipTo(sw,
								TrainRelationship.SWITCHPOSITION_SWITCH);
//						switchPositionSwitch.setProperty("edgetype", relation_SWITCHPOSITION_SWITCH);

						Relationship routeSwitchPosition = route.createRelationshipTo(swp,
								TrainRelationship.ROUTE_SWITCHPOSITION);
//						routeSwitchPosition.setProperty("edgetype", relation_ROUTE_SWITCHPOSITION);
					}

					Node prevte = null;
					for (Node trackelement : currTracks) {
						if (prevte != null) {
							Relationship trackElementConnectsTo = prevte.createRelationshipTo(trackelement,
									TrainRelationship.TRACKELEMENT_CONNECTSTO);
//							trackElementConnectsTo.setProperty("edgetype", relation_TRACKELEMENT_CONNECTSTO);
						}
						prevte = trackelement;
					}

					if (prevTracks != null && prevTracks.size() > 0 && currTracks.size() > 0) {
						Relationship trackElementConnectsTo = prevTracks.get(prevTracks.size() - 1)
								.createRelationshipTo(currTracks.get(0),
										TrainRelationship.TRACKELEMENT_CONNECTSTO);
//						trackElementConnectsTo.setProperty("edgetype", relation_TRACKELEMENT_CONNECTSTO);
					}

					// Loop the last track element of the last route to the
					// first track element of the first route.
					if (i == generatorConstants.MAX_Routes - 1)
					{
						if (currTracks != null && currTracks.size() > 0 && firstTracks.size() > 0) {
							Relationship trackElementConnectsTo = currTracks.get(currTracks.size() - 1)
									.createRelationshipTo(firstTracks.get(0),
											TrainRelationship.TRACKELEMENT_CONNECTSTO);
//							trackElementConnectsTo.setProperty("edgetype", relation_TRACKELEMENT_CONNECTSTO);
						}
					}

					if (prevTracks == null) {
						firstTracks = currTracks;
					}

					prevTracks = currTracks;
					prevSig = sig2;

					// finishing Neo4j transaction
					tx.success();
					tx.finish();
				}
			}
		} finally {
			graphDb.shutdown();
		}

		serializeGraph(dbPath, fileName, generatorConstants.getGraphFormat());

		System.out.println(idx);
		System.out.println("Done");
	}

	public void serializeGraph(String dbFile, String fileNameWithoutExtension, GraphFormat graphFormat) {
		String fileName = "";
		System.out.println("Serializing...");

		Neo4jGraph graph = new Neo4jGraph(dbFile);

		try {
			switch (graphFormat) {
			case BLUEPRINTS_GRAPHSON:
				fileName = fileNameWithoutExtension + ".blueprints-graphson";
				GraphSONWriter.outputGraph(graph, new FileOutputStream(fileName));
				break;
			case FAUNUS_GRAPHSON:
				fileName = fileNameWithoutExtension + ".faunus-graphson";
				generateGraphSON(fileName, graph);
				break;
			case GRAPHML:
				fileName = fileNameWithoutExtension + ".graphml";
				GraphMLWriter.outputGraph(graph, new FileOutputStream(fileName));
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		graph.shutdown();

		System.out.println(fileName + " serialized.");
	}

	private void generateGraphSON(String graphSonFile, Neo4jGraph graph) throws IOException {
		File file = new File(graphSonFile);

		// if file doesn't exists, then create it
		if (!file.exists()) {
			file.createNewFile();
		}

		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);

		Iterable<Vertex> vertices = graph.getVertices();
		for (Vertex vertex : vertices) {
			JSONObject jsonObject = MyGSONUtils.toJSON(vertex);
			String jsonLine = jsonObject.toString();			
			bw.write(jsonLine.toString() + "\n");
		}

		bw.close();
	}

	enum TrainRelationship implements RelationshipType
	{
		ROUTE_ENTRY,
		ROUTE_EXIT,
		ROUTE_ROUTEDEFINITION,
		ROUTE_SWITCHPOSITION,
		TRACKELEMENT_SENSOR,
		TRACKELEMENT_CONNECTSTO,
		SWITCHPOSITION_SWITCH,
	}

}
