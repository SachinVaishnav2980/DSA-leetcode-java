class Solution {
    int []dp=new int[1001];
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        Arrays.fill(dp, -1);
        if(n<2) return cost[0];
        return Math.min(solve(cost, 0), solve(cost, 1));
    }

    int solve(int []cost, int i){
        if(i>=cost.length) return 0;
        if(dp[i]!=-1) return dp[i];
        int step1=cost[i]+solve(cost, i+1);
        int step2=cost[i]+solve(cost, i+2);

        return dp[i]=Math.min(step1, step2);
    }
}