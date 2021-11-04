package on.concurrent;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class QuittingTasks {
    public static final int COUNT = 150;

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        List<QuitTask> tasks = IntStream.range(1, COUNT)
                .mapToObj(QuitTask::new)
                .peek(exec::execute)
                .collect(Collectors.toList());

        new Nap(1);
        tasks.forEach(QuitTask::quit);
    }
}
