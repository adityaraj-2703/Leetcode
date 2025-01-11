package hash;

import java.util.HashMap;
import java.util.Map;

public class LongestBitwiseCombination {
    public int largestCombination(int[] candidates) {
        Map<Integer,Integer> hm = new HashMap<>();
        hm.put(candidates[0],1);
        int temp = candidates[0];
        for(int i=1;i<candidates.length;i++){
            int k = temp&candidates[i];
            hm.put(k,hm.getOrDefault(k,0)+1);
            hm.put(candidates[i],hm.getOrDefault(candidates[i],0)+1);
        }
        int max = 0;
        for(Map.Entry<Integer,Integer> m : hm.entrySet()){
            max = Math.max(max,m.getValue());
        }
        return max;
    }
}
