class Solution {
    public boolean isTrionic(int[] nums) {
        int n=nums.length;

        for(int p=1;p<n-1;p++){
            for(int q=p+1;q<n-1;q++){
                boolean first=strictlyIncreasing(nums, 0, p);
                boolean second=strictlyDecreasing(nums, p, q);
                boolean third=strictlyIncreasing(nums, q, n-1);

                if(first && second && third){
                    return true;
                }
            }
        }
        return false;
    }

    boolean strictlyIncreasing(int []nums, int p, int q){
        for(int i=p;i<q;i++){
            if(nums[i]>=nums[i+1]){
                return false;
            }
        }
        return true;
    }

    boolean strictlyDecreasing(int []nums, int p, int q){
        for(int i=p;i<q;i++){
            if(nums[i]<=nums[i+1]){
                return false;
            }
        }
        return true;
    }
}