package com.rz.utils.file.iterators.jsonUtils;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.Map;

/**
 * Created by Roee Zilkha on 5/20/2017.
 */
public class ConvertedJsonElement {
    private Map<String,JsonObject> mappedColumnToJsonParent;
    private Map<String,JsonElementCreator> jsonElemCreatorByType;
    private JsonElement jsonRoot;

    public ConvertedJsonElement(Map<String, JsonObject> mappedColumnToJsonParent, Map<String, JsonElementCreator> jsonElemCreatorByType) {
        this.mappedColumnToJsonParent = mappedColumnToJsonParent;
        this.jsonElemCreatorByType = jsonElemCreatorByType;
    }

    private void appendPrimitive(CsvParsedColumn csvParsedColumn){
        JsonObject jsonObj = mappedColumnToJsonParent.get(csvParsedColumn.name);
        JsonElementCreator jsonElementCreator = jsonElemCreatorByType.get(csvParsedColumn.type);
        JsonElement jsonElement = jsonElementCreator.createJsonElement(csvParsedColumn);
        jsonObj.add(csvParsedColumn.name, jsonElement);
    }

    public String getJson(){
        return jsonRoot.getAsString();
    }
}
