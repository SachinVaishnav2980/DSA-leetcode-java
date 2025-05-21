/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode dummyNode=new ListNode(0);
        dummyNode.next=head;
        ListNode slow=dummyNode;
        ListNode fast=dummyNode;
        ListNode temp=dummyNode;
        ListNode swap=new ListNode(0);
        for(int i=1;i<=k;i++){
            temp=temp.next;
            fast=fast.next;
        }
        while(fast!=null){
            fast=fast.next;
            slow=slow.next;
        }
        swap.val=temp.val;
        temp.val=slow.val;
        slow.val=swap.val;
        return dummyNode.next;
    }
}