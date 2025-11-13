class Solution {
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int dp[][]=new int[n][amount+1];
        for(int []row:dp){
            Arrays.fill(row, -1);
        }

        int ans=minChange(coins, amount, 0, dp);
        return ans >= Integer.MAX_VALUE/2 ? -1 : ans;
    }

    int minChange(int []coins, int amount, int index, int [][]dp){

        //Base case
        if(amount==0) return 0;

        if(index==coins.length) return Integer.MAX_VALUE/2;

        if(dp[index][amount]!=-1){
            return dp[index][amount];
        }

        //pick 
        int pick=Integer.MAX_VALUE/2;
        if(coins[index]<=amount){
         pick=1+minChange(coins, amount-coins[index], index, dp);
        }
        //not pick
        int notpick=minChange(coins, amount, index+1, dp);

        return dp[index][amount]=Math.min(pick, notpick);
    }
}