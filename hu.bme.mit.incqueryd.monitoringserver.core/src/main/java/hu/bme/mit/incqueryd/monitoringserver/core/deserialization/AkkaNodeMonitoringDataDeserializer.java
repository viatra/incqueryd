package hu.bme.mit.incqueryd.monitoringserver.core.deserialization;

import hu.bme.mit.incqueryd.monitoringserver.core.model.AkkaNodeMonitoringData;

import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

public class AkkaNodeMonitoringDataDeserializer implements JsonDeserializer<AkkaNodeMonitoringData>{

	@Override
	public AkkaNodeMonitoringData deserialize(JsonElement json, Type typeOfT,
			JsonDeserializationContext context) throws JsonParseException {
		
		JsonObject jsonObject = json.getAsJsonObject();
		
		JsonArray points = jsonObject.getAsJsonArray("points");
		JsonElement data = points.get(0);
		
		GsonBuilder gsonBuilder = new GsonBuilder();
		Gson gson = gsonBuilder.create();
		
		AkkaNodeMonitoringData actorData = gson.fromJson( data.toString(), AkkaNodeMonitoringData.class);
		
		return actorData;
	}
	
}
