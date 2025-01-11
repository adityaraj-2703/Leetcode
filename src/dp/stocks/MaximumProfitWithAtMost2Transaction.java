package dp.stocks;

public class MaximumProfitWithAtMost2Transaction {
    public static int maxProfit(int[] prices) {
        int max1 = 0;
        int max2 = 0;
        int lmax = 0;
        for(int i=1;i<prices.length;i++){
            if(prices[i] > prices[i-1]){
                lmax += prices[i] - prices[i-1];
            }
            else{
                if(max1 < lmax){
                    max2 = max1;
                    max1 = lmax;
                    
                }
                else if(max2 < lmax){
                    max2 = lmax;
                }
                lmax = 0;
            }
        }
        if(max1 < lmax){
            max2 = max1;
            max1 = lmax;
            
        }
        else if(max2 < lmax){
            max2 = lmax;
        }

        return max1 + max2;
    }
}
