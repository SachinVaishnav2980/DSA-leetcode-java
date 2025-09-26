class Solution {
    public int singleNumber(int[] nums) {
        int ans=0;
        for(int element:nums){
            ans^=element;
        }
        return ans;
    }
}