package greedy;

import java.util.*;

public class MaximumDistanceArray {
    public int maxDistance(List<List<Integer>> arrays) {
        Pair firstMin = new Pair(-1,Integer.MAX_VALUE);
        Pair secondMin = new Pair(-1,Integer.MAX_VALUE);
        for(int i=0;i<arrays.size();i++){
            if(arrays.get(i).get(0) < firstMin.val){
                secondMin = firstMin;
                firstMin = new Pair(i,arrays.get(i).get(0));
                
            }
            else if(arrays.get(i).get(0) >= firstMin.val && arrays.get(i).get(0) <= secondMin.val){
                secondMin = new Pair(i,arrays.get(i).get(0));
            }
        }
        if(secondMin.val == Integer.MAX_VALUE){
            return 0;
        }
        Pair firstMax = new Pair(-1,Integer.MIN_VALUE);
        Pair secondMax = new Pair(-1,Integer.MIN_VALUE);
        for(int i=0;i<arrays.size();i++){
            if(arrays.get(i).get(arrays.get(i).size()-1) > firstMax.val){
                secondMax = firstMax;
                firstMax = new Pair(i,arrays.get(i).get(arrays.get(i).size()-1));
                
            }
            else if(arrays.get(i).get(arrays.get(i).size()-1) <= firstMax.val && arrays.get(i).get(arrays.get(i).size()-1) >= secondMax.val){
                secondMax = new Pair(i,arrays.get(i).get(arrays.get(i).size()-1));
            }
        }
        int max = Integer.MIN_VALUE;
        if(firstMin.ind == firstMax.ind){
            max = Math.max(max,Math.abs(firstMin.val - secondMax.val));
        }
        if(firstMin.ind == secondMax.ind){
            max = Math.max(max,Math.abs(firstMin.val - firstMax.val));
        }
        if(firstMin.ind != firstMax.ind && firstMin.ind != secondMax.ind){
            max = Math.max(max,Math.max(Math.abs(firstMin.val - firstMax.val),Math.abs(firstMin.val - secondMax.val)));
        }
        if(secondMin.ind == firstMax.ind){
            max = Math.max(max,Math.abs(secondMin.val - secondMax.val));
        }
        if(secondMin.ind == secondMax.ind){
            max = Math.max(max,Math.abs(secondMin.val - firstMax.val));
        }
        if(secondMin.ind != firstMax.ind && secondMin.ind != secondMax.ind){
            max = Math.max(max,Math.max(Math.abs(secondMin.val - firstMax.val),Math.abs(secondMin.val - firstMax.val)));
        }
        return max;
        
    }
}
class Pair{
    int ind;
    int val;
    Pair(int ind,int val){
        this.ind = ind;
        this.val = val;
    }
}
