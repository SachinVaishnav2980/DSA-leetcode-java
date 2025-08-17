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
    int sum=0;
    public int sumOfLeftLeaves(TreeNode root) {
        if(root==null){
            return 0;
        }
        if(root.left==null && root.right==null) return 0;
        sum(root, true);
        return sum;
    }

    void sum(TreeNode node, boolean flag){
        if(node==null) return ;
        sum(node.left, true);
        if(flag==true && node.left==null && node.right==null){
            sum=sum+node.val;
            return;
        }
        sum(node.right, false);
    }
}