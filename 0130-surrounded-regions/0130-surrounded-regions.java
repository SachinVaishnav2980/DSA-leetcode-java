class Solution {
    int []delRow={-1, 0, 1, 0};
    int []delCol={0, 1, 0, -1};

    public void solve(char[][] board) {
        int n=board.length;
        int m=board[0].length;

        boolean [][]vis=new boolean[n][m];
        
        for(int i=0;i<n;i++){
            // first column
            if(!vis[i][0] && board[i][0]=='O'){
                dfs(i, 0, board, vis);
            }
            // last column
            if(!vis[i][m-1] && board[i][m-1]=='O'){
                dfs(i, m-1, board, vis);
            }
        }


        for(int j=0;j<m;j++){
            // first row
            if(!vis[0][j] && board[0][j]=='O'){
                dfs(0, j, board, vis);
            }
            // last row
            if(!vis[n-1][j] && board[n-1][j]=='O'){
                dfs(n-1, j, board, vis);
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!vis[i][j] && board[i][j]=='O'){
                    board[i][j]='X';
                }
            }
        }
    }

    public void dfs(int row, int col, char [][]grid, boolean [][]vis){
        vis[row][col]=true;
        int n=grid.length;
        int m=grid[0].length;
        for(int i=0;i<4;i++){
            int nrow=row+delRow[i];
            int ncol=col+delCol[i];

            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && !vis[nrow][ncol] && grid[nrow][ncol]=='O'){
                dfs(nrow, ncol, grid, vis);
            }
        }
    }
}