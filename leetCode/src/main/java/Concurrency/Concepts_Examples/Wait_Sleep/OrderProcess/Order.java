package Concurrency.Concepts_Examples.Wait_Sleep.OrderProcess;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class Order {
    private boolean isPlaced = false;
    private boolean isPaid = false;

    public synchronized void place() {
        isPlaced = true;
        notifyAll();
    }

    public synchronized void pay() {
        // Wait for the order to be placed before paying
        while (!isPlaced) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }

        // Simulate payment processing time
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }

        isPaid = true;
        notifyAll();
    }

    public synchronized boolean isPlaced() {
        return isPlaced;
    }

    public synchronized boolean isPaid() {
        return isPaid;
    }



    @Test
    public void testOrderProcess() throws InterruptedException {
        Order order = new Order();

        // Test placing an order
        Thread placeThread = new Thread(() -> {
            order.place();
        });
        placeThread.start();
        Thread.sleep(100);
        assertTrue(order.isPlaced());

        // Test paying for an order
        Thread payThread = new Thread(() -> {
            order.pay();
        });
        payThread.start();
        Thread.sleep(100);
        assertTrue(order.isPaid());
    }
}
