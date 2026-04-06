class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int n=dungeon.length;
        int m=dungeon[0].length;
        int [][]dp=new int [n+1][m+1];
        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                if(i==n-1 && j==m-1){
                    if(dungeon[i][j]>0) dp[i][j]= 1;
                    else dp[i][j]=Math.abs(dungeon[i][j])+1;
                }else{
                    int right=(j+1>=m)?Integer.MAX_VALUE:dp[i][j+1];
                    int down=(i+1>=n)?Integer.MAX_VALUE:dp[i+1][j];

                    int res=Math.min(right, down)-dungeon[i][j];
                    dp[i][j]=res>0?res:1;
                }
            }
        }
        return dp[0][0];
    }
}