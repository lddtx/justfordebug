package interview;

public class A {
    int add(int a, int b) {
        return a + b;
    }
}
class B extends A {
    int add(int a, int b) {
        return a + b;
    }
}

class Test {
    public static void main(String[] args) {
        System.out.println(new B().add(1, 2));
    }
}