package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindEventualSafeStates {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int[] outDegree = new int[graph.length];

        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                adjList.get(graph[i][j]).add(i);
                outDegree[i]++;
            }
        }
        List<Integer> res = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < outDegree.length; i++) {
            if (outDegree[i] == 0) {
                q.add(i);

            }
        }
        while (!q.isEmpty()) {
            int tmp = q.poll();
            res.add(tmp);
            for (int j = 0; j < adjList.get(tmp).size(); j++) {
                int check = adjList.get(tmp).get(j);
                outDegree[check]--;
                if (outDegree[check] == 0) {
                    q.add(check);
                }
            }
        }
        Collections.sort(res);
        return res;

    }

    public static void main(String[] args) {
        FindEventualSafeStates f = new FindEventualSafeStates();
        int[][] graph = { {}, { 0, 2, 3, 4 }, { 3 }, { 4 }, {} };
        System.out.println(f.eventualSafeNodes(graph));
    }

}
