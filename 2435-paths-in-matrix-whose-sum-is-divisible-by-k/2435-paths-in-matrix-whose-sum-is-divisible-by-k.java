class Solution {
    static final int MOD = 1_000_000_007;
    int[][][] memo;
    int m, n, K;
    int[][] grid;

    public int numberOfPaths(int[][] grid, int k) {
        this.grid = grid;
        this.K = k;
        this.m = grid.length;
        this.n = grid[0].length;

        memo = new int[m][n][k];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                for (int r = 0; r < k; r++)
                    memo[i][j][r] = -1;

        return dfs(0, 0, 0);
    }

    int dfs(int r, int c, int rem) {

        // include current cell
        rem = (rem + grid[r][c]) % K;

        // base case
        if (r == m - 1 && c == n - 1)
            return rem == 0 ? 1 : 0;

        // memo check
        if (memo[r][c][rem] != -1)
            return memo[r][c][rem];

        long ways = 0;

        // move right
        if (c + 1 < n)
            ways += dfs(r, c + 1, rem);

        // move down
        if (r + 1 < m)
            ways += dfs(r + 1, c, rem);

        memo[r][c][rem] = (int)(ways % MOD);
        return memo[r][c][rem];
    }
}
