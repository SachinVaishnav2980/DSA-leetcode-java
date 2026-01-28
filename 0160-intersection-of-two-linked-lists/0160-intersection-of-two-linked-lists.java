/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode temp1=headA;
        ListNode temp2=headB;
        int lenA=0;
        int lenB=0;
        while(temp1!=null){
            lenA++;
            temp1=temp1.next;
        }

        while(temp2!=null){
            lenB++;
            temp2=temp2.next;
        }
        temp1=headA;
        temp2=headB;
        int diff=Math.abs(lenA-lenB);
        if(lenA<lenB){
            for(int i=0;i<diff;i++){
                temp2=temp2.next;
            }
        }else{
            for(int i=0;i<diff;i++){
                temp1=temp1.next;
            }
        }

        while(temp1!=null && temp2!=null){
            if(temp1==temp2){
                return temp1;
            }
            temp1=temp1.next;
            temp2=temp2.next;
        }
        return null;
    }
}