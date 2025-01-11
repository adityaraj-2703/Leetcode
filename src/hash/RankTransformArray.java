package hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RankTransformArray {
    public int[] arrayRankTransform(int[] arr) {
        Map<Integer,Integer> hm = new HashMap<>();
        
        int[] ans = arr;
        Arrays.sort(ans);
        for(int i=0;i<arr.length;i++){
            hm.put(ans[i],i+1);
        }
        
        for(int i=0;i<arr.length;i++){
            ans[i] = hm.get(arr[i]);
        }
        return ans;
        
    }
}
