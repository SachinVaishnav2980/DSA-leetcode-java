class Solution {
    public static int pivotIndex(int[] nums){
        return pivot(nums, 0);
    }

    static int pivot(int []nums, int index){
        if (index==nums.length){
            return -1;
        }
        boolean flag=sum(nums, 0,index)==sum(nums, index+1, nums.length)?true:false;
        if(flag){
            return index;
        }else{
            return pivot(nums, index+1);
        }
    }

   static int sum(int []nums, int start, int end){
        int sum=0;
        for(int i=start;i<end;i++){
            sum+=nums[i];
        }

        return sum;
    }
}