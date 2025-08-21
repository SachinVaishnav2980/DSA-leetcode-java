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
    int edge=0;
    public int longestUnivaluePath(TreeNode root) {
        getPath(root);
        return edge;
    }

    int getPath(TreeNode node){
        if(node==null){
            return 0;
        }
        
        int left=getPath(node.left);
        int right=getPath(node.right);
        
        int leftEdge=0;
        int rightEdge=0;

        if(node.left!=null && node.left.val==node.val){
            leftEdge+=(left+1);
        }
        if(node.right!=null && node.right.val==node.val){
            rightEdge+=(right+1);

        }

        edge=Math.max(edge, leftEdge+rightEdge);
        return Math.max(leftEdge, rightEdge);

    }
}