package graph;

import java.util.HashMap;
import java.util.Map;

public class MakeALargeIsland {
    public int largestIsland(int[][] grid) {
        int max = 0;

        Map<Pair, Integer> hm = new HashMap<>();
        int index = 2;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    boolean[][] visited = new boolean[grid.length][grid[0].length];
                    int[] mem = new int[2];
                    mem[0] = 1;
                    find(grid, i, j, mem, visited);
                    hm.put(new Pair(i, j), mem[0]);
                    index++;
                }

            }
        }
        for (Map.Entry<Pair, Integer> m : hm.entrySet()) {
            System.out.println(m.getKey() + "," + m.getValue());
        }
        return max;
    }

    public void find(int[][] grid, int i, int j, int[] mem, boolean[][] visited) {
        visited[i][j] = true;
        int[] dirX = { 0, 0, 1, -1 };
        int[] dirY = { 1, -1, 0, 0 };
        for (int k = 0; k < 4; k++) {
            int newX = i + dirX[k];
            int newY = j + dirY[k];
            if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length && grid[newX][newY] == 1
                    && !visited[newX][newY]) {
                mem[0]++;
                find(grid, newX, newY, mem, visited);

            }

        }
    }

    class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public boolean equals(Object o) {
            Pair p = (Pair) o;
            return this.x == p.x && this.y == p.y;
        }

        public int hashCode() {
            return this.x * 31 + this.y;
        }
    }

}
