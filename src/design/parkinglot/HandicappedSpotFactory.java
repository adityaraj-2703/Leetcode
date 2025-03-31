package design.parkinglot;

public class HandicappedSpotFactory extends ParkingSpotFactory {

    @Override
    public ParkingSpot createParkingspot() {
        // TODO Auto-generated method stub
        return new HandicappedSpot();
    }

}
