class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        int []dp=new int [n+2];
        dp[n]=0;
        dp[n+1]=0;

        for(int i=n-1;i>=0;i--){
            int rob=nums[i]+dp[i+2];
            int notrob=dp[i+1];

            dp[i]=Math.max(rob,notrob);
        }

        return dp[0];
    }
}