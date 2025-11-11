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
        ListNode temp=head;
        List<Integer> list =new ArrayList<>();
        while (temp!=null) {
            list.add(temp.val);
            temp=temp.next;
        }

        //compare both arrays
        return compare(list);
    }

    boolean compare(List<Integer> list){
        int i=0;
        int j=list.size()-1;
        while (i<j) {
            if(!list.get(i).equals(list.get(j))){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}