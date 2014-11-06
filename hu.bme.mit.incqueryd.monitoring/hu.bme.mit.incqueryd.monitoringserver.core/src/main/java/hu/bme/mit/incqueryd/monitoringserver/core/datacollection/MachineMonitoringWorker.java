package hu.bme.mit.incqueryd.monitoringserver.core.datacollection;

import hu.bme.mit.incqueryd.monitoringserver.core.deserialization.MachineMonitoringDataDeserializer;
import hu.bme.mit.incqueryd.monitoringserver.core.model.MachineMonitoringData;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MachineMonitoringWorker extends Thread {

	private String host;
	private int port;
	
	private MachineMonitoringData data;
	

	public MachineMonitoringWorker(String host, int port) {
		this.host = host;
		this.port = port;
	}
	
	public MachineMonitoringData getData() {
		return data;
	}
	
	public String getHost() {
		return host;
	}

	@Override
	public void run() {

		URL url = null;

		try {
			url = new URL("http://" + host + ":" + port
					+ "/jolokia/read/hu.bme.mit.incqueryd:type=os");
		} catch (MalformedURLException e) {
			data = null;
			return;
		}

		String json = null;

		try {
			json = HttpService.getJson(url);
		} catch (IOException e) {
			data = null;
			return;
		}

		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.registerTypeAdapter(MachineMonitoringData.class,
				new MachineMonitoringDataDeserializer());
		Gson gson = gsonBuilder.create();

		data = gson.fromJson(json,
				MachineMonitoringData.class);

	}


}
