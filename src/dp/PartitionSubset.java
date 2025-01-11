package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

public class PartitionSubset {
    public boolean canPartition(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] pre = new int[nums.length];
        int[] suf = new int[nums.length];
        TreeMap<Integer,List<Integer>> hm = new TreeMap<>();
        hm.put(0,Arrays.asList(1));
        pre[0] = nums[0];
        suf[n-1] = nums[n-1];
        for(int i=1;i<nums.length;i++){
            pre[i] = pre[i-1] + nums[i];
            suf[n-i-1] = suf[n-i] + nums[n-i-1];
        }
        for(int i=0;i<nums.length-1;i++){
            if(pre[i] == suf[i+1]){
                return true;
            }
        }
        
        return false;

    }
}
