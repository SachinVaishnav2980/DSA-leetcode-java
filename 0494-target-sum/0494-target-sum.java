class Solution {
    static int MOD = 1000000007;
    public int findTargetSumWays(int[] nums, int target) {
        int n=nums.length;
        int totalSum=0;
        for(int element:nums) totalSum+=element;
        //Edge cases
        
        if (Math.abs(target) > totalSum) return 0;
        if ((totalSum + target) % 2 != 0) return 0;
        int sum = (totalSum + target) / 2;


        int [][]t=new int [n+1][sum+1];

        return subsetSum(t, nums, sum);
    }

        int subsetSum(int [][]t, int []nums, int sum){
            //DP initialization
            int n=nums.length;
            for(int i=0;i<=n;i++){
                t[i][0]=1;
            }

            for(int j=1;j<=sum;j++){
                t[0][j]=0;
            }

            //Solving method
            for(int i=1;i<=n;i++){
                for(int j=0;j<=sum;j++){
                    if(nums[i-1]<=j){
                        t[i][j]=(int) ((t[i - 1][j - nums[i - 1]] + (long)t[i - 1][j]) % MOD);
                    }else{
                        t[i][j]=t[i-1][j];
                    }
                }
            }
            return t[n][sum];
        }
}