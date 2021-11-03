package on.typeinfo;

class Building {}
class House extends Building {}

public class ClassCast {
    public static void main(String[] args) {
        Building b = new House();
        Class<House> houseClass = House.class;
        House h = houseClass.cast(b);

        // or
        h = (House) b;
    }
}
