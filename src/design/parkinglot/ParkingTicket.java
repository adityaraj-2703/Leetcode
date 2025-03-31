package design.parkinglot;

import java.util.Date;

public class ParkingTicket {
    private ParkingSpot p;
    private Vehicle vehicle;
    private Date startTime;
    private Date endTime;

    public ParkingTicket(Vehicle vehicle, Date startTime, ParkingSpot p) {
        this.vehicle = vehicle;
        this.startTime = startTime;
    }

    public ParkingSpot getP() {
        return p;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Date getStartTime() {
        return startTime;
    }

}
