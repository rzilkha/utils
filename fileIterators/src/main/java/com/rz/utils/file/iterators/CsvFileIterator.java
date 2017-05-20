package com.rz.utils.file.iterators;

import com.rz.utils.file.iterators.jsonUtils.ColumnMapping;
import com.rz.utils.file.iterators.jsonUtils.CsvParsedColumn;
import com.rz.utils.file.iterators.jsonUtils.CsvValueParser;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Roee Zilkha on 4/16/2017.
 */
public class CsvFileIterator implements Iterator<List<CsvParsedColumn>> {

    private final Iterator<CSVRecord> csvIterator;
    private CSVParser parser;

    private Map<String,CsvValueParser> csvHeaderValuesParsers;
    private List<String> headers;
    public CsvFileIterator(String path) throws IOException {

        parser = new CSVParser(
                new FileReader(path),
                CSVFormat.MYSQL.withHeader());
        csvIterator = parser.iterator();

    }

    @Override
    public List<CsvParsedColumn> next() {
        CSVRecord record = csvIterator.next();
        return headers.stream().map(header -> {
            CsvValueParser csvValueParser = csvHeaderValuesParsers.get(header);
            String columnValue = record.get(header);
            return csvValueParser.parsedValues(columnValue);
        }).collect(Collectors.toList());
    }

    @Override
    public boolean hasNext() {
        return csvIterator.hasNext();
    }

    public void close(){
        try {
            parser.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
