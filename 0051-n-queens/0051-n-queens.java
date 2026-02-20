class Solution {
    public List<List<String>> solveNQueens(int n) {
        boolean [][]vis=new boolean[n][n];
        List<List<String>> ans=new ArrayList<>();
        solve(vis, 0, n, ans);
        return ans;
    }

    void solve(boolean [][] vis, int row, int n, List<List<String>> ans){
        if(row>=n){
            List<String> res=display(vis);
            ans.add(res);
            return ;
        }

        for(int col=0;col<n;col++){
            if(isSafe(vis, row, n, col)){
                vis[row][col]=true;
                solve(vis, row+1, n, ans);
                vis[row][col]=false;
            }
        }
        return ;
    }

    boolean isSafe(boolean [][]vis, int row, int n, int col){
        // check vertical row
        for(int i=0;i<row;i++){
            if(vis[i][col]){
                return false;
            }
        }

        //check diagonal left
        int maxLeft=Math.min(row, col);
        for(int i=1;i<=maxLeft;i++){
            if(vis[row-i][col-i]){
                return false;
            }
        }

        //check diagonal right
        int maxRight=Math.min(row, n-col-1);
        for(int i=1;i<=maxRight;i++){
            if(vis[row-i][col+i]){
                return false;
            }
        }
        return true;
    }

    public List<String> display(boolean [][]vis){
        List<String> res=new ArrayList<>();
        for(boolean [] row: vis){
            String s="";
            for(boolean el: row){
                if(el){
                    s+='Q';
                }else{
                    s+='.';
                }
            }
            res.add(s);
        }
        return res;
    }
}