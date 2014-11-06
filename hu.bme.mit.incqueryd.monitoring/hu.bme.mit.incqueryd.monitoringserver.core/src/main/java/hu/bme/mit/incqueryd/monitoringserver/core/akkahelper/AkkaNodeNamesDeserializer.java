package hu.bme.mit.incqueryd.monitoringserver.core.akkahelper;

import java.lang.reflect.Type;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

public class AkkaNodeNamesDeserializer implements JsonDeserializer<AkkaNodeNames>{

	@Override
	public AkkaNodeNames deserialize(JsonElement json, Type typeOfT,
			JsonDeserializationContext context) throws JsonParseException {
		
		JsonObject jsonObject = json.getAsJsonObject();
		JsonObject actorPaths = jsonObject.getAsJsonObject("actorPaths");
		JsonArray nodes = actorPaths.getAsJsonArray("nodes");
		
		AkkaNodeNames names = new AkkaNodeNames();
		
		for (JsonElement jsonElement : nodes) {
			names.add(jsonElement.getAsJsonObject().getAsJsonPrimitive("node").getAsString());
		}
		
		return names;
	}

}
