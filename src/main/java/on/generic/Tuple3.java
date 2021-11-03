package on.generic;

public class Tuple3<A, B, C, D> extends Tuple2<A, B, C>{
    public final D d;
    public Tuple3(A a, B b, C c, D d) {
        super(a, b, c);
        this.d = d;
    }

    @Override
    public String rep() {
        return super.rep() + ", " + d;
    }
}
