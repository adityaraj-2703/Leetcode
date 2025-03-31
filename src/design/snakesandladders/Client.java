package design.snakesandladders;

import java.util.Arrays;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        GameManager gm = GameManager.getInstance();

        Player p1 = new Player("Player 1");
        Player p2 = new Player("Player 2");
        Player p3 = new Player("Player 3");

        List<Player> players = Arrays.asList(p1, p2, p3);

        gm.startGame(players);

    }

}
