package design.elevatorsimplified;

import java.util.ArrayList;
import java.util.List;

public class ElevatorController {
    private final List<Elevator> elevators;

    ElevatorController(int numElevators, int capacity) {
        elevators = new ArrayList<>();
        for (int i = 0; i < numElevators; i++) {
            Elevator e = new Elevator(i + 1, capacity);
            elevators.add(e);
            new Thread(() -> e.run()).start();
        }

    }

    public void requestElevator(int srcFloor, int destFloor) {
        Elevator optimalelevator = findOptimalElevator(srcFloor, destFloor);
        optimalelevator.addRequest(new Request(srcFloor, destFloor));
    }

    public Elevator findOptimalElevator(int src, int dst) {
        Elevator optimal = null;
        int min = Integer.MAX_VALUE;
        for (Elevator e : this.elevators) {
            int dist = Math.abs(e.getCurrentFloor() - src);
            if (dist < min) {
                min = dist;
                optimal = e;
            }
        }
        return optimal;
    }

}
