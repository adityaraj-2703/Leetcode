package design.elevator;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        Lift l1 = new Lift();
        LiftController l = new LiftController(List.of(l1));

        l.requestLift(3);
        l.requestLift(4);
        l.requestLift(5);

    }

}
