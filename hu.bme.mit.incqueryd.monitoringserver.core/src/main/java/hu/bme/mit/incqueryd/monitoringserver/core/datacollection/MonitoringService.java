package hu.bme.mit.incqueryd.monitoringserver.core.datacollection;

import hu.bme.mit.incqueryd.monitoringserver.core.deserialization.MachineMonitoringDataDeserializer;
import hu.bme.mit.incqueryd.monitoringserver.core.model.MachineMonitoringData;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MonitoringService {

	public static MachineMonitoringData getMachineMonitoringData (String host, int port){
		
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
		gsonBuilder.registerTypeAdapter(MachineMonitoringData.class, new MachineMonitoringDataDeserializer());
		Gson gson = gsonBuilder.create();
		
		MachineMonitoringData data = gson.fromJson(json, MachineMonitoringData.class);
		
		return data;
		
	}
	
}
