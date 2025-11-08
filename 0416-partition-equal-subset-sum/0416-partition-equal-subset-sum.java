class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            sum+=nums[i];
        }

        if(sum%2!=0) return false;
        else return subsetSum(nums, sum/2, n);
    }

    boolean subsetSum(int []nums, int sum, int n){
        boolean [][]t=new boolean[n+1][sum+1];
        //Initialization
        for(int i=0;i<n+1;i++){
            t[i][0]=true;
        }

        for(int i=1;i<sum+1;i++){
            t[0][i]=false;
        }

        //Solving large problems using sub problems
        for(int i=1;i<n+1;i++){
            for(int j=1;j<sum+1;j++){
                if(nums[i-1]<=j){
                    t[i][j]=t[i-1][j-nums[i-1]] || t[i-1][j];
                }else{
                    t[i][j]=t[i-1][j];
                }
            }
        }
        return t[n][sum];
    }
}