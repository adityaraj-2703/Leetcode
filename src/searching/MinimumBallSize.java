package searching;

public class MinimumBallSize {
    public static int minimumSize(int[] nums, int maxOperations) {
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
        }
        int l=0;
        int r = sum;
        int ans = -1;
        while(l<=r){
            int m = l + (r-l)/2;
            if(find(m,nums,maxOperations)){
                ans = m;
                r = m-1;
            }
            else{
                l = m+1;
            }
        }
        return ans;
        
        
    }
    public static boolean find(int m,int[] nums,int maxOperations){
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(m>=nums[i]){
                count++;
            }
            else{
                if(nums[i]%m==0){
                    count += nums[i]/m;
                }
                else{
                    count += (nums[i]/m) + 1;
                }
                
            }
        }
        if(count <= (nums.length+maxOperations)){
            return true;
        }
        return false;
    }
}
