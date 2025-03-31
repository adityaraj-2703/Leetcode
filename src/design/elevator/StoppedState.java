package design.elevator;

public class StoppedState implements LiftState {

    @Override
    public void handleRequest(Lift lift, int floor) {
        // TODO Auto-generated method stub
        System.out.println("Stopped at floor: " + floor);
        lift.setFloor(floor);
    }

}
