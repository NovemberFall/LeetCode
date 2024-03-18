package Concurrency.Concepts_Examples.Synchronized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class AirplaneBookingSystem_lambda {
    private final List<String> availableSeats;
    private final Object lock = new Object();

    public AirplaneBookingSystem_lambda() {
        availableSeats = new ArrayList<>(Arrays.asList(
                "A1", "A2", "B1", "B2", "C1", "C2"));
    }

    public void bookSeat(String seat, String passengerName) {
        synchronized (lock) {
            if (availableSeats.contains(seat)) {
                availableSeats.remove(seat);
                System.out.println("Booking successful: " + passengerName + " booked seat " + seat);
            } else {
                System.out.println("Booking failed: " + passengerName + " could not book seat " + seat);
            }
        }
    }

    public static void main(String[] args) {
        AirplaneBookingSystem_lambda bookingSystem = new AirplaneBookingSystem_lambda();

        // Creating Passenger Threads using lambda expressions
        Runnable passenger1 = () -> bookingSystem.bookSeat("A1", "Alice");
        Runnable passenger2 = () -> bookingSystem.bookSeat("A1", "Bob");
        Runnable passenger3 = () -> bookingSystem.bookSeat("A1", "Mia");

        // Starting Passenger Threads
        new Thread(passenger1).start();
        new Thread(passenger2).start();
        new Thread(passenger3).start();
    }
}
