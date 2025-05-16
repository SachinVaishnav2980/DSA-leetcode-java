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
    public Boolean isPalindrome(ListNode head){
        ListNode mid=middleNode(head);
        ListNode head2=reverseIter(mid);
        ListNode head3=head2;
        while(head!=null && head2!=null){
            if(head.val!=head2.val){
                break;
            }
            head=head.next;
            head2=head2.next;
        }
        reverseIter(head3);
        if(head==null || head2==null){
            return true;
        }
        return false;
    }
    public ListNode middleNode(ListNode head) {
        ListNode fast=head;
        ListNode slow= head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        } 
        return slow;
    }
    public ListNode reverseIter(ListNode head){
            if (head == null) {
            return head;
        }
        ListNode prev = null;
        ListNode present = head;
        ListNode next = present.next;

        while (present != null) {
            present.next = prev;
            prev = present;
            present = next;
            if (next != null) {
                next = next.next;
            }
        }
        return prev;
        }
}