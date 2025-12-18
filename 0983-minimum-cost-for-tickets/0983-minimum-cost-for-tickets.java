class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n=days.length;
        boolean[] travel = new boolean[366];
        for (int d : days) travel[d] = true;

        int []dp=new int[366];
        for(int d=1;d<=365;d++){
            if(!travel[d]){
                dp[d]=dp[d-1];
            }else{
                dp[d]=Math.min(dp[d - 1] + costs[0], Math.min(
                    dp[Math.max(0, d - 7)] + costs[1],
                    dp[Math.max(0, d - 30)] + costs[2]
                    )
                );
            }
        }
        return dp[365];
    }
}