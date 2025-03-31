package design.parkinglot;

public class ParkingSpot {
    private String number;
    private boolean free = true;
    private Vehicle vehicle;
    private final ParkingSpotType parkingSpotType;

    public ParkingSpot(ParkingSpotType parkingspotType) {
        this.parkingSpotType = parkingspotType;
    }

    public boolean assignVehicle(Vehicle vehicle) {
        if (!this.free)
            return false;
        this.vehicle = vehicle;
        free = false;
        return true;
    }

    public boolean removeVehicle() {
        this.free = true;
        this.vehicle = null;
        return true;

    }

    public boolean isFree() {
        return free;
    }

    public String getNumber() {
        return number;

    }

    public ParkingSpotType getParkingSpotType() {
        return parkingSpotType;
    }

}
