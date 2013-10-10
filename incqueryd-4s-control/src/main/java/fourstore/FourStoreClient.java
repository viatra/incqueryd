package fourstore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

public class FourStoreClient {

	protected final String extension = ".owl";
	protected final String clustername = "incqueryd_cluster";
	protected final String serverUrl;
	protected final String filename;

	public FourStoreClient(final String serverUrl, final String filename) {
		this.serverUrl = serverUrl;
		this.filename = filename;
	}

	public void load() {
		final String importCommand = String.format("4s-import %s %s", clustername, filename + extension);

		try {
			System.out.println(importCommand);
			final Process importProcess = Runtime.getRuntime().exec(importCommand);
			importProcess.waitFor();
		} catch (final IOException e) {
			e.printStackTrace();
		} catch (final InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Load executed.");
	}

	public long check() throws IOException {
		final String query = "PREFIX base: <http://www.semanticweb.org/ontologies/2011/1/TrainRequirementOntology.owl#>\n" + 
				"PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n" + 
				"PREFIX owl:  <http://www.w3.org/2002/07/owl#>\n" + 
				"PREFIX rdf:  <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" + 
				"\n" + 
				"SELECT distinct ?xSensor\n" + 
				"WHERE\n" + 
				"{\n" + 
				"    ?xRoute rdf:type base:Route .\n" + 
				"    ?xSwitchPosition rdf:type base:SwitchPosition .\n" + 
				"    ?xSwitch rdf:type base:Switch .\n" + 
				"    ?xSensor rdf:type base:Sensor .\n" + 
				"    ?xRoute base:Route_switchPosition ?xSwitchPosition .\n" + 
				"    ?xSwitchPosition base:SwitchPosition_switch ?xSwitch .\n" + 
				"    ?xSwitch base:TrackElement_sensor ?xSensor .\n" + 
				"\n" + 
				"    OPTIONAL {\n" + 
				"        ?xRoute ?Route_routeDefinition ?xSensor .\n" + 
				"        FILTER (sameTerm(base:Route_routeDefinition, ?Route_routeDefinition))\n" + 
				"    } .\n" + 
				"    FILTER (!bound(?Route_routeDefinition))\n" + 
				"}";
		
		// passing command name and arguments as an array to the ProcessBuilder
		final String[] command = new String[] { "4s-query", clustername, "-f", "text", "-s", "-1", query };
		final ProcessBuilder builder = new ProcessBuilder(command);
		Process process = null;
		process = builder.start();

		// hooking on the process' output stream
		final InputStream stdout = process.getInputStream();
		final BufferedReader reader = new BufferedReader(new InputStreamReader(stdout));

		// collecting ids
		// final Pattern pattern = Pattern.compile("#(.*?)>");
		long count = 0;
		String line;
		while ((line = reader.readLine()) != null) {
			if (line.length() > 0 && line.charAt(0) != '?') {
//				System.out.println(line);
				count++;
			}
		}
		System.out.println(count + " matches.");
		return count;
	}

	protected Multimap<Object, Object> collectEdges(final String edgeLabel) throws IOException {
		final Multimap<Object, Object> vertexPairs = ArrayListMultimap.create();

		final String query = String.format(
				"PREFIX base: <http://www.semanticweb.org/ontologies/2011/1/TrainRequirementOntology.owl#> SELECT ?x ?y WHERE { ?x base:%s ?y }",
				edgeLabel);

		// passing command name and arguments as an array to the ProcessBuilder
		final String[] command = new String[] { "4s-query", clustername, "-f", "text", "-s", "-1", query };
		final ProcessBuilder builder = new ProcessBuilder(command);
		Process process = null;
		process = builder.start();

		// hooking on the process' outputstream
		final InputStream stdout = process.getInputStream();
		final BufferedReader reader = new BufferedReader(new InputStreamReader(stdout));

		// collecting ids
		final Pattern pattern = Pattern.compile("#(.*?)>");
		String line;
		while ((line = reader.readLine()) != null) {
			final Matcher matcher = pattern.matcher(line);

			if (matcher.find()) {
				final String sourceString = matcher.group(1);
				if (matcher.find()) {
					final String destinationString = matcher.group(1);
					final Long source = Long.parseLong(sourceString);
					final Long destination = Long.parseLong(destinationString);
					vertexPairs.put(source, destination);
				}
			}
		}

		return vertexPairs;
	}


	public void edit() throws IOException, InterruptedException {
		final String edgeLabel = "Route_routeDefinition";
		final Multimap<Object, Object> routeAndSensorIds = collectEdges(edgeLabel);
		
		// swift move: get the set of the routeAndSensorIds multimap and create an ArrayList from them
		final ArrayList<Object> routeIds = new ArrayList<>(routeAndSensorIds.keys().elementSet());

		// randomly choosing some Routes to modify
		final List<Object> routesToModify = new ArrayList<>();

		final Random random = new Random(0);
		final int nElemToModify = 10;
		// choose nElemToModify elements to modify
		for (int i = 0; i < nElemToModify; i++) {
			final int rndTargetPosition = random.nextInt(routeIds.size());
			final Object routeId = routeIds.get(rndTargetPosition);
			routesToModify.add(routeId);

			// small modification over the original TrainBenchmark: we always choose nElemToModify different Routes
			routeIds.remove(routeId);
		}

		for (final Map.Entry<Object, Object> row : routeAndSensorIds.entries()) {
			final Object routeId = row.getKey();
			final Object sensorId = row.getValue();

			if (routesToModify.contains(routeId)) {
				routesToModify.remove(routeId);

//				System.out.println("deleting edge: " + routeId + " --> " + sensorId);
				deleteEdge(routeId, sensorId, edgeLabel);
			}
		}
	}	
	
	protected void deleteEdge(final Object sourceVertexId, final Object destinationVertexId, final String edgeLabel) throws IOException, InterruptedException {
		final String delete = String.format(
				"PREFIX base: <http://www.semanticweb.org/ontologies/2011/1/TrainRequirementOntology.owl#> DELETE DATA { base:%s base:%s base:%s }",
				sourceVertexId,
				edgeLabel,
				destinationVertexId
				);

		final String[] command = new String[] { "4s-update", clustername, delete };

		final ProcessBuilder builder = new ProcessBuilder(command);
		Process process = null;
		process = builder.start();
		process.waitFor();
	}


}
