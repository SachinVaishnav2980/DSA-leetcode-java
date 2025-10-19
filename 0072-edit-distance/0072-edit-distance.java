class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = -1;
            }
        }

        return match(word1, word2, 0, 0, n, m, dp);
    }

    int match(String word1, String word2, int i, int j, int n, int m, int[][] dp) {
        // Base cases
        if (i == n && j == m) return 0;
        if (i == n) return m - j;
        if (j == m) return n - i;

        if (dp[i][j] != -1) return dp[i][j];

        if (word1.charAt(i) == word2.charAt(j)) {
            dp[i][j] = match(word1, word2, i + 1, j + 1, n, m, dp);
            return dp[i][j];
        }

        int insert = 1 + match(word1, word2, i, j + 1, n, m, dp);
        int delete = 1 + match(word1, word2, i + 1, j, n, m, dp);
        int replace = 1 + match(word1, word2, i + 1, j + 1, n, m, dp);

        dp[i][j] = Math.min(insert, Math.min(delete, replace));
        return dp[i][j];
    }
}
