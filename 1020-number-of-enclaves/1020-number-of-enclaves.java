class Solution {
    int []delRow={-1, 0, 1, 0};
    int []delCol={0, 1, 0, -1};

    public int numEnclaves(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        boolean [][]vis=new boolean[n][m];
        for(int i=0;i<m;i++){
            
            //first row
            if(!vis[0][i] && grid[0][i]==1){
                dfs(0, i, grid, vis);
            }
            
            //last row
            if(!vis[n-1][i] && grid[n-1][i]==1){
                dfs(n-1, i, grid, vis);
            }
            
        }
        
        for(int i=0;i<n;i++){
            //first col
            if(!vis[i][0] && grid[i][0]==1){
                dfs(i, 0, grid, vis);
            }
            //last col
            if(!vis[i][m-1] && grid[i][m-1]==1){
                dfs(i, m-1, grid, vis);
            }
        }
        
        int cnt=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!vis[i][j] && grid[i][j]==1){
                    cnt++;
                }
            }
        }
        return cnt;   
    }
    
    void dfs(int row, int col, int [][]grid, boolean [][]vis){
        vis[row][col]=true;
        
        for(int i=0;i<4;i++){
            int nr=row+delRow[i];
            int nc=col+delCol[i];
            
            if(nr>=0 && nr<grid.length && nc>=0 && nc<grid[0].length
                && !vis[nr][nc] && grid[nr][nc]==1){
                    dfs(nr, nc, grid, vis);
            }
        }
    }
}