package design.elevator;

public class MovingUpState implements LiftState {

    @Override
    public void handleRequest(Lift lift, int floor) {
        // TODO Auto-generated method stub
        if (floor > lift.getFloor()) {
            System.out.println("Moving up the floor :" + floor);
            lift.setFloor(floor);
        }
    }

}
