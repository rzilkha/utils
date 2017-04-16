package com.rz.utils.file.iterators;

import com.rz.utils.file.iterators.storables.ProcessedInputResponse;
import com.rz.utils.file.iterators.storables.StorableEngine;
import org.apache.commons.csv.CSVFormat;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Roee Zilkha on 4/16/2017.
 */
public abstract class FileToStoragesIterator implements Closeable {
    private StorableEngine storableEngine;
    private String filePath;

    public FileToStoragesIterator(StorableEngine storableEngine, String filePath) {
        this.storableEngine = storableEngine;
        this.filePath = filePath;


//        CSVFormat.EXCEL.parse(new BufferedReader(new BufferedInputStream("dasda")));
    }

    public StorableEngine getStorableEngine() {
        return storableEngine;
    }

    public String getFilePath() {
        return filePath;
    }

    public ProcessedInputResponse next(){
        return null;
    }

    public void close() throws IOException {
        storableEngine.close();
    }
}
