package design.parkinglot;

public class Display implements DisplayObserver {

    @Override
    public void update(String message) {
        System.out.println(message);
    }
}
