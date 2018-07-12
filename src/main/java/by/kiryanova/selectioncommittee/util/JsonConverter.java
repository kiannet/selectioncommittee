package by.kiryanova.selectioncommittee.util;

import by.kiryanova.selectioncommittee.entity.Specialty;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.util.List;

public class JsonConverter {

    private final Gson gson;

    public JsonConverter() {

        gson = new GsonBuilder().create();
    }

    public String convertToJson(List<String> specialties) {

        JsonArray jarray = gson.toJsonTree(specialties).getAsJsonArray();
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("specialties", jarray);
        return jsonObject.toString();
    }
}
