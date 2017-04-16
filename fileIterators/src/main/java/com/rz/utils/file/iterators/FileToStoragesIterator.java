package com.rz.utils.file.iterators;

import com.google.common.reflect.TypeToken;
import com.rz.utils.file.iterators.storables.ProcessedInputResponse;
import com.rz.utils.file.iterators.storables.StorableEngine;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Roee Zilkha on 4/16/2017.
 */
public  class FileToStoragesIterator<T extends FileIterator> implements Closeable {
    private StorableEngine storableEngine;
    private T fileIterator;

    public FileToStoragesIterator( Class<T> clazz,String path) throws Exception  {
        this.storableEngine = null;
        Constructor<T> fileIteratorCtor = clazz.getConstructor(String.class);
        try {
            fileIterator = fileIteratorCtor.newInstance(path);
        } catch (InvocationTargetException e) {
            throw new Exception(e.getCause());
        }


        this.fileIterator = fileIterator;
    }

    public StorableEngine getStorableEngine() {
        return storableEngine;
    }



    public ProcessedInputResponse next(){
        return null;
    }

    public boolean hasNext(){
        return fileIterator.hasNext();
    }

    public void close() throws IOException {
        fileIterator.close();
        storableEngine.close();
    }

        public static void main(String[] args) throws Exception {

        FileToStoragesIterator<CsvFileIterator> fileIteratorFileToStoragesIterator = new FileToStoragesIterator<CsvFileIterator>(CsvFileIterator.class,"C:\\inputFiles\\try.csv");

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
