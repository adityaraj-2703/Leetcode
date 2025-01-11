package graph;

import java.util.*;

public class ValidArrangementOfPairs {
    public int[][] validArrangement(int[][] pairs) {
        int max = Integer.MIN_VALUE;
        for(int i=0;i<pairs.length;i++){
            max = Math.max(pairs[i][0],Math.max(max,pairs[i][1]));
        }
        int[][] ans2 = new int[pairs.length][2];
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<=max;i++){
            adjList.add(new ArrayList<>());
        }
        for(int i=0;i<pairs.length;i++){
            adjList.get(pairs[i][0]).add(pairs[i][1]);
        }
        
        for(int i=0;i<pairs.length;i++){
            Integer count=0;
            boolean[] visited = new boolean[max+1];
            List<List<Integer>> ans = new ArrayList<>();
            dfsUtil(visited,pairs[i][0],count,adjList,ans);
            if(ans.get(ans.size()-1).get(2) == pairs.length){
                int[][] ans1 = new int[pairs.length][2];
                for(int x=0;x<ans.size();x++){
                    ans1[x][0] = ans.get(x).get(0);
                    ans1[x][1] = ans.get(x).get(1);
                }
                return ans1;
            }
        }
        return ans2;

    }
    public void dfsUtil(boolean[] visited,int i,Integer count,List<List<Integer>> adjList, List<List<Integer>> ans){
        visited[i]  = true;
        for(int t : adjList.get(i)){
            if(!visited[t]){
                List<Integer> temp = new ArrayList<>();
                temp.add(i);
                temp.add(t);
                temp.add(count+1);
                ans.add(temp);
                dfsUtil(visited,t,count+1,adjList,ans);
            }
        }
    }
}
