package com.learn.playground.gson.typeadapter;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.*;

public class NestedJson {
    private static final String NESTED_JSON = "{\"first\":{\"second\":{\"third\":{\"fourth\":{\"list\":[\"cat\",\"dog\",\"bird\"]}}}}}";

    private static Type sType = new TypeToken<List<String>>(){}.getType();

    public List<String> parseByJsonDeserializer(){
        GsonBuilder gsonBuilder = new GsonBuilder().registerTypeAdapter(sType, new NestedJsonDeserializer());
        return gsonBuilder.create().fromJson(NESTED_JSON, sType);
    }

    private static class NestedJsonDeserializer implements JsonDeserializer<List<String>>{
        @Override
        public List<String> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            JsonArray jsonArray = parseNested(json, "list", Arrays.asList("first", "second", "third", "fourth"));
            return new Gson().fromJson(jsonArray, typeOfT);
        }

        private JsonArray parseNested(JsonElement jsonElement, String target, List<String> paths){
            JsonArray result = null;
            if(jsonElement.isJsonObject()){
                JsonObject jsonObject = jsonElement.getAsJsonObject();
                for(String key : paths){
                    JsonElement pathJsonElement = jsonObject.get(key);
                    if(pathJsonElement != null && pathJsonElement.isJsonObject()){
                        jsonObject = pathJsonElement.getAsJsonObject();
                    } else {
                        break;
                    }
                }
                JsonElement resultJsonElement = jsonObject.get(target);
                if(resultJsonElement != null && resultJsonElement.isJsonArray()){
                    result = resultJsonElement.getAsJsonArray();
                }
            }
            return result;
        }
    }

}
