package Concurrency.Concepts_Examples.Lock_Interface;

public class AirPlane {
    private int totalSeats;
    private int bookedSeats = 0;

    public AirPlane(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public boolean bookSeats(int numSeats) {
        if (numSeats <= 0) {
            throw new IllegalArgumentException("Number of seats to book must be greater than 0.");
        }

        if (bookedSeats + numSeats <= totalSeats) {
            bookedSeats += numSeats;
            return true;
        } else {
            return false;
        }

    }

    public int getNumAvailableSeats() {
        return totalSeats - bookedSeats;
    }
}

