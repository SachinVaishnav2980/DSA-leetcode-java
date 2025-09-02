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
    long maxProduct;
    long totalSum;
    public int maxProduct(TreeNode root) {
        maxProduct=0;
        totalSum=getSum(root);
        helper(root);
        return (int)(maxProduct % 1000000007);
    }

    long getSum(TreeNode node){
        if(node==null){
            return 0;
        }

        return node.val+getSum(node.left)+getSum(node.right);
    }

    long helper(TreeNode node){
        if(node==null){
            return 0;
        }

        long left=helper(node.left);
        long right=helper(node.right);
        long subtreeSum=left+right+node.val;

        maxProduct=Math.max(maxProduct, (totalSum-subtreeSum)*subtreeSum);
        return subtreeSum;
    }
}