package on.stream;

import static on.common.Repeat.*;

public class Looping {
    static void hi() {
        System.out.println("Hi!");
    }

    public static void main(String[] args) {
        repeat(3, () -> System.out.println("Looping"));
        repeat(2, Looping::hi);
    }
}
