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
    int postIdx=0;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n=postorder.length;
        postIdx=n-1;

        //store all the index-val pair in map
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i], i);
        }
        return helper(postorder, inorder, 0, inorder.length-1); 
    }

    public TreeNode helper(int[] postorder, int[] inorder, int left, int right) {
        if(left>right){
            return null;
        }
        if(postIdx < 0) return null;
        int rootVal=postorder[postIdx--];
        TreeNode root=new TreeNode(rootVal);
        int inIdx=map.get(rootVal);
        root.right=helper(postorder, inorder, inIdx+1, right);
        root.left=helper(postorder, inorder, left, inIdx-1);
        return root;
    }
    
}