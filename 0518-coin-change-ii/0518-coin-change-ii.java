class Solution {
    public int change(int amount, int[] coins) {
        int n=coins.length;
        int [][]dp=new int [n][amount+1];
        for(int []row:dp){
            Arrays.fill(row, -1);
        }
        return minChange(coins, amount, 0, dp);
    }

    int minChange(int []coins, int amount, int index, int [][]dp){
        //Base case
        if(amount==0){
            return 1;
        }

        if(index==coins.length) return 0;

        if(dp[index][amount]!=-1) return dp[index][amount];
        //pick 
        int pick=0;
        if(coins[index]<=amount){
           pick= minChange(coins, amount-coins[index], index, dp);
        }
        //not pick
        int notpick=minChange(coins, amount, index+1, dp);

        return dp[index][amount]=pick+notpick;
    }
}