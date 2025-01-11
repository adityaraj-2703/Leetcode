package hash;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        Set<Integer> hs = new TreeSet<>();
        for(int i=0;i<nums.length;i++){
            hs.add(nums[i]);
        }
        int i=1;
        Iterator<Integer> iterator = hs.iterator();
        while(iterator.hasNext()){
            int a = iterator.next();
            if(a > i){
                return i;
            }
            i++;

        }
        return i;
    }
}
