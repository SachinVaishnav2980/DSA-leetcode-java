class Solution {
    int []dp=new int[501];
    public int maxSumAfterPartitioning(int[] arr, int k) {
        Arrays.fill(dp, -1);
        return solve(arr, 0, k);
    }

    int solve(int []arr, int i, int k){
        //Base case
        if(i>=arr.length) return 0;

        if(dp[i]!=-1) return dp[i];
        int curr_max=Integer.MIN_VALUE;
         int result=0;
        for(int j=i;j<arr.length && j-i+1<=k;j++){
            curr_max=Math.max(curr_max, arr[j]);
            result=Math.max(result, ((j-i+1)*curr_max)+solve(arr, j+1, k));
        }
        return dp[i]=result;
    }
}