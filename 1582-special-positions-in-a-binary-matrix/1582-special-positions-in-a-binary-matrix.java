class Solution {
    public int numSpecial(int[][] mat) {
        int count=0;
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==1){
                    boolean left=solveRow(mat, i, j);
                    boolean right=solveCol(mat, i, j);
                    if(left && right){
                        count++;
                    }
                }
            }
        }
        return count;
    }

    boolean solveRow(int [][]mat, int i, int j){
        int n=mat.length;
        int m=mat[0].length;

        for(int k=0;k<n;k++){
            if(k!=i && mat[k][j]==1){
                return false;
            }
        }
        return true;
    }

    boolean solveCol(int [][]mat, int i, int j){
        int n=mat.length;
        int m=mat[0].length;

        for(int k=0;k<m;k++){
            if(k!=j && mat[i][k]==1){
                return false;
            }
        }
        return true;
    }
}