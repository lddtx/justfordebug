package on.function;

import java.util.function.IntToLongFunction;
import java.util.function.LongFunction;
import java.util.function.ToLongFunction;

class LBaz {
    long l;

    LBaz(long l) {
        this.l = l;
    }
}

public class FunctionInterface {
    static IntToLongFunction x = i -> i;
    static ToLongFunction<LBaz> y = lb -> lb.l;

    static LongFunction<LBaz> lf = LBaz::new;

    public static void main(String[] args) {
        long l = x.applyAsLong(1);
        System.out.println(l);

        long l2 = y.applyAsLong(lf.apply(2));
        System.out.println(l2);
    }
}
