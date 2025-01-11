package graph;

import java.util.*;

public class MinimumObstacleToRemove {
    public int minimumObstacles(int[][] grid) {
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0,0,0});
        int[][] visited = new int[grid.length][grid[0].length];
        for(int i=0;i<visited.length;i++){
            for(int j=0;j<visited[i].length;j++){
                visited[i][j] = Integer.MAX_VALUE;
            }
        }
        visited[0][0] = 0;
        while(!q.isEmpty()){
            int[] temp = q.poll();
            int[] dirX = {0,0,-1,1};
            int[] dirY = {1,-1,0,0};
            for(int i=0;i<4;i++){
                int tX = temp[0] + dirX[i];
                int tY = temp[1] + dirY[i];
                if(tX>=0 && tX<grid.length && tY>=0 && tY<grid[0].length && visited[tX][tY]==Integer.MAX_VALUE){
                    if(grid[tX][tY]!=0){
                        
                        q.offerLast(new int[]{tX,tY,temp[2]+1});

                        visited[tX][tY] = temp[2]+1;
                    }
                    else if(grid[tX][tY]==0){
                        q.offerFirst(new int[]{tX,tY,temp[2]});
                        visited[tX][tY] = temp[2];
                    }
                    
                }
            }
        }
        int m = grid.length;
        int n = grid[0].length;
        return visited[m-1][n-1];

    }
}
class Pair1{
    int x;
    int y;
    int count;
    Pair1(int x,int y,int count){
        this.x = x;
        this.y = y;
        this.count = count;
    }

}