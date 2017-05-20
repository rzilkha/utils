package com.rz.utils.file.iterators.jsonUtils;

import org.omg.CORBA.Object;

import java.util.List;
import java.util.Map;

/**
 * Created by Roee Zilkha on 5/19/2017.
 */
public class CsvParsedColumn {
    public Map<String,Object> mapValues;
    public List<String> listValues;
    public String type;
    public String name;

    @Override
    public int hashCode(){
        return name.hashCode();
    }
}
