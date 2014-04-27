package hu.bme.mit.incqueryd.monitoringserver.core.deserialization;

import java.lang.reflect.Type;

import hu.bme.mit.incqueryd.monitoringserver.core.model.AkkaActorMonitoringData;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

public class AkkaActorMonitoringDataDeserializer implements JsonDeserializer<AkkaActorMonitoringData> {

	@Override
	public AkkaActorMonitoringData deserialize(JsonElement json, Type typeOfT,
			JsonDeserializationContext context) throws JsonParseException {


		JsonObject jsonObject = json.getAsJsonObject();
		
		GsonBuilder gsonBuilder = new GsonBuilder();
		Gson gson = gsonBuilder.create();
		
		AkkaActorMonitoringData actorData = gson.fromJson( jsonObject.toString(), AkkaActorMonitoringData.class);
		
		return actorData;
	}

}
