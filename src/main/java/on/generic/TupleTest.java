package on.generic;

public class TupleTest {
    static Tuple<String, Integer> f() {
        return new Tuple<>("hi", 47);
    }

    static Tuple2<Double, String, Integer> g() {
        return new Tuple2<>(1.1, "hi", 47);
    }

    static Tuple3<Long, Double, String, Integer> h() {
        return new Tuple3<>(3l,5.4, "hi", 47);
    }
}
