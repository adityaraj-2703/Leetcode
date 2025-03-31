package design.elevator;

public class Lift {
    private LiftState currentState;
    private MovementStrategy movementStrategy;
    private int floor;

    public Lift() {
        this.currentState = new StoppedState();
        this.movementStrategy = new DefaultMovementStrategy();
    }

    public void handleRequest(int floor) {
        currentState.handleRequest(this, floor);
        move();
    }

    public void move() {
        movementStrategy.move(this, floor);
    }

    public void update(int floor) {
        System.out.println("this is :" + floor);
    }

    public LiftState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(LiftState currentState) {
        this.currentState = currentState;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public MovementStrategy getMovementStrategy() {
        return movementStrategy;
    }

    public void setMovementStrategy(MovementStrategy movementStrategy) {
        this.movementStrategy = movementStrategy;
    }

}
