package graphloader.performance.benchmark.main;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.ResultSetFuture;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.exceptions.InvalidConfigurationInQueryException;
import com.datastax.driver.core.querybuilder.Insert;
import com.datastax.driver.core.querybuilder.QueryBuilder;

public class Benchmark {
	Cluster cluster;
	Session session;

	public Benchmark(String host) {

		cluster = Cluster.builder().addContactPoints(host).build();
		session = cluster.connect("system");

		// drop keyspace if it exists
		try {
			runQuery("DROP KEYSPACE graph");
		} catch (InvalidConfigurationInQueryException exception) {
			System.out.println("cannot drop keyspace");
		}

		// create and use keyspace
		String createKeyspace =
				"CREATE KEYSPACE graph" +
						" WITH REPLICATION = { 'class' : 'SimpleStrategy', 'replication_factor' : 1 }";
		runQuery(createKeyspace);
		String useKeyspace = "USE graph";
		runQuery(useKeyspace);

		// create column family for vertices
		String createColumnFamilyForVertices =
				"CREATE TABLE vertices (" +
						" id text PRIMARY KEY," +
						" col1 text," +
						" col2 text," +
						" col3 text," +
						" col4 text," +
						" col5 text," +
						" col6 text," +
						" col7 text," +
						" col8 text," +
						" col9 text," +
						" col10 text," +
						")";
		runQuery(createColumnFamilyForVertices);
	}

	private void runQuery(String string) {
		session.execute(string);
	}

	public void executeAsync(int n) throws InterruptedException {
		AsyncBulkInsertListener listener = new AsyncBulkInsertListener();
		Executor executor = Executors.newSingleThreadExecutor();

		for (int i = 0; i < n; i++) {
			String s = Integer.toString(i);

			Insert insert = QueryBuilder.insertInto("graph", "vertices");
			String[] names = { "id", "col1", "col2", "col3", "col4", "col5", "col6", "col7", "col8", "col9", "col10" };
			Object[] values = { s, s, s, s, s, s, s, s, s, s, s };
			insert.values(names, values);
			ResultSetFuture executeAsync = session.executeAsync(insert);
			listener.insert();
			executeAsync.addListener(listener, executor);
		}

		System.out.println(System.currentTimeMillis() / 1000 + " waiting");

		synchronized (listener) {
			if (!listener.isFinished()) {
				listener.wait();
			}
		}

		System.out.println(System.currentTimeMillis() / 1000 + " done");
	}

	public void executeSync(int n) {
		for (int i = 0; i < n; i++) {
			String s = Integer.toString(i);

			Insert insert = QueryBuilder.insertInto("graph", "vertices");
			String[] names = { "id", "col1", "col2", "col3", "col4", "col5", "col6", "col7", "col8", "col9", "col10" };
			Object[] values = { s, s, s, s, s, s, s, s, s, s, s };
			insert.values(names, values);
			session.execute(insert);
		}
	}

	public void executePrepared(int n) {
		String insertQuery = "INSERT INTO vertices " +
				"(id, col1, col2, col3, col4, col5, col6, col7, col8, col9, col10) " +
				"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement preparedStatement = session.prepare(insertQuery);

		for (int i = 0; i < n; i++) {
			BoundStatement bind = preparedStatement.bind();
			bind.setString(0, Integer.toString(i));
			bind.setString(1, Integer.toString(i));
			bind.setString(2, Integer.toString(i));
			bind.setString(3, Integer.toString(i));
			bind.setString(4, Integer.toString(i));
			bind.setString(5, Integer.toString(i));
			bind.setString(6, Integer.toString(i));
			bind.setString(7, Integer.toString(i));
			bind.setString(8, Integer.toString(i));
			bind.setString(9, Integer.toString(i));
			bind.setString(10, Integer.toString(i));
			session.execute(bind);
		}
	}

	public void callBack() {
		System.out.println("callback invoked");
	}

}