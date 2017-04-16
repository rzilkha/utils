package com.rz.utils.file.iterators.storables;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by Roee Zilkha on 4/16/2017.
 */
public interface StorableEngine extends Closeable {
    boolean open();

    @Override
    void close() throws IOException;

    void processInputLine(HeadersToValueParser headersToValueParser);

    void rollback(ProcessedInputResponse failedCommitResponse);
}
