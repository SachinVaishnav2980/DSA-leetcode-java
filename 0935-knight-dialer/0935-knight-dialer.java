class Solution {
    int MOD = 1000000007;

    int[][] moves = {
        {4, 6},        // 0
        {6, 8},        // 1
        {7, 9},        // 2
        {4, 8},        // 3
        {0, 3, 9},     // 4
        {},             // 5
        {0, 1, 7},     // 6
        {2, 6},        // 7
        {1, 3},        // 8
        {2, 4}         // 9
    };

    public int knightDialer(int n) {

        int[][] dp = new int[n + 1][10];

        // Base case
        for (int d = 0; d <= 9; d++) {
            dp[1][d] = 1;
        }

        // Build DP
        for (int len = 2; len <= n; len++) {
            for (int d = 0; d <= 9; d++) {
                for (int next : moves[d]) {
                    dp[len][next] = (dp[len][next] + dp[len - 1][d]) % MOD;
                }
            }
        }

        // Final sum
        int ans = 0;
        for (int d = 0; d <= 9; d++) {
            ans = (ans + dp[n][d]) % MOD;
        }

        return ans;
    }
}
