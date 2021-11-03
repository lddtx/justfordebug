package on.concurrent;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class ConcurrencyTest {
    @Test
    void main() throws InterruptedException {
        assertEquals(1, work().size());
    }

    static List<Integer> work() throws InterruptedException {
        final List<Integer> list = Collections.synchronizedList(new ArrayList<>());
        Thread thread = new Thread(() -> addIfAbsent(list, 47));
        thread.start();
        addIfAbsent(list, 47);
        thread.join();
        System.out.println("Elements: " + list);
        return list;
    }

    private static void addIfAbsent(List<Integer> list, Integer x) {
        if (!list.contains(x)) {
            list.add(x);
        }
    }
}
