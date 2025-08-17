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
        if(root==null) return null;
        List<String> list=new ArrayList<>();
        StringBuilder string=new StringBuilder();
        findpath(root, list, string);
        return list;
    }

    void findpath(TreeNode node, List<String> list, StringBuilder string){
        if(node==null) return;
        int len=string.length();
        string.append(node.val);
        if(node.left==null && node.right==null){
            list.add(string.toString());
        }else{
            string.append("->");    
            findpath(node.left, list, string);
            findpath(node.right, list, string);
        }
        string.setLength(len);
    }
}