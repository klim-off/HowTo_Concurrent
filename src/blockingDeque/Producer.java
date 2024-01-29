package blockingDeque;

public class Producer implements Runnable {
    private final Storage storage;

    public Producer(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            storage.put(i);
        }
    }
}