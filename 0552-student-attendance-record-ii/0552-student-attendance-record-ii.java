class Solution {
    static int MOD=1000000007;
    public int checkRecord(int n) {
        int [][][]dp=new int[n][2][3];
        for(int i=0;i<n;i++){
            for(int j=0;j<2;j++){
                for(int k=0;k<3;k++){
                    dp[i][j][k]=-1;
                }
            }
        }
        return solve(0, 0, 0, n, dp);
    }

    int solve(int days, int curr_a, int curr_l, int n, int [][][]dp){
        //Base Case
        if(days==n) return 1;
        if(dp[days][curr_a][curr_l]!=-1) return dp[days][curr_a][curr_l];
        int num_a=(curr_a==1)?0:solve(days+1, 1, 0, n, dp);
        int num_l=(curr_l==2)?0:solve(days+1, curr_a, curr_l+1, n, dp);
        int num_p=solve(days+1, curr_a, 0, n, dp);

        int total=((num_a + num_l)%MOD + num_p)%MOD;
        dp[days][curr_a][curr_l]=total;
        return total;
    }
}