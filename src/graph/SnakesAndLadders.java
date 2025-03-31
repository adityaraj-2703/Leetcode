package graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class SnakesAndLadders {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        Map<Integer, PairMap> hm = new HashMap<>();
        boolean rev = false;
        int ind = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (!rev) {
                for (int j = 0; j < n; j++) {
                    hm.put(ind, new PairMap(i, j, false));
                    ind++;
                }
            } else {
                for (int j = n - 1; j >= 0; j--) {
                    hm.put(ind, new PairMap(i, j, false));
                    ind++;
                }

            }
        }
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, n - 1, 0, 0));
        hm.put(0, new PairMap(n - 1, 0, true));
        int min = Integer.MAX_VALUE;
        while (!q.isEmpty()) {
            Pair temp = q.poll();
            if (temp.ind == n - 1) {
                min = Math.min(temp.count, min);
            }
            for (int i = 1; i <= 6; i++) {
                int newInd = temp.ind + i;
                int total = n * n;
                if (newInd < total && !hm.get(newInd).visited) {
                    PairMap p = hm.get(newInd);
                    p.visited = true;
                    hm.put(newInd, p);
                    q.add(new Pair(newInd, p.x, p.y, temp.count + 1));
                }
            }
        }
        return min;
    }

    class Pair {
        int ind;
        int x;
        int y;
        int count;

        Pair(int ind, int x, int y, int count) {
            this.ind = ind;
            this.x = x;
            this.y = y;
            this.count = count;
        }

    }

    class PairMap {
        int x;
        int y;
        boolean visited;

        PairMap(int x, int y, boolean visited) {
            this.x = x;
            this.y = y;
            this.visited = visited;
        }
    }

    public static void main(String[] args) {
        SnakesAndLadders s = new SnakesAndLadders();
        int[][] board = { { -1, -1, -1, -1, -1, -1 },
                { -1, -1, -1, -1, -1, -1 },
                { -1, -1, -1, -1, -1, -1 },
                { -1, 35, -1, -1, 13, -1 },
                { -1, -1, -1, -1, -1, -1 },
                { -1, 15, -1, -1, -1, -1 } };
        System.out.println(s.snakesAndLadders(board));
    }

}
