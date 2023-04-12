package OO_Design.Parking_Lot;

public enum VehicleSize {
    Compact(1),
    Large(2);

    private final int size;

    VehicleSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }
}
