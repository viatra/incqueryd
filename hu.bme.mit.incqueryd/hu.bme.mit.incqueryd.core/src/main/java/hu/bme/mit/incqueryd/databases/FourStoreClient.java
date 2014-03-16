package hu.bme.mit.incqueryd.databases;

import hu.bme.mit.trainbenchmark.benchmark.util.UnixUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

/**
 * 
 * @author szarnyasg
 *
 */
public class FourStoreClient {

	static final String ONTOLOGYIRI = "http://www.semanticweb.org/ontologies/2011/1/TrainRequirementOntology.owl";
	static final String BASE_PREFIX = ONTOLOGYIRI + "#";
	static final String RDF_PREFIX = "http://www.w3.org/1999/02/22-rdf-syntax-ns#";
	
	static final String SPARQL_BASE_PREFIX = "PREFIX base: <" + BASE_PREFIX + "> ";
	static final String SPARQL_RDF_PREFIX = "PREFIX rdf: <" + RDF_PREFIX + "> ";
	
	protected final String clustername = "trainbenchmark_cluster";
	protected final boolean showCommandOutput = false;
	protected final boolean showUpdateCommands = false;
	
	protected long uniqueId = 1000000000;

	public void load(final String modelPath) throws IOException {
		if (!new File(modelPath).exists()) {
			throw new FileNotFoundException(modelPath);
		}

		final String command[] = new String[] { "4s-import", clustername, modelPath };
		UnixUtils.run(command, showCommandOutput);
	}

	public void update(final String query) throws IOException {	
		final String[] command = new String[] { "4s-update", clustername, query };
	
		UnixUtils.run(command, showUpdateCommands);
	}

	// queries

	public List<Long> collectVertices(final String type) throws IOException {
		final String queryString = String.format(SPARQL_BASE_PREFIX + SPARQL_RDF_PREFIX + "SELECT ?x WHERE { ?x rdf:type base:%s }",
				type);

		return queryIds(queryString);
	}

	public Map<Long, Integer> collectVerticesWithProperty(final String propertyName) throws IOException {
		final String queryString = String.format(SPARQL_BASE_PREFIX + SPARQL_RDF_PREFIX + "SELECT ?x ?y WHERE { ?x base:%s ?y }",
				propertyName);

		return queryIdAndProperty(queryString);
	}

	public Multimap<Long, Long> collectEdges(final String edgeLabel) throws IOException {
		final Multimap<Long, Long> vertexPairs = ArrayListMultimap.create();

		final String query = String.format(SPARQL_BASE_PREFIX + "SELECT ?x ?y WHERE { ?x base:%s ?y }", edgeLabel);

		final BufferedReader reader = runQuery(query);

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

	public Multimap<Long, Long> collectOutgoingEdges(final String vertexType, final String edgeLabel)
			throws IOException {
		final Multimap<Long, Long> vertexPairs = ArrayListMultimap.create();

		final String query = String.format(SPARQL_BASE_PREFIX + SPARQL_RDF_PREFIX
				+ "SELECT ?x ?y WHERE { ?x rdf:type base:%s . ?x base:%s ?y }", vertexType, edgeLabel);

		final BufferedReader reader = runQuery(query);

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

	protected BufferedReader runQuery(final String query) throws IOException {		
		// passing command name and arguments as an array to the ProcessBuilder
		final String[] command = new String[] { "4s-query", clustername, "-f", "text", "-s", "-1", query };

		final BufferedReader reader = UnixUtils.runAndReadOutput(command, showCommandOutput);
		return reader;
	}

	public List<Long> queryIds(final String query) throws IOException {
		final BufferedReader reader = runQuery(query);

		// example: <http://www.semanticweb.org/ontologies/2011/1/TrainRequirementOntology.owl#87947>
		final String regex = "<" + BASE_PREFIX + "(\\d+)>";
		final Pattern pattern = Pattern.compile(regex);

		final List<Long> results = new ArrayList<>();

		String line;
		while ((line = reader.readLine()) != null) {
			final Matcher matcher = pattern.matcher(line);
			if (matcher.matches()) {
				final long id = Long.parseLong(matcher.group(1));
				results.add(id);
			}
		}
		return results;
	}

	protected Map<Long, Integer> queryIdAndProperty(final String query) throws IOException {
		final BufferedReader reader = runQuery(query);

		// example: <http://www.semanticweb.org/ontologies/2011/1/TrainRequirementOntology.owl#87947>
		// "653"^^<http://www.w3.org/2001/XMLSchema#int>
		final String regex = "<" + BASE_PREFIX + "(\\d+)>\\t\"([\\d-]+?)\".*";
		final Pattern pattern = Pattern.compile(regex);

		final Map<Long, Integer> results = new HashMap<>();
		String line;
		while ((line = reader.readLine()) != null) {
			final Matcher matcher = pattern.matcher(line);
			if (matcher.matches()) {
				final long id = Long.parseLong(matcher.group(1));
				final int property = Integer.parseInt(matcher.group(2));
				results.put(id, property);
			}
		}
		return results;
	}

	// modifications

	public void updateProperty(final Long vertexId, final String propertyName, final int value) throws IOException {
		final String deleteQuery = String.format(SPARQL_BASE_PREFIX
				+ "DELETE { base:%d base:%s ?y } WHERE { base:%d base:%s ?y }", vertexId, propertyName, vertexId,
				propertyName);
		update(deleteQuery);

		final String insertQuery = String.format(SPARQL_BASE_PREFIX
				+ "INSERT DATA { base:%s base:%s \"%d\"^^<http://www.w3.org/2001/XMLSchema#int> }", vertexId,
				propertyName, value);
		update(insertQuery);
	}

	// deletions

	public void deleteVertex(final Long id) throws IOException {
		// if we try to use DELETE DATA (as in the deleteEdge() method), 4store throws an error:
		// DELETE WHERE { x } not yet supported, use DELETE { x } WHERE { x }

		// delete "incoming edges"
		final String deleteQuery1 = String.format(SPARQL_BASE_PREFIX + " DELETE { ?x ?y base:%d } WHERE { ?x ?y base:%d }",
				id, id);
		// delete "outgoing edges" and "properties"
		final String deleteQuery2 = String.format(SPARQL_BASE_PREFIX + " DELETE { base:%d ?x ?y } WHERE { base:%d ?x ?y }",
				id, id);

		update(deleteQuery1);
		update(deleteQuery2);
	}

	public void deleteEdge(final Long sourceVertexId, final Long destinationVertexId, final String edgeLabel)
			throws IOException {
		final String deleteQuery = String.format(SPARQL_BASE_PREFIX + "DELETE DATA { base:%s base:%s base:%s }",
				sourceVertexId, edgeLabel, destinationVertexId);
		update(deleteQuery);
	}

	// insertions

	public long insertVertex(final String vertexType) throws IOException {
		final long vertexId = uniqueId++;

		final String insertQuery = String.format(SPARQL_BASE_PREFIX + SPARQL_RDF_PREFIX + "INSERT DATA { base:%d rdf:type base:%s }",
				vertexId, vertexType);
		update(insertQuery);

		return vertexId;
	}

	public void insertEdge(final long sourceVertexId, final long destinationVertexId, final String edgeLabel)
			throws IOException {
		final String insertQuery = String.format(SPARQL_BASE_PREFIX + "INSERT DATA { base:%d base:%s base:%d }",
				sourceVertexId, edgeLabel, destinationVertexId);
		update(insertQuery);
	}

}
