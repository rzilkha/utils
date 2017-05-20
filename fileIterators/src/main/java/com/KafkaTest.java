package com;



import akka.Done;
import akka.actor.ActorSystem;
import akka.kafka.*;
import akka.kafka.javadsl.Consumer;
import akka.kafka.javadsl.Producer;
import akka.stream.ActorMaterializer;
import akka.stream.Materializer;
import akka.stream.javadsl.FileIO;
import akka.stream.javadsl.Framing;
import akka.stream.javadsl.Sink;
import akka.stream.javadsl.Source;
import akka.util.ByteString;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Roee Zilkha on 5/13/2017.
 */
public class KafkaTest {

    static class DB {
        private final AtomicLong offset = new AtomicLong();

        public CompletionStage<Done> save(ConsumerRecord<byte[], String> record) {
            System.out.println("DB.save: " + record.value());
            offset.set(record.offset());
            return CompletableFuture.completedFuture(Done.getInstance());
        }

        public CompletionStage<Long> loadOffset() {
            return CompletableFuture.completedFuture(offset.get());
        }

        public CompletionStage<Done> update(String data) throws Exception {
            System.out.println("DB.update: " + data);
            throw new Exception("adasdsa");
//            return CompletableFuture.completedFuture(Done.getInstance());
        }
    }


    public static void main(String[] args) {

        final ActorSystem system = ActorSystem.create("QuickStart");
        final Materializer materializer = ActorMaterializer.create(system);
        final ProducerSettings<String, String> producerSettings = ProducerSettings
                .create(system, new StringSerializer(), new StringSerializer())
                .withBootstrapServers("10.0.0.8:9092");

        List<Integer> ab = Arrays.asList(1, 2, 3);


        File file = new File("C:\\utilsEntities\\utils\\fileIterators\\src\\main\\resources\\test.csv");

//
//        CompletionStage<Done> done =   Source.from(FileIO.fromFile(file)
//                .via(Framing.delimiter(ByteString.fromString("\n"), 256).map(x -> x.toString()))
//                .runForeach(x -> System.out.println(x)))
//                .map(n -> n.toString()).map(elem -> new ProducerRecord<String, String>("topic12", elem))
//                .runWith(Producer.plainSink(producerSettings), materializer);
//


//
//         final ConsumerSettings<String, String> consumerSettings =
//                ConsumerSettings.create(system, new StringDeserializer(), new StringDeserializer())
//                        .withBootstrapServers("10.0.0.8:9092")
//                        .withGroupId("group1")
//                        .withProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
////
////        Consumer.committableSource(consumerSettings, Subscriptions.topics("topic1"))
////                .map(msg ->
////                        new ProducerMessage.Message<String, String, ConsumerMessage.Committable>(
////                                new ProducerRecord<>("topic2", msg.record().value()), msg.committableOffset()))
////                .runWith(Producer.commitableSink(producerSettings), materializer);
//
//        final DB db = new DB();
//
//        Consumer.committableSource(consumerSettings, Subscriptions.topics("topic1"))
//                .mapAsync(1, msg -> db.update(msg.record().value())
//                        .thenApply(done -> msg))
//                .mapAsync(1, msg -> msg.committableOffset().commitJavadsl())
//                .runWith(Sink.ignore(), materializer);

    }
}
