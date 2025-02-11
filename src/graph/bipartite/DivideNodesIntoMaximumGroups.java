package graph.bipartite;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import tree.TreeNode.Pair;

class DivideNodesIntoMaximumGroups {
    public int magnificentSets(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            adjList.get(edges[i][0]).add(edges[i][1]);
            adjList.get(edges[i][1]).add(edges[i][0]);
        }
        if (!checkBipartite(adjList)) {
            return -1;
        }
        int[] dist = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dist[i] = countlevel(adjList, n, i);
        }
        boolean[] visited = new boolean[n + 1];
        int total_levels = 0;
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                total_levels += findMaxLevel(dist, adjList, visited, i);
            }
        }
        return total_levels;

    }

    public int findMaxLevel(int[] dist, List<List<Integer>> adjList, boolean[] visited, int i) {
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        visited[i] = true;
        int max = -1;
        while (!q.isEmpty()) {
            int t = q.poll();
            max = Math.max(max, dist[t]);
            for (int j : adjList.get(t)) {
                if (!visited[j]) {
                    q.add(j);
                    visited[j] = true;
                }
            }
        }
        return max;
    }

    public int countlevel(List<List<Integer>> adjList, int n, int i) {
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        visited[i] = true;
        int levels = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int j = 0; j < size; ++i) {
                int curr = q.poll();

                for (int nbr : adjList.get(curr)) {
                    if (!visited[nbr]) {
                        visited[nbr] = true;
                        q.add(nbr);
                    }
                }
            }
            levels++;
        }
        return levels;
    }

    public boolean checkBipartite(List<List<Integer>> adjList) {
        int[] color = new int[adjList.size()];
        boolean[] visited = new boolean[color.length];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i < adjList.size(); i++) {
            if (!visited[i]) {
                q.add(i);
                color[i] = 1;
                visited[i] = true;
                while (!q.isEmpty()) {
                    int t = q.poll();
                    for (int j : adjList.get(t)) {
                        if (color[j] == 0) {
                            if (color[t] == 1) {
                                color[j] = -1;
                            } else {
                                color[j] = 1;
                            }
                            q.add(j);
                        } else {
                            if (color[j] == color[t]) {
                                return false;
                            }
                        }
                        visited[j] = true;
                    }

                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        DivideNodesIntoMaximumGroups d = new DivideNodesIntoMaximumGroups();
        int[][] edges = { { 1, 2 }, { 1, 4 }, { 1, 5 }, { 2, 6 }, { 2, 3 }, { 4, 6 } };
        System.out.println(d.magnificentSets(6, edges));
    }

    class Pair {
        int count;
        int cc;

        Pair(int count, int cc) {
            this.count = 0;
            this.cc = cc;
        }
    }
}
