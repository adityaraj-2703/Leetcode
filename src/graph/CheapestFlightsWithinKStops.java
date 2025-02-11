package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class CheapestFlightsWithinKStops {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < flights.length; i++) {
            adjList.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2], 0));
        }
        int[] dist = new int[n];
        boolean[] visited = new boolean[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<Pair> pq = new PriorityQueue<>((n1, n2) -> n1.cost - n2.cost);
        pq.add(new Pair(src, 0, 0));
        dist[src] = 0;
        int ans = Integer.MAX_VALUE;
        while (!pq.isEmpty()) {
            Pair temp = pq.poll();
            if (temp.count > (k + 1)) {
                continue;
            }
            if (temp.ind == dst) {
                ans = Math.min(ans, temp.cost);

            }
            visited[temp.ind] = true;
            for (Pair p : adjList.get(temp.ind)) {

                if (!visited[p.ind]) {

                    if (dist[p.ind] > dist[temp.ind] + p.cost) {
                        dist[p.ind] = dist[temp.ind] + p.cost;
                        pq.add(new Pair(p.ind, dist[p.ind], temp.count + 1));
                    }
                }

            }
        }
        if (ans == Integer.MAX_VALUE) {
            return -1;
        }
        return ans;
    }

    class Pair {
        int ind;
        int cost;
        int count;

        Pair(int ind, int cost, int count) {
            this.ind = ind;
            this.cost = cost;
            this.count = count;
        }
    }

    public static void main(String[] args) {
        CheapestFlightsWithinKStops c = new CheapestFlightsWithinKStops();
        int[][] flights = { { 0, 1, 1 }, { 0, 2, 5 }, { 1, 2, 1 }, { 2, 3, 1 } };
        System.out.println(c.findCheapestPrice(4, flights, 0, 3, 1));
    }

}
