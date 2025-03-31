package design.parkinglot;

public enum ParkingSpotType {
    Handicapped("Handicapped"),
    Compact("Compact"),
    Large("Large"),
    Motorcycle("Motorcycle"),
    Electric("Electric");

    private String displayName;

    ParkingSpotType(String disPlayName) {
        this.displayName = disPlayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public boolean canFit(VehicleType vehicleType) {
        return vehicleType.canFit(this);
    }

}
