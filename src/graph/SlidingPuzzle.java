package graph;

import java.util.*;

public class SlidingPuzzle {
    public int slidingPuzzle(int[][] board) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(board,0));
        int min = Integer.MAX_VALUE;
        Set<String> hs = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                sb.append(board[i][j]);
            }
        }
        hs.add(sb.toString());
        while(!q.isEmpty()){
            Pair p = q.poll();
            int[][] temp = p.matrix;
            int c = p.count;
            if(check(temp)){
                min = Math.min(min,c);
            }
            int indX=0;
            int indY=0;
            for(int i=0;i<temp.length;i++){
                for(int j=0;j<temp[0].length;j++){
                    if(temp[i][j]==0){
                        indX = i;
                        indY = j;
                        break;
                    }
                }
            }
            int[] dirX = {0,1,0,-1};
            int[] dirY = {1,0,-1,0};
            for(int i=0;i<4;i++){
                if(indX+dirX[i] >=0 && indX+dirX[i] < temp.length && indY+dirY[i] >=0 && indY+dirY[i] <temp[0].length){
                    int[][] newTemp = new int[2][3];
                    
                    for(int x=0;x<2;x++){
                        for(int y=0;y<3;y++){
                            newTemp[x][y] = temp[x][y];
                        }
                    }
                    
                    
                    int t = newTemp[indX][indY];
                    newTemp[indX][indY] = newTemp[indX+dirX[i]][indY+dirY[i]];
                    newTemp[indX+dirX[i]][indY+dirY[i]] = t;
                    StringBuilder sb1 = new StringBuilder();
                    for(int x=0;x<2;x++){
                        for(int y=0;y<3;y++){
                            sb1.append(newTemp[x][y]);
                        }
                    }
                    if(!hs.contains(sb1.toString())){
                        q.add(new Pair(newTemp,c+1));
                        hs.add(sb1.toString());
                    }
                    
                    
                }
            }
            
        }
        if(min == Integer.MAX_VALUE){
            return -1;
        }
        return min;
    }
    public boolean check(int[][] matrix){
        if(matrix[0][0]==1 && matrix[0][1]==2 && matrix[0][2]==3 && matrix[1][0]==4 && matrix[1][1]==5 && matrix[1][2]==0){
            return true;
        }
        return false;
    }
}
class Pair{
    int[][] matrix;
    int count;
    Pair(int[][] matrix,int count){
        this.matrix = matrix;
        this.count = count;
    }
}
