package searching;

public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if(m==0){
            return nums2[(n)/2];
        }
        else if(n==0){
            return nums1[(m)/2];
        }
        double ans1 = -1; 
        double ans2 = -1;
        double l = Math.min(nums1[0], nums2[0]);
        double r = Math.max(nums1[m-1], nums2[n-1]);
        double ans = 0;
        while(l <= r){
            double temp = l + ((r-l)/2);
            int findless1 = find(temp,nums1);
            int findless2 = find(temp,nums2);
            
            int f = findless1 + findless2 + 2;
            
            if((m+n)%2 != 0 && f == ((m+n)/2)+1 ){
                ans = temp;
                l = (temp + (double)(1));
            }
            else if((m+n)%2 == 0){
                ans = temp;
                
                if(f == ((m+n)/2)){
                    ans1 = temp;
                    l = temp;
                }
                else if(f == (m+n)/2 + 1){
                    if(ans2!=-1){
                        ans2 = Math.min(temp,ans2);
                    }
                    else{
                        ans2 = temp;
                    }
                    r  = temp;  
                    
                }
                // l = temp+1;
            }
            else if(f < (m+n)/2){
                l = temp+1;
            }
            else{
                r = temp-1;
            }
        }
        if(ans1!=-1 && ans2!=-1){
            return (ans1+ ans2) / 2.0;
        }
        return ans;
    }
    static int find(double k,int[] nums){
        int ans = -1;
        int l = 0;
        int r = nums.length-1;
        while(l<=r){
            int m = l + ((r-l)/2);
            if((double)nums[m] <= k){
                ans = m;
                l = m+1;
            }
            else{
                r = m-1;
            }
        }
        return ans;
    }
}
