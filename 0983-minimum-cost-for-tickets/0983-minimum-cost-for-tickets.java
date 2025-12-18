class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n=days.length;
        int []dp=new int[n+1];
        dp[n]=0;
        for(int i=n-1;i>=0;i--){

            int j=i;
            //1-Day pass
            while(j<days.length && days[j]<days[i]+1){
                j++;
            }
            int oneday=costs[0]+dp[j];

            //7-Day pass
            while(j<days.length && days[j]<days[i]+7){
                j++;
            }
            int sevenday=costs[1]+dp[j];

            //30-Day pass
            while(j<days.length && days[j]<days[i]+30){
                j++;
            }
            int thirtyday=costs[2]+dp[j];

            dp[i]=Math.min(oneday, Math.min(sevenday, thirtyday));
        }
        return dp[0];
    }
}