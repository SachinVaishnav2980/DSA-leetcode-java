class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if (n == 1) return nums[0];

        int dp1[] = new int[n];
        int dp2[] = new int[n];
        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);

        return Math.max(
            solve(0, n - 1, nums, dp1),  // exclude last house
            solve(1, n, nums, dp2)       // exclude first house
        );
    }

    int solve(int i, int n, int[] nums, int[] dp) {
        if (i >= n) return 0;

        if (dp[i] != -1) return dp[i];

        int pick = nums[i] + solve(i + 2, n, nums, dp);
        int notpick = solve(i + 1, n, nums, dp);

        return dp[i] = Math.max(pick, notpick);
    }
}