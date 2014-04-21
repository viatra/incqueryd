package hu.bme.mit.incqueryd.monitoringserver.core.datacollection;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import hu.bme.mit.incqueryd.monitoringserver.core.deserialization.OSMonitoringDataDeserializer;
import hu.bme.mit.incqueryd.monitoringserver.core.model.OSMonitoringData;

public class MonitoringService {

	public static OSMonitoringData getOSMonitoringData (String host, int port){
		
		URL url = null;
		
		try {
			url = new URL("http://" + host +":"+ port + "/jolokia/read/hu.bme.mit.incqueryd:type=os");
		} catch (MalformedURLException e) {
			return null;
		}
		
		String json = null;
		
		try {
			json = HttpService.getJson(url);
		} catch (IOException e) {
			return null;
		}
		
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.registerTypeAdapter(OSMonitoringData.class, new OSMonitoringDataDeserializer());
		Gson gson = gsonBuilder.create();
		
		return gson.fromJson(json, OSMonitoringData.class);
		
	}
	
}
