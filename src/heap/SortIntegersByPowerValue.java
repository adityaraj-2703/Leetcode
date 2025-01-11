package heap;

import java.util.*;

public class SortIntegersByPowerValue {
    public static int getKth(int lo, int hi, int k) {
        PriorityQueue<Pair1> pq = new PriorityQueue<>(new Comparator<Pair1>(){
            public int compare(Pair1 p1,Pair1 p2){
                if(p1.val!=p2.val){
                    return p2.val - p1.val;
                }
                return p2.ind - p1.ind;
            }
        });
        int[] arr = new int[hi-lo+1];
        for(int i=lo;i<=hi;i++){
            int count = 0;
            int c = i;
            while(c!=1){
                if(c%2==0){
                    c /= 2;
                }
                else{
                    c = 3*c + 1;
                }
                count++;
            }
            
            if(pq.size()<k){
                pq.add(new Pair1(i,count));
            }
            else{
                pq.add(new Pair1(i,count));
                pq.poll();
                
            }

        }
        
        return pq.poll().ind;
    }
    static class Pair1{
        int ind;
        int val;
        Pair1(int ind,int val){
            this.ind = ind;
            this.val = val;
        }
    }
    
}

