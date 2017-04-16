package com.rz.utils.file.iterators;

import com.rz.utils.file.iterators.storables.ProcessedInputResponse;
import com.rz.utils.file.iterators.storables.StorableEngine;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
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

    public static void main(String[] args) throws IOException {
        Reader in = new FileReader("C:\\\\inputFiles\\\\try.csv");
        Iterable<CSVRecord> records = CSVFormat.MYSQL.parse(in);

        System.out.println(records.iterator().next().get(0));
        in.close();
//        CSVParser parser = new CSVParser(
//                new FileReader("C:\\inputFiles\\try.csv"),
//                CSVFormat.MYSQL.withHeader());
//        for (CSVRecord record : parser) {
//            System.out.printf("%st%sn",
//                    record.get("COL1"),
//                    record.get("COL2"));
//        }
//        parser.close();
    }
}
