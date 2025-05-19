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
    public int getDecimalValue(ListNode head) {
        double decVal=0;
        double count=0;
        ListNode node=head;
        while(node!=null){
            count++;
            node=node.next;
        }
        ListNode temp=head;
        while(temp!=null){
            decVal=decVal+(temp.val*Math.pow(2,count-1));
            count--;
            temp=temp.next;
        }
        return (int)decVal;
    }
}