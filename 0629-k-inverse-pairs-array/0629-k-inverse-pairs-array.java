class Solution {
    //Bottom-Up
    int MOD=1000000007;
    public int kInversePairs(int n, int k) {
        int [][]dp=new int[n+1][k+1];

        //Initialization
        for(int i=0;i<=n;i++){
            dp[i][0]=1;
        }

        //Solution
        for(int i=1;i<=n;i++){
            long cum=1;
            for(int j=1;j<=k;j++){
                cum+=dp[i-1][j];
                if(j>=i){
                    cum-=dp[i-1][j-i];
                }
                dp[i][j]=(int)(cum%MOD);
            }
        }
        return dp[n][k];
    }
}