package com.rz.utils.file.iterators.avro;

import com.bigdatums.avro.BdPerson;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.specific.SpecificDatumWriter;

import java.io.File;
import java.io.IOException;

/**
 * Created by Roee Zilkha on 4/17/2017.
 */
public class SerializeAvro {

    public static void main(String[] args) {
        BdPerson p1 = new BdPerson();
        p1.setId(1);
        p1.setUsername("mrscarter");
        p1.setFirstName("Beyonce");
        p1.setLastName("Knowles-Carter");
        p1.setBirthdate("1981-09-04");
        p1.setJoinDate("2016-01-01");
        p1.setPreviousLogins(10000);

        BdPerson p2 = new BdPerson();
        p2.setId(2);
        p2.setUsername("jayz");
        p2.setFirstName("Shawn");
        p2.setMiddleName("Corey");
        p2.setLastName("Carter");
        p2.setBirthdate("1969-12-04");
        p2.setJoinDate("2016-01-01");
        p2.setPreviousLogins(20000);

        File avroOutput = new File("bdperson-test.avro");
        try {
            DatumWriter<BdPerson> bdPersonDatumWriter = new SpecificDatumWriter<BdPerson>(BdPerson.class);
            DataFileWriter<BdPerson> dataFileWriter = new DataFileWriter<BdPerson>(bdPersonDatumWriter);
            dataFileWriter.create(p1.getSchema(), avroOutput);
            dataFileWriter.append(p1);
            dataFileWriter.append(p2);
            dataFileWriter.close();
        } catch (IOException e) {System.out.println("Error writing Avro");}
    }
}
