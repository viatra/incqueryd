package hu.bme.mit.incqueryd.monitoringserver.core.datacollection;

import hu.bme.mit.incqueryd.monitoringserver.core.akkahelper.AkkaNodeNames;
import hu.bme.mit.incqueryd.monitoringserver.core.akkahelper.AkkaNodeNamesDeserializer;
import hu.bme.mit.incqueryd.monitoringserver.core.deserialization.AkkaActorsOnNodeDataDeserializer;
import hu.bme.mit.incqueryd.monitoringserver.core.deserialization.AkkaNodeMonitoringDataDeserializer;
import hu.bme.mit.incqueryd.monitoringserver.core.model.AkkaActorsOnNodeData;
import hu.bme.mit.incqueryd.monitoringserver.core.model.AkkaNodeMonitoringData;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class AkkaMonitoringDataCollector {

	private List<String> nodes;
	private String atmosHost;
	private int atmosPort;
	
	public AkkaMonitoringDataCollector(String host, int port){
		nodes = new ArrayList<String>();
		
		atmosHost = host;
		atmosPort = port;
	}
	
	
	private void collectNodes(){
		URL url = null;
		
		try {
			url = new URL("http://" + atmosHost +":"+ atmosPort + "/monitoring/metadata/actorPaths?rolling=1minute");
		} catch (MalformedURLException e) {
			
		}

		String json = null;
		
		try {
			json = HttpService.getJson(url);
		} catch (IOException e) {
			
		}
		
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.registerTypeAdapter(AkkaNodeNames.class, new AkkaNodeNamesDeserializer());
		Gson gson = gsonBuilder.create();
		
		AkkaNodeNames data = gson.fromJson(json, AkkaNodeNames.class);

		nodes.addAll(data.getNodeNames());
		
	}
	
	public List<AkkaNodeMonitoringData> collectNodeData() {
		
		List<AkkaNodeMonitoringData> nodeDataList = new ArrayList<AkkaNodeMonitoringData>();
		
		collectNodes();
		
		for (String node : nodes) {
			URL url = null;
			
			try {
				url = new URL("http://" + atmosHost +":"+ atmosPort + "/monitoring/systemmetrics/timeseries/" + node + "?rolling=1minutes&maxPoints=1");
			} catch (MalformedURLException e) {
				
			}

			String json = null;
			
			try {
				json = HttpService.getJson(url);
			} catch (IOException e) {
				
			}
			
			GsonBuilder gsonBuilder = new GsonBuilder();
			gsonBuilder.registerTypeAdapter(AkkaNodeMonitoringData.class, new AkkaNodeMonitoringDataDeserializer());
			Gson gson = gsonBuilder.create();
			
			AkkaNodeMonitoringData nodeData = gson.fromJson(json, AkkaNodeMonitoringData.class);
			nodeData.setName(node);
			
			URL actorUrl = null;
			
			try {
				actorUrl = new URL("http://" + atmosHost +":"+ atmosPort + "/monitoring/actors?rolling=1minute&node=" + node);
			} catch (MalformedURLException e) {
				
			}

			String actorJson = null;
			
			try {
				actorJson = HttpService.getJson(actorUrl);
			} catch (IOException e) {
				
			}
			
			GsonBuilder actorGsonBuilder = new GsonBuilder();
			actorGsonBuilder.registerTypeAdapter(AkkaActorsOnNodeData.class, new AkkaActorsOnNodeDataDeserializer());
			Gson actorGson = actorGsonBuilder.create();
			
			AkkaActorsOnNodeData actorData = actorGson.fromJson(actorJson, AkkaActorsOnNodeData.class);
			
			actorData.setNode(node);
			
			nodeData.setActorsData(actorData);
			
			nodeDataList.add(nodeData);
			
		}
		
		return nodeDataList;
		
	}
	
}
