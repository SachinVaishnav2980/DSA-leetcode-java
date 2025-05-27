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
    public ListNode swapPairs(ListNode head) {
        ListNode a = head;
        while(head!=null) {
            if(head.next == null)
                break;
            int val1 = head.val;
            int val2 = head.next.val;
            head.val = val2;
            head.next.val = val1;
            head = head.next.next;
        }
        return a;
    }
}