package Concurrency.BlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Test;

class EnqueueMethods {
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);

        // put() will block until there is space inside the BlockingQueue for the element
        try {
            blockingQueue.put("1");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // add will throw exception if no space available in BlockingQueue
        try {
            blockingQueue.put("2");
        } catch (InterruptedException e) {
            // no space available in BlockingQueue
            e.printStackTrace();
        }

        // offer() return false if no space
        boolean wasEnqueued = blockingQueue.offer("3");

        // offer(o, time, TimeUnit) blocks for time if no space
        // then return false if still no space.
        try {
            boolean wasEnqueued2 = blockingQueue.offer("3", 1000, TimeUnit.MILLISECONDS);
            System.out.println(wasEnqueued2); // false
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testEnqueueMethods2() {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);

        // take() blocks until an element becomes available
        try {
            String element = blockingQueue.take();
            System.out.println(element);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // poll() returns null if no element is available
        String element2 = blockingQueue.poll();

        // poll(long timeout, TimeUnit timeUnit) blocks up until timeout
        // for an element to become available. If no element is available
        // before that time, null is returned.
        try {
            String element3 = blockingQueue.poll(1000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // removes the element if present in the BlockingQueue
        boolean wasRemoved = blockingQueue.remove("1");
    }

    @Test
    void testBlockingQueue_block() {
        // Create an ArrayBlockingQueue with a capacity of 10
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);

        // Add elements to the queue
        for (int i = 1; i <= 10; i++) {
            queue.add(i);
        }

        // Try to add another element, but the queue is full so this will block
        try {
            queue.put(11);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Remove and print the elements from the queue
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }
}
