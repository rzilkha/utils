package com.rz.utils.file.iterators;

import java.util.Map;

/**
 * Created by Roee Zilkha on 5/13/2017.
 */
public interface RowDataConvertor<T> {
    T convertToData(Map<String,String> rowLine);
}
