class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int inicolor=image[sr][sc];
        if (inicolor == color) return image;
        int [][]ans=image;
        int []delRow={-1, 0, 1, 0};
        int []delCol={0, 1, 0, -1};
        dfs(sr, sc, ans, inicolor, color, image, delRow, delCol);
        return ans;
    }

    public void dfs(int row, int col, int[][]ans, int inicolor, int newColor, int [][] image, int []delRow, int []delCol){
        ans[row][col]=newColor;
        int n=image.length;
        int m=image[0].length;
        for(int i=0;i<4;i++){
            int newRow= row + delRow[i];
            int newCol= col+ delCol[i];
            if(newRow>=0 && newRow<n && newCol>=0 && newCol<m && image[newRow][newCol]==inicolor && ans[newRow][newCol  ]!=newColor)
            dfs(newRow, newCol, ans, inicolor, newColor, image, delRow, delCol);
        }
    }
}