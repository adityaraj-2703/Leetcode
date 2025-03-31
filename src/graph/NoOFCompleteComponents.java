package graph;

import java.util.ArrayList;
import java.util.List;

public class NoOFCompleteComponents {
    public int countCompleteComponents(int n, int[][] edges) {
        boolean[] visited = new boolean[n];
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            adjList.get(edges[i][0]).add(edges[i][1]);
            adjList.get(edges[i][1]).add(edges[i][0]);
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int[] c = new int[2];
                dfs(i, adjList, visited, c);
                if ((c[0] * (c[0] - 1)) == c[1]) {
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(int i, List<List<Integer>> adjList, boolean[] visited, int[] c) {
        visited[i] = true;
        c[0]++;
        c[1] += adjList.get(i).size();
        for (int t : adjList.get(i)) {
            if (!visited[t]) {
                dfs(t, adjList, visited, c);
            }
        }
    }

    public static void main(String[] args) {
        int n = 6;
        int[][] edges = { { 0, 1 }, { 0, 2 }, { 1, 2 }, { 3, 4 }, { 3, 5 } };
        NoOFCompleteComponents ncc = new NoOFCompleteComponents();
        System.out.println(ncc.countCompleteComponents(n, edges));
    }

}
