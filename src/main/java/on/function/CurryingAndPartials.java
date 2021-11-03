package on.function;

import java.util.function.Function;

public class CurryingAndPartials {
    public static void main(String[] args) {
        // Curried function:
        Function<String, Function<String, String>> sum =
                a -> b -> a + b; // [1]

        Function<String, String>
                hi = sum.apply("Hi "); // [2]
        System.out.println(hi.apply("Ho"));

        // Partial application:
        Function<String, String> sumHi =
                sum.apply("Hup ");
        System.out.println(sumHi.apply("Ho"));
        System.out.println(sumHi.apply("Hey"));
    }
}
/* Output:
Hi Ho
Hup Ho
Hup Hey
*/