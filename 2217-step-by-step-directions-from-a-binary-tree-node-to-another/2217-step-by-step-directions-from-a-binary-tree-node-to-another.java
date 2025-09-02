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
    public String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode lca = lowestCommonAncestor(root, startValue, destValue);
        StringBuilder sourceToLca=new StringBuilder();
        findPath(lca, startValue, sourceToLca);
        StringBuilder lcaToDest=new StringBuilder();
        findPath(lca, destValue, lcaToDest);
        StringBuilder res=new StringBuilder();
        for(int i=0;i<sourceToLca.length();i++){
            res.append("U");
        }
        res.append(lcaToDest);
        return res.toString();

    }

    boolean findPath(TreeNode node, int target, StringBuilder str) {
        if (node == null) {
            return false;
        }

        if (node.val == target) {
            return true;
        }

        if (node.left != null) {
            str.append("L");
            if (findPath(node.left, target, str)) {
                return true;
            }
            str.deleteCharAt(str.length() - 1);
        }
        if (node.right != null) {
            str.append("R");
            if (findPath(node.right, target, str)) {
                return true;
            }
            str.deleteCharAt(str.length() - 1);
        }
        return false;
    }

    TreeNode lowestCommonAncestor(TreeNode node, int p, int q) {
        if (node == null) {
            return node;
        }

        if (node.val == p || node.val == q) {
            return node;
        }

        TreeNode left = lowestCommonAncestor(node.left, p, q);
        TreeNode right = lowestCommonAncestor(node.right, p, q);

        if (left != null && right != null) {
            return node;
        }
        return left == null ? right : left;
    }
}