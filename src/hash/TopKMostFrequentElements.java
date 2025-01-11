package hash;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.PriorityQueue;

public class TopKMostFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> hm = new TreeMap<>();
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
                
            hm.put(nums[i],hm.getOrDefault(nums[i],0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<Map.Entry<Integer, Integer>>(
            new Comparator<Map.Entry<Integer, Integer>>() {
                @Override
                public int compare(Map.Entry<Integer, Integer> a, Map.Entry<Integer, Integer> b) {
                    return b.getValue() - a.getValue();
                }
            }
        );
        pq.addAll(hm.entrySet());
        int c = 0;
        while(c<k){
            ans.add(pq.peek().getKey());
            c++;
        }
        int[] ans1 = new int[ans.size()];
        for(int i=0;i<ans1.length;i++){
            ans1[i] = ans.get(i);
        }
        return ans1;
    }
    
}
