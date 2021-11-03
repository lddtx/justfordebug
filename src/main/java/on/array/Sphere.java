package on.array;

public class Sphere {
    private static int count;
    private final int id = count++;

    @Override
    public String toString() {
        return "Sphere{" +
                "id=" + id +
                '}';
    }
}