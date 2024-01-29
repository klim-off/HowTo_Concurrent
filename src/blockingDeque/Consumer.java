package blockingDeque;

public class Consumer implements Runnable {
    private final Storage storage;

    public Consumer(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            storage.take();
        }
    }
}