package searching;

public class SearchInRotatedArray {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int search(int[] nums, int target) {
        if(nums.length==1){
            if(nums[0] == target){
                return 0;
            }
            return -1;
        }
        int st = nums[0];
        int ind = -1;
        int l = 0;
        int r = nums.length-1;
        while(l<=r){
            int m = l + (r-l)/2;
            if(nums[m] < nums[0]){
                ind = m;
                r = m-1;
            }
            
            else{
                l = m+1;
            }
        }
        if(ind ==-1){
            l=0;
            r = nums.length-1;
        }   
        else if(target >= nums[0]){
            l=0;
            r = ind-1;
        }
        else{
            l = ind;
            r = nums.length-1;
        }
        return binarySearch(nums,l,r,target);
    }
    public int binarySearch(int[] nums,int st,int en,int target){
        if(st > en){
            return -1;
        }
        while(st <= en){
            int m = st + (en-st)/2;
            if(nums[m] == target){
                return m;
            }
            else if(nums[m] > target){
                en = m-1;
            }
            else{
                st = m+1;
            }
        }
        return -1;
    }
}


