/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Node leftmostNode=root;
        while (leftmostNode.left!=null) {
            Node currNode=leftmostNode;
            while (currNode!=null) {
                currNode.left.next=currNode.right;
                if(currNode.next!=null){
                    currNode.right.next=currNode.next.left;
                }
                currNode=currNode.next;
            }
            leftmostNode=leftmostNode.left;
        }
        return root;
    }
}