class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        List<Integer> list=new ArrayList<>();
        int top=0;
        int right=m-1;
        int left=0;
        int bottom=n-1;

        while (top<=bottom && left<=right) {
            for(int j=left;j<=right;j++){
                list.add(matrix[top][j]);
            }
            top++;

            for(int j=top;j<=bottom;j++){
                list.add(matrix[j][right]);
            }
            right--;

            if(top<=bottom){
                for(int j=right;j>=left;j--){
                list.add(matrix[bottom][j]);
            }
            bottom--;
            }
            
            if(left<=right){
                for(int j=bottom;j>=top;j--){
                list.add(matrix[j][left]);
            }
            left++;
            }
        }
        return list;
    }
}