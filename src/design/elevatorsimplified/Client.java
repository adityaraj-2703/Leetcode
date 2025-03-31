package design.elevatorsimplified;

public class Client {
    public static void main(String[] args) {
        ElevatorController ec = new ElevatorController(2, 4);

        ec.requestElevator(5, 3);
        ec.requestElevator(1, 4);
        ec.requestElevator(3, 5);
    }

}
