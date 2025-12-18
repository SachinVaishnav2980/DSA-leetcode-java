class Solution {
    //Memoization Bottom up
    int [][]dp=new int[101][10001];
    public int superEggDrop(int k, int n) {
        for(int []t:dp){
            Arrays.fill(t, -1);
        }

        return solve(k, n);
    }

    int solve(int e, int f){
        if(f==0 || f==1) return f;
        if(e==1) return f;

        if(dp[e][f]!=-1) return dp[e][f];
        int low = 1, high = f;
        int ans = Integer.MAX_VALUE;

        while (low <= high) {
            int mid = (low + high) / 2;

            int breakEgg = solve(e - 1, mid - 1);
            int notBreak = solve(e, f - mid);

            int temp = 1 + Math.max(breakEgg, notBreak);
            ans = Math.min(ans, temp);

            if (breakEgg < notBreak) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return dp[e][f]=ans;
    }
}