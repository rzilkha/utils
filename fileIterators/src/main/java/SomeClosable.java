/**
 * Created by Roee Zilkha on 4/4/2017.
 */
public class SomeClosable implements AutoCloseable {
    @Override
    public void close() throws Exception {
        System.out.println("i am closing it dude");
    }
}
