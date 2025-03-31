package design.elevator;

public class MovingDownState implements LiftState {

    @Override
    public void handleRequest(Lift lift, int floor) {
        // TODO Auto-generated method stub
        if (floor < lift.getFloor()) {
            System.out.println("moving down to floor: " + floor);
            lift.setFloor(floor);
        }
    }

}
