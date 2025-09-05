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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list=new ArrayList<>();
        if(root==null){
            return list;
        }
        StringBuilder sb=new StringBuilder();
        helper(root, list, sb);
        return list;
    }

    void helper(TreeNode node, List<String> list, StringBuilder sb){
        if(node==null){
            return ;
        }
        int len=sb.length();
        if(node.left==null && node.right==null){
            sb.append(node.val);
            list.add(sb.toString());
        }else{
            sb.append(node.val).append("->");
            helper(node.left, list, sb);
            helper(node.right, list, sb);
        }
        sb.setLength(len);
    }
}