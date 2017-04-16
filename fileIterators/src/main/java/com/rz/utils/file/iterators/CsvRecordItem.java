package com.rz.utils.file.iterators;

import org.apache.commons.csv.CSVRecord;

/**
 * Created by Roee Zilkha on 4/16/2017.
 */
public class CsvRecordItem implements FileRecord {

    private CSVRecord csvRecord;

    public CsvRecordItem(CSVRecord csvRecord) {
        this.csvRecord = csvRecord;
    }

    @Override
    public String getRecordValue(String key) {
        return csvRecord.get(key);
    }
}
