class Solution {
    public void sortColors(int[] nums) {
        while (!checkSort(nums)) {
            for(int i=1;i<nums.length;i++){
                if(nums[i]<nums[i-1]){
                    swap(nums, i, i-1);
                }
            }
        }
    }

    boolean checkSort(int []nums){
        for(int i=0;i<nums.length;i++){
            if(i+1<nums.length && nums[i]>nums[i+1]){
                return false;
            }
        }
        return true;
    }
    
    void swap(int []nums, int first, int second){
        int temp=nums[first];
        nums[first]=nums[second];
        nums[second]=temp;
    }
}