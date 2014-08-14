package hu.bme.mit.incqueryd.tooling.ide.httpclient;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.commons.io.IOUtils;

public class HttpClient {

	public static String getURL(String urlString) throws IOException {
		
		URL url = new URL(urlString);

		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setReadTimeout(1000000 * 1000);

		if (conn.getResponseCode() != 200) {
			throw new IOException(
					"Failed to get data from service: HTTP error code : "
							+ conn.getResponseCode());
		}

		String responseString = IOUtils.toString(conn.getInputStream());

		conn.disconnect();

		return responseString;

	}
	
}
