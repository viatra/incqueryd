package hu.bme.mit.incqueryd.monitoringserver.core.deserialization;

import hu.bme.mit.incqueryd.monitoringserver.core.model.AkkaActorMonitoringData;
import hu.bme.mit.incqueryd.monitoringserver.core.model.AkkaActorsOnNodeData;

import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

public class AkkaActorsOnNodeDataDeserializer implements JsonDeserializer<AkkaActorsOnNodeData> {

	@Override
	public AkkaActorsOnNodeData deserialize(JsonElement json, Type typeOfT,
			JsonDeserializationContext context) throws JsonParseException {
		
		JsonObject jsonObject = json.getAsJsonObject();
		JsonArray actorPaths = jsonObject.getAsJsonArray("actors");
		
		AkkaActorsOnNodeData actors = new AkkaActorsOnNodeData();
		
		for (JsonElement jsonElement : actorPaths) {
			GsonBuilder gsonBuilder = new GsonBuilder();
			gsonBuilder.registerTypeAdapter(AkkaActorMonitoringData.class, new AkkaActorMonitoringDataDeserializer());
			Gson gson = gsonBuilder.create();
			AkkaActorMonitoringData nodeData = gson.fromJson(jsonElement.toString(), AkkaActorMonitoringData.class);
			actors.addActor(nodeData);
		}
		
		return actors;
	}

}
