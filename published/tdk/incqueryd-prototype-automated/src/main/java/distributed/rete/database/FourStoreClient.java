package distributed.rete.database;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

import distributed.rete.exceptions.DatabaseClientException;

public class FourStoreClient extends DatabaseClient {

	protected final String extension = ".owl";
	protected final String clustername = "incqueryd_cluster";

	public FourStoreClient(final String serverUrl, final String filename) {
		super(serverUrl, filename);
	}

	@Override
	public void close() {

	}

	@Override
	public void load() {
		final String importCommand = String.format("4s-import %s %s", clustername, filename + getExtension());

		try {
			System.out.println(importCommand);
			Process importProcess = Runtime.getRuntime().exec(importCommand);
			importProcess.waitFor();

		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Load executed.");
	}

	@Override
	public Iterable<?> retrieveNodes(String typeName) {
		return null;
	}

	@Override
	public Multimap<Object, Object> collectEdges(String edgeLabel) throws DatabaseClientException {
		final Multimap<Object, Object> vertexPairs = ArrayListMultimap.create();

		final String query = String.format(
				"PREFIX base: <http://www.semanticweb.org/ontologies/2011/1/TrainRequirementOntology.owl#> SELECT ?x ?y WHERE { ?x base:%s ?y }",
				edgeLabel);

		// passing command name and arguments as an array to the ProcessBuilder 
		String[] command = new String[] { "4s-query", clustername, "-f", "text", "-s", "-1", query };
		ProcessBuilder builder = new ProcessBuilder(command);
		Process process = null;
		try {
			process = builder.start();
		} catch (IOException e) {
			throw new DatabaseClientException("Error during query process.", e);
		}

		// hooking on the process' outputstream
		final InputStream stdout = process.getInputStream();
		final BufferedReader reader = new BufferedReader(new InputStreamReader(stdout));

		// collecting ids
		final Pattern pattern = Pattern.compile("#(.*?)>");
		String line;
		try {
			while ((line = reader.readLine()) != null) {
				final Matcher matcher = pattern.matcher(line);

				if (matcher.find()) {
					String sourceString = matcher.group(1);
					if (matcher.find()) {
						String destinationString = matcher.group(1);
						Long source = Long.parseLong(sourceString);
						Long destination = Long.parseLong(destinationString);
						vertexPairs.put(source, destination);
					}
				}
			}
		} catch (NumberFormatException | IOException e) {
			throw new DatabaseClientException("Error during pattern matching.", e);
		}

		return vertexPairs;
	}

	@Override
	public void deleteEdge(final Object sourceVertexId, final Object destinationVertexId, final String edgeLabel) throws DatabaseClientException {
		String delete = String.format(
				"PREFIX base: <http://www.semanticweb.org/ontologies/2011/1/TrainRequirementOntology.owl#> DELETE DATA { base:%s base:%s base:%s }",
				sourceVertexId, 
				edgeLabel,
				destinationVertexId
				);
		
		String[] command = new String[] { "4s-update", clustername, delete };
		
//		for (String c : command) {
//			System.out.print(c + " ");
//		}
//		System.out.println();
//		System.out.println("deleting edge: " + command );
		
		ProcessBuilder builder = new ProcessBuilder(command);
		Process process = null;
		try {
			process = builder.start();
			process.waitFor();
		} catch (IOException | InterruptedException e) {
			throw new DatabaseClientException("Error during edge deletion.", e);
		}
	}

	@Override
	public String getExtension() {
		return extension;
	}

}
