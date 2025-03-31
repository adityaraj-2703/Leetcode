package graph;

import java.util.Arrays;

public class LongestIncreasingPathinaMatrix {
    public int longestIncreasingPath(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                dfs(matrix, dp, i, j, 0);
            }
        }
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                max = Math.max(dp[i][j], max);
            }
        }
        return max + 1;

    }

    public void dfs(int[][] matrix, int[][] dp, int i, int j, int val) {
        int[] dirX = { 0, 0, 1, -1 };
        int[] dirY = { 1, -1, 0, 0 };
        for (int k = 0; k < 4; k++) {
            int newX = dirX[k] + i;
            int newY = dirY[k] + j;
            if (newX >= 0 && newX < matrix.length && newY >= 0 && newY < matrix[0].length
                    && matrix[newX][newY] > matrix[i][j]) {
                if (dp[newX][newY] < val + 1) {
                    dp[newX][newY] = val + 1;
                    dfs(matrix, dp, newX, newY, val + 1);
                }
            }
        }

    }

    public static void main(String[] args) {
        int[][] matrix = { { 9, 9, 4 }, { 6, 6, 8 }, { 2, 1, 1 } };
        LongestIncreasingPathinaMatrix l = new LongestIncreasingPathinaMatrix();
        System.out.println(l.longestIncreasingPath(matrix));
    }

}
