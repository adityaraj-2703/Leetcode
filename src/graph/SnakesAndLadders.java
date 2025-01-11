package graph;

import java.util.LinkedList;
import java.util.Queue;

public class SnakesAndLadders {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        Queue<Pair111> q = new LinkedList<>();
        q.add(new Pair111(1, 0));
        int min = Integer.MAX_VALUE;
        while (!q.isEmpty()) {
            Pair111 p = q.poll();
            if (p.val == n * n) {
                min = Math.min(min, p.count);

            }
            for (int i = 1; i <= 6; i++) {
                int newVal = p.val + i;
                int row = (newVal - 1) / n;
                int col = -1;
                if (row % 2 == 0) {
                    col = Math.max(newVal % n - 1, 0);
                } else {
                    col = n - (newVal % n);
                }
                if (board[row][col] != -1) {
                    q.add(new Pair111(board[row][col], p.count + 1));
                } else {
                    q.add(new Pair111(newVal, p.count + 1));
                }

            }
        }
        return min;
    }

}

class Pair111 {
    int val;
    int count;

    Pair111(int val, int count) {
        this.val = val;
        this.count = count;
    }

}
