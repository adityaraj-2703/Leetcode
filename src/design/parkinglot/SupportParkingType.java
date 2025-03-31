package design.parkinglot;

public interface SupportParkingType {
    void handleRequest(Vehicle v);

    void setNext(ParkingSpotType p);

}
