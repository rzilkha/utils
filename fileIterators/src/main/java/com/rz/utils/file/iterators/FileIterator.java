package com.rz.utils.file.iterators;

import java.io.Closeable;
import java.util.Iterator;

/**
 * Created by Roee Zilkha on 4/16/2017.
 */
public abstract class FileIterator<T>  implements Iterator<T>,Closeable {
    public String path;

    public FileIterator(String path) {
        this.path = path;
    }

    @Override
    public abstract T next();

    @Override
    public abstract boolean hasNext();

    @Override
    public void close(){

    }
}
