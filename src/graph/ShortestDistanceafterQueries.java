package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestDistanceafterQueries {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<n-1;i++){
            adjList.add(new ArrayList<>());
            adjList.get(i).add(i+1);
            
        }

        int[] ans = new int[queries.length];
        for(int i=0;i<queries.length;i++){
            adjList.get(queries[i][0]).add(queries[i][1]);
            Queue<Integer> q = new LinkedList<>();
            q.add(0);
            int count=0;
            while(!q.isEmpty()){
                 int temp = q.poll();
                 int max= -1;
                 for(int t : adjList.get(temp)){
                    max = t;
                 }
                 q.add(max);
                 count++;
            }
            ans[i] = count;

        }
        return ans;
        
        



    }
}
