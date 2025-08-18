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
    int currCount=0;
    int maxCount=0;
    TreeNode prev=null;
    ArrayList<Integer> list=new ArrayList<>();
    public int[] findMode(TreeNode root) {
        if(root==null){
            return new int[]{0};
        }
        helper(root, list);
        int []result=new int[list.size()];
        for(int i=0;i<list.size();i++){
            result[i]=list.get(i);
        }
        return result;
    }

    void helper(TreeNode node, ArrayList<Integer> list){
        if(node==null) return;

        helper(node.left, list);

        if(prev==null || prev.val!=node.val){
            currCount=1;
        }else{
            currCount+=1;
        }

        if(currCount>maxCount){
            maxCount=currCount;
            list.clear();
            list.add(node.val);
        }else if(currCount==maxCount){
            list.add(node.val);
        }

        prev=node;

        helper(node.right, list);
    }
}