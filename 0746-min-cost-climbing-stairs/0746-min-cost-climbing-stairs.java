class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        int []dp=new int[n+1];
        Arrays.fill(dp, -1);
        return Math.min(helper(cost, 0, n, dp), helper(cost, 1, n, dp));
    }

    int helper(int []cost, int i, int n, int []dp){
        if(i>=n) return 0;

        if(dp[i]!=-1) return dp[i];

        int step1=helper(cost, i+1, n, dp);
        int step2=helper(cost, i+2, n, dp);

        dp[i]=cost[i]+Math.min(step1, step2);
        return dp[i];
    }
}