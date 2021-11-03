package on.function;

import java.util.Locale;
import java.util.function.Function;

public class FunctionComposition {
    static Function<String, String>
            f1 = s-> {
                System.out.println("f1");
                return s.replace('A', '_');
            },
            f2 = s -> {
                System.out.println("f2");
                return s.substring(3);
            },
            f3 = s -> {
                System.out.println("f3");
                return s.toLowerCase(Locale.ROOT);
            },
            f4 = f1.compose(f2).andThen(f3);

    public static void main(String[] args) {
        System.out.println(f4.apply("After All"));
    }
}
