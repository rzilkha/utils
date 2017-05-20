package com.rz.utils.file.iterators.jsonUtils;

import com.google.gson.Gson;
import com.google.gson.JsonElement;

import java.util.Map;

/**
 * Created by Roee Zilkha on 5/19/2017.
 */
public class JsonInitializedJsonFactory {

    private Gson gson = new Gson();

    private ConvertedJsonElement getEmptyJsonConvertedElem(){
        return null;
    }
//    private Map<String,JsonElement> init(String json){
//
//    }
}
