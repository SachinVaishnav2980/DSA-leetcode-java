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
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> list=new ArrayList<>(); 
        inorder(root, list);
        int []arr=new int[list.size()];
        for(int i=0;i<arr.length;i++){
            arr[i]=list.get(i);
        }
        TreeNode node=sortedBST(arr, 0, arr.length-1);
        return node;
    }

    //inorder- sorted array
    public void inorder(TreeNode root, List<Integer> list){
        if(root==null){
            return ;
        }
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }

    //sorted BST
    public TreeNode sortedBST(int []arr, int start, int end){
        if(start>end) return null;
        int mid=start+(end-start)/2;
        TreeNode root=new TreeNode(arr[mid]);
        root.left=sortedBST(arr, start, mid-1);
        root.right=sortedBST(arr, mid+1, end);
        return root;
    }
}