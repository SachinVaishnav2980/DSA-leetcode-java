class Solution {
    public void moveZeroes(int[] nums) {
        if(nums.length==1){
            System.out.println(Arrays.toString(nums));
        }
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums.length-1;j++){
                if(nums[j]==0){
                    swap(nums, j, j+1);
                }
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    public void swap(int []nums, int first, int second){
        int temp=nums[first];
        nums[first]=nums[second];
        nums[second]=temp;
    }
}