package com.rz.utils.file.iterators.storables;

import java.util.Map;

/**
 * Created by Roee Zilkha on 4/16/2017.
 */
public class ProcessedInputResponse {
    public boolean isSuccess;
    public String commitStorageIndex;
    public Map<String,String> storageStateMetadata;
    public ProcessedInputErrorResponse error;
}
