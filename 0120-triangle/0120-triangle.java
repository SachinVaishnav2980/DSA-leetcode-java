class Solution {
    //Bottom-Up
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        int [][]dp=new int[n+1][n+1];

        //Solution
        for(int i=n-1;i>=0;i--){
            for(int j=i;j>=0;j--){
                dp[i][j]=triangle.get(i).get(j)+Math.min(dp[i+1][j],dp[i+1][j+1]);
            }
        }
        return dp[0][0];
    }
}