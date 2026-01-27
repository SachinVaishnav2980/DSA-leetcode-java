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
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }

        ListNode i=head;
        ListNode j=head.next;
        while(j!=null){
            boolean conflict=i.val==j.val;
            if(conflict){
                i.next=j.next;
                j=j.next;
            }else{
                i=j;
                j=j.next;
            }
        }
        return head;
    }
}