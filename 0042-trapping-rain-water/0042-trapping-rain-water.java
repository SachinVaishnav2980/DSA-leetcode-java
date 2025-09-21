class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] rightMax = new int[n];
        int[] leftMAX = new int[n];
        leftMAX[0]=height[0];
        rightMax[n-1]=height[n-1];
        for (int i = 1; i <n; i++) {
            leftMAX[i]=Math.max(height[i], leftMAX[i-1]);
        }
        for(int i=n-2;i>=0;i--){
            rightMax[i]=Math.max(height[i], rightMax[i+1]);
        }
        int units=0;
        for(int i=0;i<n;i++){
            int min=Math.min(leftMAX[i], rightMax[i]);
            units+=(min-height[i]);
        }
        return units;
    }
}