class Solution {
    public int[][] generateMatrix(int n) {
        int [][]matrix=new int[n][n];

        int top=0;
        int right=n-1;
        int left=0;
        int bottom=n-1;
        int num=1;

        while (top<=bottom && left<=right) {
            for(int j=left;j<=right;j++){
                matrix[top][j]=num++;
            }
            top++;

            for(int j=top;j<=bottom;j++){
                matrix[j][right]=num++;
            }
            right--;

            if(top<=bottom){
                for(int j=right;j>=left;j--){
                matrix[bottom][j]=num++;
            }
            bottom--;
            }
            
            if(left<=right){
                for(int j=bottom;j>=top;j--){
                matrix[j][left]=num++;
            }
            left++;
            }
        }
        return matrix;
    }
}