package on.concurrent;

import on.common.Timer;
import java.util.function.LongSupplier;
import static java.util.stream.LongStream.*;

public class Summing {
    public static final int SIZE = 100_000_000;
    // 高斯求和
    public static final long CHECK = (long)SIZE * ((long)SIZE + 1)/2;

    static void timeTest(String id, long checkValue, LongSupplier operation) {
        System.out.print(id + ": ");
        Timer timer = new Timer();
        long result = operation.getAsLong();
        if (result == checkValue) {
            System.out.println(timer.duration() + "ms");
        } else {
            System.out.format("result: %d%n checkValue: %d%n", result, checkValue);
        }
    }

    public static void main(String[] args) {
        System.out.println(CHECK);
        timeTest("sum stream", CHECK, () -> rangeClosed(0, SIZE).sum());
        timeTest("sum stream parallel", CHECK, () -> rangeClosed(0, SIZE).parallel().sum());
        timeTest("sum iterator", CHECK, () -> iterate(0, i -> i + 1).limit(SIZE + 1).sum());
        // Slower & runs out of memory above 1_000_000:
        // timeTest("Sum Iterated Parallel", CHECK, () ->
        //   LongStream.iterate(0, i -> i + 1)
        //     .parallel()
        //     .limit(SZ+1).sum());
    }
}
