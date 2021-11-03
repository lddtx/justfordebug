package on.array;

import java.util.Arrays;

public class FillingArrays {
    public static void main(String[] args) {
        int size = 6;
        String[] strings = new String[size];

        Arrays.fill(strings, "hello");
        System.out.println(Arrays.toString(strings));
        Arrays.fill(strings, 3, 5, "world");
        System.out.println(Arrays.toString(strings));
    }
}
