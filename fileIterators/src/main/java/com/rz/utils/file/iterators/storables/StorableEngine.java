package com.rz.utils.file.iterators.storables;

import com.rz.utils.file.iterators.FileRecord;

import java.io.Closeable;
import java.io.IOException;

/**
 * Created by Roee Zilkha on 4/16/2017.
 */
public interface StorableEngine extends Closeable {
    boolean open();

    @Override
    void close() throws IOException;

    ProcessedInputResponse processInputLine(FileRecord fileRecord);

    void rollback(ProcessedInputResponse failedCommitResponse);
}
