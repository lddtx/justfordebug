package on.stream;

import java.util.stream.Stream;

public class Flatmap {
    public static void main(String[] args) {
        Stream.of(1, 2, 3)
                .map(i -> Stream.of("1", "2", "3"))
                .map(e -> e.getClass().getName())
                .forEach(System.out::println);


        Stream.of(1, 2, 3)
                .flatMap(i -> Stream.of("1", "2", "3"))
                .forEach(System.out::println);
    }
}
