package com.rz.utils.file.iterators.jsonUtils;

import com.google.gson.Gson;

/**
 * Created by Roee Zilkha on 5/19/2017.
 */
public class JsonInitializedJsonFactory {

    private Gson gson = new Gson();

    private ConvertedJsonElementBuilder getEmptyJsonConvertedElem(){
        return null;
    }
//    private Map<String,JsonElement> init(String json){
//
//    }
}
