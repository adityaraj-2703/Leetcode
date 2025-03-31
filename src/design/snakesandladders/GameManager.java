package design.snakesandladders;

import java.util.ArrayList;
import java.util.List;

public class GameManager {
    private static GameManager instance;
    private final List<SnakeAndLadderGame> games;

    private GameManager() {
        this.games = new ArrayList<>();

    }

    public static synchronized GameManager getInstance() {
        if (instance == null) {
            instance = new GameManager();
        }
        return instance;
    }

    public void startGame(List<Player> players) {
        SnakeAndLadderGame g = new SnakeAndLadderGame(players);
        games.add(g);
        new Thread(() -> g.play()).start();
    }

}
