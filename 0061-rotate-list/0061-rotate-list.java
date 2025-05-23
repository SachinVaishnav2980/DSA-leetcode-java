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
        if(head==null){
            return null;
        } 
        if(head.next==null){
            return head;
        }
        int length=1;
        ListNode temp=head;
        while(temp.next!=null){
            length++;
            temp=temp.next;
        }
        k=k%length;
        if(k==0){
            return head;
        }
        ListNode ptr=head;
        for(int i=1;i<length-k;i++){
            ptr=ptr.next;
        }
        ListNode ans=ptr.next;
        ptr.next=null;
        temp.next=head;
        return ans;
    }
}