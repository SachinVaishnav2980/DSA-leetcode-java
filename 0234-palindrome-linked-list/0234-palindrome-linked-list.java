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
    public boolean isPalindrome(ListNode head) {
        if(head==null) return true;
        String number="";
        ListNode temp=head;
        while(temp!=null){
            number+=temp.val;
            temp=temp.next;
        }
        //check palindrome
        int i=0;
        int j=number.length()-1;
        while(i<=j){
            if(number.charAt(i)!=number.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}