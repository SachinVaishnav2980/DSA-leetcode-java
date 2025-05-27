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
    public ListNode deleteMiddle(ListNode head) {
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode start=dummy;
        ListNode temp=head;
        int count=0;
        while(temp!=null){
            count++;
            temp=temp.next;
        }
        if(count==1){
            return null;
        }
        int mid=count/2;
        for(int i=0;i<mid;i++){
            start=start.next;
        }
        if(start.next!=null){
            start.next=start.next.next;
        }
        return head;
    }
}