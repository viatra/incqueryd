package hu.bme.mit.incqueryd.monitoringserver.core.deserialization;

import hu.bme.mit.incqueryd.monitoringserver.core.model.NodeMonitoringData;

import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

public class NodeMonitoringDataDeserializer implements JsonDeserializer<NodeMonitoringData>{

	@Override
	public NodeMonitoringData deserialize(JsonElement json, Type typeOfT,
			JsonDeserializationContext context) throws JsonParseException {
		
		JsonObject jsonObject = json.getAsJsonObject();
		
		JsonArray points = jsonObject.getAsJsonArray("points");
		
		JsonElement data = null;
		
		if (points.size() == 0) {
			return null;
		}
		
		if (points.size() == 1) {
			data = points.get(0);
		}
		
		if (points.size() == 2) {
			data = points.get(1);
		}
		
		
		GsonBuilder gsonBuilder = new GsonBuilder();
		Gson gson = gsonBuilder.create();
		
		NodeMonitoringData actorData = gson.fromJson( data.toString(), NodeMonitoringData.class);
		
		return actorData;
	}
	
}
