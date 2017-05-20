import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Created by Roee Zilkha on 4/11/2017.
 */
public class KafkaProducerTry {
    private Properties kafkaProps = new Properties();
    private Producer<String,String> kafkaProducer;
    public KafkaProducerTry(){
        kafkaProps.put("bootstrap.servers", "10.0.0.8:9092");
        kafkaProps.put("metadata.broker.list", "10.0.0.8:9092");
        kafkaProps.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        kafkaProps.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        kafkaProducer = new KafkaProducer<String, String>(kafkaProps);
    }

    public void fire(String value){
        ProducerRecord<String,String> record = new ProducerRecord<String, String>("topic1","hello man");
        kafkaProducer.send(record);
    }

    public void syncSend(String value) throws ExecutionException, InterruptedException {
        ProducerRecord<String,String> record = new ProducerRecord<String, String>("topic1",value);
        Future<RecordMetadata> futureResponse = kafkaProducer.send(record);
        RecordMetadata response = futureResponse.get();
        System.out.println("offset is" + response.offset());
    }

    public void sendWithCallback(String value){
        ProducerRecord<String,String> record = new ProducerRecord<String, String>("tes222t123",value);
        kafkaProducer.send(record,(recordMetadata,e) -> {
            System.out.println((e == null) ? "success" : e);});

    }

}
