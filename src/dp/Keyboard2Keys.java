package dp;

public class Keyboard2Keys {
    public int minSteps(int n) {
        
        int[] dp = new int[n+1];
        for(int i=2;i<=n;i++){
            if(dp[i]==0){
                dp[i] = i;
            }
            
            if((2*i) <= n){
                if(dp[2*i]!=0){
                    dp[2*i] = Math.min(dp[2*i], dp[i]+2);
                }
                else{
                    dp[2*i] = (dp[i]+2);
                }
            }
            for(int j=3;j*i <= n ; j++){
                if(dp[j*i]!=0){
                    dp[j*i] = Math.min(dp[j*i], dp[(j-1)*i]+1);
                }
                else{
                    dp[j*i] = (dp[(j-1)*i]+1);
                }
            }
            
        }
        for(int i=0;i<=n;i++){
            System.out.println(i + "---" + dp[i]);
        }
        return dp[n];
         
    }
}
