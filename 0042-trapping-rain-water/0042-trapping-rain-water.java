class Solution {
    public int trap(int[] height) {
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            leftMax[i] = Math.max(height[i], max);
            max = leftMax[i];
        }
        int max2 = 0;
        for (int i = height.length - 1; i >= 0; i--) {
            rightMax[i] = Math.max(height[i], max2);
            max2 = rightMax[i];
        }
        int units=0;
        for(int i=0;i<height.length;i++){
            if (height[i]<leftMax[i] && height[i]<rightMax[i]) {
                units+=Math.min(leftMax[i], rightMax[i])-height[i];
            }
        }
        return units;
    }
}