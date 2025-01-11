package twoPointers;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        int i=0;
        int j = n-1;
        int c=0;
        while(j>=0 && nums[j] == val){
            j--;
            c++;
        }
        if(j == n){
            return n;
        }
        
        while(i<=j){
            if(nums[i] == val){
                c++;
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
                i++;
                j--;
            }
            else{
                i++;
            }
        }
        return c;
    }

}
