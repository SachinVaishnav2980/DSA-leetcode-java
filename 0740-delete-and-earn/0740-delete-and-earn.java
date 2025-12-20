class Solution {
    public int deleteAndEarn(int[] nums) {
        int max=Integer.MIN_VALUE;
        int n=nums.length;
        for(int i=0;i<n;i++){
            max=Math.max(max, nums[i]);
        }
        int freq[]=new int[max+1];
        for(int i=0;i<n;i++){
            freq[nums[i]]++;
        }
        int []dp=new int[max+1];
        Arrays.fill(dp, -1);
        return solve(1, freq, max, dp);
    }

    int solve(int value, int []freq, int max, int []dp){
        if(value>max) return 0;

        if(dp[value]!=-1) return dp[value];

        int notChoose=solve(value+1, freq, max, dp);
        int choose=value*freq[value]+solve(value+2, freq, max, dp);

        return dp[value]=Math.max(choose, notChoose);
    }
}