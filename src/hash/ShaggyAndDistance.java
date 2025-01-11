package hash;

import java.util.HashMap;

public class ShaggyAndDistance {
     public int solve(int[] A) {
        int min = Integer.MAX_VALUE;
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<A.length;i++){
            int l = hm.getOrDefault(A[i], -1);
            if(l!=-1){
                int j = l;
                min = Math.min(min, Math.abs(j-i));
            }
            else{
                hm.put(A[i],i);
            }
        }
        return min;
    }
}
