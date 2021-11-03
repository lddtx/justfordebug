package on.concurrent;

import java.util.Arrays;

public class SummingArrayBoxed {
    static long basicSum(Long[] ia) {
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
        Long[] la =  new Long[SIZE + 1];
        Arrays.parallelSetAll(la, i -> (long)i);
        Summing.timeTest("long array stream reduce", CHECK, () -> Arrays.stream(la).reduce(0L, Long::sum));
        Summing.timeTest("long array stream reduce parallel", CHECK, () -> Arrays.stream(la).parallel().reduce(0L, Long::sum));
        Summing.timeTest("long basic sum", CHECK, () -> basicSum(la));
        Summing.timeTest("long parallel prefix", CHECK, () -> { Arrays.parallelPrefix(la, Long::sum);
            return la[la.length - 1];});
    }
}
