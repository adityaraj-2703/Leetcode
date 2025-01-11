package heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReduceArraySizeToHalf {
public int minSetSize(int[] arr) {
        Map<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            hm.put(arr[i],hm.getOrDefault(arr[i],0)+1);
        }
        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<Integer,Integer>>() {
            public int compare(Map.Entry<Integer,Integer> m1,Map.Entry<Integer,Integer> m2){
                return m2.getValue() - m1.getValue();
            }
        });
        
        for(Map.Entry<Integer,Integer> m : hm.entrySet()){
            pq.add(m);
        }
        int sum = 0;
        int ans = 0;
        while(!pq.isEmpty()){
            Map.Entry<Integer,Integer> m = pq.poll();
            sum +=m.getValue();
            ans++;
            if(sum >= arr.length){
                return ans;
            }
        }
        return ans;
    }
}
