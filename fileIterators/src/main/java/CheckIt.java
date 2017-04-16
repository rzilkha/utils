import java.util.Arrays;

/**
 * Created by Roee Zilkha on 4/4/2017.
 */
public class CheckIt {
    public static void main(String[] args) throws Exception {

        try( SomeClosable closable = new SomeClosable()){

        }

        Arrays.asList(1).stream().forEach(num -> System.out.println(num));

        KafkaProducerTry kafkaProducerTry = new KafkaProducerTry();
        kafkaProducerTry.sendWithCallback("hello");
        Thread.sleep(100000);

    }
}
