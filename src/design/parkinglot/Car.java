package design.parkinglot;

public class Car extends Vehicle {
    public Car(VehicleType v, String number) {
        super(VehicleType.Cars, number);
    }

    public ParkingSpotType getParkingSpotType() {
        return ParkingSpotType.Compact;
    }
}
