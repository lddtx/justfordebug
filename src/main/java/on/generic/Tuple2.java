package on.generic;

public class Tuple2<A, B, C> extends Tuple<A, B>{
    public final C c;
    public Tuple2(A a, B b, C c) {
        super(a, b);
        this.c = c;
    }

    @Override
    public String rep() {
        return super.rep() + ", " + c;
    }
}
