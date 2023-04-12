package Concurrency.Concepts_Examples.Synchronized;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class AirplaneBookingSystem {
    private final List<String> availableSeats;
    private final Object lock = new Object();

    public AirplaneBookingSystem() {
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
        AirplaneBookingSystem bookingSystem = new AirplaneBookingSystem();
        PassengerThread passenger1 = new PassengerThread("Alice", "A1", bookingSystem);
        PassengerThread passenger2 = new PassengerThread("Bob", "A1", bookingSystem);

        passenger1.start();
        passenger2.start();
    }
}

class PassengerThread extends Thread {
    private final String passengerName;
    private final String seat;
    private final AirplaneBookingSystem bookingSystem;
    public PassengerThread(String passengerName, String seat, AirplaneBookingSystem bookingSystem) {
        this.passengerName = passengerName;
        this.seat = seat;
        this.bookingSystem = bookingSystem;
    }

    public void run() {
        bookingSystem.bookSeat(seat, passengerName);
    }
}

