package on.typeinfo;

public class CountedInteger {
    private static long counter;
    private final long id = counter++;

    @Override
    public String toString() {
        return "CountedInteger{" +
                "id=" + id +
                '}';
    }
}
