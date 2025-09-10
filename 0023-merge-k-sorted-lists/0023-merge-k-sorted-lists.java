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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        
        for(ListNode element:lists){
            while(element!=null){
                pq.add(element.val);
                element=element.next;
            }
        }
        
        ListNode head=new ListNode(-1);
        ListNode tail=head;
        while (!pq.isEmpty()) {
            tail.next=new ListNode(pq.poll());
            tail=tail.next;
        }

        return head.next;
    }
}