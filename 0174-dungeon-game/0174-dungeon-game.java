class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int n=dungeon.length;
        int m=dungeon[0].length;
        int [][]dp=new int [201][201];
        for(int []a:dp) Arrays.fill(a, -1);
        return solve(0, 0, dungeon, dp);
    }

    int solve(int i, int j, int [][]mat, int [][]dp){
        int n=mat.length;
        int m=mat[0].length;

        if(i>=n || j>=m) return Integer.MAX_VALUE;
        
        if(dp[i][j]!=-1) return dp[i][j];

        if(i==n-1 && j==m-1){
            if(mat[i][j]>0) return 1; 
            else return Math.max(1, 1 - mat[i][j]);
        }

        int right=solve(i, j+1, mat, dp);
        int down=solve(i+1, j, mat, dp);

        int res=Math.min(right, down)-mat[i][j];

        return dp[i][j]=res>0?res:1;
    }
}