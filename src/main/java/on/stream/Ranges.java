package on.stream;

import java.util.stream.IntStream;

public class Ranges {
    public static void main(String[] args) {
        int result = 0;
        for (int i : IntStream.range(10, 20).toArray()) {
            result += i;
        }
        System.out.println(result);
        System.out.println(IntStream.range(10, 20).sum());
    }
}
