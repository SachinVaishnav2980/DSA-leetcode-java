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
    Map<Integer, Integer> map=new HashMap<>();
    int preIdx=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //store all the index-val pair in map
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i], i);
        }

        //now build tree
        return helper(preorder, inorder, 0, inorder.length-1);
    }

    public TreeNode helper(int[] preorder, int[] inorder, int left, int right) {
        if(left>right){
            return null;
        }
        int rootVal=preorder[preIdx++];
        TreeNode root=new TreeNode(rootVal);
        int inIdx=map.get(rootVal);
        root.left=helper(preorder, inorder, left, inIdx-1);
        root.right=helper(preorder, inorder, inIdx+1, right);
        return root;
    }
}