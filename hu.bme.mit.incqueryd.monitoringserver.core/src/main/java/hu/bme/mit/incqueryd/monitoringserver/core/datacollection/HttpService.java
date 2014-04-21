package hu.bme.mit.incqueryd.monitoringserver.core.datacollection;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.commons.io.IOUtils;

public class HttpService {

	public static String getJson(URL url) throws IOException{
		
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/json");
		
		if (conn.getResponseCode() != 200) {
			throw new IOException("Failed to get data from service: HTTP error code : "
					+ conn.getResponseCode());
		}
		
		String json = IOUtils.toString(conn.getInputStream());
		
		conn.disconnect();
		
		return json;

	}
	
}
