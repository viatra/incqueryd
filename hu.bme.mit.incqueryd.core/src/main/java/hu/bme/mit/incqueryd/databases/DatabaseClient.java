package hu.bme.mit.incqueryd.databases;

import hu.bme.mit.incqueryd.exceptions.DatabaseClientException;

import com.google.common.collect.Multimap;

public abstract class DatabaseClient {

    protected String serverUrl;
    protected final String filename;

    public DatabaseClient(final String serverUrl, final String filename) {
        this.serverUrl = serverUrl;
        this.filename = filename;
    }

    public abstract String getExtension();

    public abstract void close();

    public abstract void load();

    public abstract Iterable<?> retrieveNodes(String typeName);

    public abstract Multimap<Object, Object> collectEdges(String edgeLabel) throws DatabaseClientException;

    public abstract void deleteEdge(Object sourceVertexId, Object destinationVertexId, String edgeLabel)
            throws DatabaseClientException;
}
