package com.rz.utils.file.iterators.jsonUtils;

import com.google.gson.JsonElement;

import java.util.List;
import java.util.Map;

/**
 * Created by Roee Zilkha on 5/19/2017.
 */
public interface CsvValueParser {
   CsvParsedColumn parsedValues(String columnValue);
   JsonElement json = null;


}
