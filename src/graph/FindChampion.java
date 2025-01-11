package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindChampion {
    public int findChampion(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }
        Map<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<n;i++){
            hm.put(i,0);
        }
        for(int i=0;i<edges.length;i++){
            adjList.get(edges[i][0]).add(edges[i][1]);
            hm.put(edges[i][1],hm.get(edges[i][1])+1);
        }
        int min = Integer.MAX_VALUE;
        int ind = -1;
        for(Map.Entry<Integer,Integer> m : hm.entrySet()){
            if(min > m.getValue()){
                min = m.getValue();
                ind = m.getKey();
            }
        }
        int count=0;
        for(Map.Entry<Integer,Integer> m : hm.entrySet()){
            if(min == m.getValue()){
                count++;
            }
        }
        if(count > 1){
            return -1;
        }
        return ind;


    }
}
