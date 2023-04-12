package OO_Design.Parking_Lot;

public class Car extends Vehicle{

    @Override
    public VehicleSize getVehicleSize() {
        return VehicleSize.Compact;
    }
}