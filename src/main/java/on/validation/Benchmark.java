package on.validation;

import on.common.Timer;
import java.util.Arrays;

public class Benchmark {
    static final int SIZE = 250_000_000;
    public static void main(String[] args) {
        long[] la = new long[SIZE];
        System.out.println("setAll: " + Timer.duration(() -> Arrays.setAll(la, n->n)));
        System.out.println("parallelSetAll: " + Timer.duration(() -> Arrays.parallelSetAll(la, n->n)));
    }
}
