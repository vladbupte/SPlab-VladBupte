
package ro.uvt.dp.commands;

import java.util.concurrent.*;

public class AsyncCommandExecutor {

    private static final ExecutorService pool = Executors.newFixedThreadPool(4);

    public static <R> Future<R> submit(Command<R> c) {
        return pool.submit(() -> c.execute());
    }
}
