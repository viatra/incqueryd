package hu.bme.mit.incqueryd.databases;

import hu.bme.mit.incqueryd.exceptions.DatabaseClientException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

/**
 * 
 * @author szarnyasg
 *
 */
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
            final Process importProcess = Runtime.getRuntime().exec(importCommand);
            importProcess.waitFor();

        } catch (final IOException e) {
            e.printStackTrace();
        } catch (final InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Load executed.");
    }

    @Override
    public Iterable<?> retrieveNodes(final String typeName) {
        return null;
    }

    @Override
    public Multimap<Object, Object> collectEdges(final String edgeLabel) throws DatabaseClientException {
        final Multimap<Object, Object> vertexPairs = ArrayListMultimap.create();

        final String query = String
                .format("PREFIX base: <http://www.semanticweb.org/ontologies/2011/1/TrainRequirementOntology.owl#> SELECT ?x ?y WHERE { ?x base:%s ?y }",
                        edgeLabel);

        // passing command name and arguments as an array to the ProcessBuilder
        final String[] command = new String[] { "4s-query", clustername, "-f", "text", "-s", "-1", query };
        final ProcessBuilder builder = new ProcessBuilder(command);
        Process process = null;
        try {
            process = builder.start();
        } catch (final IOException e) {
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
                    final String sourceString = matcher.group(1);
                    if (matcher.find()) {
                        final String destinationString = matcher.group(1);
                        final Long source = Long.parseLong(sourceString);
                        final Long destination = Long.parseLong(destinationString);
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
    public void deleteEdge(final Object sourceVertexId, final Object destinationVertexId, final String edgeLabel)
            throws DatabaseClientException {
        final String delete = String
                .format("PREFIX base: <http://www.semanticweb.org/ontologies/2011/1/TrainRequirementOntology.owl#> DELETE DATA { base:%s base:%s base:%s }",
                        sourceVertexId, edgeLabel, destinationVertexId);

        final String[] command = new String[] { "4s-update", clustername, delete };

        // for (String c : command) {
        // System.out.print(c + " ");
        // }
        // System.out.println();
        // System.out.println("deleting edge: " + command );

        final ProcessBuilder builder = new ProcessBuilder(command);
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
