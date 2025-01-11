package heap;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class KClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            public int compare(Pair p1,Pair p2){
                if(p1.diff != p2.diff){
                    return p1.diff - p2.diff;
                }
                else{
                    return p1.val - p2.val;
                }
            }
        });
        for(int i=0;i<arr.length;i++){
            pq.add(new Pair(arr[i],Math.abs(arr[i]-x)));
        }
        List<Integer> ans = new ArrayList<>();
        while(!pq.isEmpty() && k>0){
            ans.add(pq.poll().val);
        }
        Collections.sort(ans);
        return ans;
    }
}

class Pair{
    int val;
    int diff;
    Pair(int val,int diff){
        this.val = val;
        this.diff = diff;
    }
}
