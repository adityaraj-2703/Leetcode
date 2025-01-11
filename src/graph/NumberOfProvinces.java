package graph;

import java.util.ArrayList;
import java.util.List;

public class NumberOfProvinces {
    public static int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<isConnected.length;i++){
            adjList.add(new ArrayList<>());
        }
        for(int i=0;i<isConnected.length;i++){
            for(int j=0;j<n;j++){
                if(isConnected[i][j] == 1 && i!=j){
                    adjList.get(i).add(j);
                }
            }
        }
        int count=0;
        boolean[] visited = new boolean[isConnected.length];
        for(int i=0;i<adjList.size();i++){
            for(int j=0;j<adjList.get(i).size();j++){
                if(!visited[j]){
                    dfs(visited,adjList,j);
                    count++;
                }
            }
        }
        for(int i=0;i<visited.length;i++){
            if(!visited[i]){
                count++;
            }
        }
        return count;
    }
    public static void dfs(boolean[] visited,List<List<Integer>> adjList,int i){
        visited[i] = true;
        for(int j: adjList.get(i)){
            if(!visited[j] && i!=j){
                dfs(visited,adjList,j);
            }
        }
    }

    public static int driver(int[][] g){
        return findCircleNum(g);
    }
}
