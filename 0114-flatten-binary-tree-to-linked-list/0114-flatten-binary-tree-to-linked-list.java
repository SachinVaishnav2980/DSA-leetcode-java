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
    public void flatten(TreeNode root){
        if(root==null) return ;
        Queue<TreeNode> ans= new LinkedList<>();
        treeToQueue(root, ans);

        TreeNode node=ans.poll();
        while (!ans.isEmpty()) {
            node.left=null;
            node.right=ans.poll();
            node=node.right;
        }
    }

    public void treeToQueue(TreeNode node, Queue<TreeNode> ans){
        if(node==null) return;
        ans.offer(node);
        treeToQueue(node.left, ans);
        treeToQueue(node.right, ans);
    }
}