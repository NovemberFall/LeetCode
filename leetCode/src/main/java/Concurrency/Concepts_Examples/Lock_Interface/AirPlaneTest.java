package Concurrency.Concepts_Examples.Lock_Interface;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class AirPlaneTest {
    @Test
    public void testBookSeats() throws InterruptedException {
        AirPlane airPlane = new AirPlane(50);
        Lock lock = new ReentrantLock();

        // Test booking a single seat
        Thread t1 = new Thread(() -> {
            lock.lock();
            try {
                assertTrue(airPlane.bookSeats(1));
            } finally {
                lock.unlock();
            }
        });
        // Test booking multiple seats
        Thread t2 = new Thread(() -> {
            lock.lock();
            try {
                assertTrue(airPlane.bookSeats(10));
            } finally {
                lock.unlock();
            }
        });
        // Test booking more seats than available
        Thread t3 = new Thread(() -> {
            lock.lock();
            try {
                assertFalse(airPlane.bookSeats(50));
            } finally {
                lock.unlock();
            }
        });

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        assertEquals(39, airPlane.getNumAvailableSeats());

        // Test booking 0 seats
        assertThrows(IllegalArgumentException.class, () -> airPlane.bookSeats(0));

        // Test booking negative seats
        assertThrows(IllegalArgumentException.class, () -> airPlane.bookSeats(-10));
    }
}
