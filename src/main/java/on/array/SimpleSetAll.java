package on.array;

import java.util.Arrays;

class Bob {
    final int id;
    Bob(int n) {
        id = n;
    }

    @Override
    public String toString() {
        return "Bob" + id ;
    }
}

public class SimpleSetAll {
    public static final int SIZE = 8;
    static int val = 1;
    static char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    static char getChar(int n) {return chars[n];}

    public static void main(String[] args) {
        int[] ia = new int[SIZE];
        long[] la = new long[SIZE];
        double[] da = new double[SIZE];
        Arrays.setAll(ia, n -> n);
        Arrays.setAll(la, n -> n);
        Arrays.setAll(da, n -> n);
        System.out.println(Arrays.toString(ia));
        System.out.println(Arrays.toString(la));
        System.out.println(Arrays.toString(da));

        Arrays.setAll(ia, n -> val++);
        Arrays.setAll(la, n -> val++);
        Arrays.setAll(da, n -> val++);
        System.out.println(Arrays.toString(ia));
        System.out.println(Arrays.toString(la));
        System.out.println(Arrays.toString(da));

        Bob[] bobs = new Bob[SIZE];
        Arrays.setAll(bobs, Bob::new);
        System.out.println(Arrays.toString(bobs));

        Character[] ca = new Character[SIZE];
        Arrays.setAll(ca, SimpleSetAll::getChar);
        System.out.println(Arrays.toString(ca));
    }
}
