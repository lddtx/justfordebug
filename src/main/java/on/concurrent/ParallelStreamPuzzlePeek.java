package on.concurrent;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ParallelStreamPuzzlePeek {
    public static void main(String[] args) {
        List<Integer> x = IntStream.range(0, 30)
                .peek(e -> System.out.println(e + ": " + Thread.currentThread().getName()))
                .limit(10)
                .parallel()
                .boxed()
                .collect(Collectors.toList());
        System.out.println(x);
    }
}
