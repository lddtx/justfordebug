package on.stream;

import java.util.Optional;
import java.util.Random;
import java.util.stream.Stream;

public class Signal {
    private final String msg;
    public Signal(String msg) {
        this.msg = msg;
    }
    public String getMsg() {
        return msg;
    }

    @Override
    public String toString() {
        return "Signal{" +
                "msg='" + msg + '\'' +
                '}';
    }

    static Random rand = new Random(47);

    public static Signal morse() {
        switch (rand.nextInt(4)) {
            case 1: return new Signal("dot");
            case 2: return new Signal("dash");
            default: return null;
        }
    }

    public static Stream<Optional<Signal>> stream() {
        return Stream
                .generate(Signal::morse)
                .map(Optional::ofNullable);
    }

    public static void main(String[] args) {
        Signal.stream()
                .limit(10)
                .forEach(System.out::println);

        System.out.println("----------");

        Signal.stream()
                .limit(10)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .forEach(System.out::println);
    }
}
