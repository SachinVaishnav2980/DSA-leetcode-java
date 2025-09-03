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
    List<Integer> res=new ArrayList<>();
    int i=0;
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        if(!helper(root, voyage)){
            return Arrays.asList(-1);
        }
        return res;
    }

    boolean helper(TreeNode node, int []voyage){
        if(node==null) return true;

        if(node.val!=voyage[i++]){
            return false;
        }

        if(node.left!=null && i<voyage.length && node.left.val!=voyage[i]){
            res.add(node.val);

            return helper(node.right, voyage) && helper(node.left, voyage);
        }

        return helper(node.left, voyage) && helper(node.right, voyage);
    }
}