package com.learn.playground.gson.typeadapter;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

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
            JsonArray jsonArray =
                    json.getAsJsonObject().getAsJsonObject("first")
                            .getAsJsonObject("second")
                            .getAsJsonObject("third")
                            .getAsJsonObject("fourth")
                            .getAsJsonArray("list");
            return new Gson().fromJson(jsonArray, typeOfT);
        }
    }

}
