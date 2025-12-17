class Solution {
    //Tabulation
    public int numTrees(int n) {
        int dp[]=new int [n+1];
        dp[0]=1;
        dp[1]=1;

        for(int i=2;i<=n;i++){
            int total=0;
            for(int root=1;root<=i;root++){
                int left=dp[root-1];
                int right=dp[i-root];

                total+=(left*right);
            }
            dp[i]=total;
        }
        return dp[n];
    }
}