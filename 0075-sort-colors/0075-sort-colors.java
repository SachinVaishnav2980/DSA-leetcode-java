class Solution {
    public void sortColors(int[] nums) {
        for(int i=1;i<nums.length;i++){
            int j=i-1;
            while(j>=0){
                if(nums[j]>nums[j+1]){
                    swap(nums,j,j+1);
                }
                j--;
            }
        }
    }
    
    void swap(int []nums, int first, int second){
        int temp=nums[first];
        nums[first]=nums[second];
        nums[second]=temp;
    }
}