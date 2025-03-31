package design.elevator;

import java.util.ArrayList;
import java.util.List;

public class LiftController {
    private List<Lift> lifts;

    public LiftController(List<Lift> lifts) {
        this.lifts = lifts;
    }

    public void requestLift(int floor) {
        if (!lifts.isEmpty()) {
            lifts.get(0).handleRequest(floor);
        } else {
            System.out.println("no lift available");
        }
    }

}
