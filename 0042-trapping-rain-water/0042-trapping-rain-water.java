class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int leftMAX=0;
        int rightMax=0;
        int left=0;
        int right=n-1;
        int ans=0;
        while (left<right) {
            leftMAX=Math.max(leftMAX, height[left]);
            rightMax=Math.max(rightMax, height[right]);
            if(leftMAX<rightMax){
                ans+=leftMAX-height[left];
                left++;
            }else{
                ans+=rightMax-height[right];
                right--;
            }
        }
        return ans;
    }
}