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
    public int sumNumbers(TreeNode root) {
        ArrayList<StringBuilder> list=new ArrayList<>();
        StringBuilder string= new StringBuilder();
        sumNumbers(root, list, string);
        int sum=0;
        for(int i=0; i<list.size();i++){
            sum+= Integer.parseInt(list.get(i).toString());
        }
        return sum;
    }

    public void sumNumbers(TreeNode node, ArrayList<StringBuilder> list, StringBuilder string){
        if(node==null) return;

        string.append(Integer.toString(node.val));
        if(node.left==null && node.right==null){
            list.add(new StringBuilder(string));
        }else{
            sumNumbers(node.left, list, string);
            sumNumbers(node.right, list, string);
        }

        string.deleteCharAt(string.length()-1); //backtrack
    }
}