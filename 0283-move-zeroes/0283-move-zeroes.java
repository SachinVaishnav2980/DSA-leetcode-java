class Solution {
    public void moveZeroes(int[] nums){
        int initial=0;
        for(int element: nums){
            if(element!=0){
                nums[initial]=element;
                initial++;
            }
        }

        while (initial<nums.length) {
            nums[initial]=0;
            initial++;
        }
        System.out.println(Arrays.toString(nums));   
    }
}