package graph;

import java.util.LinkedList;
import java.util.Queue;

public class SpreadingWildfire {
    public int maximumMinutes(int[][] grid) {
        int[][] visited = new int[grid.length][grid[0].length];
        Queue<Pair> q = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    q.add(new Pair(i, j, 0));
                    visited[i][j] = 1;
                }
            }
        }
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;
        while (!q.isEmpty()) {
            Pair temp = q.poll();
            int[] dirX = { 0, 0, 1, -1 };
            int[] dirY = { 1, -1, 0, 0 };
            for (int i = 0; i < 8; i++) {
                int newX = dirX[i] + temp.x;
                int newY = dirY[i] + temp.y;
                if (newX >= 0 && newX < m && newY >= 0 && newY < m && grid[newX][newY] != 2) {
                    if (newX == 0 && newY == 0) {
                        ans = temp.val;
                        break;
                    }
                    visited[newX][newY] = 1;
                    grid[newX][newY] = 1;
                    q.add(new Pair(newX, newY, temp.val + 1));
                }
            }
        }
        if (canReach(grid)) {
            return ans - 1;
        }
        return -1;

    }

    public boolean canReach(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        if (dfs(grid, 0, 0, visited)) {
            return true;
        }
        return false;

    }

    public boolean dfs(int[][] grid, int i, int j, boolean[][] visited) {
        if (i == grid.length - 1 && j == grid[0].length - 1) {
            return true;
        }
        visited[i][j] = true;
        int[] dirX = { 0, 0, 1, -1, 1, -1, -1, 1 };
        int[] dirY = { 1, -1, 0, 0, 1, -1, 1, -1 };
        for (int k = 0; k < 8; k++) {
            int newX = dirX[k] + i;
            int newY = dirY[k] + j;
            if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length && grid[newX][newY] == 0
                    && !visited[newX][newY]) {
                if (dfs(grid, newX, newY, visited)) {
                    return true;
                }

            }
        }
        return false;

    }

    class Pair {
        int x;
        int y;
        int val;

        Pair(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;

        }
    }

    public static void main(String[] args) {
        int[][] arr = { { 0, 2, 0, 0, 0, 0, 0 }, { 0, 0, 0, 2, 2, 1, 0 }, { 0, 2, 0, 0, 1, 2, 0 },
                { 0, 0, 2, 2, 2, 0, 2 }, { 0, 0, 0, 0, 0, 0, 0 } };
        SpreadingWildfire sw = new SpreadingWildfire();
        System.out.println(sw.maximumMinutes(arr));
    }

}
