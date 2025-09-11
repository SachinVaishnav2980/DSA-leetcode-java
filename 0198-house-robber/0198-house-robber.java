class Solution {
    public int rob(int[] nums) {
        Integer []memo=new Integer[nums.length];
        return helper(nums, 0, memo);
    }

    int helper(int []nums, int index, Integer []memo){
        if(index>=nums.length){
            return 0;
        }
        if(memo[index]!=null){
            return memo[index];
        }

        int rob=nums[index]+helper(nums, index+2, memo);
        int skip=helper(nums, index+1, memo);

        return memo[index]=Math.max(rob, skip);
    }
}