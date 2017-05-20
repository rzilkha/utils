package com.rz.utils.file.iterators;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

/**
 * Created by Roee Zilkha on 4/16/2017.
 */
public class CsvFileIterator<T> implements Iterator<T> {

    private final Iterator<CSVRecord> csvIterator;
    private CSVParser parser;
    private RowDataConvertor<T> rowDataConvertor;
    public CsvFileIterator(String path) throws IOException {

        parser = new CSVParser(
                new FileReader(path),
                CSVFormat.MYSQL.withHeader());
        csvIterator = parser.iterator();

    }

    @Override
    public T next() {
        CSVRecord record = csvIterator.next();

        return  new CsvRecordItem(record);
    }

    @Override
    boolean hasNext() {
        return csvIterator.hasNext();
    }

    @Override
    public void close(){
        try {
            parser.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
