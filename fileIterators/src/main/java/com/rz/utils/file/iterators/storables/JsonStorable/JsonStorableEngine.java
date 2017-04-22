package com.rz.utils.file.iterators.storables.JsonStorable;

import com.rz.utils.file.iterators.FileRecord;
import com.rz.utils.file.iterators.storables.ProcessedInputResponse;
import com.rz.utils.file.iterators.storables.StorableEngine;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Roee Zilkha on 4/22/2017.
 */
public class JsonStorableEngine implements StorableEngine {
    private List<String> jsons = new ArrayList<>();
    private String configureFile;

    @Override
    public boolean open() {
        return true;
    }

    @Override
    public void close() throws IOException {
    }

    @Override
    public ProcessedInputResponse processInputLine(FileRecord fileRecord) {
        return null;
    }

    @Override
    public void rollback(ProcessedInputResponse failedCommitResponse) {
    }
}
