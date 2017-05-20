package com.rz.utils.file.iterators;

/**
 * Created by Roee Zilkha on 4/16/2017.
 */
public interface FileRecord<T> {
    T getRecordValue(String key);
}
