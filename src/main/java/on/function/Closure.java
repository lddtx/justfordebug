package on.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class Closure {
    Supplier<List<Integer>> fun() {
        List<Integer> l = new ArrayList<>();
        l.add(1);
        return () -> l;
    }

    public static void main(String[] args) {
        Closure closure = new Closure();
        List<Integer>
                l1 = closure.fun().get(),
                l2 = closure.fun().get();
        System.out.println(l1);
        System.out.println(l2);
        l1.add(42);
        l2.add(96);
        System.out.println(l1);
        System.out.println(l2);
    }
}
