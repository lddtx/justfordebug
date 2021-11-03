package on.stream;

import java.util.Optional;
import java.util.stream.Stream;

public class OptionalBasics {
    static void test(Optional<String> optional) {
        if (optional.isPresent()) {
            System.out.println(optional.get());
        } else {
            System.out.println("Nothing!");
        }
    }

    public static void main(String[] args) {
        test(Stream.of("Element", "ele").findFirst());
        test(Stream.<String>empty().findFirst());
    }
}
