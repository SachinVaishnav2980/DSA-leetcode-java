/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int maxTime=0;
    public int amountOfTime(TreeNode root, int start) {
        helper(root, start);
        return maxTime;
    }

    private int helper(TreeNode node, int start){
        if(node==null) return 0;
 
        int left=helper(node.left, start);
        int right=helper(node.right, start);

        if(node.val==start){
            maxTime=Math.max(left, right);
            return -1;
        }else if(left>=0 && right>=0){
            return 1+Math.max(left, right);
        }else{
            int d=Math.abs(left)+Math.abs(right);
            maxTime=Math.max(maxTime, d);
            return Math.min(left, right)-1;
        }
    }
}