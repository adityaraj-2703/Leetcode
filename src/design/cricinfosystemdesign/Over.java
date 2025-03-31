package design.cricinfosystemdesign;

import java.util.ArrayList;
import java.util.List;

public class Over {
    private final int overNumber;
    private final List<Ball> balls;

    public Over(int overNumber) {
        this.overNumber = overNumber;
        this.balls = new ArrayList<>();
    }

    public int getOverNumber() {
        return overNumber;
    }

    public List<Ball> getBalls() {
        return balls;
    }

    public void addBall(Ball b) {
        this.balls.add(b);
    }

}
