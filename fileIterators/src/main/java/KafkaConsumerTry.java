import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.util.Arrays;
import java.util.Properties;

/**
 * Created by Roee Zilkha on 4/23/2017.
 */
public class KafkaConsumerTry {
    private KafkaConsumer<String,String> kafkaConsumer;
    private Properties properties = new Properties();

    private KafkaConsumerTry(){
        Properties props = new Properties();
        props.put("bootstrap.servers", "10.0.0.8:9092");
        props.put("group.id", "consumer-tutorial");
        props.put("key.deserializer", StringDeserializer.class.getName());
        props.put("value.deserializer", StringDeserializer.class.getName());
        props.put("auto.offset.reset", "earliest");
        kafkaConsumer = new KafkaConsumer<>(props);
    }

    public void run(){
        try {
            kafkaConsumer.subscribe(Arrays.asList("testConsole2"));
            while (true) {
                ConsumerRecords<String, String> records = kafkaConsumer.poll(1);
                for (ConsumerRecord<String, String> record : records)
                    System.out.println(record.offset() + ": " + record.value());
            }
        } finally {
            kafkaConsumer.close();
        }
    }

    public static void main(String[] args) {
        KafkaConsumerTry kafkaConsumerTry = new KafkaConsumerTry();
        kafkaConsumerTry.run();
    }
}
