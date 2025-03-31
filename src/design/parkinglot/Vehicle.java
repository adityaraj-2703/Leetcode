package design.parkinglot;

public class Vehicle {
    private final VehicleType vehicleType;
    private String number;

    Vehicle(VehicleType v, String number) {
        this.vehicleType = v;
        this.number = number;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setNumber(String number) {
        this.number = number;
    }

}
