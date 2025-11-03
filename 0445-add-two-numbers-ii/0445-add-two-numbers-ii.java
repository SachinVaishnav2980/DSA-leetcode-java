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
        Stack<Integer> s1=new Stack<>();
        Stack<Integer> s2=new Stack<>();    

        while (l1!=null) {
            s1.add(l1.val);
            l1=l1.next;
        }

        while (l2!=null) {
            s2.add(l2.val);
            l2=l2.next;
        }

        ListNode head=null;
        ListNode temp=null;
        int carry=0;
        while (!s1.isEmpty() && !s2.isEmpty()) {
            int sum=s1.pop()+s2.pop()+carry;
            if(head==null){
                head=new ListNode(sum%10);
                temp=head;
            }else{
                ListNode newNode=new ListNode(sum%10);
                temp.next=newNode;
                temp=temp.next;
            }
            carry=sum/10;
        }
        
        while (!s1.isEmpty()) {
            int sum=s1.pop()+carry;
            ListNode newNode=new ListNode(sum%10);
            temp.next=newNode;
            temp=temp.next;
            carry=sum/10;
        }

        while (!s2.isEmpty()) {
            int sum=s2.pop()+carry;
            ListNode newNode=new ListNode(sum%10);
            temp.next=newNode;
            temp=temp.next;
            carry=sum/10;
        }

        if(carry!=0){
            ListNode newNode=new ListNode(carry);
            temp.next=newNode;
        }
        return reverse(head);
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
}