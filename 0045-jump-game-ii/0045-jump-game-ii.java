class Solution {
    public int jump(int[] nums) {
        int jump=0;
        int n=nums.length;
        int left=0;
        int right=0;
        while(right<n-1){
            int maxJump=0;
            for(int i=left;i<=right;i++){
                maxJump=Math.max(maxJump, nums[i]+i);
            }
            left=right+1;
            right=maxJump;
            jump++;
        }
        return jump;
    }
}