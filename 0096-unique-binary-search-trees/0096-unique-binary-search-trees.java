class Solution {
    public int numTrees(int n) {
        return solve(n);
    }

    int solve(int n){
        //Base case
        if(n==0 || n==1) return 1;

        int total=0;
        for(int i=1;i<=n;i++){

            int left=solve(i-1);
            int right=solve(n-i);

            total+=(left*right);
        }
        return total;   
    }
}