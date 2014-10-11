package hu.bme.mit.incqueryd.stats;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

public class StatsUtil {

	public static void saveStats(String statsFile, Map<String, Long> stats) throws IOException {
		Properties props = new Properties();
		for (Map.Entry<String, Long> entry : stats.entrySet()) {
			props.setProperty(entry.getKey(), entry.getValue().toString());
		}

		File f = new File(statsFile);
		OutputStream out = new FileOutputStream(f);
		props.store(out, "");
	}

	public static Map<String, Long> loadStats(String statsFile) throws IOException {
		Properties props = new Properties();
		InputStream is = null;

		File f = new File(statsFile);
		is = new FileInputStream(f);
		props.load(is);

		Map<String, Long> stats = new HashMap<>();
		for (Entry<Object, Object> entry : props.entrySet()) {
			stats.put((String) entry.getKey(), Long.parseLong((String) entry.getValue()));
		}
		return stats;
	}
}
