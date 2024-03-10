package Concurrency.BlockingQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumer {

    // Shared buffer using a BlockingQueue (thread-safe)
    private static final BlockingQueue<String> queue = new LinkedBlockingQueue<>(10); // Capacity of 10

    public static void main(String[] args) {

        // Producer Thread
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 15; i++) {
                    try {
                        String item = "Item " + i;
                        queue.put(item); // Add item to the queue (blocks if full)
                        System.out.println("Produced: " + item);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        // Consumer Thread
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        String item = queue.take(); // Remove item from the queue (blocks if empty)
                        System.out.println("Consumed: " + item);
                        // Process the item here...
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}

