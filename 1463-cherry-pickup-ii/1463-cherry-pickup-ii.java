class Solution {
    int n;
    int m;
    int [][][]memo=new int [71][71][71];
    public int cherryPickup(int[][] grid) {
        n=grid.length;
        m=grid[0].length;
        for(int i=0;i<memo.length;i++){
            for(int j=0;j<memo[0].length;j++){
                for(int k=0;k<memo[0][0].length;k++){
                    memo[i][j][k]=-1;
                }
            }
        }
        return solve(grid, 0, 0, m-1);
    }

    int solve(int [][]grid, int row, int c1, int c2){
        if(row>=grid.length) return 0;

        if(memo[row][c1][c2]!=-1) return memo[row][c1][c2];

        
        int cherry=grid[row][c1];
        if(c1!=c2){
            cherry+=grid[row][c2];
        }
        int ans=0;
        for(int val1=-1;val1<=1;val1++){
            for(int val2=-1;val2<=1;val2++){
                int nrow=row+1;
                int col1=c1+val1;
                int col2=c2+val2;
                if(col1>=0 && col1<m && col2>=0 && col2<m){
                    ans=Math.max(ans, solve(grid, nrow, col1, col2));
                }
            }
        }
        return memo[row][c1][c2]=cherry+ans;
    }
}