package Concurrency.Concepts_Examples.notify_notifyAll;

import java.util.LinkedList;
import java.util.Queue;

class MessageBroker {
    private Queue<String> messageQueue = new LinkedList<>();

    public synchronized void produce(String message) {
        messageQueue.add(message);
        System.out.println("Produced: " + message);
        // Notify consumer threads that new messages are available
        notifyAll();
    }

    public synchronized String consume() throws InterruptedException {
        while (messageQueue.isEmpty()) {
            // Wait until a message is available
            wait();
        }
        String message = messageQueue.poll();
        System.out.println("Consumed: " + message);
        return message;
    }
}

class Main {
    public static void main(String[] args) {
        MessageBroker broker = new MessageBroker();

        // Create producer threads
        Thread producer1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                broker.produce("Message " + i);
            }
        });

        Thread producer2 = new Thread(() -> {
            for (int i = 5; i < 10; i++) {
                broker.produce("Message " + i);
            }
        });

        // Create consumer threads
        Thread consumer1 = new Thread(() -> {
            try {
                for (int i = 0; i < 5; i++) {
                    broker.consume();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread consumer2 = new Thread(() -> {
            try {
                for (int i = 0; i < 5; i++) {
                    broker.consume();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // Start all threads
        producer1.start();
        producer2.start();
        consumer1.start();
        consumer2.start();
    }
}