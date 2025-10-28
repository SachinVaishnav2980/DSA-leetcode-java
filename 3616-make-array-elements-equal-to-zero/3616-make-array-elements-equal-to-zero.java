class Solution {
    public int countValidSelections(int[] nums) {
        int selection=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                if(check(nums.clone(), i-1, false)) selection++;  //left

                if(check(nums.clone(), i+1, true)) selection++;  //right
            }
        }
        return selection;
    }

    boolean check(int []nums, int curr, boolean right){
        int n=nums.length;
        if (allzero(nums)) return true;
        if (curr < 0 || curr >= n) return false;
        while (!allzero(nums)) {
            if(curr<0 || curr>=n) return false;

            if(nums[curr]==0){
                curr = right ? curr+1 : curr-1;

            }else{
                nums[curr]--;
                right=!right;
                curr = right ? curr+1 : curr-1;
            }
        }
        return true;
    }

    boolean allzero(int []nums){
        for(int num:nums){
            if(num!=0) return false;
        }
        return true;
    }
}