package atomicBoolean;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;

/* 
Кто первый встал, того и тапки
*/

public class Solution {
    private static final int COUNT = 5;
    private static final int TIMEOUT = 10;
   // private static Boolean isHit = false;
    private static AtomicBoolean isHit = new AtomicBoolean();

    public static void main(final String[] arguments) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(COUNT);

        for (int i = 1; i <= COUNT; i++) {
            Shooter shooter = new Shooter(i);
            executor.submit(shooter);
        }

        executor.awaitTermination(TIMEOUT, TimeUnit.MILLISECONDS);

        executor.shutdown();
    }

    static class Shooter implements Runnable {
        private int id;

        public Shooter(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }

        @Override
        public void run() {
            System.out.println("Did someone hit? " + isHit.get());
            if (isHit.compareAndSet(false, true)) {
                System.out.println("The shooter #" + id + " hit!");
                System.out.println("Did someone hit? " + isHit);
            }
        }
    }
}