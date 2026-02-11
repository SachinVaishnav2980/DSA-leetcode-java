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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1=new ArrayList<>();
        List<Integer> list2=new ArrayList<>();
        // Map<Integer, Integer> map1=new TreeMap<>();
        // Map<Integer, Integer> map2=new TreeMap<>();
        bottomView(root1, list1);
        bottomView(root2, list2);

        int i=0;
        int j=0;
        while(i<list1.size() && j<list2.size()){
            if(list1.get(i)!=list2.get(j)){
                return false;
            }
            i++;
            j++;
        }
        if(i!=list1.size()) return false;
        if(j!=list2.size()) return false;
        return true;
    }

    private void bottomView(TreeNode node, List<Integer> list){
        if(node==null){
            return ;
        }

        if(node.left==null && node.right==null) list.add(node.val);
        bottomView(node.left, list);
        bottomView(node.right, list);
    }
}