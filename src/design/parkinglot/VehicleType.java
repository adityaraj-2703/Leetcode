package design.parkinglot;

public enum VehicleType {
    Cars("Cars"),
    Trucks("Trucks"),
    Electric("Electric"),
    Motorcycles("Motorcycles"),
    Van("Van");

    private String description;

    VehicleType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public boolean canFit(ParkingSpotType spotType) {
        switch (this) {
            case Trucks:
            case Van:
                return spotType == ParkingSpotType.Large;
            case Motorcycles:
                return spotType == ParkingSpotType.Motorcycle;
            case Cars:
                return spotType == ParkingSpotType.Compact || spotType == ParkingSpotType.Large;
            case Electric:
                return spotType == ParkingSpotType.Electric;
            default:
                return false;
        }

    }

    public double getTax(VehicleType type) {
        switch (this) {
            case Trucks:
            case Van:
                return 0.4;
            case Motorcycles:
                return 0.5;
            case Cars:
                return 0.6;
            case Electric:
                return 0.7;
            default:
                return 0.8;
        }
    }

}
