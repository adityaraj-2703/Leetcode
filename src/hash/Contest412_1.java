package hash;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Contest412_1 {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        Map<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            
            hm.put(i,nums[i]);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<Map.Entry<Integer, Integer>>(
            new Comparator<Map.Entry<Integer, Integer>>() {
                @Override
                public int compare(Map.Entry<Integer, Integer> a, Map.Entry<Integer, Integer> b) {
                    
                    if(a.getValue() == b.getValue()){
                        return a.getKey() - b.getKey();
                    }
                    else{
                        return a.getValue() - b.getValue();
                    }
                }
            }
        );
        pq.addAll(hm.entrySet());
        
        
        
        for(int i=0;i<k;i++){
            Map.Entry<Integer, Integer> l = pq.poll(); 
            l.setValue(l.getValue() * 2);
            pq.add(l);
            
        }
        int[] ans = new int[pq.size()];
        
        while(!pq.isEmpty()){
            Map.Entry<Integer, Integer> l = pq.poll(); 
            ans[l.getKey()] = l.getValue();
            
        }
        return ans;
    }
}
