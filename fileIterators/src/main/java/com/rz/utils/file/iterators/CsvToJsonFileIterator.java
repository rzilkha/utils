package com.rz.utils.file.iterators;

import com.rz.utils.file.iterators.jsonUtils.ConvertedJsonElementBuilder;
import com.rz.utils.file.iterators.jsonUtils.CsvParsedColumn;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Roee Zilkha on 5/20/2017.
 */
public class CsvToJsonFileIterator implements Iterator<String> {

    private  CsvFileIterator csvFileIterator;
    private List<String> headers;

    public CsvToJsonFileIterator(String path) throws IOException {

        CsvFileIterator csvFileIterator = new CsvFileIterator(path);

    }

    @Override
    public boolean hasNext() {
        return csvFileIterator.hasNext();
    }

    @Override
    public String next() {
        List<CsvParsedColumn> csvParsedColumns = csvFileIterator.next();

        ConvertedJsonElementBuilder convertedJsonElementBuilder = null;
        csvParsedColumns.forEach(csvParsedColumn -> convertedJsonElementBuilder.appendParseColumn(csvParsedColumn));

        return convertedJsonElementBuilder.build();
    }
}
