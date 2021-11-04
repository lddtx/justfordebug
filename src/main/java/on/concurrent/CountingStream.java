package on.concurrent;

import java.util.stream.IntStream;

public class CountingStream {
    public static void main(String[] args) {
        System.out.println("sum = " +
                IntStream.range(0, 10)
                        .parallel()
                        .mapToObj(CountingTask::new)
                        .map(ct -> ct.call()).reduce(0, Integer::sum)
        );
    }
}
