package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class NumberOfWaysToArriveAtDestination {
    public static void main(String[] args) {
        NumberOfWaysToArriveAtDestination n = new NumberOfWaysToArriveAtDestination();
        int[][] roads = { { 0, 6, 7 }, { 0, 1, 2 }, { 1, 2, 3 }, { 1, 3, 3 }, { 6, 3, 3 }, { 3, 5, 1 }, { 6, 5, 1 },
                { 2, 5, 1 }, { 0, 4, 5 }, { 4, 6, 2 } };
        System.out.println(n.countPaths(7, roads));
    }

    public int countPaths(int n, int[][] roads) {
        List<List<Pair>> adjList = new ArrayList<>();
        int[] dist = new int[n];
        for (int i = 0; i < dist.length; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        boolean[] visited = new boolean[n];
        dist[0] = 0;
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < roads.length; i++) {
            adjList.get(roads[i][0]).add(new Pair(roads[i][1], roads[i][2]));
            adjList.get(roads[i][1]).add(new Pair(roads[i][0], roads[i][2]));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((n1, n2) -> n1.val - n2.val);
        pq.add(new Pair(0, 0));
        int min = Integer.MAX_VALUE;
        int count = 0;
        while (!pq.isEmpty()) {
            Pair temp = pq.poll();
            if (temp.vertex == n - 1) {
                if (temp.val < min) {
                    min = temp.val;
                    count = 1;
                } else if (temp.val == min) {
                    count++;
                }
            }
            visited[temp.vertex] = true;
            for (Pair i : adjList.get(temp.vertex)) {

                if (!visited[i.vertex]) {
                    dist[i.vertex] = Math.min(dist[i.vertex], dist[temp.vertex] + i.val);
                    if (dist[i.vertex] == dist[temp.vertex] + i.val) {

                        pq.add(new Pair(i.vertex, temp.val + i.val));
                    }

                }

            }
        }
        System.out.println(min);
        return count;
    }

    class Pair {
        int vertex;
        int val;

        Pair(int vertex, int val) {
            this.vertex = vertex;
            this.val = val;
        }
    }
}
