package design.snakesandladders;

import java.util.List;

public class SnakeAndLadderGame {
    private final Board b;
    private final List<Player> players;
    private final Dice d;
    private int currPlayerInd;

    public SnakeAndLadderGame(List<Player> players) {
        b = new Board();
        this.players = players;
        d = new Dice();
        currPlayerInd = 0;

    }

    public void play() {
        while (true) {
            Player c = players.get(currPlayerInd);
            int diceroll = d.roll();
            int newP = c.getPosition() + diceroll;
            if (newP <= b.getBoardSize()) {
                c.setPosition(b.getNewPositionAfterSnakeOrLadder(newP));
                System.out.println(c.getName() + "rolled a" + diceroll + "and moved to position" + c.getPosition());

            } else {
                System.out.println(c.getName() + "rolled a" + diceroll + "and it was greater than 100");
            }
            if (c.getPosition() == b.getBoardSize()) {
                System.out.println(c.getName() + "wins!!!!!");
                break;
            }

            currPlayerInd = (currPlayerInd + 1) % players.size();
        }
    }

}
