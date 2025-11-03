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
        // reverse both the Linked lists
        l1 = reverse(l1);
        l2 = reverse(l2);

        // Now add them properly
        ListNode head2 = sumLL(l1, l2);

        // again reverse to get final ans
        head2 = reverse(head2);
        return head2;
    }

    ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode nextNode = head.next;
            head.next = prev;
            prev = head;
            head = nextNode;
        }
        return prev;
    }

    ListNode sumLL(ListNode l1, ListNode l2){
            ListNode head2=null;
            ListNode temp3=null;

            int carry=0;

            while (l1!=null && l2!=null) {
                int sum=(l1.val+l2.val)+carry;

                if(head2==null){
                    head2=new ListNode(sum%10);
                    temp3=head2;
                }else{
                    ListNode node=new ListNode(sum%10);
                    temp3.next=node;
                    temp3=temp3.next;
                }
                carry=sum/10;
                l1=l1.next;
                l2=l2.next;
            }

            while (l1!=null) {
                int sum=(l1.val)+carry;
                ListNode node=new ListNode(sum%10);
                temp3.next=node;
                temp3=temp3.next;
                carry=sum/10;
                l1=l1.next;
            }

            while (l2!=null) {
                int sum=(l2.val)+carry;
                ListNode node=new ListNode(sum%10);
                temp3.next=node;
                temp3=temp3.next;
                carry=sum/10;
                l2=l2.next;
            }

            if(carry!=0){
                ListNode newNode=new ListNode(carry);
                temp3.next=newNode;
            }
            return head2;
        }
}