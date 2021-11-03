package on.enums;

enum SpicinessEnum{NOT, MILD, MEDIUM, HOT, FLAMING}
public class Burrito {
    SpicinessEnum degree;
    public Burrito(SpicinessEnum degree) {
        this.degree = degree;
    }

    @Override
    public String toString() {
        return "Burrito{" +
                "degree=" + degree +
                '}';
    }

    public static void main(String[] args) {
        System.out.println(new Burrito(SpicinessEnum.NOT));
        System.out.println(new Burrito(SpicinessEnum.MEDIUM));
        System.out.println(new Burrito(SpicinessEnum.HOT));
    }
}
