package blockingDeque;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class Storage {
    private final BlockingDeque<Integer> deque = new LinkedBlockingDeque<>(2);


    public void take() {
        try {
          //  System.out.println("take - " + deque.poll());
            System.out.println("take - " + deque.take());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void put(int i) {
        try {
           // deque.add(i);
            deque.put(i);
            System.out.println("put - " + i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}