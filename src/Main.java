import java.time.Instant;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        runRunnable();
    }

    public static void runRunnable () {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        ExecutorService service = Executors.newFixedThreadPool(1);
        service.execute(getRunnable(executor, 10));
        service.execute(getRunnable(executor, 11));
        service.shutdown();
//        executor.shutdown();
    }

    public static Runnable getRunnable(ScheduledExecutorService executor, int id) {
        return () -> {
            System.out.println("start-" + id + ": " + Instant.now());
            Runnable endTask = () -> {
                System.out.println("end-" + id + "  : " + Instant.now());
            };
            executor.schedule(endTask, 100, TimeUnit.MILLISECONDS);
        };
    }

}