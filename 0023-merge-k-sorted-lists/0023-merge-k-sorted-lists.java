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
        PriorityQueue<ListNode> queue=new PriorityQueue<>((a, b)-> a.val-b.val);
        for (ListNode node:lists) {
            if (node!=null) {
                queue.add(node);    
            }
        }

        ListNode head=new ListNode(0);
        ListNode tail=head;

        while (!queue.isEmpty()) {
            ListNode curr=queue.poll();
            tail.next=curr;
            tail=tail.next;
            if(curr.next!=null){
                queue.add(curr.next);
            }
        }
        return head.next;
    }
}