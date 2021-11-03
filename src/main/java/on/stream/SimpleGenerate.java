package on.stream;

import java.util.stream.Stream;

public class SimpleGenerate {
    public static void main(String[] args) {
        Stream.generate(() -> "duplicate")
                .limit(3)
                .forEach(System.out::println);
    }
}
