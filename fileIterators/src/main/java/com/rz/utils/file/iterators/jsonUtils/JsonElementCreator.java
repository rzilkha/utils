package com.rz.utils.file.iterators.jsonUtils;

import com.google.gson.JsonElement;

/**
 * Created by Roee Zilkha on 5/20/2017.
 */
public interface JsonElementCreator {
    JsonElement createJsonElement(CsvParsedColumn csvParsedColumn);
}
