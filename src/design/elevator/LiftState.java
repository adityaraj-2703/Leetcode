package design.elevator;

public interface LiftState {
    void handleRequest(Lift lift, int floor);
}
