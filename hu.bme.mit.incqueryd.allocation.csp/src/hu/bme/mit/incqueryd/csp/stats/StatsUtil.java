package hu.bme.mit.incqueryd.csp.stats;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

public class StatsUtil {

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
