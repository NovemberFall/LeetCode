package ObjectOriented_Design.Parking_Lot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Level {
    private final List<ParkingSpot> spots;

    public Level(int numOfSpots) {
        List<ParkingSpot> list = new ArrayList<>(numOfSpots);
        int i = 0;
        for (; i < numOfSpots / 2; i++) {
            list.add(new ParkingSpot(VehicleSize.Compact));
        }
        for (; i < numOfSpots; i++) {
            list.add(new ParkingSpot(VehicleSize.Large));
        }
        spots = Collections.unmodifiableList(list);
    }

    public boolean hasSpot(Vehicle vehicle) {
        for (ParkingSpot s : spots) {
            if (s.fit(vehicle)) {
                return true;
            }
        }
        return false;
    }

    public boolean park(Vehicle vehicle) {
        for (ParkingSpot s : spots) {
            if (s.fit(vehicle)) {
                s.park(vehicle);
                return true;
            }
        }
        return false;
    }

    public boolean leave(Vehicle vehicle) {
        for (ParkingSpot s : spots) {
            if (s.getVehicle() == vehicle) {
                s.leave();
                return true;
            }
        }
        return false;
    }
}
