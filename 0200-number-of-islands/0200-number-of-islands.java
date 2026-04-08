class Solution {
    public  int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        boolean [][]vis=new boolean[n][m];

        int cnt=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!vis[i][j] && grid[i][j]=='1'){
                    dfs(i, j, vis, grid);
                    cnt++;
                }
            }
        }
        return cnt;
    }

     int []delRow={-1, 0, 1, 0};
     int []delCol={0, 1, 0, -1};

    void dfs(int i, int j, boolean [][] vis, char[][]grid){
        vis[i][j]=true;

        for(int k=0;k<4;k++){
            int nrow=i+delRow[k];
            int ncol=j+delCol[k];

            if(nrow>=0 && nrow<grid.length && ncol>=0 && ncol<grid[0].length && !vis[nrow][ncol] && grid[nrow][ncol]=='1'){
                dfs(nrow, ncol, vis, grid);
            }
        }
    }
}