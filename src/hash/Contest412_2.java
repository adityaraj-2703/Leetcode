package hash;

import java.util.HashMap;
import java.util.Map;

public class Contest412_2 {
    public int countPairs(int[] nums) {
        int count=0;
        for(int i=0;i<nums.length;i++){
            Map<Integer,Integer> hm = new HashMap<>();
            int n = nums[i];
            while(n>0){
                hm.put(n%10, hm.getOrDefault(n%10,0) + 1);
                n = n/10;
            }
            
            for(int j=i+1;j<nums.length;j++){
                Map<Integer,Integer> hm1 = new HashMap<>();
                int n1 = nums[j];
                while(n1>0){
                    hm1.put(n1%10, hm1.getOrDefault(n1%10,0) + 1);
                    n1 = n1/10;
                }
                boolean flag = true;
                if(hm1.size() > hm.size()){
                    for(Map.Entry<Integer,Integer> e : hm1.entrySet()){
                        int l = e.getKey();
                        int l1 = hm.getOrDefault(l,-1);
                        if(l1 == e.getValue() || l==0 || e.getValue()==0){
                            continue;
                        }
                        else{
                            flag = false;
                            break;
                        }
                    }
                }
                else{
                    for(Map.Entry<Integer,Integer> e : hm.entrySet()){
                        int l = e.getKey();
                        int l1 = hm1.getOrDefault(l,-1);
                        if(l1 == e.getValue() || l1==0 || e.getValue()==0){
                            continue;
                        }
                        else{
                            flag = false;
                            break;
                        }
                    }
                }
                
                if(flag){
                    count++;
                }
            }
        }
        return count;
    }
    
}
class Pair{
    
}