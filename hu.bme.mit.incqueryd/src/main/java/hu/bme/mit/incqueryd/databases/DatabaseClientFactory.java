package hu.bme.mit.incqueryd.databases;

public class DatabaseClientFactory {

    public static DatabaseClient createDatabaseClient(final DatabaseClientType type, final String serverUrl,
            final String filename) {
        switch (type) {
        case FOURSTORE:
            return new FourStoreClient(serverUrl, filename);
        case TITANFAUNUS:
            return new TitanFaunusClient(serverUrl, filename);
        default:
            return null;
        }
    }
}
