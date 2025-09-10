class Solution {
    public int minimumOperations(int[] nums) {
        if(check(nums)){
            return 0;
        }
        int op=0;
        for(int i=0;i<nums.length;i++){
            int min=findMin(nums);
            for(int j=0;j<nums.length;j++){
                if(nums[j]!=0){
                    nums[j]-=min;
                }
            }
            op++;
            if(check(nums)){
                return op;
            }
        }
        return op;
    }

    boolean check(int []nums){
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                continue;
            }else{
                return false;
            }
        }
        return true;
    }


    int findMin(int []nums){
        int min=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0 && nums[i]<min){
                min=nums[i];
            }
        }
        return min;
    }
}