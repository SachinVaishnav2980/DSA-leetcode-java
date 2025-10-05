class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        int[][] dirs = { {0, 1}, {1, 0}, {0, -1}, {-1, 0} };

        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            dfs(heights, pacific, i, 0, dirs);      
            dfs(heights, atlantic, i, m - 1, dirs); 
        }
        for (int j = 0; j < m; j++) {
            dfs(heights, pacific, 0, j, dirs);     
            dfs(heights, atlantic, n - 1, j, dirs); 
        }

        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    ans.add(Arrays.asList(i, j));
                }
            }
        }
        return ans;
    }

    void dfs(int[][] heights, boolean[][] visited, int row, int col, int[][] dirs) {
        if (visited[row][col]) return; 
        visited[row][col] = true;

        for (int[] d : dirs) {
            int ni = row + d[0];
            int nj = col + d[1];
            if (isValid(ni, nj, heights.length, heights[0].length) 
                && !visited[ni][nj]
                && heights[ni][nj] >= heights[row][col]) {
                dfs(heights, visited, ni, nj, dirs);
            }
        }
    }

    boolean isValid(int row, int col, int n, int m) {
        return row >= 0 && col >= 0 && row < n && col < m;
    }
}