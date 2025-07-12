class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int leftSum=0;
        int rightSum=0;
        for(int i=k-1;i>=0;i--){
            leftSum+=cardPoints[i];
        }
        int maxSum=leftSum;
        int index=cardPoints.length-1;
        for(int i=k-1;i>=0;i--){
            leftSum-=cardPoints[i];
            rightSum+=cardPoints[index];
            index--;
            maxSum=Math.max(maxSum, leftSum+rightSum);
        }
        return maxSum;
    }
}