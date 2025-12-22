class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n=nums.length;
        if(n<3) return 0;
        int total=0;
        for(int i=2;i<n;i++){
            total+=solve(nums, i);
        }
        return total;
    }

    int solve(int []nums, int i){
        if(i<2) return 0;

        if(nums[i]-nums[i-1]!=nums[i-1]-nums[i-2]){
            return 0;
        }

        return 1+solve(nums, i-1);
    }
}