package com.rz.utils.file.iterators.storables;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Roee Zilkha on 4/16/2017.
 */
public class HeadersToValueParser {
    private Map<String,Integer> headersToColIndex;
    private List<String> lineValues = new ArrayList<>();
    public String getHeaderValue(String key){
        Integer index = headersToColIndex.get(key);
        if(index==null){
            return null;
        }
        if(index>lineValues.size()){
            return null;
        }

        return lineValues.get(index);
    }
}
