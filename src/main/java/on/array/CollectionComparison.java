package on.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CollectionComparison {
    public static void main(String[] args) {
        Sphere[] spheres = new Sphere[10];
        for (int i = 0; i < 5; i++) {
            spheres[i] = new Sphere();
        }
        System.out.println(Arrays.toString(spheres));
        System.out.println(spheres[4]);

        int[] integers = {0, 1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(integers));
        System.out.println(integers[4]);

        List<Integer> integerList = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5));
        integerList.add(97);
        System.out.println(integerList);
        System.out.println(integerList.get(4));
    }
}
