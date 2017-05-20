package com.rz.utils.file.iterators.avro;

import com.bigdatums.avro.BdPerson;
import org.apache.avro.file.DataFileReader;
import org.apache.avro.io.DatumReader;
import org.apache.avro.specific.SpecificDatumReader;

import java.io.File;
import java.io.IOException;

/**
 * Created by Roee Zilkha on 4/17/2017.
 */
public class DeserializeAvro {
    public static void main(String[] args) {
        try {
            DatumReader<BdPerson> bdPersonDatumReader = new SpecificDatumReader(BdPerson.class);
            DataFileReader<BdPerson> dataFileReader = new DataFileReader<BdPerson>(new File("bdperson-test.avro"), bdPersonDatumReader);
            BdPerson p = null;
            while(dataFileReader.hasNext()){
                p = dataFileReader.next(p);
                System.out.println(p);
            }
        } catch(IOException e) {System.out.println("Error reading Avro");}
    }
}
