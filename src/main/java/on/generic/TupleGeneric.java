package on.generic;

public class TupleGeneric {
    public static <A, B> Tuple<A, B> tuple(A a, B b) {
        return new Tuple<>(a, b);
    }
    public static <A, B, C> Tuple2<A, B, C> tuple(A a, B b, C c) {
        return new Tuple2<>(a, b, c);
    }
    public static <A, B, C, D> Tuple3<A, B, C, D> tuple(A a, B b, C c, D d) {
        return new Tuple3<>(a, b, c, d);
    }
}
