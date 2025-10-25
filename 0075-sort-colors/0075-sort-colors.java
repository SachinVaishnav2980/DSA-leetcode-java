class Solution {
    public void sortColors(int[] nums) {
        int n=nums.length;
        int low=0;
        int mid=0;
        int high=n-1;
        while (mid<=high) {
            if(nums[mid]==0){
                swap(nums, low, mid);
                mid++;
                low++;
            }else if(nums[mid]==1){
                mid++;
            }else{
                swap(nums, high, mid);
                high--;
            }
        }

    }
    
    void swap(int []nums, int first, int second){
        int temp=nums[first];
        nums[first]=nums[second];
        nums[second]=temp;
    }
}