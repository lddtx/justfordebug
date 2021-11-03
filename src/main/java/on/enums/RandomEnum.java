package on.enums;

import java.util.Random;

public class RandomEnum {
    private static Random rand = new Random(47);

    public static <T extends Enum<T>> T random(Class<T> c) {
        return random(c.getEnumConstants());
    }

    public static <T> T random(T[] values) {
        return values[rand.nextInt(values.length)];
    }
}
