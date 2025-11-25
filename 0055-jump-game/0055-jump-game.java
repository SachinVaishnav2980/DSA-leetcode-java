class Solution {
    public boolean canJump(int[] nums) {
        // Greedy approach
        int maxIndex=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(i>maxIndex) return false;
            if(maxIndex==n-1) return true;
            maxIndex=Math.max(maxIndex, i+nums[i]);
        }
        return true;
    }
}