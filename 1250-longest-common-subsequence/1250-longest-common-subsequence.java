class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m=text1.length();
        int n= text2.length();
        int [][]mat=new int[m+1][n+1];
        for(int []row:mat){
            Arrays.fill(row, -1);
        }
        return helper(text1, text2, 0, 0, mat);
    }

    int helper(String text1, String text2, int i, int j, int [][]mat){
        if(i==text1.length() || j==text2.length()){
            return 0;
        }

        if(mat[i][j]!=-1){
            return mat[i][j];
        }

        if(text1.charAt(i)==text2.charAt(j)){
            return mat[i][j]=1+helper(text1, text2, i+1, j+1, mat);
        }else{
            return mat[i][j]=Math.max(helper(text1, text2, i+1, j, mat),helper(text1, text2, i, j+1, mat));
        }
    }
}