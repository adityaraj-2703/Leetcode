package graph;

import java.util.LinkedList;
import java.util.Queue;

public class WallsAndGates {
    public void wallsAndGates(int[][] rooms) {
        Queue<Pair> q = new LinkedList<>();
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    q.add(new Pair(i, j, 0));
                }
            }
        }
        while (!q.isEmpty()) {
            Pair temp = q.poll();
            int[] dirX = { 0, 0, 1, -1 };
            int[] dirY = { 1, -1, 0, 0 };
            for (int i = 0; i < 4; i++) {
                int newX = temp.x + dirX[i];
                int newY = temp.y + dirY[i];
                if (newX >= 0 && newX < rooms.length && newY >= 0 && newY < rooms[0].length && rooms[newX][newY] != -1
                        && rooms[newX][newY] > (temp.val + 1)) {
                    int n = temp.val + 1;
                    rooms[newX][newY] = n;
                    q.add(new Pair(newX, newY, n));
                }
            }

        }
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
        int[][] rooms = { { 2147483647, -1, 0, 2147483647 }, { 2147483647, 2147483647, 2147483647, -1 },
                { 2147483647, -1, 2147483647, -1 }, { 0, -1, 2147483647, 2147483647 } };
        WallsAndGates w = new WallsAndGates();
        w.wallsAndGates(rooms);
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                System.out.print(rooms[i][j] + " , ");

            }
            System.out.println();
        }
    }

}
