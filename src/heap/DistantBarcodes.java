package heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class DistantBarcodes {
    public int[] rearrangeBarcodes(int[] barcodes) {
        
        
        Map<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<barcodes.length;i++){
            hm.put(barcodes[i],hm.getOrDefault(barcodes[i], 0)+1);
        }
        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<Integer,Integer>>() {
            public int compare(Map.Entry<Integer,Integer> m1, Map.Entry<Integer,Integer> m2){
                return m2.getValue() - m1.getValue();
            }
        });
        if(hm.size()==1){
            return barcodes;
        }
        for(Map.Entry<Integer,Integer> m : hm.entrySet()){
            pq.add(m);
        }
        int[] ans = new int[barcodes.length];
        int ind=0;
        while(pq.isEmpty()){
            Map.Entry<Integer,Integer> m1 = pq.poll();
            Map.Entry<Integer,Integer> m2 = pq.poll();
            ans[ind++] = m1.getKey();
            ans[ind++] = m2.getKey();
            if(m1.getValue() > 1){
                m1.setValue(m1.getValue()-1);
                pq.add(m1);
            }
            if(m2.getValue() > 1){
                m2.setValue(m2.getValue()-1);
                pq.add(m2);
            }
        }
        return ans;
        
        
    }
}

