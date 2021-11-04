package on.concurrent;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class QuittingCompletable {
    public static void main(String[] args) {
        List<QuitTask> tasks = IntStream.range(0, QuittingTasks.COUNT)
                .mapToObj(QuitTask::new)
                .collect(Collectors.toList());

        List<CompletableFuture<Void>> futures = tasks.stream()
                .map(CompletableFuture::runAsync)
                .collect(Collectors.toList());
        new Nap(1);
        tasks.forEach(QuitTask::quit);
        futures.forEach(CompletableFuture::join);
    }
}
