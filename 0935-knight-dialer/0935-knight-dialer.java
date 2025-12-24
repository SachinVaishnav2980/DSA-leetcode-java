class Solution {
    int [][]moves={
        {4, 6}, //0
        {6, 8}, //1
        {7, 9}, //2
        {4, 8}, //3
        {0, 3, 9}, //4
        {},     //5
        {0, 1, 7}, //6
        {2, 6}, //7
        {1, 3}, //8
        {2, 4} //9
    };
    int [][]dp=new int[10][5001];
    int MOD=1000000007;
    public int knightDialer(int n) {
        int total=0;
        for(int []row:dp){
            Arrays.fill(row, -1);
        }
        for(int i=0;i<=9;i++){
            total=(total+solve(i, n))%MOD;
        }
        return total;
    }

    int solve(int digit, int steps){
        if(steps==1) return 1;
        if(dp[digit][steps]!=-1) return dp[digit][steps];
        //check all possible directions
        int ways=0;
        for(int next:moves[digit]){
            ways=(ways+solve(next, steps-1))%MOD;
        }
        return dp[digit][steps]=ways;
    }
}