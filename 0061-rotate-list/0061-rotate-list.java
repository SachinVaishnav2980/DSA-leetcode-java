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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null){
            return head;
        }
        int size=0;
        ListNode temp=head;
        while (temp!=null) {
            size++;
            temp=temp.next;
        }
        k=k%size;
        if (k == 0) return head;
        int index=size-k;
        ListNode pivot= head;
        for(int i=0;i<index-1;i++){
            pivot=pivot.next;   
        }
        ListNode start=pivot.next;
        pivot.next=null;

        //reach to end of second ll
        ListNode finalNode=start;
        while (finalNode.next!=null) {
            finalNode=finalNode.next;
        }
        finalNode.next=head;
        return start;
    }
}