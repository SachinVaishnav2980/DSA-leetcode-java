class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n=image.length;
        int m=image[0].length;
        //BFS
        int incolor=image[sr][sc];
        if(incolor==color){
            return image;
        }

        int []delrow={-1, 0, 1, 0};
        int []delcol={0, 1, 0, -1};
        int [][]ans=image;
        solve(image, sr, sc, incolor, color, delrow, delcol, ans);
        return ans;
    }

    public void solve(int[][]image, int row, int col, int incolor, int color, int []delrow, 
        int[]delcol, int [][]ans){
            ans[row][col]=color;

            for(int i=0;i<4;i++){
                int sr=row+delrow[i];
                int sc=col+delcol[i];

                if(sr>=0 && sc>=0 && sr<image.length && sc<image[0].length && image[sr][sc]==incolor && ans[sr][sc]!=color){
                    solve(image, sr, sc, incolor, color, delrow, delcol, ans);
                }
            }
        }
}