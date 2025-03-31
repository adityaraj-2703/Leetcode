package design.parkinglot;

import java.util.List;

public class ParkingFloor {
    private String number;
    private List<EntrancePanel> entrances;
    private List<ExitPanel> exits;

    public ParkingFloor(String num) {
        this.number = num;
    }

    public String getFloor() {
        return this.number;
    }

}
