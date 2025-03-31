package graph;

import java.util.PriorityQueue;

public class MinCostToConnectAllPoints {
    public int minCostConnectPoints(int[][] points) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> p1.val - p2.val);
        boolean[] visited = new boolean[points.length];
        // visited[0] = true;
        pq.add(new Pair(points[0][0], points[0][1], 0, 0));
        int sum = 0;
        int count = 0;
        while (!pq.isEmpty() && count < points.length) {
            if (visited[pq.peek().ind]) {
                pq.poll();
                continue;
            }
            count++;
            Pair temp = pq.poll();
            sum += temp.val;
            visited[temp.ind] = true;
            for (int i = 0; i < points.length; i++) {
                if (visited[i]) {
                    continue;
                }

                int lat = Math.abs(temp.x - points[i][0]);
                int lon = Math.abs(temp.y - points[i][1]);
                pq.add(new Pair(points[i][0], points[i][1], lat + lon, i));
            }
        }
        return sum;
    }

    class Pair {
        int x;
        int y;
        int val;
        int ind;

        Pair(int x, int y, int val, int ind) {
            this.val = val;
            this.x = x;
            this.y = y;
            this.ind = ind;
        }
    }

    public static void main(String[] args) {
        int[][] points = { { 0, 0 }, { 2, 2 }, { 3, 10 }, { 5, 2 }, { 7, 0 } };
        MinCostToConnectAllPoints mcp = new MinCostToConnectAllPoints();
        System.out.println(mcp.minCostConnectPoints(points));
    }

}
