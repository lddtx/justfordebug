package on.function;

import java.util.function.Function;

interface MyInterface {
    String output(String arg);
}

public class MyFunction {
    public String out(String arg) {
        return "MyFunction out call";
    }

    public static void main(String[] args) {
        MyFunction myFunction = new MyFunction();
        Function<String, String> out = myFunction::out;
        MyInterface my = myFunction::out;
    }
}
