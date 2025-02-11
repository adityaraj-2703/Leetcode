package graph;

import java.util.ArrayList;
import java.util.List;

public class ShortestCycleInAGraph {
    public int findShortestCycle(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            adjList.get(edges[i][0]).add(edges[i][1]);
            adjList.get(edges[i][1]).add(edges[i][0]);
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            boolean[] visited = new boolean[n];
            if (!visited[i] && isCycle(adjList, visited, i, i)) {
                boolean[] visited1 = new boolean[n];
                ans = Math.min(ans, countCycle(adjList, visited1, i, i));
            }
        }
        return ans;
    }

    public int countCycle(List<List<Integer>> adjList, boolean[] visited, int i, int parent) {
        visited[i] = true;
        int count = 1;
        for (int j : adjList.get(i)) {
            if (!visited[j]) {
                int temp = count + countCycle(adjList, visited, j, i);
                return temp;
            } else if (j != parent) {
                return count;
            }
        }
        return count;
    }

    public boolean isCycle(List<List<Integer>> adjList, boolean[] visited, int i, int parent) {
        visited[i] = true;
        for (int j : adjList.get(i)) {
            if (!visited[j]) {
                return isCycle(adjList, visited, j, i);
            } else if (parent != j) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ShortestCycleInAGraph s = new ShortestCycleInAGraph();
        int[][] edges = { { 0, 1 }, { 0, 2 } };
        System.out.println(s.findShortestCycle(3, edges));
    }

}
