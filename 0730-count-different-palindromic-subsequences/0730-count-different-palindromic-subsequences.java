import java.util.Arrays;

class Solution {
    int MOD = 1000000007;

    public int countPalindromicSubsequences(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }

        return helper(s, 0, n - 1, dp);
    }

    int helper(String s, int i, int j, int[][] dp) {
        if (i > j) return 0;
        if (i == j) return 1;

        if (dp[i][j] != -1) return dp[i][j];

        long res = 0;
        boolean match = s.charAt(i) == s.charAt(j);

        if (!match) {
            res = (long)helper(s, i + 1, j, dp)
                + helper(s, i, j - 1, dp)
                - helper(s, i + 1, j - 1, dp);

            return dp[i][j] = (int)((res % MOD + MOD) % MOD);
        }

        int low = i + 1;
        int high = j - 1;

        while (low <= high && s.charAt(low) != s.charAt(i)) low++;
        while (low <= high && s.charAt(high) != s.charAt(j)) high--;

        if (low > high) {
            res = 2L * helper(s, i + 1, j - 1, dp) + 2;
        } else if (low == high) {
            res = 2L * helper(s, i + 1, j - 1, dp) + 1;
        } else {
            res = 2L * helper(s, i + 1, j - 1, dp)
                - helper(s, low + 1, high - 1, dp);
        }

        return dp[i][j] = (int)((res % MOD + MOD) % MOD);
    }
}