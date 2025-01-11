package dp;

public class MinimumCostForTickets {
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[days.length];
        return minCostTicketsUtil(days,costs,0,dp,0);
    }
    public int minCostTicketsUtil(int[] days, int[] costs,int i,int[] dp,int tc){
        if(i==days.length){
            return 0;
        }
        int tc1=0;
        int j = i;
        int st = days[i];
        while(j<days.length && days[j] < st+1){
            tc1+=costs[0];
            j++;
        }
        tc1 += tc;
        tc1 += minCostTicketsUtil(days,costs,j,dp,tc1);

        int tc2 = 0;
        j = i;
        st = days[i];
        while(j<days.length && days[j] < st+7){
            tc2+=costs[1];
            j++;
        }
        tc2 += tc;
        tc2 += minCostTicketsUtil(days,costs,j,dp,tc2);

        int tc3 = 0;
        j = i;
        st = days[i];
        while(j<days.length && days[j] < st+1){
            tc3+=costs[2];
            j++;
        }
        tc3 += tc;
        tc3 += minCostTicketsUtil(days,costs,j,dp,tc3);

        return Math.min(tc1,Math.min(tc2,tc3));

    }
}
