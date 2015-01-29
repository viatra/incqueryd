/*******************************************************************************
 * Copyright (c) 2010-2014, Gabor Szarnyas, Istvan Rath and Daniel Varro
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Gabor Szarnyas - initial API and implementation
 *******************************************************************************/

package hu.bme.mit.incqueryd.engine.test.util;

import hu.bme.mit.incqueryd.engine.rete.dataunits.Tuple;

import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;

public class TupleDeserializer implements JsonDeserializer<Tuple> {

	@Override
	public Tuple deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
			throws JsonParseException {		
		
		JsonObject jsonObject = json.getAsJsonObject();
		JsonArray array = jsonObject.getAsJsonArray("tuple");
			
		ArrayList<Object> list = new ArrayList<Object>();
		
		for (Object object : array) {		
			// checking if the object is a primitive
			if (object instanceof JsonPrimitive) {
				JsonPrimitive primitive = (JsonPrimitive) object;
				
				// if it is a number, get it as a long
				if (primitive.isNumber()) {
					long i = primitive.getAsLong();
					list.add(i);
				}
			}
		}			
		
		Tuple tuple = new Tuple(list.toArray());
		return tuple;
	}
   
}
