class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;

        int[] newNums = new int[n + 2];
        newNums[0] = 1;
        newNums[n + 1] = 1;

        for (int i = 0; i < n; i++) {
            newNums[i + 1] = nums[i];
        }

        int[][] dp = new int[n + 2][n + 2];

        for (int left = n; left >= 1; left--) {
            for (int right = left; right <= n; right++) {

                int ans = Integer.MIN_VALUE;

                for (int i = left; i <= right; i++) {
                    int coins = newNums[left - 1] * newNums[i] * newNums[right + 1]
                              + dp[left][i - 1]
                              + dp[i + 1][right];

                    ans = Math.max(ans, coins);
                }

                dp[left][right] = ans;  
            }
        }

        return dp[1][n];
    }
}