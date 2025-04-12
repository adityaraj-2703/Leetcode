package graph;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistanceFromAllBuildings {
    public int shortestDistance(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    boolean[][] visited = new boolean[m][n];
                    Queue<Pair> q = new LinkedList<>();
                    q.add(new Pair(i, j, 0));
                    dp[i][j] = Integer.MAX_VALUE;
                    visited[i][j] = true;
                    while (!q.isEmpty()) {
                        Pair temp = q.poll();
                        int[] dirX = { 0, 0, 1, -1 };
                        int[] dirY = { 1, -1, 0, 0 };
                        for (int k = 0; k < 4; k++) {
                            int newX = dirX[k] + temp.x;
                            int newY = dirY[k] + temp.y;
                            if (newX >= 0 && newX < m && newY >= 0 && newY < n && !visited[newX][newY]
                                    && grid[newX][newY] == 0) {
                                visited[newX][newY] = true;
                                dp[newX][newY] = dp[newX][newY] + temp.val + 1;
                                q.add(new Pair(newX, newY, temp.val + 1));
                            }
                        }
                    }

                } else if (grid[i][j] == 2) {
                    dp[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                min = Math.min(min, dp[i][j]);
            }
        }
        return min;
    }

    class Pair {
        int x;
        int y;
        int val;

        Pair(int x, int y, int val) {
            this.y = y;
            this.x = x;
            this.val = val;
        }
    }

    public static void main(String[] args) {
        int[][] grid = { { 1, 0, 2, 0, 1 }, { 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 0 } };
        ShortestDistanceFromAllBuildings s = new ShortestDistanceFromAllBuildings();
        System.out.println(s.shortestDistance(grid));
    }

}
