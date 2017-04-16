package com.rz.utils.file.iterators;

import java.io.Closeable;

/**
 * Created by Roee Zilkha on 4/16/2017.
 */
public abstract class FileIterator  implements Closeable {
    public String path;

    public FileIterator(String path) {
        this.path = path;
    }

    abstract FileRecord next();

    abstract boolean hasNext();
    @Override
    public void close(){

    }
}
