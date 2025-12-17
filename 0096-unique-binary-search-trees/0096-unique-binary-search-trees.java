class Solution {
    public int numTrees(int n) {
        int memo[]=new int [n+1];
        Arrays.fill(memo, -1);
        return solve(n, memo);
    }

    int solve(int n, int []memo){
        //Base case
        if(n==0 || n==1) return 1;

        if(memo[n]!=-1) return memo[n];
        int total=0;
        for(int i=1;i<=n;i++){

            int left=solve(i-1, memo);
            int right=solve(n-i, memo);

            total+=(left*right);
        }
        return memo[n]=total;   
    }
}