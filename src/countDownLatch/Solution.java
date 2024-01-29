package countDownLatch;

import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/* 
Арбайтен!
*/

public class Solution {

    public static ExecutorService executor = Executors.newCachedThreadPool();

    public static void main(String[] args) throws InterruptedException {
        AtomicInteger codeLines = new AtomicInteger();
        CountDownLatch countDownLatch = new CountDownLatch(100);
        List<Callable<Boolean>> developers = Stream
                .generate(() -> new Developer(codeLines,countDownLatch))
                .limit(6)
                .collect(toList());
        executor.invokeAll(developers);
        countDownLatch.await();
       // executor.awaitTermination(1, TimeUnit.SECONDS);
        executor.shutdownNow();
        System.out.println("Проект готов!");
    }
}

