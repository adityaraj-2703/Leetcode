package design.snakesandladders;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {
    private static final int BOARD_SIZE = 100;
    private final List<SnakeCell> snakes;
    private final List<LadderCell> ladders;
    private final Map<Integer, Integer> specialcells;

    public Board() {
        snakes = new ArrayList<>();
        ladders = new ArrayList<>();
        specialcells = new HashMap<>();
        initializeSnakesandLadders();
    }

    public void initializeSnakesandLadders() {
        snakes.add(new SnakeCell(16, 6));
        specialcells.put(16, 6);
        snakes.add(new SnakeCell(48, 26));
        specialcells.put(48, 26);
        snakes.add(new SnakeCell(64, 60));
        specialcells.put(64, 60);
        snakes.add(new SnakeCell(93, 73));
        specialcells.put(93, 73);

        // Initialize ladders
        ladders.add(new LadderCell(1, 38));
        specialcells.put(1, 38);
        ladders.add(new LadderCell(4, 14));
        specialcells.put(4, 14);
        ladders.add(new LadderCell(9, 31));
        specialcells.put(9, 31);
        ladders.add(new LadderCell(21, 42));
        specialcells.put(21, 42);
        ladders.add(new LadderCell(28, 84));
        specialcells.put(28, 84);
        ladders.add(new LadderCell(51, 67));
        specialcells.put(51, 67);
        ladders.add(new LadderCell(80, 99));
        specialcells.put(80, 99);
    }

    public int getNewPositionAfterSnakeOrLadder(int position) {
        if (specialcells.containsKey(position)) {
            return specialcells.get(position);
        }
        return position;
    }

    public static int getBoardSize() {
        return BOARD_SIZE;
    }

}
