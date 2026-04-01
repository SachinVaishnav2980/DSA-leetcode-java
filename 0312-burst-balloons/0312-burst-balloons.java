class Solution {
    public int maxCoins(int[] nums) {
        int n=nums.length;

        int []newNums=new int[n+2];
        newNums[0]=1;
        newNums[n+1]=1;
        for(int i=0;i<n;i++){
            newNums[i+1]=nums[i];
        }
        int [][]dp=new int [301][301];
        int max=helper(1, nums.length, newNums, dp);
        return max;
    }

    private int helper(int left, int right, int []nums, int [][]dp){
        //Base case
        if(left>right) return 0;

        //Hypothesis
        if(dp[left][right]!=0) return dp[left][right];
        int ans = Integer.MIN_VALUE;
        for(int i=left; i<=right; i++){
           int coins= nums[left-1] * nums[i] * nums[right+1] + helper(left,i-1,nums, dp) + helper(i+1,right,nums, dp);
           ans=Math.max(ans, coins);
        }
        return dp[left][right]=ans;        
    }
}