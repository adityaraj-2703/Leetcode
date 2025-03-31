package design.elevator;

public class RequestCommand implements LiftCommand {
    private Lift lift;
    private int floor;

    public RequestCommand(Lift lift, int floor) {
        this.lift = lift;
        this.floor = floor;
    }

    @Override
    public void execute() {
        // TODO Auto-generated method stub
        lift.handleRequest(floor);
    }

}
