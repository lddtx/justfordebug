package on.concurrent;

import java.util.concurrent.CompletableFuture;

public class CompletableApply {
    public static void main(String[] args) {
        CompletableFuture<Machina> cf = CompletableFuture.completedFuture(new Machina(0));
        CompletableFuture<Machina> cf2 = cf.thenApply(Machina::work);
        CompletableFuture<Machina> cf3 = cf.thenApply(Machina::work);
        CompletableFuture<Machina> cf4 = cf.thenApply(Machina::work);
        CompletableFuture<Machina> cf5 = cf.thenApply(Machina::work);
    }
}
