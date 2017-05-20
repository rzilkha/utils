package com.rz.utils.file.iterators.jsonUtils;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.Map;

/**
 * Created by Roee Zilkha on 5/20/2017.
 */
public class ConvertedJsonElementBuilder {
    private Map<String,JsonObject> mappedColumnToJsonParent;
    private Map<String,JsonElementCreator> jsonElemCreatorByType;
    private JsonElement jsonRoot;

    public ConvertedJsonElementBuilder(Map<String, JsonObject> mappedColumnToJsonParent, Map<String, JsonElementCreator> jsonElemCreatorByType) {
        this.mappedColumnToJsonParent = mappedColumnToJsonParent;
        this.jsonElemCreatorByType = jsonElemCreatorByType;
    }


    public void appendParseColumn(CsvParsedColumn csvParsedColumn){
        JsonObject jsonObj = mappedColumnToJsonParent.get(csvParsedColumn.name);
        JsonElementCreator jsonElementCreator = jsonElemCreatorByType.get(csvParsedColumn.type);
        JsonElement jsonElement = jsonElementCreator.createJsonElement(csvParsedColumn);
        jsonObj.add(csvParsedColumn.name, jsonElement);
    }

    public String build(){
        return jsonRoot.getAsString();
    }
}
