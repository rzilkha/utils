package com.rz.utils.file.iterators.jsonUtils;

import com.google.gson.JsonElement;

import java.util.List;

/**
 * Created by Roee Zilkha on 5/19/2017.
 */
public class ColumnMapping {
    private String jsonType;
    private CsvValueParser csvValueParser;

    public void appendColumnValues(JsonElement jsonElement, String columnValue){
        CsvParsedColumn parsedColumn = csvValueParser.parsedValues(columnValue);

    }


}
