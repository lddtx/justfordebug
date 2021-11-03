package on.concurrent;

import java.util.Arrays;

public class SummingArray {
    static long basicSum(long[] ia) {
        long sum = 0;
        for (int i = 0; i < ia.length; i++) {
            sum += ia[i];
        }
        return sum;
    }

    public static final int SIZE = 20_000_000;
    public static final long CHECK = (long)SIZE * ((long)SIZE + 1)/2;

    public static void main(String[] args) {
        System.out.println(CHECK);
        long[] la =  new long[SIZE + 1];
        Arrays.parallelSetAll(la, i -> i);
        Summing.timeTest("array stream sum", CHECK, () -> Arrays.stream(la).sum());
        Summing.timeTest("array stream sum parallel", CHECK, () -> Arrays.stream(la).parallel().sum());
        Summing.timeTest("basic sum", CHECK, () -> basicSum(la));
        Summing.timeTest("parallel prefix", CHECK, () -> { Arrays.parallelPrefix(la, Long::sum);
            return la[la.length - 1];});
    }
}
