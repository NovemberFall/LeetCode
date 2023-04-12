package OO_Design.Parking_Lot;

public class ParkingSpot {
    private final VehicleSize vehicleSize;
    private Vehicle currentVehicle;

    public ParkingSpot(VehicleSize vehicleSize) {
        this.vehicleSize = vehicleSize;
    }

    public boolean fit(Vehicle v) {
        if (currentVehicle == null && vehicleSize.getSize() >= v.getVehicleSize().getSize()) {
            return true;
        }
        return false;
    }

    /* record a vehicle is parked in by updating the currentVehicle field */
    public void park(Vehicle v) {
        currentVehicle = v;
    }

    public void leave() {
        currentVehicle = null;
    }

    public Vehicle getVehicle() {
        return currentVehicle;
    }
}
