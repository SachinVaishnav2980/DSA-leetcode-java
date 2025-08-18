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
    TreeNode prev=null;
    int diff=Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        helper(root);
        return diff;
    }

    void helper(TreeNode node){
        if(node==null){
            return ;
        }

        getMinimumDifference(node.left);
        TreeNode currNode=node;
        if(prev!=null){
            diff=Math.min(diff, Math.abs(currNode.val-prev.val));
        }
        
        prev=currNode;

        getMinimumDifference(node.right);
    }
}