package design.snakesandladders;

import java.util.Random;

public class Dice {
    private static final int MIN = 1;
    private static final int MAX = 6;

    public int roll() {
        Random random = new Random();
        int randomNumber = random.nextInt(6) + 1;
        return randomNumber;
    }

}
