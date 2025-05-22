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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyNode=new ListNode(0);
        ListNode current=dummyNode;
        int carry=0;
        int sum;
        while(l1!=null && l2!=null){
            sum=0;
            sum=l1.val+l2.val+carry;
            int digit=sum%10;
            current.next=new ListNode(digit);
            current=current.next;
            carry= Math.floorDiv(sum,10);
            l1=l1.next;
            l2=l2.next;
        }
        while(l1!=null){
            sum=0;
            sum=l1.val+carry;
            int digit=sum%10;
            current.next=new ListNode(digit);
            current=current.next;
            carry= Math.floorDiv(sum,10);
            l1=l1.next;
        }
        while(l2!=null){
            sum=0;
            sum=l2.val+carry;
            int digit=sum%10;
            current.next=new ListNode(digit);
            current=current.next;
            carry= Math.floorDiv(sum,10);
            l2=l2.next;
        }
        if(carry==1){
            current.next=new ListNode(carry);
        }
        return dummyNode.next;
    }
}