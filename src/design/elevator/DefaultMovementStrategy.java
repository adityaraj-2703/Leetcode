package design.elevator;

public class DefaultMovementStrategy implements MovementStrategy {

    @Override
    public void move(Lift lift, int floor) {
        // TODO Auto-generated method stub
        lift.setCurrentState(new StoppedState());
        System.out.println("lift stopped at floor: " + floor);
        lift.setFloor(floor);
    }

}
