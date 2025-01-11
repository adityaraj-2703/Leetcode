package twoPointers;

public class SubArraySum {
    public int[] solve(int[] A, int B) {
        
        int[] presum = new int[A.length+1];
        presum[0] = 0;
        presum[1] = A[0];
        for(int i=2;i<presum.length;i++){
            presum[i] = presum[i-1] + A[i-1];
        }
        int i=0;
        int j = A.length-1;
        while(i!=j){
            if((presum[j] - presum[i]) == B){
                int[] ans = new int[j-i];
                int c = i;
                for(int k=0;k<ans.length;k++){
                    ans[k] = A[c];
                    c++; 
                    
                }
                return ans;
            }
            else if((presum[j] - presum[i]) > B){
                j--;
            }
            else{
                i++;
            }
        }
        int[] a = new int[1];
        a[0] = -1;
        return a;
    }
    
}
