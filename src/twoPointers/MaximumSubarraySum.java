package twoPointers;

import java.util.HashSet;

public class MaximumSubarraySum {
    public long solve(int[] nums, int k) {
        HashSet<Integer> hs = new HashSet<>();
        int i = 0;
        hs.add(nums[i]);
        if(hs.size()==k){
            return nums[i];
        }
        long sum = 0;
        long temp = nums[i];
        int j = i+1;
        while(j<nums.length){
            if(hs.contains(nums[j]) && hs.size()==k){
                if(temp > sum){
                    sum = temp;
                }
                hs.clear();
                
                i=j;
                hs.add(nums[i]);
                temp = nums[i];
            }
            else if(!hs.contains(nums[j]) && hs.size()==k){
                if(temp > sum){
                    sum = temp;
                }
                temp = temp - nums[i] + nums[j];
                hs.remove(nums[i]);
                hs.add(nums[j]);
                if(temp > sum){
                    sum = temp;
                }
                i++;
            }
            else if(hs.contains(nums[j]) && hs.size()!=k){
                hs.clear();
                i=j;
                hs.add(nums[i]);
                temp = nums[j];
            }
            else{
                hs.add(nums[j]);
                temp +=nums[j];
                if(hs.size()==k){
                    if(temp > sum){
                        sum = temp;
                    }
                }
            }
            j++;
        }
        return sum;
        
    }
    
}
